public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private String descripcion;
    private int dia;
    private double hora;

    public Tarea(String titulo, String descripcion, int dia, double hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;

        if (dia < 1) {
            this.dia = 1;
        } else if (dia > 7) {
            this.dia = 7;
        } else {
            this.dia = dia;
        }

        if (hora < 0.00) {
            this.hora = 0.00;
        } else if (hora > 23.59) {
            this.hora = 23.59;
        } else {
            this.hora = hora;
        }
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDia(int dia) {
        if (dia < 1) {
            this.dia = 1;
        } else if (dia > 7) {
            this.dia = 7;
        } else {
            this.dia = dia;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setHora(double hora) {
        if (hora < 0.00) {
            this.hora = 0.00;
        } else if (hora > 23.59) {
            this.hora = 23.59;
        } else {
            this.hora = hora;
        }
    }

    public double getHora() {
        return hora;
    }

    @Override
    public String toString() {
        String diaSemana = "";
        switch (dia) {
            case 1 -> diaSemana = "Lunes";
            case 2 -> diaSemana = "Martes";
            case 3 -> diaSemana = "Miércoles";
            case 4 -> diaSemana = "Jueves";
            case 5 -> diaSemana = "Viernes";
            case 6 -> diaSemana = "Sábado";
            default -> diaSemana = "Domingo";
        }

        return "Título: " + titulo + "\nDescripcion: " + descripcion + "\nDia: " + diaSemana + "\nHora: " + hora;
    }

    @Override
    public int compareTo(Tarea otra) {
        int res;

        if (dia - otra.getDia() != 0) {
            res = dia - otra.getDia();
        } else {
            res = (int)(hora - otra.getHora());
        }
        return res;
    }
}
