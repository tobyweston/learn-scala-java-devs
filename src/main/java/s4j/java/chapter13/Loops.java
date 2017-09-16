package s4j.java.chapter13;

import java.util.Arrays;
import java.util.List;

public class Loops {

    public static class Do {
        public static void main(String... args) {
            int i = 0;
            do {
                System.out.println(i);
                i++;
            } while (i < 10);
        }
    }

    public static class While {
        public static void main(String... args) {
            int i = 0;
            while (i < 10) {
                System.out.println(i);
                i++;
            }
        }
    }

    public static class For {
        public static void main(String... args) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    public static class EnhancedFor {
        public static void main(String... args) {
            List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            for (Integer i : numbers) {
                System.out.println(i);
            }

            numbers.forEach(i -> System.out.println(i));
            numbers.forEach(System.out::println);
        }
    }

}
