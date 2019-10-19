package com.mall.oss.module.customer.remote;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.customer.base.CustInfo;
import com.mall.customer.service.CustomerInfoService;
import com.mall.oss.handle.SingleRemoteTemplate;
import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerOneRemote extends SingleRemoteTemplate<CustInfo, CustInfo> {
    @Reference(version = "1.0.0")
    private CustomerInfoService customerInfoService;

    @Override
    protected CommonResponse<CustInfo> callRemote(CommonRequest<CustInfo> request) {
        return customerInfoService.getOne(request);
    }
}
