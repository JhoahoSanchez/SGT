<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Categorías</title>
    <link rel="stylesheet" href="styles/styleCategorias.css">
</head>

<body>
    <header class="header">
        <div class="logo">
            <a href="index.jsp"><img src="images/icon.png" alt="Logo"></a>
        </div>
        <nav>
            <ul class="nav-links">
                <li><a href="#">Perfil</a></li>
                <li><a href="tareas.jsp">Tareas</a></li>
                <li><a href="categorias.jsp">Categorías</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="container">
        <form>
            <div class="todo-app">
                <h2>Categorías</h2>
                <div class="row">
                    <input class="text-input" type="text" id="input-box" placeholder="Ingrese una nueva categoría...">
                    <input class="color-input" type="color" id="color-selector" name="colorPicker">
                    <button onclick="addCategory()">Add</button>
                </div>
                <ul id="list-container"></ul>
            </div>
        </form>
    </div>
    <script src="scripts/common.js"></script>
    <script src="scripts/scriptCategorias.js"></script>
</body>

</html>