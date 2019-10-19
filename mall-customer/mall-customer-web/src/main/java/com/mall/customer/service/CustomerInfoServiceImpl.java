package com.mall.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.customer.base.CustInfo;
import com.mall.customer.base.CustInfoGoodsAddr;
import com.mall.customer.base.Page;
import com.mall.customer.dao.CustCollectMapper;

import javax.annotation.Resource;
import java.util.List;


@Service(version = "1.0.0")
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

    public CustInfo getById(String id) {
        return custCollectMapper.selectById(id);
    }

    public boolean update(CustInfo custInfo) {
        QueryWrapper<CustInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("realname","A");
        queryWrapper.like("realname","%a%");
        return custCollectMapper.update(custInfo, queryWrapper) > 0;
    }

    public boolean delete(CustInfo custInfo) {
        QueryWrapper<CustInfo> queryWrapper = new QueryWrapper<>();
        return custCollectMapper.delete(queryWrapper) > 0;
    }

    public List<CustInfo> test(CustInfo custInfo) {
        return custCollectMapper.test(custInfo);
    }

    public List<CustInfoGoodsAddr> test2(CustInfoGoodsAddr custInfo) {
        return custCollectMapper.test2();
    }

    @Override
    public Page<CustInfo> getPageList(Page page, CustInfo custInfo) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());// 分页 init ，拦截mybatisplus
        // mybatisplus 处理开始
        QueryWrapper<CustInfo> queryWrapper = new QueryWrapper<>();
//        List<CustInfo> list = custCollectMapper.selectList(queryWrapper);
        List<CustInfo> list = custCollectMapper.test(custInfo);
        // 分页开始
        PageInfo pageInfo = new PageInfo(list); //拦截 完毕！

        Page<CustInfo> custInfoPage = new Page<>();
        custInfoPage.setResponse(pageInfo.getList());
        custInfoPage.setPageNo(pageInfo.getPageNum());
        custInfoPage.setPageSize(pageInfo.getPageSize());
        custInfoPage.setTotalCount(pageInfo.getTotal());
        custInfoPage.setTotalPage(pageInfo.getPages());
        return custInfoPage;
    }

}
