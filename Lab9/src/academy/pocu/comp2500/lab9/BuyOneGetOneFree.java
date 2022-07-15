package academy.pocu.comp2500.lab9;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class BuyOneGetOneFree {

    private ArrayList<Book> books;
    private HashSet<UUID> skuNumber;

    public BuyOneGetOneFree(HashSet<UUID> skuNumber) {
        this.skuNumber = skuNumber;
    }

    public int getTotalPrice(ArrayList<Book> books) {
        int stack[] = new int[skuNumber.size()];
        int data[] = new int[skuNumber.size()];
        Iterator<UUID> itr = skuNumber.iterator();
        int count = 0;
        int totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {

            if (skuNumber.contains(books.get(i).getSku())) {
                for (int j = 0; j < skuNumber.size(); j++) {
                    if (itr.next().equals(books.get(i).getSku())) {
                        stack[count]++;
                        data[count] += books.get(i).getPrice();
                        break;
                    }
                    count++;
                }
            } else {
                totalPrice += books.get(i).getPrice();
            }





            itr = skuNumber.iterator();
            count = 0;
        }

        for (int i = 0; i < skuNumber.size(); i++) {
            int num = stack[i] / 2;
            int value = data[i] / stack[i] * num;
            totalPrice += (data[i] - value);
        }

        this.books = books;
        return totalPrice;
    }

    public int getTotalPrice(BuyOneGetOneFree buyOneGetOneFree) {

        return buyOneGetOneFree.getTotalPrice(buyOneGetOneFree.books);
    }
}
