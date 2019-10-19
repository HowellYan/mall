package com.mall.customer.base;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Table(name = "cust_info")
public class CustInfo implements Serializable {

  @Id
  @TableId
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
}
