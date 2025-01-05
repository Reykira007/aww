<?php
require_once 'db.php';

header("Content-Type: application/json");

$query = "SELECT i.id_information, i.tgl_information, i.email, i.komentar, i.tanggapan, i.status, k.nama_kategori 
          FROM information i
          LEFT JOIN kategori k ON i.id_kategori = k.id_kategori
          WHERE i.id_kategori = 4";

$result = mysqli_query($conn, $query);

$information = [];
if ($result && mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        $information[] = [
            "id_information" => $row["id_information"],
            "tgl_information" => $row["tgl_information"],
            "email" => $row["email"],
            "komentar" => $row["komentar"],
            "tanggapan" => $row["tanggapan"],
            "status" => $row["status"],
            "kategori" => $row["nama_kategori"]
        ];
    }
    echo json_encode($information);
} else {
    echo json_encode([]);
}

mysqli_close($conn);
?>
