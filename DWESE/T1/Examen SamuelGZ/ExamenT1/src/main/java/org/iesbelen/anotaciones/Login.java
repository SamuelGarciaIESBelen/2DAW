package org.iesbelen.anotaciones;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// passwd: admin <-> hashPasswd: 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
@CredencialAn(usuario = "usuario1",
        hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")

// passwd: admin1234 <-> hashPasswd: ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270
@CredencialAn(usuario = "usuario2",
        hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")
public class Login {
    List<Credencial> users;

    public Login() {
        users = cargadorDeContexto();
    }

    /**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:
     8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password ) throws NoSuchAlgorithmException {
        MessageDigest digest;

        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] byteHash) {

        StringBuilder hexString = new StringBuilder(2 * byteHash.length);
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static List<Credencial> cargadorDeContexto() {
        List<Credencial> users = new ArrayList<>();

        CredencialAn[] credenciales = Login.class.getAnnotationsByType(CredencialAn.class);

        for (CredencialAn c : credenciales) {
            users.add(new Credencial(c.usuario(), c.hashPasswd()));
        }
        return users;
    }

    public void login() throws NoSuchAlgorithmException {
        Scanner scan  = new Scanner(System.in);
        String usuario, hashPasswd;

        System.out.print("Introduce un usuario: ");
        usuario = scan.nextLine();
        System.out.print("Introduce una contraseña: ");
        hashPasswd = hashPassword(scan.nextLine());

        Credencial cred = new Credencial(usuario, hashPasswd);

        if (users.contains(cred)) {
            System.out.println("ACCESO CONCEDIDO");
        } else {
            System.out.println("ACCESO DENEGADO");
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (Credencial cred : users) {
            res += cred.toString() + "\n";
        }
        return res;
    }
}
