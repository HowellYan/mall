package com.mall.oss.module.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Howell.Yang
 */
@Data
@Document(indexName = "es_user", type = "doc", shards = 1, replicas = 0, refreshInterval = "-1")
public class EsUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Field(type = FieldType.Text, fielddata = true)
    private String id;

    //@ApiModelProperty(value = "创建者")
    @Field(type = FieldType.Text, fielddata = true)
    private String createBy;

    //@ApiModelProperty(value = "创建时间")
    @Field(type = FieldType.Date, index = false, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //@ApiModelProperty(value = "更新者")
    @Field(type = FieldType.Text, fielddata = true)
    private String updateBy;

    //@ApiModelProperty(value = "更新时间")
    @Field(type = FieldType.Date, index = false, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //@ApiModelProperty(value = "删除标志 默认0")
    private Integer delFlag = 0;

    //@ApiModelProperty(value = "用户名")
    @Field(type = FieldType.Text, fielddata = true)
    private String username;

    //@ApiModelProperty(value = "密码")
    @Field(type = FieldType.Text, fielddata = true)
    private String password;

    //@ApiModelProperty(value = "昵称")
    @Field(type = FieldType.Text, fielddata = true)
    private String nickName;

    //@ApiModelProperty(value = "手机")
    @Field(type = FieldType.Text, fielddata = true)
    private String mobile;

    //@ApiModelProperty(value = "邮件")
    @Field(type = FieldType.Text, fielddata = true)
    private String email;

    //@ApiModelProperty(value = "省市县地址")
    @Field(type = FieldType.Text, fielddata = true)
    private String address;

    //@ApiModelProperty(value = "街道地址")
    @Field(type = FieldType.Text, fielddata = true)
    private String street;

    //@ApiModelProperty(value = "性别")
    @Field(type = FieldType.Text, fielddata = true)
    private String sex;

    //@ApiModelProperty(value = "密码强度")
    @Field(type = FieldType.Text, fielddata = true)
    private String passStrength;

    //@ApiModelProperty(value = "用户头像")
    @Field(type = FieldType.Text, fielddata = true)
    private String avatar = "";

    //@ApiModelProperty(value = "用户类型 0普通用户 1管理员")
    private Integer type = 0;

    //@ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status = 0;

    //@ApiModelProperty(value = "描述/详情/备注")
    @Field(type = FieldType.Text, fielddata = true)
    private String description;

    //@ApiModelProperty(value = "所属部门id")
    @Field(type = FieldType.Text, fielddata = true)
    private String departmentId;
}
