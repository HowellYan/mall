package com.mall.customer.service;

import com.mall.customer.base.CustInfo;

import java.util.List;

public interface CustomerInfoService {
    String getString(String name);

    List<CustInfo> getList(CustInfo custInfo);
}
