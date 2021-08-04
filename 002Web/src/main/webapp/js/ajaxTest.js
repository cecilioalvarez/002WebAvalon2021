$(document).ready(addListeners);

function addListeners() {
    $("#request").click(() => sendRequest());
};

function sendRequest() {
    let settings = {
        url: "ServletAjaxPrueba",
        method: "GET",
        dataType: "json",
        async: true,
        success: showResponse
    };
    $.ajax(settings);
};

function showResponse(books) {
    $("#response-viewer").empty();
    
    let $table = $("<table>");
    let $thead = $("<thead>")
            .appendTo($table);
    let $tbody = $("<tbody>")
            .appendTo($table);
    
    $("<tr>")
            .append($("<th>").html("Isbn"))
            .append($("<th>").html("Título"))
            .append($("<th>").html("Autor"))
            .appendTo($thead);
    
    for (let index in books) {
        $("<tr>")
            .append($("<td>").html(books[index].pk_isbn.toUpperCase()))
            .append($("<td>").html(books[index].title))
            .append($("<td>").html(books[index].fk_author.name))
            .appendTo($tbody);
    }
    $table.appendTo($("#response-viewer"));
};