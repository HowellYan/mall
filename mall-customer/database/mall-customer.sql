SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cust_collect
-- ----------------------------
DROP TABLE IF EXISTS `cust_collect`;
CREATE TABLE `cust_collect` (
  `login_account` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `goods_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`login_account`,`goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='客户商品收藏列表';

-- ----------------------------
-- Table structure for cust_goods_addr
-- ----------------------------
DROP TABLE IF EXISTS `cust_goods_addr`;
CREATE TABLE `cust_goods_addr` (
  `goods_addr_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `login_account` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登陆账号',
  `consignee` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人',
  `province` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省',
  `city` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '市',
  `district` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区',
  `address` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址',
  `postcode` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `moblie` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号码',
  `telephone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '固定电话',
  PRIMARY KEY (`goods_addr_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='收货地址';

-- ----------------------------
-- Table structure for cust_info
-- ----------------------------
DROP TABLE IF EXISTS `cust_info`;
CREATE TABLE `cust_info` (
  `login_account` bigint(20) NOT NULL COMMENT '登陆账号(登录号就是手机号)',
  `login_pw` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码,请加密不可逆',
  `pay_pw` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付密码,请加密不可逆',
  `identity` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `nickname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `realname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `sex` int(2) NOT NULL DEFAULT '0' COMMENT '性别:1.男 2.女 0.未知',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日时间',
  `province` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `city` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `district` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区',
  `address` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `drink_wine` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '常喝酒类：白酒,红酒',
  `like_wine` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '喜欢酒类品牌：牌子1,牌子2',
  `headerimg` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像地址',
  `marry` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '婚姻状况 1.已婚有子女 2.未婚无子女 3.恋爱中 4.单身 5.丧偶 6.离异',
  `education` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教育程度 1.高中及以下 2.大学专科 3.大学本科 4.硕士 5.',
  `job` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '从事职业',
  `industry` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业',
  `income` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '月均收入',
  `cust_level` int(2) NOT NULL DEFAULT '1' COMMENT '客户等级：1.普通用户 2.普通实名',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '客户状态：1.正常 2.冻结',
  PRIMARY KEY (`login_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='客户信息表';

SET FOREIGN_KEY_CHECKS = 1;
