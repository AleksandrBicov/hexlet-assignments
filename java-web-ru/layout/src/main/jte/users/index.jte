@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page

@template.layout.page(
    content = @`
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
                    @for(var userPage : page.getUsers())
                        <tr>
                            <td>${userPage.getId()}</td>
                            <td>${userPage.getFirstName()}</td>
                            <td>${userPage.getLastName()}</td>
                            <td>${userPage.getEmail()}</td>
                            <td><a href="/users/${userPage.getId()}">Посмотреть</a></td>
                        </tr>
                    @endfor
                </tbody>
            </table>
    `
)