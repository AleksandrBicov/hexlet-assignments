@import exercise.dto.users.UserPage
@param exercise.dto.users.UserPage page

@template.layout.page(
    content = @`
        <div class="card">
            <div class="card-header">
                <h1 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
            </div>
            <div class="card-body">
                <p><strong>Email:</strong> ${page.getUser().getEmail()}</p>
                <p><strong>ID:</strong> ${page.getUser().getId()}</p>
                <p><a href="/users/" class="btn btn-primary btn-sm">Назад</a></p>
            </div>
        </div>
    `
)