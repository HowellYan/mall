package com.mall.customer.handle;

import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;

public abstract class SingleTemplate<Request, Response> {

    public CommonResponse<Response> call(CommonRequest<Request> request) {
        CommonResponse<Response> response = new CommonResponse<Response>();
        //请求remote
        try {
            Response Response = callInner(request);
            response.setResponse(Response);
            response.setCode("000000");
            response.setContent("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    protected abstract Response callInner(CommonRequest<Request> request) throws Exception;
}
