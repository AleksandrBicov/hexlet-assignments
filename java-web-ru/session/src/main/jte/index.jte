@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        <p>Вы вошли как: ${page.getName()}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти" />
        </form>
    @elseif(page.getError() != null)
        <p>${page.getError()}</p>
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти" />

        </form>
    @else
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти" />
        </form>
    @endif
    `
)