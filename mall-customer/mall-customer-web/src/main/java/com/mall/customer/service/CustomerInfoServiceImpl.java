package com.mall.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.customer.base.CustInfo;
import com.mall.customer.dao.CustCollectMapper;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Resource
    private CustCollectMapper custCollectMapper;

    @Override
    public String getString(String name) {
        return "Service:"+ name;
    }

    /**
     * invoke CustomerInfoService.getList({"class":"com.mall.customer.base.CustInfo","custInfo":{}})
     * @param custInfo
     * @return
     */
    @Override
    public List<CustInfo> getList(CustInfo custInfo) {
        QueryWrapper<CustInfo> queryWrapper = new QueryWrapper<>();
        return custCollectMapper.selectList(queryWrapper);
    }
}
