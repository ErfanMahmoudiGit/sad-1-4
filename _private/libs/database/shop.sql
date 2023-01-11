-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 11, 2023 at 01:00 AM
-- Server version: 5.7.40
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `AddBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddBook` (IN `p_bookId` VARCHAR(255), IN `p_bookName` VARCHAR(255), IN `p_bookCategory` VARCHAR(255), IN `p_bookPrice` FLOAT(50) UNSIGNED, IN `p_bookCount` INT(30) UNSIGNED, IN `p_bookisActive` BOOLEAN)   INSERT into `book`(book.`book_id`,book.`name`,book.`category`,book.`price`,book.`count`,book.`is_active`) VALUES (p_bookId,p_bookName,p_bookCategory,p_bookPrice,p_bookCount,p_bookisActive)$$

DROP PROCEDURE IF EXISTS `CheckUserPass`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CheckUserPass` (IN `p_username` VARCHAR(255), IN `P_password` VARCHAR(255))   SELECT * FROM user WHERE user.`username` = p_username AND user.`password` = P_password$$

DROP PROCEDURE IF EXISTS `GetAllUsers`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllUsers` ()   SELECT * FROM user$$

DROP PROCEDURE IF EXISTS `getNameByUsername`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getNameByUsername` (IN `p_username` VARCHAR(255))   SELECT `user`.`firstname` FROM user where `user`.`username` = p_username$$

DROP PROCEDURE IF EXISTS `IsUsernameExist`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `IsUsernameExist` (IN `p_username` VARCHAR(255))   SELECT * FROM user WHERE user.`username` = p_username$$

DROP PROCEDURE IF EXISTS `registerUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `registerUser` (IN `p_username` VARCHAR(255), IN `p_firstname` VARCHAR(255), IN `p_lastname` VARCHAR(255), IN `p_phonenumber` VARCHAR(20), IN `p_password` VARCHAR(255))   INSERT INTO user(user.`username`, user.`firstname`, user.`lastname`, user.`phonenumber`, user.`password`) VALUES(p_username, p_firstname, p_lastname, p_phonenumber, p_password )$$

DROP PROCEDURE IF EXISTS `searchBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchBook` (IN `BookName` VARCHAR(255))   SELECT * FROM book WHERE `book`.`name` = BookName$$

DROP PROCEDURE IF EXISTS `SearchBookByCategory`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchBookByCategory` (IN `s_category` VARCHAR(255))   SELECT * FROM book WHERE `book`.`category` = s_category$$

DROP PROCEDURE IF EXISTS `UpdateBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateBook` (IN `b_username` VARCHAR(255), IN `b_name` VARCHAR(255), IN `b_category` VARCHAR(255), IN `b_price` FLOAT(50), IN `b_count` INT(30), IN `b_isActivate` BOOLEAN)   UPDATE book SET `book`.`book_id` = b_username , `book`.`name` = b_name ,`book`.`category` = b_category ,`book`.`price` = b_price , `book`.`count` = b_count ,`book`.`is_active` = b_isActivate WHERE book.book_id = b_username$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `count` int(10) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `name`, `category`, `price`, `count`, `is_active`) VALUES
('book1', 'riazi1', 'riaziat', 700000, 0, 0),
('book2', 'riazi2', 'riaziat', 100000, 0, 0),
('book3', 'tarahi', 'honar', 200000, 0, 0),
('book4', 'tahlil tarahi', 'computer', 200000, 1, 1),
('b4', 'shimi2', 'paye', 125000, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `username` varchar(255) NOT NULL,
  `book_id` varchar(255) NOT NULL,
  `buy_time_at` datetime NOT NULL,
  PRIMARY KEY (`username`,`book_id`,`buy_time_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `firstname`, `lastname`, `phonenumber`) VALUES
('user1', '1111', 'ali', 'khalili', '09909999999'),
('user2', '1111', 'amir', 'amiri', '099088888888'),
('user3', '81dc9bdb52d04dc20036dbd8313ed055', 'yasin', 'yasiin', '09999999'),
('mmd', '6512bd43d9caa6e02c990b0a82652dca', 'محمد', 'جعفری', '09123456789'),
('amirhosain', '1111', 'amir', 'h', '0907');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
