package academy.pocu.comp2500.lab4;

public class Singleton {

    public static Singleton instance;

    private int num;

    private Singleton(int num) {
        this.num = num;
    }

    private Singleton() {
        instance = null;
    }

    public static Singleton getInstance(int num) {
        if (instance == null) {
            instance = new Singleton(num);
        }

        return instance;
    }

    public static void clear() {
        assert instance != null;

        instance = null;
    }

    public int getNum() {
        return this.num;
    }
}
