public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Batman Inc.");
        empresa.cargadorDeDirectivos(empresa);
        empresa.cargadorDeTecnicos(empresa);
        empresa.cargadorDeOficiales(empresa);

        System.out.println(empresa);
    }
}