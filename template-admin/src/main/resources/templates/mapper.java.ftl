package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Param;

/**
 * ${table.comment!} Mapper 接口
 *
 * @author ${author}
 * @since ${.now?string('yyyy-MM-dd hh:mm:ss')}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
    /**
    * 插入非空字段
    * @param record
    * @param insertEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int insertSelective(@Param("record") ${table.entityName} record, @Param("insertEmptyString") boolean insertEmptyString);

    /**
    * 插入非空字段
    * @param record
    * @param updateEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int updateByIdSelective(@Param("record") ${table.entityName} record, @Param("updateEmptyString") boolean updateEmptyString);

}
</#if>
