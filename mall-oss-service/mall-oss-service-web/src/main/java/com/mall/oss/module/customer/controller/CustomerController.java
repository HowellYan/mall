package com.mall.oss.module.customer.controller;


import com.mall.customer.base.CustInfo;
import com.mall.oss.module.customer.remote.CustomerInfoServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerInfoServiceRemote customerInfoServiceRemote;

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<CustInfo> index() {
        return customerInfoServiceRemote.getList();
    }

}
