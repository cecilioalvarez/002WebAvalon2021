$(document).ready(addListeners);

function addListeners() {
    $("#create-table").click(() => createTable(parseInt($("#rows").val()), parseInt($("#columns").val()), $("#table-container")));
    $("#clean-table").click(() => cleanTable($("#table-container")));
};

function createTable(rows, columns, $container) {
    cleanTable($container);
    
    $("<table>").attr("id", "custom-table")
            .append($("<caption>").html("Tabla generada dinámicamente"))
            .append($("<thead>"))
            .append($("<tbody>"))
            .appendTo($container);
    
    let $tr_thead = $("<tr>").appendTo("#custom-table thead");
    for (let i = 0; i < columns; i++) {
        $("<th>").html("Encabezado " + (i + 1)).appendTo($tr_thead);
    }
    
    for (let i = 0; i < rows; i++) {
        let $tr = $("<tr>").appendTo("#custom-table tbody");
        for (let j = 0; j < columns; j++) {
            $("<td>").html("Fila: " + (i + 1) + " / Columna: " + (j + 1)).appendTo($tr);
        }
    }
    $("#clean-table").prop("hidden", false);
};

function cleanTable($container) {
    $container.empty();
    $("input[type='number']").val("2");
    $("#clean-table").prop("hidden", true);
};