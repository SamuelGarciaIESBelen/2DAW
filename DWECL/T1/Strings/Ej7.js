function string_parametrize(texto){
    if (typeof texto !== 'string') {
        return null;
    }
    return texto.toLowerCase().replace(/[^a-z0-9\s]/g, "").replace(/\s+/g, "-");
}
console.log(string_parametrize("Batman,  #  the World's Greatest Detective!"));