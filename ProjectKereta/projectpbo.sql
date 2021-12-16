-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Des 2021 pada 04.13
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectpbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kereta`
--

CREATE TABLE `kereta` (
  `id` int(11) NOT NULL,
  `nama_kereta` varchar(50) NOT NULL,
  `rute_kereta` varchar(50) DEFAULT NULL,
  `jam_operasi` varchar(50) DEFAULT NULL,
  `kapasitas` int(11) NOT NULL,
  `jml_penumpang` int(11) NOT NULL DEFAULT 0,
  `harga_kereta` int(11) NOT NULL DEFAULT 15000
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kereta`
--

INSERT INTO `kereta` (`id`, `nama_kereta`, `rute_kereta`, `jam_operasi`, `kapasitas`, `jml_penumpang`, `harga_kereta`) VALUES
(1, 'dhoho', 'kediri-jombang-surabaya', '16.00-18.30-21.00', 30, 1, 15000),
(2, 'dhoho 2', 'jombang-mojokerto-kediri', '14.00-15.30-17.30', 30, 1, 15000),
(3, 'dhoho 3', 'surabaya-jombang-kediri', '13.00-15.40-17.20', 30, 1, 35000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penduduk`
--

CREATE TABLE `penduduk` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_ktp` varchar(50) NOT NULL,
  `alamat` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penduduk`
--

INSERT INTO `penduduk` (`id`, `nama`, `no_ktp`, `alamat`) VALUES
(1, 'budi', '123', 'jl jalan'),
(2, 'Andi Surya', '223', 'Jl Anggrek 103'),
(3, 'budi', '3999', 'jl jalan'),
(4, 'ricky', '9145', 'jlsjl'),
(5, 'Budi Subakti', '1234', '12314');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `id` int(11) NOT NULL,
  `id_penduduk` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_kereta` int(11) NOT NULL,
  `id_tiket` varchar(50) NOT NULL,
  `tempat_keberangkatan` varchar(50) NOT NULL,
  `jadwal_keberangkatan` varchar(50) NOT NULL,
  `tgl_berangkat` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `no_hp` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tgl_lahir` varchar(50) DEFAULT NULL,
  `id_penduduk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `no_hp`, `password`, `tgl_lahir`, `id_penduduk`) VALUES
(6, '081', '124', '21-02-2001', 4),
(7, '091', '132', NULL, 2),
(8, '082335', '12345', '21-10-2012', 2),
(9, '08335', '12312', '21-02-2003', 5);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kereta`
--
ALTER TABLE `kereta`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penduduk`
--
ALTER TABLE `penduduk`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `no_ktp` (`no_ktp`);

--
-- Indeks untuk tabel `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_tiket` (`id_tiket`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `no_hp` (`no_hp`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kereta`
--
ALTER TABLE `kereta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `penduduk`
--
ALTER TABLE `penduduk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tiket`
--
ALTER TABLE `tiket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
