package academy.pocu.comp2500.lab6.app;

import java.util.ArrayList;

import academy.pocu.comp2500.lab6.MeatLoverPizza;
import academy.pocu.comp2500.lab6.Topping;

public class Program {

    public static void main(String[] args) {
        MeatLoverPizza meatLoverPizza = new MeatLoverPizza();
        boolean isAdded = meatLoverPizza.addGreenPeppers(); // true
        boolean isRemoved = meatLoverPizza.removeGreenPeppers(); // true
        isAdded = meatLoverPizza.addRedOnions(); // true
        boolean isValid = meatLoverPizza.isValid(); // true
        int price = meatLoverPizza.getPrice(); // 21
        ArrayList<Topping> toppings = meatLoverPizza.getToppings();
    }
}
