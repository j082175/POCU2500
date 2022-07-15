package academy.pocu.comp2500.lab9;

import java.lang.reflect.Array;
import java.util.*;

public class BuyOneGetOneFree {

    private ArrayList<Book> books;
    private HashSet<UUID> skuNumber;
    private int skuNumberSize;
    public BuyOneGetOneFree(HashSet<UUID> skuNumber) {
        this.skuNumber = skuNumber;
        this.skuNumberSize = skuNumber.size();
    }

    public int getTotalPrice(ArrayList<Book> books) {
        int stack[] = new int[skuNumberSize];
        int data[] = new int[skuNumberSize];
        Iterator itr = skuNumber.iterator();
        int count = 0;
        int totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {
            if (skuNumber.contains(books.get(i).getSku())) {
                for (int j = 0; j < skuNumberSize; j++) {
                    if (itr.next().equals(books.get(i).getSku())) {
                        stack[count]++;
                        data[count] += books.get(i).getPrice();
                        break;
                    }
                    count++;
                }


            }
            itr = skuNumber.iterator();
            count = 0;
        }

        for (int i = 0; i < skuNumberSize; i++) {
            int num = stack[i] % 2;
            totalPrice += data[i] / (stack[i] - num);
        }

        this.books = books;
        return totalPrice;
    }

    public int getTotalPrice(BuyOneGetOneFree buyOneGetOneFree) {

        return buyOneGetOneFree.getTotalPrice(buyOneGetOneFree.books);
    }
}
