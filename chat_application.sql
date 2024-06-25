-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2024 lúc 04:48 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `chat_application`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `files`
--

CREATE TABLE `files` (
  `FileID` int(10) UNSIGNED NOT NULL,
  `FileExtension` varchar(255) DEFAULT NULL,
  `BlurHash` varchar(255) DEFAULT NULL,
  `Status` char(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `files`
--

INSERT INTO `files` (`FileID`, `FileExtension`, `BlurHash`, `Status`) VALUES
(13, '.jpg', NULL, '0'),
(14, '.jpg', NULL, '0'),
(15, '.jpg', NULL, '0'),
(16, '.jpg', NULL, '0'),
(17, '.jpg', NULL, '0'),
(18, '.jpg', NULL, '0'),
(19, '.jpg', NULL, '0'),
(20, '.jpg', NULL, '0'),
(21, '.jpg', NULL, '0'),
(22, '.jpg', NULL, '0'),
(23, '.jpg', NULL, '0'),
(24, '.jpg', NULL, '0'),
(25, '.jpg', NULL, '0'),
(26, '.jpg', NULL, '0'),
(27, '.jpg', NULL, '0'),
(28, '.jpg', NULL, '0'),
(29, '.jpg', NULL, '0'),
(30, '.jpg', NULL, '0'),
(31, '.jpg', NULL, '0'),
(32, '.jpg', NULL, '0'),
(33, '.jpg', NULL, '0'),
(34, '.jpg', NULL, '0'),
(35, '.jpg', NULL, '0'),
(36, '.jpg', NULL, '0'),
(37, '.jpg', NULL, '0'),
(38, '.jpg', NULL, '0'),
(39, '.jpg', NULL, '0'),
(40, '.jpg', NULL, '0'),
(41, '.jpg', NULL, '0'),
(42, '.jpg', NULL, '0'),
(43, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(44, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(45, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(46, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(47, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(48, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(49, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(50, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(51, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(52, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(53, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(54, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(55, '.jpg', 'LPGbn;NYIVM{~n%Ks:R*bwnz?HkD', '1'),
(56, '.jpg', 'LfHU^8D%?bWB~qoJo#xt?bxtV[kC', '1'),
(57, '.jpg', 'LQKBEwt6tlSh_4%2?HMx_NWXM{xt', '1'),
(58, '.jpg', 'LQKBEwt6tlSh_4%2?HMx_NWXM{xt', '1'),
(59, '.jpg', 'LfHU^8D%?bWB~qoJo#xt?bxtV[kC', '1'),
(60, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(61, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(62, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(63, '.jpg', 'LOKKi_s:?^bFIXj]oyax%KWBNHt7', '1'),
(64, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(65, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(66, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(67, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(68, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(69, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(70, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(71, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(72, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(73, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(74, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(75, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(76, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(77, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(78, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(79, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(80, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(81, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(82, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(83, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(84, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(85, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(86, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(87, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(88, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(89, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(90, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(91, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(92, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(93, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(94, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(95, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(96, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(97, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(98, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(99, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(100, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(101, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(102, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(103, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(104, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(105, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(106, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(107, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(108, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(109, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(110, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(111, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(112, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(113, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(114, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(115, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(116, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(117, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(118, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(119, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(120, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(121, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(122, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(123, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(124, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(125, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(126, '.png', 'LISr.Xt7?wX9x]o0tTSOyXf6WAfk', '1'),
(127, '.png', 'LOH06M{^0o5=j1$3WFNd$yNxoI$z', '1'),
(128, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1'),
(129, '.jpg', 'LeQ0aRof~pj[%LRjM|xu-;f6E1bH', '1'),
(130, '.jpg', 'LPEMFJf-1BbcW@xUk9NN0[juw?oI', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `UserID` int(10) UNSIGNED NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Avatar` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`UserID`, `UserName`, `Password`, `Avatar`) VALUES
(1, 'Minh Hiếu', '0901178334bin', NULL),
(2, 'Phương Thảo', '0901178334bin', NULL),
(25, 'subincot', '123', NULL),
(26, 'Hieu', '123', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `UserID` int(10) UNSIGNED NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Gender` char(1) NOT NULL DEFAULT '',
  `Image` mediumtext DEFAULT NULL,
  `ImageString` varchar(255) DEFAULT '',
  `Status` char(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`UserID`, `UserName`, `Gender`, `Image`, `ImageString`, `Status`) VALUES
(1, 'Minh Hiếu', '', NULL, '', '1'),
(2, 'Phương Thảo', '', NULL, '', '1'),
(25, 'subincot', '', NULL, '', '1'),
(26, 'Hieu', '', NULL, '', '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`FileID`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`);

--
-- Chỉ mục cho bảng `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `files`
--
ALTER TABLE `files`
  MODIFY `FileID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `user_account`
--
ALTER TABLE `user_account`
  MODIFY `UserID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `user_account`
--
ALTER TABLE `user_account`
  ADD CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
