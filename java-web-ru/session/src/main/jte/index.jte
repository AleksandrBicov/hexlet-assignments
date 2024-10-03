@import exercise.dto.MainPage
@import exercise.util.NamedRoutes;
@param MainPage page

@template.layout.page(
    content = @`
            <h1>Привет, Хекслет!</h1>
            @if(page.getName() == null)
                <form action="${NamedRoutes.buildSessionPath()}" method="get">
                                    <button type="submit">Войти</button>
                </form>
            @else
                <form action="${NamedRoutes.logoutPath()}" method="get">
                <button type="submit">Выйти</button>
                 </form>
            @endif
    `
)
