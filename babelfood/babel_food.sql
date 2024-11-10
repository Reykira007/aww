-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2024 at 06:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `babel_food`
--

-- --------------------------------------------------------

--
-- Table structure for table `food_details`
--

CREATE TABLE `food_details` (
  `id` int(11) NOT NULL,
  `food_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `history` text DEFAULT NULL,
  `price_range` varchar(50) DEFAULT NULL,
  `rating` decimal(2,1) DEFAULT 0.0,
  `total_reviews` int(11) DEFAULT 0,
  `image_name` varchar(100) NOT NULL,
  `portion_size` varchar(50) DEFAULT NULL,
  `spicy_level` enum('Tidak Pedas','Sedikit Pedas','Pedas','Sangat Pedas') DEFAULT NULL,
  `calories` varchar(50) DEFAULT NULL,
  `best_time` varchar(100) DEFAULT NULL,
  `ingredients` text DEFAULT NULL,
  `eating_tips` text DEFAULT NULL,
  `accompaniment` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_details`
--

INSERT INTO `food_details` (`id`, `food_id`, `name`, `description`, `history`, `price_range`, `rating`, `total_reviews`, `image_name`, `portion_size`, `spicy_level`, `calories`, `best_time`, `ingredients`, `eating_tips`, `accompaniment`, `created_at`) VALUES
(1, 1, 'Lempah Kuning', 'Lempah Kuning adalah masakan khas Bangka berupa sup ikan dengan kuah berwarna kuning yang kaya rempah. Hidangan ini memiliki cita rasa yang gurih, segar, dan aromatik. Kuahnya yang segar cocok dimakan dalam berbagai kesempatan.', 'Lempah Kuning merupakan masakan tradisional yang telah ada sejak lama di Pulau Bangka. Nama \"Lempah\" sendiri dalam bahasa Bangka berarti \"masak\" atau \"memasak\". Warna kuning pada kuah berasal dari kunyit yang juga berfungsi sebagai antiseptik alami.', 'Rp 25.000 - Rp 35.000', 4.9, 128, 'img_lempah_kuning', '1-2 porsi', 'Sedikit Pedas', '280 kkal per porsi', 'Makan siang atau makan malam', 'Ikan segar (kakap/kerapu/tenggiri), Kunyit segar, Serai, Daun salam, Lengkuas, Bawang merah, Bawang putih, Cabai rawit, Jahe, Kemiri, Garam, Gula', 'Lebih nikmat dimakan selagi hangat. Bisa ditambahkan jeruk nipis dan sambal untuk menambah kesegaran. Kuah bisa disesuaikan dengan selera masing-masing.', 'Nasi putih hangat, Sambal terasi, Lalapan segar (timun, daun kemangi, selada)', '2024-11-10 17:10:46'),
(2, 2, 'Mie Koba', 'Mie Koba adalah hidangan mie khas Bangka yang berasal dari daerah Koba. Mie ini terkenal dengan kuahnya yang gurih berbahan dasar ikan dan tekstur mienya yang kenyal. Disajikan dengan berbagai topping yang menggugah selera.', 'Mie Koba pertama kali dibuat di daerah Koba, Bangka Tengah. Makanan ini merupakan perpaduan budaya Tionghoa dan Melayu yang menciptakan cita rasa unik. Awalnya dibuat oleh pedagang Tionghoa yang menetap di Koba.', 'Rp 20.000 - Rp 30.000', 4.7, 156, 'img_mie_koba', '1 porsi', 'Tidak Pedas', '350 kkal per porsi', 'Sarapan atau makan siang', 'Mie telur khusus, Ikan tenggiri, Bawang putih, Bawang merah, Sawi hijau, Daun bawang, Seledri, Merica, Garam, Minyak bawang putih', 'Aduk mie dengan kuah sebelum dimakan. Bisa ditambahkan cabe atau saus sambal sesuai selera. Lebih nikmat dimakan selagi hangat.', 'Pangsit goreng, Acar mentimun, Sambal cabe rawit', '2024-11-10 17:10:46'),
(3, 3, 'Rusip', 'Rusip adalah makanan fermentasi khas Bangka yang terbuat dari ikan teri atau bilis. Memiliki rasa yang khas, gurih, dan sedikit asam karena proses fermentasi. Biasa digunakan sebagai condiment atau dimakan dengan nasi.', 'Rusip merupakan warisan kuliner yang sudah ada sejak zaman dahulu. Makanan ini awalnya dibuat sebagai cara mengawetkan ikan dalam jangka panjang. Proses fermentasi alami membuat rusip memiliki cita rasa yang unik.', 'Rp 15.000 - Rp 25.000', 4.5, 98, 'img_rusip', 'Sesuai kebutuhan', 'Pedas', '120 kkal per 100gr', 'Bisa dimakan kapan saja sebagai pendamping', 'Ikan teri/bilis segar, Garam, Beras sangrai, Cabai rawit, Bawang merah, Bawang putih, Gula aren', 'Bisa dimakan langsung atau dicampur dengan nasi. Sebagai sambal pendamping, bisa ditambahkan jeruk kunci untuk rasa lebih segar.', 'Nasi putih, Sayur rebus, Ikan goreng', '2024-11-10 17:10:46'),
(4, 4, 'Lakso', 'Lakso adalah makanan khas Bangka berupa mie berbahan dasar tepung sagu yang disiram dengan kuah santan gurih. Mie lakso memiliki tekstur yang kenyal dan lembut. Kuah santannya yang creamy memberikan cita rasa yang khas.', 'Lakso merupakan perpaduan budaya Melayu dan Tionghoa. Nama \"Lakso\" dipercaya berasal dari kata \"Laksa\" dalam bahasa Hokkien. Makanan ini sudah menjadi bagian dari kuliner Bangka sejak puluhan tahun lalu.', 'Rp 18.000 - Rp 28.000', 4.9, 145, 'img_lakso', '1 porsi', 'Tidak Pedas', '300 kkal per porsi', 'Sarapan atau makan siang', 'Tepung sagu, Tepung beras, Santan kelapa, Ebi, Bawang merah, Bawang putih, Lengkuas, Serai, Daun salam, Garam, Merica', 'Aduk rata mie dengan kuah santan sebelum dimakan. Bisa ditambahkan bawang goreng dan sambal sebagai pelengkap.', 'Bawang goreng, Sambal, Kerupuk', '2024-11-10 17:10:46');

-- --------------------------------------------------------

--
-- Table structure for table `popular_foods`
--

CREATE TABLE `popular_foods` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `rating` decimal(2,1) DEFAULT 0.0,
  `image_name` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `popular_foods`
--

INSERT INTO `popular_foods` (`id`, `name`, `description`, `rating`, `image_name`, `created_at`, `updated_at`) VALUES
(1, 'Lempah Kuning', 'Kuah kuning segar dan lezat.', 4.9, 'img_lempah_kuning', '2024-11-10 16:27:20', '2024-11-10 16:27:20'),
(2, 'Mie Koba', 'Mie ikan segar dan lezat khas koba.', 4.7, 'img_mie_koba', '2024-11-10 16:27:20', '2024-11-10 16:27:20'),
(3, 'Rusip', 'Terbuat dari fermentasi ikan segar.', 4.5, 'img_rusip', '2024-11-10 16:27:20', '2024-11-10 16:27:20'),
(4, 'Lakso', 'Terbuat dari mi dan kuah santan.', 4.9, 'img_lakso', '2024-11-10 16:27:20', '2024-11-10 16:27:20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food_details`
--
ALTER TABLE `food_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `food_id` (`food_id`);

--
-- Indexes for table `popular_foods`
--
ALTER TABLE `popular_foods`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food_details`
--
ALTER TABLE `food_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `popular_foods`
--
ALTER TABLE `popular_foods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `food_details`
--
ALTER TABLE `food_details`
  ADD CONSTRAINT `food_details_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `popular_foods` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
