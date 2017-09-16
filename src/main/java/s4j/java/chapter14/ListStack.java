package s4j.java.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStack<T> implements Stack<T> {

    static <A> A[] toArray(Stack<A> stack) {
        throw new UnsupportedOperationException();
    }

    static <A extends Comparable<A>> A[] toSortedArray(Stack<A> stack) {
        throw new UnsupportedOperationException();
    }

    public static <T> void copy(ListStack<? extends T> source, ListStack<? super T> destination) {
        for (T t : source.elements) {
            destination.elements.add(t);
        }
    }

    private final List<T> elements = new ArrayList<>();

    @Override
    public void push(T t) {
        elements.add(0, t);
        System.out.println(Arrays.toString(elements.toArray()));
    }

    @Override
    public T pop() {
        if (elements.isEmpty())
            throw new IndexOutOfBoundsException();
        return elements.remove(0);
    }

    public static void main(String... args) {
        Stack<String> stack = new ListStack<>();
        stack.push("C");
        stack.push("B");
        stack.push("A");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());


        List<String> a = new ArrayList<>();
        List<? extends CharSequence> b = new ArrayList<>();
        List<? extends Object> c = new ArrayList<>();

        b = a;
        c = b;
        c = a;
    }

}
