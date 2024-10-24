function emailCifrado(email) {
    let partesEmail = email.split("@");
    let parteLocal = partesEmail[0];
    let parteDominio = partesEmail[1];

    let parteLocalProtegida = parteLocal.substring(0, 4) + "...";

    return parteLocalProtegida + "@" + parteDominio;
}
console.log(emailCifrado("sam@gmail.com"));