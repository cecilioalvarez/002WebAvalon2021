$(document).ready(addListeners);

function addListeners() {
    $("#addPerson").click(() => {
        $("#error").html("").prop("hidden", true);
        
        let fieldsWithErrors = new Array();
        
        if (!validateName($("#name").val())) {
            fieldsWithErrors.push($("#name"));
        }

        if (!validateAge($("#age").val())) {
            fieldsWithErrors.push($("#age"));
        }
        
        if (fieldsWithErrors.length > 0) {
            showErrors(fieldsWithErrors);
        } else {
            $("#table-container").prop("hidden", false);
            $("#name, #age").removeClass("invalid");
            $("#name, #age").addClass("valid");
            let tr = $("<tr>").appendTo($("#table-body"));
            $("<td>").html($("#name").val()).appendTo(tr);
            $("<td>").html($("#age").val()).appendTo(tr);
            $("<input>").attr("type", "button").attr("name", "delete").val("Borrar").addClass("delete")
                    .click((event) => {
                        $(event.target).parent().parent().remove();
                        if ($("#table-body").children().length === 0) {
                            $("#table-container").prop("hidden", true);
                        }
                    })
                    .appendTo($("<td>")
                    .appendTo(tr));
        }
    });
    $("input[type='button']").click(() => $("input:not([type='button'])").val(""));
    $("#resetTable").click(()=> {
        $("#table-body").children().remove();
        $("#table-container").prop("hidden", true);
    });
};
            
let validateName = (name) => {
    return name.length >= 3;
};

let validateAge = (age) => {
    return age >= 18 && age <= 110;
};

function showErrors(fields) {
    let anyError = false;
    for (let i = 0; i <= fields.length; i++) {
        $(fields[i]).removeClass("valid");
        $(fields[i]).addClass("invalid");
        $("#error").html((anyError ? $("#error").html() +  "<br/>" : "") + $(fields[i]).data("error")).prop("hidden", false);
        anyError = true;
    }
    return anyError;
};