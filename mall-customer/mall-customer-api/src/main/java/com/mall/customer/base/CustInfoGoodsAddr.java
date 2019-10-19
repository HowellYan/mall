package com.mall.customer.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustInfoGoodsAddr implements Serializable {
    private String loginAccount;
    private String loginPw;
    private String payPw;
    private String identity;
    private Date createTime;
    private Date updateTime;
    private String nickname;
    private String realname;
    private long sex = 1;
    private Date birthday;
    private String province;
    private String city;
    private String district;
    private String address;
    private String drinkWine;
    private String likeWine;
    private String headerimg;
    private String marry;
    private String education;
    private String job;
    private String industry;
    private String income;
    private long custLevel = 1;
    private long status = 1;

    private String goodsAddrId;
    //@NotNull(message = "收货人")
    private String consignee;
    //@NotNull(message = "省")
    private String bprovince;
    // "市")
    private String bcity;
    // "区")
    private String bdistrict;
    // "详细地址")
    private String baddress;
    // "邮政编码")
    private String postcode;
    // "手机号码")
    private String moblie;
    // "固定电话")
    private String telephone;

}
