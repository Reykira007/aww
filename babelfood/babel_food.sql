-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2025 at 06:03 PM
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
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `id_information` int(4) NOT NULL,
  `tgl_information` date NOT NULL,
  `email` varchar(40) NOT NULL,
  `komentar` text NOT NULL,
  `tanggapan` text DEFAULT NULL,
  `status` enum('Pending','Diterima','Ditolak') DEFAULT 'Pending',
  `id_kategori` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`id_information`, `tgl_information`, `email`, `komentar`, `tanggapan`, `status`, `id_kategori`) VALUES
(1, '2024-11-11', 'budi@gmail.com', 'Kenapa alamat toko X berbeda dengan real?', 'Toko pindah lokasi.', 'Diterima', 4),
(2, '2024-12-01', 'andi@yahoo.com', 'Mohon tambahkan deskripsi makanan lebih lengkap.', NULL, 'Pending', 4),
(3, '2024-12-05', 'siti@outlook.com', 'Kenapa harga berbeda dengan yang ada di toko?', 'Sedang kami periksa.', 'Pending', 4),
(4, '2025-01-05', 'admin@gmail.com', 'admin', NULL, 'Pending', 4),
(5, '2025-01-05', 'tes@gmail.com', 'testing dulu', NULL, 'Pending', 4),
(6, '2025-01-05', 'kucing@gmail.com', 'kucing ku belang', NULL, 'Pending', 4);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  `dibuat_pada` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `dibuat_pada`) VALUES
(1, 'Makanan', '2025-01-05 12:15:07'),
(2, 'Minuman', '2025-01-05 12:15:07'),
(3, 'Promo', '2025-01-05 12:15:07'),
(4, 'Informasi', '2025-01-05 12:15:07'),
(5, 'Tambah Resep', '2025-01-05 16:36:25'),
(6, 'Request Menu', '2025-01-05 16:36:25');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `id_makanan` int(11) NOT NULL,
  `nama_makanan` varchar(100) NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `harga` decimal(10,2) NOT NULL,
  `gambar` varchar(255) DEFAULT NULL,
  `id_kategori` int(11) DEFAULT NULL,
  `dibuat_pada` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`id_makanan`, `nama_makanan`, `deskripsi`, `harga`, `gambar`, `id_kategori`, `dibuat_pada`) VALUES
(1, 'Lakso', 'Lakso adalah mie dengan kuah santan khas Bangka Belitung.', 25000.00, 'lakso.png', 1, '2025-01-05 12:45:50'),
(2, 'Mie Belitung', 'Mie Belitung dengan kuah udang yang khas.', 30000.00, 'mie_belitung.png', 1, '2025-01-05 12:45:50'),
(3, 'Lempah Kuning', 'Lempah kuning khas Bangka dengan cita rasa asam pedas.', 40000.00, 'lempah_kuning.png', 1, '2025-01-05 12:45:50'),
(4, 'Otak-Otak Bangka', 'Otak-otak berbahan dasar ikan dengan rasa gurih khas.', 20000.00, 'otak_otak.png', 1, '2025-01-05 12:45:50');

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `id_minuman` int(11) NOT NULL,
  `nama_minuman` varchar(100) NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `harga` decimal(10,2) NOT NULL,
  `gambar` varchar(255) DEFAULT NULL,
  `id_kategori` int(11) DEFAULT NULL,
  `dibuat_pada` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`id_minuman`, `nama_minuman`, `deskripsi`, `harga`, `gambar`, `id_kategori`, `dibuat_pada`) VALUES
(1, 'Es Jeruk Kunci', 'Minuman segar dengan perasan jeruk kunci khas Bangka.', 12000.00, 'es_jeruk_kunci.png', 2, '2025-01-05 13:36:10'),
(2, 'Kopi Tung Tau', 'Kopi tradisional khas Bangka yang diseduh dengan cara tradisional.', 20000.00, 'kopi_tung_tau.png', 2, '2025-01-05 13:36:10'),
(3, 'Es Air Serbat', 'Minuman dengan campuran rempah-rempah seperti jahe dan gula aren.', 15000.00, 'es_air_serbat.png', 2, '2025-01-05 13:36:10'),
(4, 'Air Gula Aren', 'Minuman manis dengan campuran gula aren dan jeruk nipis.', 8000.00, 'air_gula_aren.png', 2, '2025-01-05 13:36:10');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id_order` int(10) NOT NULL,
  `id_makanan` int(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `total_harga` double NOT NULL,
  `status` varchar(20) DEFAULT 'Pending',
  `tgl_pesanan` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id_order`, `id_makanan`, `email`, `jumlah`, `total_harga`, `status`, `tgl_pesanan`) VALUES
(1, 1, 'user1@gmail.com', 2, 50000, 'Pending', '2025-01-05 22:31:34'),
(2, 2, 'user2@gmail.com', 1, 30000, 'Selesai', '2025-01-05 22:31:34'),
(3, 1, 'user1@gmail.com', 2, 50000, 'Pending', '2025-01-05 22:42:48');

-- --------------------------------------------------------

--
-- Table structure for table `promo`
--

CREATE TABLE `promo` (
  `id_promo` int(11) NOT NULL,
  `nama_promo` varchar(100) NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `gambar` varchar(255) DEFAULT NULL,
  `harga_awal` decimal(10,2) NOT NULL,
  `harga_diskon` decimal(10,2) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `dibuat_pada` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `promo`
--

INSERT INTO `promo` (`id_promo`, `nama_promo`, `deskripsi`, `gambar`, `harga_awal`, `harga_diskon`, `id_kategori`, `dibuat_pada`) VALUES
(1, 'Diskon Es Jeruk Kunci', 'Nikmati diskon spesial untuk Es Jeruk Kunci segar!', 'es_jeruk_kunci.png', 12000.00, 8000.00, 3, '2025-01-05 14:16:17'),
(2, 'Promo Mie Belitung', 'Hanya hari ini! Mie Belitung dengan harga spesial.', 'mie_belitung.png', 25000.00, 20000.00, 3, '2025-01-05 14:16:17'),
(3, 'Paket Hemat Otak-Otak', 'Paket hemat otak-otak dengan minuman gratis.', 'otak_otak.png', 30000.00, 25000.00, 3, '2025-01-05 14:16:17'),
(4, 'Diskon Kopi Tung Tau', 'Cicipi Kopi Tung Tau dengan diskon menarik.', 'kopi_tung_tau.png', 15000.00, 10000.00, 3, '2025-01-05 14:16:17');

-- --------------------------------------------------------

--
-- Table structure for table `request_menu`
--

CREATE TABLE `request_menu` (
  `id_request` int(11) NOT NULL,
  `nama_menu` varchar(100) NOT NULL,
  `deskripsi_menu` text NOT NULL,
  `jenis_menu` enum('Makanan','Minuman') NOT NULL,
  `email_pengguna` varchar(50) NOT NULL,
  `perkiraan_harga` decimal(10,2) NOT NULL,
  `alasan_request` text NOT NULL,
  `gambar_referensi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `request_menu`
--

INSERT INTO `request_menu` (`id_request`, `nama_menu`, `deskripsi_menu`, `jenis_menu`, `email_pengguna`, `perkiraan_harga`, `alasan_request`, `gambar_referensi`) VALUES
(1, 'Ayam geprek', 'Dengan sambel bawang', 'Makanan', 'tes@gmail.com', 25000.00, 'makanan favorit', '');

-- --------------------------------------------------------

--
-- Table structure for table `resep_makanan`
--

CREATE TABLE `resep_makanan` (
  `id_resep` int(11) NOT NULL,
  `nama_resep` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `bahan` text NOT NULL,
  `langkah_persiapan` text NOT NULL,
  `waktu_persiapan` int(11) NOT NULL,
  `tingkat_kesulitan` enum('Mudah','Sedang','Sulit') NOT NULL,
  `gambar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `resep_makanan`
--

INSERT INTO `resep_makanan` (`id_resep`, `nama_resep`, `deskripsi`, `bahan`, `langkah_persiapan`, `waktu_persiapan`, `tingkat_kesulitan`, `gambar`) VALUES
(1, 'Laksa Bangka', 'Laksa khas Bangka dengan kuah santan gurih.', 'Tepung beras, santan, bawang putih, udang, bumbu rempah.', '1. Siapkan bahan. 2. Masak kuah. 3. Sajikan.', 60, 'Sedang', 'laksa_bangka.png'),
(2, 'Lempah Kuning', 'Sup ikan khas Bangka dengan kuah asam pedas.', 'Ikan tenggiri, nanas, cabai, kunyit, asam jawa.', '1. Rebus bahan. 2. Tambahkan ikan. 3. Sajikan.', 45, 'Mudah', 'lempah_kuning.png'),
(3, 'tes', 'tes', 'tes', 'tes', 123, '', 'tes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`id_information`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id_makanan`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`id_minuman`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_makanan` (`id_makanan`);

--
-- Indexes for table `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`id_promo`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `request_menu`
--
ALTER TABLE `request_menu`
  ADD PRIMARY KEY (`id_request`);

--
-- Indexes for table `resep_makanan`
--
ALTER TABLE `resep_makanan`
  ADD PRIMARY KEY (`id_resep`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `information`
--
ALTER TABLE `information`
  MODIFY `id_information` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `makanan`
--
ALTER TABLE `makanan`
  MODIFY `id_makanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `minuman`
--
ALTER TABLE `minuman`
  MODIFY `id_minuman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `promo`
--
ALTER TABLE `promo`
  MODIFY `id_promo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `request_menu`
--
ALTER TABLE `request_menu`
  MODIFY `id_request` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `resep_makanan`
--
ALTER TABLE `resep_makanan`
  MODIFY `id_resep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `information`
--
ALTER TABLE `information`
  ADD CONSTRAINT `information_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE;

--
-- Constraints for table `makanan`
--
ALTER TABLE `makanan`
  ADD CONSTRAINT `makanan_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE;

--
-- Constraints for table `minuman`
--
ALTER TABLE `minuman`
  ADD CONSTRAINT `minuman_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_makanan`) REFERENCES `makanan` (`id_makanan`);

--
-- Constraints for table `promo`
--
ALTER TABLE `promo`
  ADD CONSTRAINT `promo_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
