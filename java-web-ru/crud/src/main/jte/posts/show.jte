@import exercise.dto.posts.PostPage
@import exercise.model.Post
@param  PostPage page

@template.layout.page(
    content = @`
            <main>
                    <h1>Пост</h1>
                    <h3>ID поста ${page.getPost().getName()} --- ${page.getPost().getId()}  </h3>
                    <p>${page.getPost().getBody()}</p>
                    <a href="/posts">Назад</a>
            </main>
    `
)