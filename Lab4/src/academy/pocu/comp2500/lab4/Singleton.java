package academy.pocu.comp2500.lab4;

public class Singleton {
    public static int aa = 555;
    public static Singleton instance = null;
    // static Singleton instance;

    private int num;

    private Singleton(int num) {
        this.num = num;
    }

    private Singleton() {
        instance = null;
    }

    public static void aaclear() {
        aa = 0;
    }

    public static Singleton getInstance(int num) {
        if (instance == null) {
            instance = new Singleton(num);
        }

        return instance;
    }

    public static void clear() {
        assert instance != null;

        Singleton.instance = null;
    }

    public int getNum() {
        return this.num;
    }
}
