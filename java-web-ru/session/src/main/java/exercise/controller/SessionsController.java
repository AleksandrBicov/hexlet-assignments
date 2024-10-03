package exercise.controller;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.model.User;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static exercise.repository.UsersRepository.findByName;
import static exercise.util.Generator.getUsers;
import static exercise.util.Security.encrypt;
import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new LoginPage(ctx.sessionAttribute("name"),null);
        ctx.render("index.jte", model("page", page));
    }

    public static void loginForm(Context ctx) {
        ctx.render("build.jte");}

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = encrypt(ctx.formParam("password"));

        boolean nicknameExists = getUsers().stream()
                .anyMatch(user -> {
                    assert name != null;
                    return user.getName().startsWith(name);
                });

        if (!nicknameExists) {
            var page = new LoginPage(ctx.sessionAttribute("name"),"Wrong username or password.");
            ctx.render("index.jte", model("page", page));
            return;
        }

        User user = findByName(name)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (user.getPassword().equals(password)) {
            ctx.sessionAttribute("name", name);
            ctx.redirect("/");
        } else {
            var page = new LoginPage(ctx.sessionAttribute("name"),"Wrong username or password.");
            ctx.render("index.jte", model("page", page));
        }
    }


    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
