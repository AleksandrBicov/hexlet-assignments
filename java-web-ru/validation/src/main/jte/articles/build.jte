@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
     @if(page != null && page.getErrors() != null && !page.getErrors().isEmpty())
          <ul>
              @for(var validator : page.getErrors().values())
                  @for(var error : validator)
                      <li>${error.getMessage()}</li>
                  @endfor
              @endfor
          </ul>
      @endif

        <form action="/articles" method="post">
          <div>
            <label>
              Заголовок
              <input type="text" name="title" value="${page.getTitle()}" />
            </label>
          </div>
          <div>
            <label>
              Тело статьи
              <textarea name="contents"> ${page.getContents()}</textarea>
            </label>
          </div>
          <input type="submit" value="Опубликовать" />
        </form>
    `
)