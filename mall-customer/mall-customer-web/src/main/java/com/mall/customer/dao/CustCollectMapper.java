package com.mall.customer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.customer.base.CustInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustCollectMapper extends BaseMapper<CustInfo> {
   List<CustInfo> test(@Param("custInfo")  CustInfo custInfo);
}
