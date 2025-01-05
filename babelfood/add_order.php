<?php
require_once 'db.php';

header("Content-Type: application/json");

$id_makanan = isset($_POST['id_makanan']) ? $_POST['id_makanan'] : '';
$email = isset($_POST['email']) ? $_POST['email'] : '';
$jumlah = isset($_POST['jumlah']) ? $_POST['jumlah'] : '';
$total_harga = isset($_POST['total_harga']) ? $_POST['total_harga'] : '';

if (!empty($id_makanan) && !empty($email) && !empty($jumlah) && !empty($total_harga)) {
    $query = "INSERT INTO orders (id_makanan, email, jumlah, total_harga) 
              VALUES ('$id_makanan', '$email', '$jumlah', '$total_harga')";
    
    if (mysqli_query($conn, $query)) {
        echo json_encode(["success" => true, "message" => "Pesanan berhasil ditambahkan"]);
    } else {
        echo json_encode(["success" => false, "message" => "Gagal menambahkan pesanan"]);
    }
} else {
    echo json_encode(["success" => false, "message" => "Semua data harus diisi"]);
}

mysqli_close($conn);
?>
