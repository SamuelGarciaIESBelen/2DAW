package org.iesbelen.model;

import java.util.Objects;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String password;
    private String rol;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return idUsuario == usuario.idUsuario && Objects.equals(nombre, usuario.nombre) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, password);
    }
}
