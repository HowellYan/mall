package com.mall.oss.common.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class DataPermissionAspect {
    @Pointcut("@annotation(com.mall.parent.entitybase.annotation.DataPermission)")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] objects = pjp.getArgs();
        log.info("请求数据" + JSONObject.toJSONString(objects));
        for (Object object:objects){
            getObjectClass(object);
        }

        Object retVal = pjp.proceed(objects);
        log.info("响应数据" + JSONObject.toJSONString(retVal));
        return retVal;
    }

    public void getObjectClass(Object object) {
        log.info("对象Parameter数量" + object.getClass().getTypeParameters().length);
        if(!isPrimitive(object)) {
            log.info(object.getClass().getName());
        }
    }

    /**判断一个对象是否是基本类型或基本类型的封装类型*/
    private boolean isPrimitive(Object obj) {
        try {
            if (obj.getClass().isArray() && isArray(obj.getClass().getComponentType())) {
                return true;
            } else {
                return obj.getClass().isPrimitive() || obj instanceof String;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isArray(Class<?> obj) {
        if (obj.isArray()) {
            isArray(obj.getComponentType());
        } else {
            return obj.isPrimitive() ||
                    obj.getName().equals("java.lang.Boolean") ||
                    obj.getName().equals("java.lang.Character") ||
                    obj.getName().equals("java.lang.Byte") ||
                    obj.getName().equals("java.lang.Short") ||
                    obj.getName().equals("java.lang.Integer") ||
                    obj.getName().equals("java.lang.Long") ||
                    obj.getName().equals("java.lang.Float") ||
                    obj.getName().equals("java.lang.Double") ||
                    obj.getName().equals("java.lang.Void") ||
                    obj.getName().equals("java.lang.String") ;
        }
        return false;
    }

}
