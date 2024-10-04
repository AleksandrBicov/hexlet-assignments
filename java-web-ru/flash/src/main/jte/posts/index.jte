@import exercise.model.Post
@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
      <h1>Список постов</h1>
              <ul>
                  @for (Post post : page.getPosts())
                      <li>${post.getId()} ${post.getName()}</li>
                  @endfor
              </ul>
      <a href="/posts/build">Создать Пост</a>
    `
)