package top.newhand.common.exception;

import lombok.Data;
import top.newhand.common.enums.BaseEnum;
import top.newhand.common.enums.BaseExceptionEnum;

/**
 * @author hexg8236
 * @className CustomException
 * @Since 2024/4/18 20:42
 * @description 自定义异常
 **/
@Data
public class CustomException extends RuntimeException {

    private String msg;

    private int code = 1001;

    private int status = 500;

    public CustomException(BaseEnum baseEnum) {
        super(baseEnum.getValue());
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomException(BaseExceptionEnum errorEnum) {
        super(errorEnum.getValue());
        this.status = errorEnum.getStatus();
        this.msg = errorEnum.getValue();
        this.code = errorEnum.getCode();
    }

    public CustomException(BaseExceptionEnum baseEnum, Throwable e) {
        super(baseEnum.getValue(), e);
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, int status) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }

    public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, int status, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }
}
