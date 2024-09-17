@import gg.jte.Content
@param Content content
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Layout</title>
    </head>
    <body>
        <header>
            <p><a href="/">Home</a></p>
            <p><a href="/users">Users</a></p>
        </header>

         ${content}

        <footer>
            <p>Thanks for visiting, come again soon!</p>
        </footer>
    </body>
</html>