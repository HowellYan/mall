package com.mall.oss.handle;

import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;

public abstract class SingleRemoteTemplate<Request, Response> {
    public CommonResponse<Response> call(CommonRequest<Request> request) {
        CommonResponse<Response> response = new CommonResponse<>();
        CommonResponse<Response> resRemote = callRemote(request);
        response.setCode(resRemote.getCode());
        response.setContent(resRemote.getContent());
        if ("000000".equals(resRemote.getCode())) {
            response.setResponse(resRemote.getResponse());
        }
        return response;
    }

    //远程接口调用
    protected abstract CommonResponse<Response> callRemote(CommonRequest<Request> request) ;

}
