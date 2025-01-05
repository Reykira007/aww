<?php
require_once 'db.php';

header("Content-Type: application/json");

$kategori = isset($_GET['kategori']) ? $_GET['kategori'] : '';

$query = "SELECT m.id_makanan, m.nama_makanan, m.deskripsi, m.harga, 
                 CONCAT('http://10.0.2.2/babelfood/images/', m.gambar) AS gambar_url, 
                 k.nama_kategori
          FROM makanan m
          LEFT JOIN kategori k ON m.id_kategori = k.id_kategori";

if (!empty($kategori)) {
    $query .= " WHERE k.nama_kategori = '" . mysqli_real_escape_string($conn, $kategori) . "'";
}

$result = mysqli_query($conn, $query);

$makanan = [];
if ($result && mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        $makanan[] = [
            "id_makanan" => $row["id_makanan"],
            "nama_makanan" => $row["nama_makanan"],
            "deskripsi" => $row["deskripsi"],
            "harga" => $row["harga"],
            "gambar_url" => $row["gambar_url"],
            "kategori" => $row["nama_kategori"]
        ];
    }
    echo json_encode($makanan);
} else {
    echo json_encode([]);
}

mysqli_close($conn);
?>
