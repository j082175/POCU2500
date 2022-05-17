package academy.pocu.comp2500.lab4.app;

import java.util.ArrayList;

public class A {
    public ArrayList<A> a;

    A() {
        a = new ArrayList<>();
    }

    public void add(A a) {
        a.add(a);
    }
}
