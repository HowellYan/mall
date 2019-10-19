package com.mall.oss.module.customer.controller;


import com.mall.customer.base.CustInfo;
import com.mall.oss.module.customer.remote.CustomerInfoServiceRemote;
import com.mall.oss.module.customer.remote.GetCustomerOneRemote;
import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerInfoServiceRemote customerInfoServiceRemote;

    @Autowired
    private GetCustomerOneRemote getCustomerOneRemote;

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<CustInfo> index() {
        return customerInfoServiceRemote.getList();
    }

    @ResponseBody
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET)
    public CommonResponse<CustInfo> getOne(@PathVariable("id") String id) {
        CommonRequest<CustInfo> request = new CommonRequest<>();
        CustInfo custInfo = new CustInfo();
        custInfo.setLoginAccount(id);
        request.setRequest(custInfo);
        return getCustomerOneRemote.call(request);
    }

}
