package s4j.java.chapter13;

@SuppressWarnings("all")
public class If {

    private final int age = 23;

    public If() {
        if (age > 55) {
            retire();
        } else {
            carryOnWorking();
        }
    }

    void retire() { }
    void carryOnWorking() { }
    void savings() { }
}
