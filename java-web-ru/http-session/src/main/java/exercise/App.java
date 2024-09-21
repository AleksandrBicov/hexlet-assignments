package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

import static exercise.Data.getUsers;

public final class App {

    private static final List<Map<String, String>> USERS = getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.contentType("text/html");
            ctx.result("<h1 align=\"center\">Hello Hexlet</h1>");
        });

        // BEGIN
        app.get("/users", ctx -> {

            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            int startIndex = (page - 1) * per;
            int endIndex = Math.min(page * per, USERS.size());

            List<Map<String, String>> usersPage = USERS.subList(startIndex, endIndex);

            ctx.json(usersPage);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
