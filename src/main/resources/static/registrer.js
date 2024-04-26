$(function () {
    $("#feilHentFilmer").html("");
    $("#feilLagreBillett").html("");

    hentFilmer();
});

function hentFilmer() {
    $.get("/hentFilmer", function (data) {
        formaterFilmer(data);
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilHentFilmer").html(json.message);
    });
}

function formaterFilmer(filmer) {
    let ddlFilmer = "<select id='DDLFilmer' class='form-control'><option>Velg film:</option>";

    filmer.forEach(function (film) {
        ddlFilmer += "<option>" + film.tittel + "</option>";
    });
    ddlFilmer += "</select>";
    $("#utFilmer").html(ddlFilmer);
}

function registrer() {
    const filmen = $("#DDLFilmer option:selected").text();
    const sjekkFilmen = sjekkFilm(filmen);

    const ant = $("#antall").val()
    const sjekkAnt = sjekkAntall(ant);

    const fNavn = $("#fornavn").val();
    const sjekkFNavn = sjekkFornavn(fNavn);

    const eNavn = $("#etternavn").val()
    const sjekkENavn = sjekkEtternavn(eNavn);

    const telNr = $("#telefonNr").val();
    const sjekkTelNr = sjekkTelefon(telNr);

    const eAdresse = $("#epost").val();
    const sjekkEAdresse = sjekkEpost(eAdresse);

    if(sjekkFilmen && sjekkAnt && sjekkFNavn && sjekkENavn && sjekkTelNr && sjekkEAdresse) {
        const billett = {
            film : filmen,
            antall : ant,
            fornavn : fNavn,
            etternavn : eNavn,
            telefonNr : telNr,
            epost : eAdresse
        };

        $.post("/lagreBillett", billett, function () {
            window.location.href = "index.html";
        }).fail(function (jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feilLagreBillett").html(json.message);
        });
    }
}

function sjekkFilm(film) {
    $("#feilFilm").html("");

    if(film === "Velg film:") {
        $("#feilFilm").html("Vennligst velg en film!");
        return false;
    }
    else {
        $("#feilFilm").html("");
        return true;
    }
}

function sjekkAntall(antall) {
    $("#feilAntall").html("");

    if(isNaN(antall) || antall < 1) {
        $("#feilAntall").html("Vennligst oppgi et gyldig antall!");
        return false;
    }
    else {
        $("#feilAntall").html("");
        return true;
    }

}

function sjekkFornavn(fornavn) {
    $("#feilFornavn").html("");
    const regexNavn = /^[a-zæøåA-ZÆØÅ]{2,50}$/;

    if(!regexNavn.test(fornavn)) {
        $("#feilFornavn").html("Vennligst oppgi et gyldig fornavn!");
        return false;
    }
    else {
        $("#feilFornavn").html("");
        return true;
    }
}

function sjekkEtternavn(etternavn) {
    const regexNavn = /^[a-zæøåA-ZÆØÅ]{2,50}$/;

    if(!regexNavn.test(etternavn)) {
        $("#feilEtternavn").html("Vennligst oppgi et gyldig etternavn!");
        return false;
    }
    else {
        $("#feilEtternavn").html("");
        return true;
    }
}

function sjekkTelefon(telefonNr) {
    $("#feilTelefonNr").html("");
    const regexTelefon = /^[0-9]{8}$/;

    if(!regexTelefon.test(telefonNr)) {
        $("#feilTelefonNr").html("Vennligst oppgi et gylid telefonnummer!");
        return false;
    }
    else {
        $("#feilTelefonNr").html("");
        return true
    }
}

function sjekkEpost(epost) {
    $("#feilEpost").html("");
    const regexEpost = /^[a-zæøåA-ZÆØÅ]+@[a-zæøåA-ZÆØÅ]+\.[a-zæøåA-ZÆØÅ]+$/;

    if (!regexEpost.test(epost) || epost.length > 100) {
        $("#feilEpost").html("Vennligst oppgi en gyldig epost!");
        return false;
    }
    else {
        $("#feilEpost").html("");
        return true;
    }
}