$(document).ready(loadTableData);

function loadTableData() {
    let people = [
        {name: "Manuel", calification: 9}, 
        {name: "Elsa", calification: 6}, 
        {name: "Verónica", calification: 4}, 
        {name: "Alonso", calification: 1},
        {name: "Enrique", calification: 8}, 
        {name: "Desiré", calification: 8}, 
        {name: "Fernando", calification: 3}, 
        {name: "Gabriela", calification: 5},
        {name: "Saúl", calification: 7}, 
        {name: "Tamara", calification: 2}, 
        {name: "Regina", calification: 10}
    ];
            
    function loadTableContent(data, tableBody) {
        for (let index in data) {
            $("<tr>")
                    .append($("<td>").html(data[index].name))
                    .append($("<td>").html(data[index].calification).addClass("calification"))
                    .appendTo(tableBody);
        }
        $(".calification").each((index, td) => $(td).parent().addClass(parseInt($(td).html()) >= 5 ? "passed" : "failed"));
    };
    
    loadTableContent(people, $("#table-body"));
};