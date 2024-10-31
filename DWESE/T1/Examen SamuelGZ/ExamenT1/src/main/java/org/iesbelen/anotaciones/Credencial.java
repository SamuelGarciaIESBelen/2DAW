package org.iesbelen.anotaciones;

import java.util.Objects;

public class Credencial {
    private String usuario;
    private String hashPasswd;

    public Credencial(String usuario, String hashPasswd) {
        this.usuario = usuario;
        this.hashPasswd = hashPasswd;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setHashPasswd(String hashPasswd) {
        this.hashPasswd = hashPasswd;
    }
    public String getHashPasswd() {
        return hashPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credencial that = (Credencial) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(hashPasswd, that.hashPasswd);
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario + " | HashPasswd: " + hashPasswd;
    }
}
