<?php
require_once 'db.php';

header("Content-Type: application/json");

$query = "SELECT p.id_promo, p.nama_promo, p.deskripsi, 
                 CONCAT('http://10.0.2.2/babelfood/images/', p.gambar) AS gambar_url, 
                 p.harga_awal, p.harga_diskon, k.nama_kategori AS kategori
          FROM promo p
          LEFT JOIN kategori k ON p.id_kategori = k.id_kategori";

$result = mysqli_query($conn, $query);

$promo = [];
if ($result && mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        $promo[] = [
            "id_promo" => $row["id_promo"],
            "nama_promo" => $row["nama_promo"],
            "deskripsi" => $row["deskripsi"],
            "gambar_url" => $row["gambar_url"],
            "harga_awal" => $row["harga_awal"],
            "harga_diskon" => $row["harga_diskon"],
            "kategori" => $row["kategori"]
        ];
    }
    echo json_encode($promo);
} else {
    echo json_encode([]);
}

mysqli_close($conn);
?>
