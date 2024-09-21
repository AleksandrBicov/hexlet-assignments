package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });


        app.get("/", ctx -> {
            ctx.contentType("text/html");
            ctx.result("<p><a href='http://localhost:7070/phones'>phones</a></p>"
                    + "<p><a href='http://localhost:7070/domains'>domains</a></p>");
        });

        app.get("/phones", ctx -> {
            // Создаем объект для сериализации в JSON
            List<String> newList = Data.getPhones();

            // Сериализуем объект в JSON и отправляем клиенту
            ctx.json(newList);
        });

        app.get("/domains", ctx -> {
            // Создаем объект для сериализации в JSON
            List<String> newList2 = Data.getDomains();

            // Сериализуем объект в JSON и отправляем клиенту
            ctx.json(newList2);
        });

        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
