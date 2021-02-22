-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2021 at 04:52 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dtb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_account`
--

CREATE TABLE `tb_account` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(250) NOT NULL,
  `name` varchar(100) NOT NULL,
  `question` varchar(250) NOT NULL,
  `answer` varchar(200) NOT NULL,
  `created_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_account`
--

INSERT INTO `tb_account` (`id`, `username`, `password`, `name`, `question`, `answer`, `created_date`) VALUES
(1, 'Monica', '$2a$10$wwjtY.CLoUmo5rRH4.MWWO8FzT8BITMf/JxIlQ5ToQj1r680E.PFG', 'monica', 'How do you feel ?', 'sad', '2019-09-12'),
(4, 'son', '$2a$10$MI0tk.46WpsGZst4u29d..xIFNC1EK9fsQIqUWOo53OrO2LbuKmTK', 'son', 'How do you feel ?', 'sad', '2019-09-19'),
(5, 'son', '$2a$10$3CPHvTVYtBatIQ/CMzZnU.bFwbg4A7MLPmTrUkYZwwtQuyA8i6js.', 'son', 'How do you feel ?', 'cold', '2020-06-29');

-- --------------------------------------------------------

--
-- Table structure for table `tb_book_cat`
--

CREATE TABLE `tb_book_cat` (
  `id` int(11) NOT NULL,
  `category` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_book_cat`
--

INSERT INTO `tb_book_cat` (`id`, `category`) VALUES
(1, 'abcd'),
(2, 'novel'),
(3, 'romance');

-- --------------------------------------------------------

--
-- Table structure for table `tb_book_detail`
--

CREATE TABLE `tb_book_detail` (
  `title` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `photo` longblob NOT NULL,
  `status` bit(1) NOT NULL,
  `rental_price` float NOT NULL,
  `id_cat` int(11) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `call_number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_book_detail`
--

INSERT INTO `tb_book_detail` (`title`, `author`, `photo`, `status`, `rental_price`, `id_cat`, `isbn`, `call_number`) VALUES
('fgdfhfghs', 'dfhsfhs', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff610000000473424954080808087c086488000000097048597300000b1300000b1301009a9c18000000d849444154388dddd2bf4a825118c7f18f38a8af6b8d8dd122045111cd3517742bdd407397d1204a4d42280ede400435d4102d0de150a8416043e6f01ee8457c8fb438f4dbcef3e7fb9ce7fc0eff56655ce113277f6daea083111e508f151767ce095ad8c1013650c32b9e3189c1aae8e11d5b21768a9bd0f884fd18a087376ccec9ada38d2f1ce601ba18603b275f44230c5999579004c810bb9915ea38c7315603e02cef165907f670893eeea4eff0825bdce70148ffc0353ef0e8d7c63534f183710c0025e9be031c65e2055ce07b1120a6c4023b97ab2957962d28c915938f0000000049454e44ae426082, b'1', 43, 2, '123-1234', 'ee-ff-123'),
('dgfdsghfs?', 'thong', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff610000000473424954080808087c086488000000097048597300000b1300000b1301009a9c180000011b49444154388dd591b14ac3601485cfb96904718858b3d40ebe815357e92ef461d462973489b120dd047757c7ae3e816be90bb809925f0bba35e65e5789691471f18c17ce77bfcb05fe7d581db463edc0ca89a80e200800599872ea2e5ab77500a996a57cbf27e04acf3f0896fe160d6784a561b41a7d6bd01e1737049c3bf7875530ad5878a5f69e269b0f6b0d4475a0f4aeaa5b9e5379a4ca4cc53b6a3c018260e705799daa11ce88a0190059bc6e9787b575a20fe3bc1160caa919aedbb1763e97c3a81812d675d2baab02bebc318c5623a39d5265668403d127ac0b700f8634cffca4e10420cf362ebd527ba0cd417b8321cbe9efc3908288c3a848aa9d1f278c8a241c17b61bad8ed71a3425cffcc4cc4e485bfedae2cff3015ea770ffee712a7c0000000049454e44ae426082, b'1', 123, 2, '123-321', 'ff-rr-321'),
('abd', 'gffg', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff610000000473424954080808087c086488000000097048597300000b1300000b1301009a9c18000001e149444154388d7593bd6f926114c57ff7068311781bab111357278477d02e8eba694c938626c645274747ea50159a3aa1ff80abdd4a497469e36274331a8d16cb3f503f121243ca0ba91ff45e070a82c01d6fee39e79e739f4798525e443be732a700123bf586ac6093e6e4ff46a7929d33d125842b4012002332f5ad98524e2cd4de4f2588aae1aa19cbaae3c43d1e4cf1d554be561a2388aae12a706f9aa5117b4e2958dc5e1910742ad9b92efab6af6cd857415e0a7211383b61973d412e27f3b50f0a60a24b03b0d9378f4b2ec8d76e26bac742f0ba19bbffe4ed0eaeeb07ee05809817d1762fb09e27d55733d7b69b007afdcd7e6b237ca1c2be40d3dd7e229a066eab4bcb1de99f2ad90f09b3d9ef4fc304803fb970c4c5cf9858c1dc8f1e827b3989049d4a261d1b76a6f03879f2c4b2fe68de88aae19f8efd8e07add6ad4e30f3ce85476361c6d563899d7aa39d0d2394146ebb72e97517581b1e8caae197494126e73f3754563053df9a7ab329e5e8a608ae0031a56c602e7a7cf2b0cf8e6883a94a19461e52ae64c85ddc9e89e8af21744c9c7994d4a0e57e3f58ac3d1c2100686d8445171e28e8a44d0c4cdc8b7df0180140bb9a3b7fe05e50e42a22c12174cfd14d552927173e7d9c1acc886f47daeb99d3d1f36cda7df2e702f80b7a1cca6aa418e2600000000049454e44ae426082, b'1', 210, 1, '1234567', 'gg-hh-123'),
('itnh cam', 'kien', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff61000000097048597300000b1300000b1301009a9c18000001af49444154388d95d03b6fd3601487f1e7d8afdd340928347405242e9fa0034c558460a0cdc0c40768aa00516160618accc0066d05698708f6c2c28610031148201610134888091850237aa1247112db87814b1b128772e6f7f7e86fcb8c57290b7280a1a7be8b5c5df64adf671fdd3e2fb097fdee4275a2d8958257f105ee2bacc607c4dfb3d9beee9f4c24023b7a091c031ec8b873cefc7a307fc72bbd891fa072f9f9ca9241dfb79b5f73762835e0acd6bb65337cfa3656b82008a96496c69f88a686077660d06788f558948554324bb8b93e1944ce376b5758781a74cd14ca21000bc9d71be3f5ceaba63b38f037eed8d38e13dd002d083c6925d2f9ccdbd5c306e7637f6000366e7853d1e26f5c9dc837419240b2ef1f5c7ab152fef9cdac071d7bda36e13cca6c2fdebe9e05730f6f8da81dde55f800ec336ef85a241e03f42c6859d615d6369aa363999c06764d94a3c3705f40544f2332d95adb60742c9323b4afb546d27371b82770b1b694eefa7a02e19d0547da5b8dadeaa9e24c1c1cb8c089e4e0f254e9cbbf104048642c15958257f11516413eef06eeb833a29a35a8de13e138e8ff71b53e116ae9072a1bce0bde0d63700000000049454e44ae426082, b'1', 34, 3, '345-6789', 'yy-zz-456');

-- --------------------------------------------------------

--
-- Table structure for table `tb_issue_book`
--

CREATE TABLE `tb_issue_book` (
  `id_issue` int(11) NOT NULL,
  `user_issue` int(11) NOT NULL,
  `due_date` date NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `issue_date` date NOT NULL,
  `isbn_book` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_issue_book`
--

INSERT INTO `tb_issue_book` (`id_issue`, `user_issue`, `due_date`, `book_name`, `issue_date`, `isbn_book`) VALUES
(2, 1, '2019-09-05', 'abcdffgf', '2019-09-01', '1234567'),
(3, 1, '2019-10-01', 'abd', '2019-09-26', '1234567'),
(4, 1, '2019-10-01', 'abd', '2019-09-26', '1234567'),
(5, 1, '2019-10-01', 'abd', '2019-09-26', '1234567'),
(6, 1, '2019-10-02', 'itnh cam', '2019-09-27', '345-6789');

-- --------------------------------------------------------

--
-- Table structure for table `tb_return_book`
--

CREATE TABLE `tb_return_book` (
  `id_return` int(11) NOT NULL,
  `user_return` int(11) NOT NULL,
  `name_book` varchar(100) NOT NULL,
  `isbn_return` varchar(30) NOT NULL,
  `return_date` date NOT NULL,
  `fees` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_return_book`
--

INSERT INTO `tb_return_book` (`id_return`, `user_return`, `name_book`, `isbn_return`, `return_date`, `fees`) VALUES
(1, 1, 'abcdffgf', '1234567', '2019-09-05', 0),
(2, 1, 'abcdffgf', '1234567', '2019-09-25', 200),
(3, 1, 'abcdffgf', '1234567', '2019-09-25', 200),
(4, 1, 'abcdffgf', '1234567', '2019-09-25', 200),
(5, 1, 'abcdffgf', '1234567', '2019-09-25', 200),
(6, 1, 'abcdffgf', '1234567', '2019-09-25', 200),
(7, 1, 'abcdffgf', '1234567', '2019-10-11', 360),
(8, 1, 'abcdffgf', '1234567', '2019-09-26', 210),
(9, 1, 'abcdffgf', '1234567', '2019-09-26', 210),
(10, 1, 'abcdffgf', '1234567', '2019-09-26', 210),
(11, 1, 'abd', '1234567', '2019-11-15', 450);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user_detail`
--

CREATE TABLE `tb_user_detail` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `department` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user_detail`
--

INSERT INTO `tb_user_detail` (`id`, `name`, `address`, `phone`, `department`) VALUES
(1, 'abc', 'dfhgdjdfhfdh', '01234354', 'alvneld'),
(2, 'abc', 'rêtrwtw', '01234354', 'alvneld');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_account`
--
ALTER TABLE `tb_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_book_cat`
--
ALTER TABLE `tb_book_cat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_book_detail`
--
ALTER TABLE `tb_book_detail`
  ADD PRIMARY KEY (`call_number`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `id_cat` (`id_cat`);

--
-- Indexes for table `tb_issue_book`
--
ALTER TABLE `tb_issue_book`
  ADD PRIMARY KEY (`id_issue`),
  ADD KEY `isbn_book` (`isbn_book`),
  ADD KEY `user_issue` (`user_issue`);

--
-- Indexes for table `tb_return_book`
--
ALTER TABLE `tb_return_book`
  ADD PRIMARY KEY (`id_return`),
  ADD KEY `isbn_return` (`isbn_return`),
  ADD KEY `user_return` (`user_return`);

--
-- Indexes for table `tb_user_detail`
--
ALTER TABLE `tb_user_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_account`
--
ALTER TABLE `tb_account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_book_cat`
--
ALTER TABLE `tb_book_cat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_issue_book`
--
ALTER TABLE `tb_issue_book`
  MODIFY `id_issue` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_return_book`
--
ALTER TABLE `tb_return_book`
  MODIFY `id_return` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_book_detail`
--
ALTER TABLE `tb_book_detail`
  ADD CONSTRAINT `tb_book_detail_ibfk_1` FOREIGN KEY (`id_cat`) REFERENCES `tb_book_cat` (`id`);

--
-- Constraints for table `tb_issue_book`
--
ALTER TABLE `tb_issue_book`
  ADD CONSTRAINT `tb_issue_book_ibfk_1` FOREIGN KEY (`isbn_book`) REFERENCES `tb_book_detail` (`isbn`),
  ADD CONSTRAINT `tb_issue_book_ibfk_2` FOREIGN KEY (`user_issue`) REFERENCES `tb_user_detail` (`id`);

--
-- Constraints for table `tb_return_book`
--
ALTER TABLE `tb_return_book`
  ADD CONSTRAINT `tb_return_book_ibfk_1` FOREIGN KEY (`isbn_return`) REFERENCES `tb_book_detail` (`isbn`),
  ADD CONSTRAINT `tb_return_book_ibfk_2` FOREIGN KEY (`user_return`) REFERENCES `tb_issue_book` (`user_issue`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
