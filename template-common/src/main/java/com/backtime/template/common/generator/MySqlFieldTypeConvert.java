package com.backtime.template.common.generator;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

/**
 * @Author backtime
 * @Date 2021/4/15 0:50
 * @Description
 */
public class MySqlFieldTypeConvert extends MySqlTypeConvert {

    @Override
    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        if ( fieldType.toLowerCase().contains("tinyint") || fieldType.toLowerCase().contains("boolean") ) {
            return DbColumnType.BOOLEAN;
        }
        if ( fieldType.toLowerCase().contains("varchar") || fieldType.toLowerCase().contains("char") || fieldType.toLowerCase().contains("text") ) {
            return DbColumnType.STRING;
        }
        if (fieldType.toLowerCase().contains("decimal") || fieldType.toLowerCase().contains("numeric")) {
            return DbColumnType.DOUBLE;
        }
        if (fieldType.toLowerCase().contains("integer") ||fieldType.toLowerCase().contains("int(") || fieldType.toLowerCase().contains("int4")) {
            return DbColumnType.INTEGER;
        }
        if (fieldType.toLowerCase().contains("int8")) {
            return DbColumnType.LONG;
        }
        if (fieldType.toLowerCase().contains("bigint")) {
            return DbColumnType.LONG;
        }
        if (fieldType.toLowerCase().contains("datetime")) {
            return DbColumnType.DATE;
        }
        if (fieldType.toLowerCase().contains("timestamp")) {
            return DbColumnType.DATE;
        }
        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
    }

}
