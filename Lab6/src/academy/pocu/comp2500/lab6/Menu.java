package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    protected int price;
    protected ArrayList<Topping> toppings = new ArrayList<>();

    public Menu(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}
