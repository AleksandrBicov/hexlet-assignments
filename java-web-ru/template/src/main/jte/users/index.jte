@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page

<html>
    <head>
        <title>${page.getHeader()}</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <h1>${page.getHeader()}</h1>
        @if(page.getUsersPage().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <table>
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
                            <td><a href="/users/${userPage.getId()}">View</a></td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    </body>
</html>