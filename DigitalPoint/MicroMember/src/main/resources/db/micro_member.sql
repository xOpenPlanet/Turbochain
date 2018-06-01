SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for integrate
-- ----------------------------
DROP TABLE IF EXISTS `integrate`;
CREATE TABLE `integrate` (
  `id` varchar(40) NOT NULL,
  `integrate` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for integrate_detail
-- ----------------------------
DROP TABLE IF EXISTS `integrate_detail`;
CREATE TABLE `integrate_detail` (
  `txid` varchar(255) NOT NULL COMMENT '积分明细编号',
  `memberOID` varchar(36) NOT NULL COMMENT '用户编号',
  `companyOID` varchar(32) DEFAULT NULL COMMENT '所属租户',
  `siteOID` varchar(32) DEFAULT NULL COMMENT '所属场站',
  `createTime` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(32) DEFAULT NULL COMMENT '更新时间',
  `integral` varchar(32) DEFAULT NULL COMMENT '消费积分',
  `type` varchar(32) DEFAULT NULL COMMENT '1、兑换2、抵扣3、累计',
  `deductibleAmount` varchar(32) DEFAULT NULL COMMENT '抵扣金额',
  `consumeAmount` varchar(32) DEFAULT NULL COMMENT '消费金额',
  `goods` varchar(32) DEFAULT NULL COMMENT '消费商品',
  `goodsQty` varchar(10) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`txid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
