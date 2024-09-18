@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
        </form>

          @if (!page.getUsers().isEmpty())
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
                             @for(var user : page.getUsers())
                                 <tr>
                                     <td>${user.getId()}</td>
                                     <td>${user.getFirstName()}</td>
                                     <td>${user.getLastName()}</td>
                                     <td>${user.getEmail()}</td>
                                     <td><a href="/users/${user.getId()}" class="btn btn-primary btn-sm">Посмотреть</a></td>
                                 </tr>
                             @endfor
                         </tbody>
                     </table>
                 @endif
    `
)