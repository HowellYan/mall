package com.mall.oss.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * Elasticsearch文档实体类
 *
 * @author Howell.Yang
 */
@Data
@Document(indexName = "log", type = "log", shards = 1, replicas = 0, refreshInterval = "-1")
public class EsLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String createBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, index = false, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

}
