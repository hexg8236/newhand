package top.newhand.common.exception;

import top.newhand.common.enums.BaseEnum;
import top.newhand.common.enums.BaseExceptionEnum;

/**
 * @author hexg8236
 * @className CustomException 自定义Web异常
 * @Since 2024/4/18 20:25
 * @description
 **/

public class CustomWebException extends RuntimeException {
    /**
     * 自定义异常
     */
    private static final long serialVersionUID = 1L;
    // 异常中的信息
    private String msg;
    // 业务状态码，规则：4位数，从1001开始递增
    private int code = 1;
    //http状态码，按照http协议规范，如：200,201,400等
    private int status = 200;

    public CustomWebException(BaseEnum baseEnum) {
        super(baseEnum.getValue());
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomWebException(BaseEnum baseEnum, Throwable e) {
        super(baseEnum.getValue(), e);
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomWebException(BaseExceptionEnum errorEnum) {
        super(errorEnum.getValue());
        this.msg = errorEnum.getValue();
        this.code = errorEnum.getCode();
    }
    public CustomWebException(BaseExceptionEnum errorEnum, Throwable e) {
        super(errorEnum.getValue(), e);
        this.msg = errorEnum.getValue();
        this.code = errorEnum.getCode();
    }

    public CustomWebException(String msg) {
        super(msg);
        this.msg = msg;
    }
    public CustomWebException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomWebException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomWebException(String msg, int code, int status) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }

    public CustomWebException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomWebException(String msg, int code, int status, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }



}
