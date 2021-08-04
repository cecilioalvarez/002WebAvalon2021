$(document).ready(addListeners);

function addListeners() {
    $("input[name='language']").change(()=> $("#answer-languages").html("Quieres aprender más de: " + $("input[name='language']:checked").val()));
    $("input[name='language-learned']").change(()=> {
        $("#answer-learned").html("Ya has aprendido: ");
        let anyLanguage = false;
        $("input[name='language-learned']:checked").each((index, input) => {
            $("#answer-learned").html($("#answer-learned").html() + (anyLanguage ? ", " : "") + $(input).val());
            anyLanguage = true;
        });
    });
}