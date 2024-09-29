package exercise.controller;

import exercise.dto.users.UserPage;
import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import lombok.ToString;

import static exercise.repository.UserRepository.find;
import static io.javalin.rendering.template.TemplateUtil.model;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void usersPOST(Context ctx) {

        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String token = Security.generateToken();
        var user = new User(firstName,lastName,email,password,token);
        UserRepository.save(user);
        Long id = user.getId();
        System.out.println("id пользователя = " + id);
        ctx.cookie("userToken",token);
        ctx.redirect("/users/" + id);
    }

    public static void show(Context ctx) {

        var tokenFromCookie = ctx.cookie("userToken");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        User user = find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        assert tokenFromCookie != null;
        if (!tokenFromCookie.equals(user.getToken())) {
            ctx.redirect("/users/build");
            return;
        }
        UserPage page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));

    }
    // END
}
