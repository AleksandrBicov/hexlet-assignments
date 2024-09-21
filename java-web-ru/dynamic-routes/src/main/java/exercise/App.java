package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;


public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {

            var id = ctx.pathParam("id");


            Map<String, String> company = COMPANIES.stream()
                    .filter(compania ->id.equals(compania.get("id")))
                    .findFirst()
                    .orElse(null);

            if (company != null) {
                ctx.json(company);
            } else {
                ctx.status(404).result("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });


        app.get("/", ctx -> {
            ctx.contentType("text/html");
            ctx.result("" +
                    "<form onsubmit='event.preventDefault(); redirectToCompany(this);'>" +
                    "  <label for='companyId'>Enter Company ID:</label>" +
                    "  <input type='text' id='companyId' name='id' required>" +
                    "  <button type='submit'>Search</button>" +
                    "</form>" +
                    "<script>" +
                    "  function redirectToCompany(form) {" +
                    "    var id = form.elements.id.value;" +
                    "    window.location.href = '/companies/' + id;" +
                    "  }" +
                    "</script>"
            );
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
