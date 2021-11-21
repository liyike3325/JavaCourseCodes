-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-11-21 14:31:50
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
-- 数据库： `fbank1`
--

-- --------------------------------------------------------

--
-- 表的结构 `account_info`
--

CREATE TABLE `account_info` (
  `id` bigint(20) NOT NULL,
  `account_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '户主姓名',
  `account_no` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡号',
  `account_password` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '帐户密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `account_info`
--

INSERT INTO `account_info` (`id`, `account_name`, `account_no`, `account_password`) VALUES
(2, '张三的账户', '1', '');

-- --------------------------------------------------------

--
-- 表的结构 `balance`
--

CREATE TABLE `balance` (
  `id` int(11) NOT NULL,
  `account_no` varchar(100) NOT NULL COMMENT '银行卡号',
  `rmb` decimal(10,2) NOT NULL COMMENT '人民币',
  `frozen_rmb` decimal(10,2) NOT NULL COMMENT '冻结人民币',
  `dollar` decimal(10,2) NOT NULL COMMENT '美元',
  `frozen_dollar` decimal(10,2) NOT NULL COMMENT '冻结美元'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='余额表';

--
-- 转存表中的数据 `balance`
--

INSERT INTO `balance` (`id`, `account_no`, `rmb`, `frozen_rmb`, `dollar`, `frozen_dollar`) VALUES
(1, '1', '100.00', '0.00', '100.00', '0.00');

-- --------------------------------------------------------

--
-- 表的结构 `local_cancel_log`
--

CREATE TABLE `local_cancel_log` (
  `tx_no` varchar(64) NOT NULL COMMENT '事务id',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `local_confirm_log`
--

CREATE TABLE `local_confirm_log` (
  `tx_no` varchar(64) NOT NULL COMMENT '事务id',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `local_try_log`
--

CREATE TABLE `local_try_log` (
  `tx_no` varchar(64) NOT NULL COMMENT '事务id',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转储表的索引
--

--
-- 表的索引 `account_info`
--
ALTER TABLE `account_info`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `local_cancel_log`
--
ALTER TABLE `local_cancel_log`
  ADD PRIMARY KEY (`tx_no`);

--
-- 表的索引 `local_try_log`
--
ALTER TABLE `local_try_log`
  ADD PRIMARY KEY (`tx_no`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `account_info`
--
ALTER TABLE `account_info`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `balance`
--
ALTER TABLE `balance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
