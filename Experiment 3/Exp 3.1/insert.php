<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "WEB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if POST request
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $action = $_POST["action"];

    // INSERT
    if ($action == "Submit") {
        $regno = $conn->real_escape_string($_POST["regno"]);
        $name  = $conn->real_escape_string($_POST["name"]);
        $dept  = $conn->real_escape_string($_POST["dept"]);

        $sql = "INSERT INTO STU (regno, name, dept) VALUES ('$regno', '$name', '$dept')";

        if ($conn->query($sql) === TRUE) {
            echo "<h3>New record inserted successfully</h3>";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    }

    // SHOW ALL
    elseif ($action == "Show All") {
        $sql = "SELECT regno, name, dept FROM STU";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            echo "<h2>Student Records</h2>";
            echo "<table border='1' cellpadding='10'>";
            echo "<tr><th>Reg No</th><th>Name</th><th>Department</th></tr>";

            while ($row = $result->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . htmlspecialchars($row["regno"]) . "</td>";
                echo "<td>" . htmlspecialchars($row["name"]) . "</td>";
                echo "<td>" . htmlspecialchars($row["dept"]) . "</td>";
                echo "</tr>";
            }
            echo "</table>";
        } else {
            echo "<h3>No records found.</h3>";
        }
    }

    // DELETE
    elseif ($action == "Delete") {
        $regno = $conn->real_escape_string($_POST["regno"]);
        $sql = "DELETE FROM STU WHERE regno='$regno'";

        if ($conn->query($sql) === TRUE) {
            echo "<h3>Record deleted successfully</h3>";
        } else {
            echo "Error deleting record: " . $conn->error;
        }
    }
}

$conn->close();
?>
<br>
<a href="form.html">Go Back</a>
