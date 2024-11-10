<?php
require_once 'db.php';

header('Content-Type: application/json');

try {
    $query = "SELECT * FROM popular_foods ORDER BY rating DESC LIMIT 4";
    $result = mysqli_query($conn, $query);

    if ($result) {
        $foods = array();
        while ($row = mysqli_fetch_assoc($result)) {
            $foods[] = array(
                'id' => $row['id'],
                'name' => $row['name'],
                'description' => $row['description'],
                'rating' => $row['rating'],
                'image_name' => $row['image_name']
            );
        }

        echo json_encode(array(
            'status' => true,
            'message' => 'Data retrieved successfully',
            'data' => $foods
        ));
    } else {
        echo json_encode(array(
            'status' => false,
            'message' => 'Failed to retrieve data'
        ));
    }
} catch (Exception $e) {
    echo json_encode(array(
        'status' => false,
        'message' => 'Error: ' . $e->getMessage()
    ));
}

mysqli_close($conn);
?>