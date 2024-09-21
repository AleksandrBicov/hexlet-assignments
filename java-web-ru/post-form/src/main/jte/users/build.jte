@import exercise.dto.users.BuildUserPage
@param BuildUserPage page

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

        <form action="/users" method="post">
          <div>
            <label>
              Имя
              <input type="text" name="firstName" value="${page.getFirstName()}" />
            </label>
          </div>
          <div>
            <label>
                Фамилия
                <input type="text" name="lastName" value="${page.getLastName()}" />
            </label>
          </div>
          <div>
            <label>
              Email
              <input type="email" required name="email" value="${page.getEmail()}" />
            </label>
          </div>
          <div>
            <label>
              Пароль
              <input type="password" required name="password" />
            </label>
          </div>
          <div>
                <label>
                  Подтверждение пароля
                  <input type="password" required name="passwordConfirmation" />
                </label>
          </div>
          <input type="submit" value="Зарегистрировать" />
        </form>
    `
)