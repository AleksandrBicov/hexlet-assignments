@import exercise.util.NamedRoutes;
@param String error

@template.layout.page(
    content = @`
    @if (error != null) {
            <div class="alert alert-danger" role="alert">
                @error
            </div>
    }
    @endif
        <form action="/sessions" method="post">
            <div>
                <label for="name">name:</label>
                <input type="text" id="name" name="name">
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <button type="submit">Login</button>
        </form>
    `
)
