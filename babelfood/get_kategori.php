<?php
header("Content-Type: application/json");

// Pastikan file koneksi ditemukan
if (!file_exists(__DIR__ . '/db.php')) {
    die(json_encode(["error" => "File db.php tidak ditemukan."]));
}

// Sertakan file koneksi
require_once __DIR__ . '/db.php';

$query = "SELECT * FROM kategori";
$result = mysqli_query($conn, $query);

if ($result && mysqli_num_rows($result) > 0) {
    $kategori = [];
    while ($row = mysqli_fetch_assoc($result)) {
        $kategori[] = [
            "id_kategori" => $row["id_kategori"],
            "nama_kategori" => $row["nama_kategori"]
        ];
    }
    echo json_encode($kategori);
} else {
    echo json_encode([]);
}

mysqli_close($conn);
?>
