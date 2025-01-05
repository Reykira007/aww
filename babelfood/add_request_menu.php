<?php
require_once 'db.php';

header("Content-Type: application/json");

$nama_menu = isset($_POST['nama_menu']) ? $_POST['nama_menu'] : '';
$deskripsi_menu = isset($_POST['deskripsi_menu']) ? $_POST['deskripsi_menu'] : '';
$jenis_menu = isset($_POST['jenis_menu']) ? $_POST['jenis_menu'] : '';
$email_pengguna = isset($_POST['email_pengguna']) ? $_POST['email_pengguna'] : '';
$perkiraan_harga = isset($_POST['perkiraan_harga']) ? $_POST['perkiraan_harga'] : '';
$alasan_request = isset($_POST['alasan_request']) ? $_POST['alasan_request'] : '';
$gambar_referensi = isset($_POST['gambar_referensi']) ? $_POST['gambar_referensi'] : '';

if (!empty($nama_menu) && !empty($deskripsi_menu) && !empty($jenis_menu) && !empty($email_pengguna) && !empty($perkiraan_harga) && !empty($alasan_request)) {
    $query = "INSERT INTO request_menu (nama_menu, deskripsi_menu, jenis_menu, email_pengguna, perkiraan_harga, alasan_request, gambar_referensi)
              VALUES ('$nama_menu', '$deskripsi_menu', '$jenis_menu', '$email_pengguna', '$perkiraan_harga', '$alasan_request', '$gambar_referensi')";

    if (mysqli_query($conn, $query)) {
        echo json_encode(["success" => true, "message" => "Request berhasil ditambahkan"]);
    } else {
        echo json_encode(["success" => false, "message" => "Gagal menambahkan request"]);
    }
} else {
    echo json_encode(["success" => false, "message" => "Semua data harus diisi"]);
}

mysqli_close($conn);
?>
