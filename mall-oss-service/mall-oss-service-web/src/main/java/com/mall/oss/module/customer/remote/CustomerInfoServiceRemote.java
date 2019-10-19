package com.mall.oss.module.customer.remote;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.customer.base.CustInfo;
import com.mall.customer.service.CustomerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInfoServiceRemote {
    @Reference(version = "1.0.0")
    private CustomerInfoService customerInfoService;


    public List<CustInfo> getList() {
        return customerInfoService.test(new CustInfo());
    }
}