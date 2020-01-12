package com.mall.oss.module.customer.controller;


import com.mall.customer.base.CustInfo;
import com.mall.oss.module.customer.remote.CustomerInfoServiceRemote;
import com.mall.oss.module.customer.remote.GetCustomerOneRemote;
import com.mall.oss.module.customer.service.EsLogService;
import com.mall.oss.module.entity.EsLog;
import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private EsLogService esLogService;

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
    public CommonResponse<CustInfo> getOne(@PathVariable("id") long id) {
        CommonRequest<CustInfo> request = new CommonRequest<>();
        CustInfo custInfo = new CustInfo();
        custInfo.setLoginAccount(id);
        request.setRequest(custInfo);
        return getCustomerOneRemote.call(request);
    }


    @ResponseBody
    @RequestMapping(value = "/getLog",method = RequestMethod.GET)
    public Page<EsLog> getLog() {
        return esLogService.getLog();
    }

}
