-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-11-07 13:25:07
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
-- 数据库： `bootcamp_shop_1`
--

-- --------------------------------------------------------

--
-- 表的结构 `bs_order_0`
--

CREATE TABLE `bs_order_0` (
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

--
-- 转存表中的数据 `bs_order_0`
--

INSERT INTO `bs_order_0` (`id`, `uid`, `tid`, `oid`, `item_id`, `quantity`, `price`, `total_fee`, `payment`, `item_name`, `status`, `create_time`, `update_time`, `delete_time`) VALUES
(1, 1, '664119076745904128', 'ON1', 1, 1, '100.00', '100.00', '100.00', '鞋子', 'TRADE_FINISHED', '2021-11-07 06:52:05', '2021-11-07 06:52:05', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `bs_order_1`
--

CREATE TABLE `bs_order_1` (
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

--
-- 转存表中的数据 `bs_order_1`
--

INSERT INTO `bs_order_1` (`id`, `uid`, `tid`, `oid`, `item_id`, `quantity`, `price`, `total_fee`, `payment`, `item_name`, `status`, `create_time`, `update_time`, `delete_time`) VALUES
(1, 1, '664055992022990849', 'ON001', 1, 100, '100.00', '100.00', '100.00', '鞋子', 'TRADE_FINISHED', '2021-11-05 08:00:00', '2021-11-05 08:00:00', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `bs_order_2`
--

CREATE TABLE `bs_order_2` (
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
-- 表的结构 `bs_order_3`
--

CREATE TABLE `bs_order_3` (
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
-- 表的结构 `bs_order_4`
--

CREATE TABLE `bs_order_4` (
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
-- 表的结构 `bs_order_5`
--

CREATE TABLE `bs_order_5` (
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
-- 表的结构 `bs_order_6`
--

CREATE TABLE `bs_order_6` (
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
-- 表的结构 `bs_order_7`
--

CREATE TABLE `bs_order_7` (
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
-- 表的结构 `bs_order_8`
--

CREATE TABLE `bs_order_8` (
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
-- 表的结构 `bs_order_9`
--

CREATE TABLE `bs_order_9` (
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
-- 表的结构 `bs_order_10`
--

CREATE TABLE `bs_order_10` (
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
-- 表的结构 `bs_order_11`
--

CREATE TABLE `bs_order_11` (
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
-- 表的结构 `bs_order_12`
--

CREATE TABLE `bs_order_12` (
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
-- 表的结构 `bs_order_13`
--

CREATE TABLE `bs_order_13` (
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
-- 表的结构 `bs_order_14`
--

CREATE TABLE `bs_order_14` (
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
-- 表的结构 `bs_order_15`
--

CREATE TABLE `bs_order_15` (
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

--
-- 转储表的索引
--

--
-- 表的索引 `bs_order_0`
--
ALTER TABLE `bs_order_0`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `bs_order_1`
--
ALTER TABLE `bs_order_1`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `bs_order_0`
--
ALTER TABLE `bs_order_0`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `bs_order_1`
--
ALTER TABLE `bs_order_1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
