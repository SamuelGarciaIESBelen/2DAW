package org.iesbelen.demo.model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String editorial;

    public Libro(int id, String titulo, String autor, String editorial) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTitulo() { return titulo; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getAutor() { return autor; }

    public void setEditorial(String editorial) { editorial = editorial; }

    public String getEditorial() { return editorial; }
}
