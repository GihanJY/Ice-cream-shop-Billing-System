-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2024 at 07:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `icecreamshopdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `icecream`
--

CREATE TABLE `icecream` (
  `idicecream` int(11) NOT NULL,
  `icecreamname` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `flavor` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `icecream`
--

INSERT INTO `icecream` (`idicecream`, `icecreamname`, `price`, `flavor`, `type`) VALUES
(1, 'Vanilla Delight', 350, 'Vanilla', 'Tubs'),
(2, 'Choco Bliss', 400, 'Chocolate', 'Cones'),
(3, 'Strawberry Dream', 375, 'Strawberry', 'Scoops'),
(4, 'Minty Magic', 425, 'Mint', 'Cones'),
(5, 'Caramel Crunch', 450, 'Caramel', 'Tubs'),
(6, 'Berry Burst', 400, 'Mixed Berry', 'Scoops'),
(7, 'Pistachio Punch', 475, 'Pistachio', 'Tubs'),
(8, 'Mango Mania', 395, 'Mango', 'Cones'),
(9, 'Lemon Zest', 380, 'Lemon', 'Scoops'),
(10, 'Cookie Craze', 460, 'Cookies & Cream', 'Cones'),
(11, 'Coffee Bliss', 425, 'Coffee', 'Tubs'),
(12, 'Hazelnut Heaven', 485, 'Hazelnut', 'Cones'),
(13, 'Butterscotch Bites', 440, 'Butterscotch', 'Tubs'),
(14, 'Coconut Chill', 395, 'Coconut', 'Popsicals'),
(15, 'Peachy Keen', 410, 'Peach', 'Scoops'),
(16, 'Raspberry Rush', 390, 'Raspberry', 'Popsicals'),
(17, 'Almond Amour', 465, 'Almond', 'Tubs'),
(18, 'Tropical Tango', 400, 'Pineapple', 'Popsicals'),
(19, 'Black Forest Bliss', 475, 'Black Forest', 'Scoops'),
(20, 'Blueberry Bliss', 420, 'Blueberry', 'Cones');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `userpassword` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `username`, `userpassword`) VALUES
(1, 'Admin', '1234'),
(2, 'Saman', '2345'),
(3, 'Kamal', '3456'),
(4, 'Saduni', '4567'),
(5, 'Nethmi', '5678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `icecream`
--
ALTER TABLE `icecream`
  ADD PRIMARY KEY (`idicecream`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `icecream`
--
ALTER TABLE `icecream`
  MODIFY `idicecream` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
