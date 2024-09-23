package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import io.javalin.http.Context;
import io.javalin.validation.Validator;

import java.util.List;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {

    // BEGIN
    public static void indexPosts(Context ctx) {
        int page = Math.max(ctx.queryParamAsClass("page", Integer.class).getOrDefault(1),1);
        List<Post> posts = PostRepository.findAll(page, 5);
        PostsPage pageData= new PostsPage(posts, page);
        ctx.render("posts/index.jte", model("page", pageData));
    }

    public static void showPosts(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(1L);

        Optional<Post> postOptional = PostRepository.find(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            var page = new PostPage(post);
            ctx.render("posts/show.jte",model("page", page));
        } else {
            ctx.status(404).result(" Page not found");
        }
    }
    // END
}
