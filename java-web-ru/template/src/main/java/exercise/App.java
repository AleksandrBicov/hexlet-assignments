package exercise;

import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.Javalin;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import exercise.model.User;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        List<UserPage> userPages = USERS.stream()
                .map(user -> new UserPage(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());

        app.get("/users", ctx -> {

            var header = "users";

            // Создаем объект UsersPage
            var page = new UsersPage(userPages, header);

            // Передаем объект UsersPage в шаблон
            ctx.render("users/index.jte", model("page", page));
        });

        // END

        app.get("/users/{id}", ctx -> {
            long userId = Long.parseLong(ctx.pathParam("id"));
            Optional<UserPage> userPageOptional = userPages.stream()
                    .filter(userPage -> userPage.getId() == userId)
                    .findFirst();

            if (userPageOptional.isPresent()) {
                UserPage userPage = userPageOptional.get();
                ctx.render("users/show.jte", model("userPage", userPage));
            } else {
                ctx.status(404).result("User not found");
            }
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });
        return app;
    }



    public static void main(String[] args) {
        getApp().start(7070);
    }
}
