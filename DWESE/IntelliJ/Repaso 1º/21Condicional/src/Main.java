import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double nota1, nota2, media;

        do {
            System.out.print("Introduce una nota: ");
            nota1 = scan.nextDouble();
        } while (nota1 < 0 || nota1 > 10);

        do {
            System.out.print("Introduce otra nota: ");
            nota2 = scan.nextDouble();
        } while (nota2 < 0 || nota2 > 10);

        media = (nota1 + nota2) / 2;

        if (media >= 5) {
            System.out.printf("Tu nota de Programación es %.2f\n", media);
        } else {
            String res;

            do {
            System.out.print("¿Cuál ha sido el resultado de la recuperación? (Apto / No apto): ");
            res = scan.nextLine().toLowerCase();
            } while (!res.equals("apto") && !res.equals("no apto"));

            if (res.equals("apto")) {
                System.out.println("Tu nota de Programación es 5,00");
            } else {
                System.out.printf("Tu nota de Programación es %.2f\n", media);
            }
        }
    }
}