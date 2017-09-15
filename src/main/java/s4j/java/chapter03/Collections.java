package s4j.java.chapter03;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.forEach(value -> System.out.println(value));
    }

}
