package top.newhand.common.enums;

/**
 * @author HeXianGang
 * @className BaseEnum
 * @description 枚举基本接口
 * @since 2024/4/18 20:29
 **/

public interface BaseEnum {
    /**
     * 业务状态码
     */
    Integer getCode();
    /**
     * 业务说明
     */
    String getValue();
}
