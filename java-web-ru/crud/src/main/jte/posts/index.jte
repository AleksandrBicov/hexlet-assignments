@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@param  PostsPage page

@template.layout.page(
    content = @`
            <main>
                <h1>Список постов</h1>
                <ol>
                    @for (var posts : page.getPosts())
                        <li><a href="http://localhost:7070/posts/${posts.getId()}">${posts.getName()}</a>
                        </li>
                    @endfor
                </ol>

                <div>
                 <a href="?page=${page.getPage() - 1}">Назад</a>
                 <a href="?page=${page.getPage() + 1}">Вперед</a>
                 </div>

            </main>
    `
)

