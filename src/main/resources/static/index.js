$(function () {
    $("#feilHentAlleBilletter").html("");
    $("#feilSlettAlleBilletter").html("");
    $("#feilSlettEnBillett").html("");

    hentAlleBilletter();
});

function hentAlleBilletter() {
    $.get("/hentAlleBilletter", function (data) {
        formaterBilletter(data);
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilHentAlleBilletter").html(json.message);
    });
}

function formaterBilletter(billetter) {
    let tabellBilletter = "<table class='table table-striped table-bordered'><tr>" +
                                 "<th>Film</th><th>Antall</th><th>Fornavn</th>" +
                                 "<th>Etternavn</th><th>Telefon</th><th>Epost</th>" +
                                 "<th>Endre</th><th>Slett</th></tr>";

    billetter.forEach(function (billett) {
        tabellBilletter += "<tr><td>" + billett.film + "</td><td>" + billett.antall + "</td>" +
                           "<td>" + billett.fornavn + "</td><td>" + billett.etternavn + "</td>" +
                           "<td>" + billett.telefonNr + "</td><td>" + billett.epost + "</td>" +
                           "<td><a class='btn btn-primary' href='endre.html?nr=" + billett.nr + "'>Endre</a></td>" +
                           "<td><button class='btn btn-danger' onclick='slettEnBillett(" + billett.nr + ")'>Slett</button></td></tr>";
    });
    tabellBilletter += "</table>";
    $("#utBilletter").html(tabellBilletter);
}

function slettAlleBilletter() {
    $.ajax( {
        url : "/slettAlleBilletter",
        type : "DELETE",
        success : function () {
            hentAlleBilletter();
        }
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilSlettAlleBilletter").html(json.message);
    });
}

function slettEnBillett(nr) {
    $.ajax( {
        url : "/slettEnBillett?nr=" + nr,
        type : "DELETE",
        success : function () {
            hentAlleBilletter();
        }
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilSlettEnBillett").html(json.message);
    });
}