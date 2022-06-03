package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int damage;
    
    public Pet(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }
}
