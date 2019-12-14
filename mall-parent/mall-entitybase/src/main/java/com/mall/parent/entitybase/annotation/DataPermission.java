package com.mall.parent.entitybase.annotation;

import java.lang.annotation.*;

/**
 * Group
 * 群或组，拥有一定数量权限的集合，亦可以是权限的载体。
 *
 * 子类：User（用户）、Role（角色）、Position（岗位）、Unit（部门），通过用户的特定构成，形成不同业务场景的群或组，而通过对群或组的父类授权，完成了用户的权限获取。
 *
 * Permission
 * 权限，拥有一定数量资源的集成，亦可以是资源的载体。
 *
 * Resources
 * 权限下有资源，资源的来源有：Menu（菜单）、Button（动作权限）、页面元素（按钮、tab等）、数据权限等
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermission {
}
