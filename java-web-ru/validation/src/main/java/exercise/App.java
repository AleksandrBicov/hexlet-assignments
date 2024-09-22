package exercise;

import exercise.dto.articles.BuildArticlePage;
import io.javalin.Javalin;
import io.javalin.validation.ValidationException;

import java.util.HashMap;
import java.util.List;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage("","",new HashMap<>());
            ctx.render("articles/build.jte",model("page", page));
        });


        app.post("/articles", ctx -> {
            try {
                String title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
                        .get();

                String content = ctx.formParamAsClass("content", String.class)
                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();

                var article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.status(302).redirect("/articles");
            } catch (ValidationException exception) {
                String title = ctx.formParam("title");
                String content = ctx.formParam("content");
                var page = new BuildArticlePage(title, content, exception.getErrors());
                ctx.status(422).render("articles/build.jte", model("page", page));

                exception.getErrors().forEach((key, value) ->
                        System.out.println("Ошибка по ключу: " + key + " - " + value));
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
