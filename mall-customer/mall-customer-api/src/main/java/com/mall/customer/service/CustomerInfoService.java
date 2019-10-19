package com.mall.customer.service;

import com.mall.customer.base.CustInfo;
import com.mall.customer.base.Page;

import java.util.List;

public interface CustomerInfoService {
    String getString(String name);

    List<CustInfo> getList(CustInfo custInfo);

    Page<CustInfo> getPageList(Page page, CustInfo custInfo);

    List<CustInfo> test(CustInfo custInfo);
}
