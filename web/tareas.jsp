<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGT</title>
    <link rel="stylesheet" href="styles/styleTareas.css">

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
        <div class="todo-app">
            <h2>Tareas</h2>
            <div class="row">
                <button onclick="showPopup()">Add</button>
            </div>
            <ul id="list-container"></ul>

        </div>
    </div>

    <div id="popup-container" class="popup-container">
        <div class="popup-content">
            <form>
                <!-- Contenido de la ventana emergente -->
                <h3>Agregar Tarea</h3>
                <br>
                <div class="rowP">
                <input type="text" id="description" required placeholder="Ingrese una nueva tarea...">
                </div>
                <div class="rowP">
                <select id="category-select" placeholder="Seleccione una categoría"></select>
                </div>
                <div class="rowP">
                <label for="date">Fecha límite</label>
                <input type="date" id="date" required>
                </div>
                <div class="popup-footer">
                    <button onclick="addTask()">Guardar</button>
                    <button onclick="closePopup()">Cerrar</button>
                  </div>
            </form>
        </div>
    </div>
    <script src="scripts/scriptTareas.js"> </script>
</body>

</html>