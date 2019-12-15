package com.mall.customer.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.mall.parent.entitybase.annotation.GroupBy;
import com.mall.parent.entitybase.annotation.Permission;
import com.mall.parent.entitybase.base.BaseEntity;
import com.mall.parent.entitybase.common.CommonConstant;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

@Data
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "用户名")
    @Column(unique = true, nullable = false)
    private String username;

//    @ApiModelProperty(value = "密码")
    private String password;

//    @ApiModelProperty(value = "昵称")
    private String nickName;

//    @ApiModelProperty(value = "手机")
    private String mobile;

//    @ApiModelProperty(value = "邮件")
    private String email;

//    @ApiModelProperty(value = "省市县地址")
    private String address;

//    @ApiModelProperty(value = "街道地址")
    private String street;

//    @ApiModelProperty(value = "性别")
    private String sex;

//    @ApiModelProperty(value = "密码强度")
    @Column(length = 2)
    private String passStrength;

//    @ApiModelProperty(value = "用户头像")
    @Column(length = 1000)
    private String avatar = CommonConstant.USER_DEFAULT_AVATAR;

//    @ApiModelProperty(value = "用户类型 0普通用户 1管理员")
    private Integer type = CommonConstant.USER_TYPE_NORMAL;

//    @ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status = CommonConstant.USER_STATUS_NORMAL;

//    @ApiModelProperty(value = "描述/详情/备注")
    private String description;

//    @ApiModelProperty(value = "所属部门id")
    private String departmentId;

    @Transient
    @TableField(exist=false)
//    @ApiModelProperty(value = "所属部门名称")
    private String departmentTitle;

    @Transient
    @TableField(exist=false)
//    @ApiModelProperty(value = "用户拥有角色")
    private List<String> roles;

//    @Transient
//    @TableField(exist=false)
//    @ApiModelProperty(value = "用户拥有的权限")
//    private List<String> permissions;

    @Permission
    private List<String> permission;

    @GroupBy
    private String groupBy;
}
