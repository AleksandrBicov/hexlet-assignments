package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import io.javalin.rendering.template.JavalinJte;

import static exercise.util.NamedRoutes.*;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/",SessionsController::index);
        // BEGIN
        //  GET — форма логина, в которой пользователь вводит имя и пароль
        app.get(buildSessionPath(),SessionsController::loginForm);
        //  POST для создания сессии
        app.post(loginPath(),SessionsController::create);
        //  POST для удаления сессии
        app.post(logoutPath(),SessionsController::delete);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
