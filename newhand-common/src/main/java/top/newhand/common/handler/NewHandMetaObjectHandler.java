package top.newhand.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author hexg8236
 * @className NewHandMetaObjectHandler
 * @Since 2024/4/24 22:01
 * @description 数据自动填充处理器
 **/
@Component
public class NewHandMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入数据时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object created = getFieldValByName("created", metaObject);
        if (created == null) {
            setFieldValByName("created", LocalDateTime.now(), metaObject);
        }

        Object updated = getFieldValByName("updated", metaObject);
        if (updated == null) {
            setFieldValByName("updated", LocalDateTime.now(), metaObject);
        }
    }

    /**
     * 更新数据时自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新数据时，直接更新字段
        setFieldValByName("updated", LocalDateTime.now(), metaObject);
    }
}
