-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2016 at 09:27 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tender`
--
CREATE DATABASE IF NOT EXISTS `tender` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tender`;

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
CREATE TABLE IF NOT EXISTS `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `mobile_no` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `circular_notice`
--

DROP TABLE IF EXISTS `circular_notice`;
CREATE TABLE IF NOT EXISTS `circular_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cir_date` date NOT NULL,
  `notice_desc` text NOT NULL,
  `emp_id` int(11) NOT NULL,
  `view_designation_id` int(11) NOT NULL,
  `view_dept_id` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_id` (`emp_id`),
  KEY `view_designation_id` (`view_designation_id`),
  KEY `view_dept_id` (`view_dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `circular_notice_details`
--

DROP TABLE IF EXISTS `circular_notice_details`;
CREATE TABLE IF NOT EXISTS `circular_notice_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `circular_notice_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `is_read` tinyint(1) NOT NULL,
  `read_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `circular_notice_id` (`circular_notice_id`,`emp_id`),
  KEY `emp_id` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `company_mst`
--

DROP TABLE IF EXISTS `company_mst`;
CREATE TABLE IF NOT EXISTS `company_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `demand_details`
--

DROP TABLE IF EXISTS `demand_details`;
CREATE TABLE IF NOT EXISTS `demand_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demand_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `demand_id` (`demand_id`),
  KEY `item_id` (`item_id`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `demand_mst`
--

DROP TABLE IF EXISTS `demand_mst`;
CREATE TABLE IF NOT EXISTS `demand_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fin_year` varchar(20) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `demand_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  KEY `emp_id` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `title`) VALUES
(1, 'Marketing'),
(2, 'IT'),
(3, 'Financial');

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

DROP TABLE IF EXISTS `designation`;
CREATE TABLE IF NOT EXISTS `designation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `emd_issue`
--

DROP TABLE IF EXISTS `emd_issue`;
CREATE TABLE IF NOT EXISTS `emd_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `issued_date` date NOT NULL,
  `emd_amount` double NOT NULL,
  `emd_by` varchar(50) NOT NULL,
  `cheque_no` varchar(100) NOT NULL,
  `cheque_date` varchar(100) NOT NULL,
  `is_approved` tinyint(1) NOT NULL,
  `is_refunded` tinyint(1) DEFAULT NULL,
  `refund_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `item_mst`
--

DROP TABLE IF EXISTS `item_mst`;
CREATE TABLE IF NOT EXISTS `item_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_order_details`
--

DROP TABLE IF EXISTS `purchase_order_details`;
CREATE TABLE IF NOT EXISTS `purchase_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `purchase_amt` double NOT NULL,
  `total` double NOT NULL,
  `remark` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_order_id` (`purchase_order_id`,`item_id`),
  KEY `item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_order_mst`
--

DROP TABLE IF EXISTS `purchase_order_mst`;
CREATE TABLE IF NOT EXISTS `purchase_order_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `net_total` double NOT NULL,
  `is_approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `quotation_details`
--

DROP TABLE IF EXISTS `quotation_details`;
CREATE TABLE IF NOT EXISTS `quotation_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `quotation_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `unit_wise_qty` int(11) NOT NULL,
  `unit_wise_price` double NOT NULL,
  `company_id` int(11) NOT NULL,
  `remark` text NOT NULL,
  `is_issued` tinyint(1) NOT NULL,
  `item_qty` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`),
  KEY `quotation_id` (`quotation_id`),
  KEY `item_id` (`item_id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `quotation_mst`
--

DROP TABLE IF EXISTS `quotation_mst`;
CREATE TABLE IF NOT EXISTS `quotation_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `q_date` date NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `remark` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `stock_mst`
--

DROP TABLE IF EXISTS `stock_mst`;
CREATE TABLE IF NOT EXISTS `stock_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fin_year` varchar(20) NOT NULL,
  `item_id` int(11) NOT NULL,
  `as_on_date` date NOT NULL,
  `opening_qty` int(11) NOT NULL,
  `closing_qty` int(11) NOT NULL,
  `min_qty` int(11) NOT NULL,
  `max_qty` int(11) NOT NULL,
  `rate` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) NOT NULL,
  `person_name` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zipcode` varchar(20) NOT NULL,
  `contact_no` varchar(50) NOT NULL,
  `mobile_no` varchar(50) NOT NULL,
  `fax_no` varchar(50) NOT NULL,
  `email_id` varchar(150) NOT NULL,
  `website` varchar(200) NOT NULL,
  `gst_no` varchar(100) NOT NULL,
  `gst_date` date NOT NULL,
  `cst_no` varchar(100) NOT NULL,
  `cst_date` date NOT NULL,
  `tin_no` varchar(100) NOT NULL,
  `tin_date` date NOT NULL,
  `company_desc` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `password` varchar(200) NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tender_branch`
--

DROP TABLE IF EXISTS `tender_branch`;
CREATE TABLE IF NOT EXISTS `tender_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`,`branch_id`),
  KEY `branch_id` (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tender_details`
--

DROP TABLE IF EXISTS `tender_details`;
CREATE TABLE IF NOT EXISTS `tender_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `remark` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tender_id` (`tender_id`,`item_id`),
  KEY `item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tender_mst`
--

DROP TABLE IF EXISTS `tender_mst`;
CREATE TABLE IF NOT EXISTS `tender_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pub_date` date NOT NULL,
  `pub_desc` text NOT NULL,
  `submitted_date` date NOT NULL,
  `emd` double NOT NULL,
  `doc_cost` double NOT NULL,
  `deadline_date` date NOT NULL,
  `deadline_time` time NOT NULL,
  `opening_date` date NOT NULL,
  `press_note_loc` text NOT NULL,
  `is_approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `mobile_no` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `doj` date NOT NULL,
  `branch_id` int(11) NOT NULL,
  `designation_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `email_id` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `branch_id` (`branch_id`),
  KEY `designation_id` (`designation_id`),
  KEY `department_id` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `circular_notice`
--
ALTER TABLE `circular_notice`
  ADD CONSTRAINT `circular_notice_ibfk_3` FOREIGN KEY (`view_dept_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `circular_notice_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `circular_notice_ibfk_2` FOREIGN KEY (`view_designation_id`) REFERENCES `designation` (`id`);

--
-- Constraints for table `circular_notice_details`
--
ALTER TABLE `circular_notice_details`
  ADD CONSTRAINT `circular_notice_details_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `circular_notice_details_ibfk_1` FOREIGN KEY (`circular_notice_id`) REFERENCES `circular_notice` (`id`);

--
-- Constraints for table `demand_details`
--
ALTER TABLE `demand_details`
  ADD CONSTRAINT `demand_details_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  ADD CONSTRAINT `demand_details_ibfk_1` FOREIGN KEY (`demand_id`) REFERENCES `demand_mst` (`id`),
  ADD CONSTRAINT `demand_details_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item_mst` (`id`);

--
-- Constraints for table `demand_mst`
--
ALTER TABLE `demand_mst`
  ADD CONSTRAINT `demand_mst_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `demand_mst_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `emd_issue`
--
ALTER TABLE `emd_issue`
  ADD CONSTRAINT `emd_issue_ibfk_1` FOREIGN KEY (`tender_id`) REFERENCES `tender_mst` (`id`),
  ADD CONSTRAINT `emd_issue_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `item_mst`
--
ALTER TABLE `item_mst`
  ADD CONSTRAINT `item_mst_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company_mst` (`id`);

--
-- Constraints for table `purchase_order_details`
--
ALTER TABLE `purchase_order_details`
  ADD CONSTRAINT `purchase_order_details_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item_mst` (`id`),
  ADD CONSTRAINT `purchase_order_details_ibfk_1` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order_mst` (`id`);

--
-- Constraints for table `purchase_order_mst`
--
ALTER TABLE `purchase_order_mst`
  ADD CONSTRAINT `purchase_order_mst_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  ADD CONSTRAINT `purchase_order_mst_ibfk_1` FOREIGN KEY (`tender_id`) REFERENCES `tender_mst` (`id`);

--
-- Constraints for table `quotation_details`
--
ALTER TABLE `quotation_details`
  ADD CONSTRAINT `quotation_details_ibfk_4` FOREIGN KEY (`company_id`) REFERENCES `company_mst` (`id`),
  ADD CONSTRAINT `quotation_details_ibfk_1` FOREIGN KEY (`tender_id`) REFERENCES `tender_mst` (`id`),
  ADD CONSTRAINT `quotation_details_ibfk_2` FOREIGN KEY (`quotation_id`) REFERENCES `quotation_mst` (`id`),
  ADD CONSTRAINT `quotation_details_ibfk_3` FOREIGN KEY (`item_id`) REFERENCES `item_mst` (`id`);

--
-- Constraints for table `stock_mst`
--
ALTER TABLE `stock_mst`
  ADD CONSTRAINT `stock_mst_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item_mst` (`id`);

--
-- Constraints for table `tender_branch`
--
ALTER TABLE `tender_branch`
  ADD CONSTRAINT `tender_branch_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  ADD CONSTRAINT `tender_branch_ibfk_1` FOREIGN KEY (`tender_id`) REFERENCES `tender_mst` (`id`);

--
-- Constraints for table `tender_details`
--
ALTER TABLE `tender_details`
  ADD CONSTRAINT `tender_details_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item_mst` (`id`),
  ADD CONSTRAINT `tender_details_ibfk_1` FOREIGN KEY (`tender_id`) REFERENCES `tender_mst` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`),
  ADD CONSTRAINT `user_ibfk_3` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
