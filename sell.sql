/*
Navicat MySQL Data Transfer

Source Server         : sell
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-12-23 21:43:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1608716205194104611', '1608716205146127866', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:36:45', '2020-12-23 17:36:45');
INSERT INTO `order_detail` VALUES ('1608716236991938515', '1608716236989978144', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:37:16', '2020-12-23 17:37:16');
INSERT INTO `order_detail` VALUES ('1608716236995710817', '1608716236989978144', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:37:16', '2020-12-23 17:37:16');
INSERT INTO `order_detail` VALUES ('1608716264031119732', '1608716264029831668', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:37:44', '2020-12-23 17:37:44');
INSERT INTO `order_detail` VALUES ('1608716264033262198', '1608716264029831668', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:37:44', '2020-12-23 17:37:44');
INSERT INTO `order_detail` VALUES ('1608716281046600008', '1608716281044874053', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:38:01', '2020-12-23 17:38:01');
INSERT INTO `order_detail` VALUES ('1608716281049949908', '1608716281044874053', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:38:01', '2020-12-23 17:38:01');
INSERT INTO `order_detail` VALUES ('1608716296880903248', '1608716296878161403', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:38:16', '2020-12-23 17:38:16');
INSERT INTO `order_detail` VALUES ('1608716296886479739', '1608716296878161403', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:38:16', '2020-12-23 17:38:16');
INSERT INTO `order_detail` VALUES ('1608716306823967124', '1608716306821548517', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:38:26', '2020-12-23 17:38:26');
INSERT INTO `order_detail` VALUES ('1608716306827856358', '1608716306821548517', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:38:26', '2020-12-23 17:38:26');
INSERT INTO `order_detail` VALUES ('1608716319120676690', '1608716319119528766', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:38:39', '2020-12-23 17:38:39');
INSERT INTO `order_detail` VALUES ('1608716319123663329', '1608716319119528766', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:38:39', '2020-12-23 17:38:39');
INSERT INTO `order_detail` VALUES ('1608716338598104400', '1608716338596381414', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:38:58', '2020-12-23 17:38:58');
INSERT INTO `order_detail` VALUES ('1608716338600273709', '1608716338596381414', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:38:58', '2020-12-23 17:38:58');
INSERT INTO `order_detail` VALUES ('1608716369494413138', '1608716369493674583', '1', '八宝粥', '5.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 17:39:29', '2020-12-23 17:39:29');
INSERT INTO `order_detail` VALUES ('1608716369499548753', '1608716369493674583', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201118144712875.png?x-oss-https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 17:39:29', '2020-12-23 17:39:29');
INSERT INTO `order_detail` VALUES ('1608729111690660104', '1608729111686373802', '1', '八宝粥', '6.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:11:51', '2020-12-23 21:11:51');
INSERT INTO `order_detail` VALUES ('1608729111696695584', '1608729111686373802', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:11:51', '2020-12-23 21:11:51');
INSERT INTO `order_detail` VALUES ('1608729402731482978', '1608729402729234608', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:16:42', '2020-12-23 21:16:42');
INSERT INTO `order_detail` VALUES ('1608729402738157279', '1608729402729234608', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:16:42', '2020-12-23 21:16:42');
INSERT INTO `order_detail` VALUES ('1608729409073511575', '1608729409070219436', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:16:49', '2020-12-23 21:16:49');
INSERT INTO `order_detail` VALUES ('1608729409076665898', '1608729409070219436', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:16:49', '2020-12-23 21:16:49');
INSERT INTO `order_detail` VALUES ('1608729425193746229', '1608729425191428231', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:17:05', '2020-12-23 21:17:05');
INSERT INTO `order_detail` VALUES ('1608729425196613626', '1608729425191428231', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:17:05', '2020-12-23 21:17:05');
INSERT INTO `order_detail` VALUES ('1608729439214451516', '1608729439213697177', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:17:19', '2020-12-23 21:17:19');
INSERT INTO `order_detail` VALUES ('1608729439217929345', '1608729439213697177', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:17:19', '2020-12-23 21:17:19');
INSERT INTO `order_detail` VALUES ('1608729454673378411', '1608729454671295763', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:17:34', '2020-12-23 21:17:34');
INSERT INTO `order_detail` VALUES ('1608729454675613117', '1608729454671295763', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:17:34', '2020-12-23 21:17:34');
INSERT INTO `order_detail` VALUES ('1608729472757624418', '1608729472755326949', '1', '八宝粥', '7.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:17:52', '2020-12-23 21:17:52');
INSERT INTO `order_detail` VALUES ('1608729472760100204', '1608729472755326949', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:17:52', '2020-12-23 21:17:52');
INSERT INTO `order_detail` VALUES ('1608729656731595706', '1608729656730873427', '1', '八宝粥', '8.00', '2', 'https://img-blog.csdnimg.cn/20201223173114430.png', '2020-12-23 21:20:56', '2020-12-23 21:20:56');
INSERT INTO `order_detail` VALUES ('1608729656734806417', '1608729656730873427', '2', '南瓜粥', '12.00', '2', 'https://img-blog.csdnimg.cn/20201223173235731.png', '2020-12-23 21:20:56', '2020-12-23 21:20:56');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1608716205146127866', ' 张珊', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '10.00', '0', '0', '2020-12-23 17:36:45', '2020-12-23 17:36:45');
INSERT INTO `order_master` VALUES ('1608716236989978144', ' 张珊', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:37:16', '2020-12-23 17:37:16');
INSERT INTO `order_master` VALUES ('1608716264029831668', ' 张小瑞', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:37:44', '2020-12-23 17:37:44');
INSERT INTO `order_master` VALUES ('1608716281044874053', '齐齐猪', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:38:01', '2020-12-23 17:38:01');
INSERT INTO `order_master` VALUES ('1608716296878161403', '义义虎', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:38:16', '2020-12-23 17:38:16');
INSERT INTO `order_master` VALUES ('1608716306821548517', '清清鱼', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:38:26', '2020-12-23 17:38:26');
INSERT INTO `order_master` VALUES ('1608716319119528766', '明明慧', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '0', '0', '2020-12-23 17:38:39', '2020-12-23 17:38:39');
INSERT INTO `order_master` VALUES ('1608716338596381414', '颖颖旭', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '2', '0', '2020-12-23 17:38:58', '2020-12-23 21:20:21');
INSERT INTO `order_master` VALUES ('1608716369493674583', '帅帅龙', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '34.00', '2', '0', '2020-12-23 17:39:29', '2020-12-23 21:20:16');
INSERT INTO `order_master` VALUES ('1608729111686373802', '帅帅龙', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '36.00', '1', '0', '2020-12-23 21:11:51', '2020-12-23 21:20:10');
INSERT INTO `order_master` VALUES ('1608729656730873427', '帅帅龙', ' 18853261111', '火星', ' ew3euwhd7sjw9diwkq', '40.00', '0', '0', '2020-12-23 21:20:56', '2020-12-23 21:20:56');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '新品榜', '1', '2020-12-14 23:57:35', '2020-12-23 17:34:49');
INSERT INTO `product_category` VALUES ('2', '促销榜', '2', '2020-12-20 19:25:26', '2020-12-23 17:34:52');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', '八宝粥', '8.00', '40', '八宝粥很好吃的哦', 'https://img-blog.csdnimg.cn/20201223173114430.png', '0', '1', '2020-12-23 21:20:34', '2020-12-23 21:20:56');
INSERT INTO `product_info` VALUES ('2', '南瓜粥', '12.00', '68', '南瓜粥很好吃的哦', 'https://img-blog.csdnimg.cn/20201223173235731.png', '0', '2', '2020-12-23 17:49:08', '2020-12-23 21:20:56');
INSERT INTO `product_info` VALUES ('3', '锅贴', '25.00', '100', '锅贴也是很好吃的哦', 'https://img-blog.csdnimg.cn/20201223173334146.png', '0', '1', '2020-12-23 17:34:20', '2020-12-23 21:20:46');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `type` int(64) NOT NULL COMMENT '用户类型，0表示用户，1表示管理员',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1', 'along', '111', '1', '2020-12-23 19:29:28', '2020-12-23 19:29:28');
INSERT INTO `seller_info` VALUES ('2', 'along', '111', '0', '2020-12-23 19:29:28', '2020-12-23 19:29:28');
