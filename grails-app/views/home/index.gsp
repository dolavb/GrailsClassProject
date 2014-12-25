<html>

<head>
    <title><g:message code="default.welcome.title" args="[meta(name: 'app.name')]"/></title>
    <meta name="layout" content="kickstart"/>
</head>

<body>

<section id="info">
    <div class="center">
        <h1>WELCOM TO BLABHA</h1>
    </div>

    <div class="center">
        <p>Blabha is a simple application to manage products and their bill of materails</p>
    </div>
</section>

<section id="info2">
    <div class="row">
        <div class="col-md-4">
            <div class="center">
                <h3>Demo Users</h3>
            </div>

            <p>
            <table class="table table-bordered">
                <tr>
                    <th>
                        User Name
                    </th>
                    <th>
                        Password
                    </th>
                </tr>
                <tr>
                    <td>
                        blabhaAdmin
                    </td>
                    <td>
                        Admin
                    </td>
                </tr>
                <tr>
                    <td>
                        blabhaEditor
                    </td>
                    <td>
                        Editor
                    </td>
                </tr>
                <tr>
                    <td>
                        blabhaViewer
                    </td>
                    <td>
                        Viewer
                    </td>
                </tr>
            </table>
        </p>
        </div>

        <div class="col-md-4">
            <div class="center">
                <h3>Getting Started</h3>
            </div>

            <p>Using the admin or the edior user or any other user with the role editor:</p>
            <ul>
                <li>
                    Create Material: access the material module in the product Product Design menu and creates some materials
                </li>
                <li>
                    Create a Product: access product managment and create a product
                </li>
                <li>
                    Edit your newly created product: access the product editor, drag and drop materials in the product.
                </li>
            </ul>

        </div>

        <div class="col-md-4">
            <div class="center">
                <h3>Other Features</h3>
            </div>

            <p>There is an admin menu from which you can access the Spring security UI</p>
        </div>
    </div>
</section>

</body>

</html>
