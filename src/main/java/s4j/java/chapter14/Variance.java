package s4j.java.chapter14;

@SuppressWarnings("all")
public class Variance {

    static class A {}
    static class B extends A {}

    static class Container<T> {
    }

    public static void main(String... args) {
        basicSubTyping();
        containerSubTyping();
    }

    private static void basicSubTyping() {
        A a = new A();
        B b = new B();
        a = b;
        // b = a; // compiler failure
    }

    private static void containerSubTyping() {
        Container<A> a = new Container<>();
        Container<B> b = new Container<>();

        // a = b;  // compiler failure
    }
}
