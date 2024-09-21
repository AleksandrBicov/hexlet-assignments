@import exercise.dto.users.UserPage
@param exercise.dto.users.UserPage userPage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Данные пользователя</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="card">
            <div class="card-header">
                <h1 class="card-title">${userPage.getFirstName()} ${userPage.getLastName()}</h1>
            </div>
            <div class="card-body">
                <p><strong>Email:</strong> ${userPage.getEmail()}</p>
                <p><strong>ID:</strong> ${userPage.getId()}</p>
                <p><a href="/users/" class="btn btn-primary btn-sm">Назад</a></p>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>