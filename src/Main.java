import java.security.KeyPair;
import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    // Hello
    public static void zad241() {
        int n = scanner.nextInt();
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        int min = Integer.MAX_VALUE;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        // 1 5 7 9 10 12 15 18
        Arrays.sort(numbers); // O(olgn)
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(Math.abs(numbers[i] - numbers[i + 1]), min);
        }
        System.out.println(min);
    }

    // Ordered Pairs (надредени двойки)
    // (1,2) -> x = 1; y = 2
    // (3,4) ->
    // (5,6)
    // (a, b) -> {a, {a, b}}
    static class Pairs implements Comparable<Pairs> {
        private int a;
        private int b;

        public Pairs(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        @Override
        public int compareTo(Pairs o) {
            if (a > o.getA()) {
                return 1;
            } else if (a < o.getA()) {
                return -1;
            } else {
                if (b > o.getB()) {
                    return 1;
                } else if (b < o.getB()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    public static void zad242() {
        int n = scanner.nextInt();
        if (n < 2) {
            throw new IllegalArgumentException();
        }

        Pairs[] pairs = new Pairs[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Pairs pair = new Pairs(a, b);
            pairs[i] = pair;
        }
        Arrays.sort(pairs);
        for (int i = 0; i < n; i++) {
            System.out.println(pairs[i]);
        }
    }

    // zad244
    // [100 -> 300]
    // [195
    public static void zad244() {
        int n = scanner.nextInt();
        if (n < 2) {
            throw new IllegalArgumentException();
        }
        int[] numbers = new int [10000000];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            numbers[a-1] ++;
        }
        for (int i = 0; i < 1000000; i++) {
            if (numbers[i] > 0) {
                for (int j = 0; j < numbers[i]; j++) {
                    System.out.print(i+1 + " ");
                }
            }
        }
    }

    public static void zad245() {
        int n = scanner.nextInt();

        int[] first = new int[n];

        for (int i = 0; i < n; i++) {
            first[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) {
            second[i] = scanner.nextInt();
        }
        Arrays.sort(first);
        Arrays.sort(second);
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < n && secondIndex < m) {
            if (first[firstIndex] > second[secondIndex]) {
                secondIndex++;
            }else if (first[firstIndex] < second[secondIndex]) {
                firstIndex++;
            }else{
                System.out.println(first[firstIndex] + " ");
                firstIndex++;
            }
        }
        // [1 3 7 7 10 12 57 99]
        // [3 4 6 8 15 44 57]
        // [1,3,3,4,6,7,7,8,10,12,15,44,57,57,99]
    }

    public static void zad246() {
       Set <Integer> set = new HashSet();
       Random random = new Random();
       while(set.size() < 6) {
           int a = random.nextInt(1, 49);
           set.add(a);
       }
       Object[] numbers = set.toArray();

       Arrays.sort(numbers);
       for (int i = 0; i < numbers.length; i++) {
           System.out.print(numbers[i] + " ");
       }
    }

    public static void main(String[] args) {
        zad2512();
    }

    public static void zad2512(){
        String regex = "<[^>]+>";
        String string = "<!DOCTYPE html>\n" +
                "<html lang=\"bg\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Примерен HTML файл.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Здравей, свят!</h1>\n" +
                "    <p>Това е примерен HTML файл с малко текст в него.</p>\n" +
                "</body>\n" +
                "</html>";
        string = string.replaceAll(regex, "");
        string = string.replaceAll("\n", " ");
        string = string.replaceAll("\\s{2,}", " ");
        System.out.println(string);
    }
}