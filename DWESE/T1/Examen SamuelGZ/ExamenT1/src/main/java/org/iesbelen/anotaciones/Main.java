package org.iesbelen.anotaciones;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Login users = new Login();
        System.out.println(users);
        users.login();
    }
}
