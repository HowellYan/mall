package com.mall.parent.entitybase.base;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mall.parent.entitybase.annotation.CreatedBy;
import com.mall.parent.entitybase.annotation.GroupBy;
import com.mall.parent.entitybase.annotation.Permission;
import com.mall.parent.entitybase.common.CommonConstant;
import lombok.Data;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Howell.Yang
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
//    @ApiModelProperty(value = "唯一标识")
    private String id;

//    @ApiModelProperty(value = "创建者")
    @CreatedBy
    private String createBy = "system";

//    @CreatedDate
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "创建时间")
    private Date createTime;

//    @ApiModelProperty(value = "更新者")
//    @LastModifiedBy
    private String updateBy = "system";

//    @LastModifiedDate
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

//    @ApiModelProperty(value = "删除标志 默认0")
    private Integer delFlag = CommonConstant.STATUS_NORMAL;

    @GroupBy
    private String group;

    @Permission
    @Transient
    @TableField(exist=false)
    private List<String> permissions;
}
