@import exercise.dto.users.UserPage
@param exercise.dto.users.UserPage userPage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .user-details {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .user-details h1 {
            margin-top: 0;
        }
        .user-details p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="user-details">
        <h1>${userPage.getFirstName()} ${userPage.getLastName()}</h1>
        <p><strong>Email:</strong> ${userPage.getEmail()}</p>
        <p><strong>ID:</strong> ${userPage.getId()}</p>
        <p><a href="/users/">Back</a></p>
    </div>
</body>
</html>