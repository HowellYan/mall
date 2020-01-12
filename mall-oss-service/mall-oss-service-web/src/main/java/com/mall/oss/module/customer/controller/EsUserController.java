package com.mall.oss.module.customer.controller;

import com.mall.oss.module.customer.service.EsUserService;
import com.mall.oss.module.entity.EsLog;
import com.mall.oss.module.entity.EsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class EsUserController {

    @Autowired
    private EsUserService esUserService;

    @ResponseBody
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public Page<EsUser> getLog(@RequestBody EsUser esUser) {
        return esUserService.getList(esUser);
    }

    @ResponseBody
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public EsUser saveUser(@RequestBody EsUser esUser) {
        if (esUser == null){
            return null;
        }
        esUser.setId(UUID.randomUUID().toString().replaceAll("-",""));
        return esUserService.saveOrUpdate(esUser);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public EsUser updateUser(@RequestBody EsUser esUser) {
        if (esUser == null || (esUser!=null && esUser.getId() == null)) {
            return null;
        }
        return esUserService.saveOrUpdate(esUser);
    }


}
