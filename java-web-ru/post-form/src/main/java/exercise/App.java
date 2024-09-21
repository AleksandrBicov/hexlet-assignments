package exercise;

import exercise.dto.users.BuildUserPage;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static exercise.util.Security.encrypt;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });


        // BEGIN
        app.get("/users/build", ctx -> {
            // Создание объекта BuildUserPage с пустыми значениями
            var page = new BuildUserPage("", "", "", new HashMap<>());
            ctx.render("users/build.jte", model("page", page));
        });

        app.post("/users", ctx -> {
            String firstName = StringUtils.capitalize(Objects.requireNonNull(ctx.formParam("firstName")).toLowerCase());
            String lastName = StringUtils.capitalize(Objects.requireNonNull(ctx.formParam("lastName")).toLowerCase());
            String email = Objects.requireNonNull(ctx.formParam("email")).trim().toLowerCase();

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .get();
                var user = new User(firstName, lastName, email, password);

                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                // Заполнение карты ошибок при возникновении ValidationException
                var page = new BuildUserPage(firstName, lastName, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
