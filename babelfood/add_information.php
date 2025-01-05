<?php
require_once 'db.php';

header("Content-Type: application/json");

$email = isset($_POST['email']) ? $_POST['email'] : '';
$komentar = isset($_POST['komentar']) ? $_POST['komentar'] : '';

$tgl_information = date('Y-m-d');
$id_kategori = 4;

if (!empty($email) && !empty($komentar)) {
    $query = "INSERT INTO information (tgl_information, email, komentar, id_kategori) 
              VALUES ('$tgl_information', '$email', '$komentar', $id_kategori)";
    
    if (mysqli_query($conn, $query)) {
        echo json_encode(["success" => true, "message" => "Informasi berhasil ditambahkan"]);
    } else {
        echo json_encode(["success" => false, "message" => "Gagal menyimpan informasi ke database"]);
    }
} else {
    echo json_encode(["success" => false, "message" => "Email dan komentar harus diisi"]);
}

mysqli_close($conn);
file_put_contents('log.txt', "Email: $email, Komentar: $komentar\n", FILE_APPEND);
?>
