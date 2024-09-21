@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Layout</title>
        <!-- Подключение Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <header class="container mt-4">
            <p> <a href="/" class="btn btn-primary btn-sm">Home</a>
                <a href="/users" class="btn btn-primary btn-sm">Users</a>   </p>
        </header>

        <div class="container mt-4">
            ${content}
        </div>

        <footer class="bg-dark text-white text-center py-1">
                    <div class="container">
                        <p>Thanks for visiting, come again soon!</p>
                    </div>
                </footer>

        <!-- Подключение Bootstrap JS и зависимостей -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>