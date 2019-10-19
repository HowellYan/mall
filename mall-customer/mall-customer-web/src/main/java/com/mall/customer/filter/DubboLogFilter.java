package com.mall.customer.filter;

import com.alibaba.dubbo.rpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Slf4j
public class DubboLogFilter implements Filter {
    private static final String BEFORE_LOG_MSG = "Calling  service[{}.{}][{}].Sent request:{}.";
    private static final String AFTER_LOG_MSG = "Called  service[{}.{}].[{}]. elapsed:[{} Seconds] ";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //打印请求前日志
        doLogBefore(invoker, invocation);

        //调用
        Result result = invoker.invoke(invocation);

        //打印请求后日志
        stopWatch.stop();

        doLogAfter(invoker, invocation, result.getValue(), stopWatch.getTotalTimeSeconds());
        return result;
    }

    private void doLogBefore(Invoker<?> invoker, Invocation invocation) {
        log.info(BEFORE_LOG_MSG,
                invoker.getInterface().getSimpleName(), invocation.getMethodName(),
                invoker.getUrl().getAddress(),  invocation.getArguments());
    }

    private void doLogAfter(Invoker<?> invoker, Invocation invocation, Object response, Double elapsed) {
        String clazzName = invoker.getInterface().getSimpleName();   //获得类名
        String methodName = invocation.getMethodName();
        log.info(AFTER_LOG_MSG,
                clazzName, methodName, response == null?null:response.toString(),elapsed);
    }
}
