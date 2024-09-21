@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${page.getHeader()}</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>${page.getHeader()}</h1>
        @if(page.getUsersPage().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var userPage : page.getUsersPage())
                        <tr>
                            <td>${userPage.getId()}</td>
                            <td>${userPage.getFirstName()}</td>
                            <td>${userPage.getLastName()}</td>
                            <td>${userPage.getEmail()}</td>
                            <td><a href="/users/${userPage.getId()}" class="btn btn-primary btn-sm">Посмотреть</a></td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>