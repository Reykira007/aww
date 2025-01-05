<?php
require_once 'db.php'; 

header("Content-Type: application/json");

$nama_resep = isset($_POST['nama_resep']) ? $_POST['nama_resep'] : '';
$deskripsi = isset($_POST['deskripsi']) ? $_POST['deskripsi'] : '';
$bahan = isset($_POST['bahan']) ? $_POST['bahan'] : '';
$langkah_persiapan = isset($_POST['langkah_persiapan']) ? $_POST['langkah_persiapan'] : '';
$waktu_persiapan = isset($_POST['waktu_persiapan']) ? $_POST['waktu_persiapan'] : '';
$tingkat_kesulitan = isset($_POST['tingkat_kesulitan']) ? $_POST['tingkat_kesulitan'] : '';
$gambar = isset($_POST['gambar']) ? $_POST['gambar'] : '';

if (!empty($nama_resep) && !empty($deskripsi) && !empty($bahan) && !empty($langkah_persiapan) && !empty($waktu_persiapan) && !empty($tingkat_kesulitan)) {
    $query = "INSERT INTO resep_makanan (nama_resep, deskripsi, bahan, langkah_persiapan, waktu_persiapan, tingkat_kesulitan, gambar) 
              VALUES ('$nama_resep', '$deskripsi', '$bahan', '$langkah_persiapan', '$waktu_persiapan', '$tingkat_kesulitan', '$gambar')";
    
    if (mysqli_query($conn, $query)) {
        echo json_encode(["success" => true, "message" => "Resep berhasil ditambahkan"]);
    } else {
        echo json_encode(["success" => false, "message" => "Gagal menambahkan resep"]);
    }
} else {
    echo json_encode(["success" => false, "message" => "Semua data harus diisi"]);
}

mysqli_close($conn);
?>
