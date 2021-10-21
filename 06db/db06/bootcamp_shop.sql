-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-10-21 03:24:22
-- 服务器版本： 5.7.27
-- PHP 版本： 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `bootcamp_shop`
--

-- --------------------------------------------------------

--
-- 表的结构 `bs_item`
--

CREATE TABLE `bs_item` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `quantity` int(11) NOT NULL COMMENT '库存',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';

-- --------------------------------------------------------

--
-- 表的结构 `bs_order`
--

CREATE TABLE `bs_order` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `tid` varchar(50) NOT NULL COMMENT '交易编号',
  `oid` varchar(50) NOT NULL COMMENT '子订单编号',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `price` decimal(10,2) NOT NULL COMMENT '单商品原价',
  `total_fee` decimal(10,2) NOT NULL COMMENT '商品金额（商品价格乘以数量的总金额）',
  `payment` decimal(10,2) NOT NULL COMMENT '子订单实付金额',
  `item_name` varchar(255) NOT NULL COMMENT '商品名称',
  `status` varchar(50) NOT NULL COMMENT '交易状态，可选值WAIT_BUYER_PAY(等待买家付款)、TRADE_FINISHED(交易成功)',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '订单修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '订单删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单列表';

-- --------------------------------------------------------

--
-- 表的结构 `bs_trade`
--

CREATE TABLE `bs_trade` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `tid` varchar(50) NOT NULL COMMENT '交易编号',
  `payment` decimal(10,2) NOT NULL COMMENT '最终支付价格',
  `status` varchar(50) NOT NULL COMMENT '交易状态，可选值WAIT_BUYER_PAY(等待买家付款)、TRADE_FINISHED(交易成功)',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '订单修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '订单删除时间',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '订单支付时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易信息';

-- --------------------------------------------------------

--
-- 表的结构 `bs_user`
--

CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户主表';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
