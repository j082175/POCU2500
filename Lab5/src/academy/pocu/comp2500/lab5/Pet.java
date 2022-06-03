package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int damage;
    
    public Pet(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    protected int getDamage() {
        return this.damage;
    }
}
