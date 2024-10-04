package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        List<Post> list = PostRepository.getEntities();
        var page = new PostsPage(list);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String body = ctx.formParam("body");

        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Пост должен быть не короче 2 символов")
                    .get();
            Post post = new Post(name,body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            String name = ctx.formParam("name");
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", model("page", page));
        }
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }



}
