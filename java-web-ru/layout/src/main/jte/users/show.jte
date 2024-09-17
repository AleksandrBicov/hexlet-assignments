@import exercise.dto.users.UserPage
@param exercise.dto.users.UserPage page

@template.layout.page(
    content = @`
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
                <p><strong>Email:</strong> ${page.getUser().getEmail()}</p>
                <p><strong>ID:</strong> ${page.getUser().getId()}</p>
                <p><a href="/users/">Назад</a></p>
    `
)