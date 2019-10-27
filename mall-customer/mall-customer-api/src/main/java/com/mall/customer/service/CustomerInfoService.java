package com.mall.customer.service;

import com.mall.customer.base.CustInfo;
import com.mall.customer.base.CustInfoGoodsAddr;
import com.mall.customer.base.Page;
import com.mall.parent.entitybase.request.CommonRequest;
import com.mall.parent.entitybase.response.CommonResponse;

import java.util.List;

public interface CustomerInfoService {
    String getString(String name);

    List<CustInfo> getList(CustInfo custInfo);

    Page<CustInfo> getPageList(Page page, CustInfo custInfo);

    List<CustInfo> test(CustInfo custInfo);

    List<CustInfoGoodsAddr> test2(CustInfoGoodsAddr custInfo);

    CustInfo getById(String id);

    CommonResponse<CustInfo> getOne(CommonRequest<CustInfo> custInfoCommonRequest );

    List<CustInfo> add(CustInfo custInfo);
}
