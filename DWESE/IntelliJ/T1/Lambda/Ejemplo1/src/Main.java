import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        // 1 Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor)
        List<Transaction> tr11 = transactions.stream()
                                    .filter(tr -> tr.getAnio() == 2011)
                                    .sorted((a, b) -> a.getValor() - b.getValor())
                                    .toList();
        System.out.println("1: " + tr11);

        // 2 ¿Cuáles son todas las ciudades (sin repetición) donde trabajan los traders?
        List<String> cities = transactions.stream()
                                    .map(tr -> tr.getTrader().getCiudad())
                                    .distinct()
                                    .toList();
        System.out.println("2: " + cities);

        // O mediante toSet
        Set<String> citiesSet = transactions.stream()
                                    .map(tr -> tr.getTrader().getCiudad())
                                    .collect(toSet());
        System.out.println("0: " + citiesSet);

        // 3 Encuentre todos los traders de Cambridge y ordénelos por nombre
        List<Trader> traders = transactions.stream()
                                    .map(Transaction::getTrader)
                                    .filter(tr -> "Cambridge".equals(tr.getCiudad()))
                                    .distinct()
                                    .sorted(comparing(Trader::getNombre))
                                    .toList();
        System.out.println("3: " + traders);

        // 4 Devuelva los nombres de todos los traders ordenados alfabéticamente en una sola cadena
        String traderStr = transactions.stream()
                                .map(tr -> tr.getTrader().getNombre())
                                .distinct()
                                .sorted()
                                .reduce("", (n1, n2) -> n1 + n2 + " ");
        System.out.println("4: " + traderStr);

        // O mediante joining
        traderStr = transactions.stream()
                            .map(tr -> tr.getTrader().getNombre())
                            .distinct()
                            .sorted()
                            .collect(joining(" "));
        System.out.println("0: " + traderStr);

        // 5 ¿Hay traders con sede en Milán? Sí o no
        boolean milan = transactions.stream().anyMatch(tr -> "Milan".equals(tr.getTrader().getCiudad()));

        System.out.println("5: " + milan);

        // 6 Imprime los valores de todas las transacciones de los traders que viven en Cambridge
        System.out.print("6: ");
        transactions.stream()
                            .filter(tr -> "Cambridge".equals(tr.getTrader().getCiudad()))
                            .map(Transaction::getValor)
                            .forEach(System.out::println);

        // 7 ¿Cuál es el valor más alto de todas las transacciones?
        Optional<Integer> highest = transactions.stream()
                                            .map(Transaction::getValor)
                                            .reduce(Integer::max);

        System.out.println("7: " + highest);

        // 8 Encuentra la transacción con el valor más pequeño
        Optional<Transaction> smallestTransaction =  transactions.stream()
                                                            .reduce((t1, t2) -> t1.getValor() < t2.getValor() ? t1 : t2);
        smallestTransaction = transactions.stream()
                                    .min(comparing(Transaction::getValor));
        System.out.println("8: " + smallestTransaction);
    }
}