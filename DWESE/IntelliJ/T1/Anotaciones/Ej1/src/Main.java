public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto();
        empresa.setNombre("Batman Inc.");
        System.out.println(empresa);
    }
}