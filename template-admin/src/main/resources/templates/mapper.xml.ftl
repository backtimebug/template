<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
    <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.name},
</#list>
        ${table.fieldNames}
    </sql>

</#if>
<#--    只插入非空字段-->
    <insert id="insertSelective">
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list table.fields as field>
            <#--                主键字段-->
            <#if field.keyFlag>
            <#--   判断属性是否为null-->
            <#if field.propertyType == "String">
            <if test="record.${field.propertyName} != null">
                <if test="record.${field.propertyName} == '' and insertEmptyString">
                    ${field.name},
                </if>
                <if test="record.${field.propertyName} != ''">
                    ${field.name},
                </if>
            </if>
            <#else>
            <if test="record.${field.propertyName} != null">
                ${field.name},
            </if>
            </#if>
            </#if>
            </#list>
            <#list table.fields as field>
<#--                普通字段-->
            <#if !field.keyFlag>
            <#--   判断属性是否为null-->
            <#if field.propertyType == "String">
            <if test="record.${field.propertyName} != null">
                <if test="record.${field.propertyName} == '' and insertEmptyString">
                ${field.name},
                </if>
                <if test="record.${field.propertyName} != ''">
                    ${field.name},
                </if>
            </if>
            <#else>
            <if test="record.${field.propertyName} != null">
                ${field.name},
            </if>
            </#if>
            </#if>
            </#list>
        </trim>
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list table.fields as field>
            <#--                主键字段-->
            <#if field.keyFlag>
            <#--   判断属性是否为null-->
            <#if field.propertyType == "String">
            <if test="record.${field.propertyName} != null">
                <if test="record.${field.propertyName} == '' and insertEmptyString">
                    <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
                </if>
                <if test="record.${field.propertyName} != ''">
                    <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
                </if>
            </if>
            <#else>
            <if test="record.${field.propertyName} != null">
                <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
            </if>
            </#if>
            </#if>
            </#list>
            <#list table.fields as field>
            <#--                普通字段-->
            <#if !field.keyFlag>
            <#--   判断属性是否为null-->
            <#if field.propertyType == "String">
            <if test="record.${field.propertyName} != null">
                <if test="record.${field.propertyName} == '' and insertEmptyString">
                    <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
                </if>
                <if test="record.${field.propertyName} != ''">
                    <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
                </if>
            </if>
            <#else>
            <if test="record.${field.propertyName} != null">
                <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
            </if>
            </#if>
            </#if>
            </#list>
            <#list table.fields as field>
            <if test="record.${field.propertyName} != null">
                <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
            </if>
            </#list>
        </trim>
    </insert>

<#--    只跟新非空字段-->
    <update id="updateByIdSelective">
        update ${table.name}
        set
        <trim suffixOverrides=",">
            <#list table.fields as field>
                <#if !field.keyFlag>
                <#if field.propertyType == "String">
        <if test="record.${field.propertyName} != null">
            <if test="record.${field.propertyName} == '' and updateEmptyString">
            ${field.name} = <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
            </if>
            <if test="record.${field.propertyName} != ''">
                ${field.name} = <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
            </if>
        </if>
                <#else>
        <if test="record.${field.propertyName} != null">
            ${field.name} = <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>},</#noparse>
        </if>
                </#if>
                </#if>
            </#list>
        </trim>
        where
        <trim suffixOverrides=" and">
        <#list table.fields as field>
            <#if field.keyFlag><#--主键-->
            ${field.name} = <#noparse>#{record.</#noparse>${field.propertyName}<#noparse>}</#noparse> and
            </#if>
        </#list>
        </trim>
    </update>
</mapper>
