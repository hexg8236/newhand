package top.newhand.common.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.newhand.common.exception.CustomException;
import top.newhand.common.exception.CustomWebException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hexg8236
 * @className GlobalExceptionHandler
 * @Since 2024/4/19 21:57
 * @description 全局异常处理器
 **/

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 参数校验失败异常
     *
     * @param exception 校验失败异常
     * @return 响应数据
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handle(ValidationException exception) {
        List<String> errors = null;

        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        }
        if (ObjectUtil.isNotEmpty(exception.getCause())) {
            log.error("参数校验失败异常 -> ", exception);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MapUtil.<String, Object>builder()
                .put("code", HttpStatus.BAD_REQUEST.value())
                .put("msg", errors).build());
    }

    /**
     * 自定义异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handle(CustomException exception) {
        if (ObjectUtil.isNotEmpty(exception.getCause())) {
            log.error("自定义异常处理 -> ", exception);
        }
        return ResponseEntity.status(exception.getStatus()).body(MapUtil.<String, Object>builder()
                .put("code", exception.getCode())
                .put("msg", exception.getMessage()).build());
    }

    /**
     * web自定异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(CustomWebException.class)
    public ResponseEntity<Object> handle(CustomWebException exception) {
        if (ObjectUtil.isNotEmpty(exception.getCause())) {
            log.error("自定义异常处理 -> ", exception);
        }
        JSONObject jsonObject = JSONUtil.parseObj(exception);
        return ResponseEntity.status(exception.getStatus()).body(MapUtil.<String, Object>builder()
                .put("code", exception.getCode())
                .put("msg", jsonObject.getStr("msg")).build());
    }

    /**
     * 其他未知异常
     *
     * @param exception 未知异常
     * @return 响应数据
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception exception) {
        if (ObjectUtil.isNotEmpty(exception.getCause())) {
            log.error("其他未知异常 -> ", exception);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(MapUtil.<String, Object>builder()
                .put("code", HttpStatus.INTERNAL_SERVER_ERROR.value())
                .put("msg", ExceptionUtil.stacktraceToString(exception)).build());
    }
}
