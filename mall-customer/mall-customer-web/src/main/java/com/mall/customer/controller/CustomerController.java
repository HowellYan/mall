package com.mall.customer.controller;

import com.mall.customer.base.CustInfo;
import com.mall.customer.base.Page;
import com.mall.customer.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CustomerController {

    @Resource
    private CustomerInfoService customerInfoService;

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<CustInfo> index() {
        return customerInfoService.getList(new CustInfo());
    }

    @ResponseBody
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public Page<CustInfo> page(@ModelAttribute Page<CustInfo> page,
                               @ModelAttribute CustInfo custInfo) {
        return customerInfoService.getPageList(page, custInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<CustInfo> test(CustInfo custInfo){
        return customerInfoService.test(custInfo);
    }

}
