package top.newhand.common.enums;

/**
 * @author HeXianGang
 * @className BaseExceptionEnum
 * @description 所有的异常类型枚举都需要实现该接口
 * @since 2024/4/18 20:33
 **/

public interface BaseExceptionEnum extends BaseEnum {
    /**
     * http响应状态码
     */
    Integer getStatus();
}
