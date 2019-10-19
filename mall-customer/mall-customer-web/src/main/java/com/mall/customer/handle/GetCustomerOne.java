package com.mall.customer.handle;

import com.mall.customer.base.CustInfo;
import com.mall.customer.dao.CustCollectMapper;
import com.mall.parent.entitybase.request.CommonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class GetCustomerOne extends SingleTemplate<CustInfo, CustInfo> {

    @Resource
    private CustCollectMapper custCollectMapper;

    @Override
    protected CustInfo callInner(CommonRequest<CustInfo> request) throws Exception {
        CustInfo custInfo = request.getRequest();
        return custCollectMapper.selectById(custInfo.getLoginAccount());
    }
}
