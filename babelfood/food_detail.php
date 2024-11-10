<?php
require_once 'db.php';

header('Content-Type: application/json');

if(isset($_GET['id'])) {
    $id = $_GET['id'];
    
    $query = "SELECT * FROM food_details WHERE food_id = ?";
    $stmt = mysqli_prepare($conn, $query);
    mysqli_stmt_bind_param($stmt, "i", $id);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);

    if($result) {
        $foods = array();
        while($row = mysqli_fetch_assoc($result)) {
            $foods[] = array(
                'id' => $row['id'],
                'food_id' => $row['food_id'],
                'name' => $row['name'],
                'description' => $row['description'],
                'history' => $row['history'],
                'price_range' => $row['price_range'],
                'rating' => $row['rating'],
                'total_reviews' => $row['total_reviews'],
                'image_name' => $row['image_name'],
                'portion_size' => $row['portion_size'],
                'spicy_level' => $row['spicy_level'],
                'calories' => $row['calories'],
                'best_time' => $row['best_time'],
                'ingredients' => $row['ingredients'],
                'eating_tips' => $row['eating_tips'],
                'accompaniment' => $row['accompaniment']
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
} else {
    echo json_encode(array(
        'status' => false,
        'message' => 'ID is required'
    ));
}

mysqli_close($conn);
?>