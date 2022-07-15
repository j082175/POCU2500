package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DecadeMadness extends Cart { //Cart 클래스도 변경

    private final double DISCOUNT_RATE = 0.8;
    public DecadeMadness() {
    }


    public int getTotalPrice(ArrayList<Book> books) { //계산은 double로
        double totalPrice = 0;
        int checkDecade[];
        int checkDecadeCount[];
        double priceArr[];
        int count = 0;
        HashSet<Integer> yearArr = new HashSet<>();
        Iterator<Integer> itr;

        for (int i = 0; i < books.size(); i++) {
            yearArr.add(books.get(i).getPublishedYear() / 10);
        }

        checkDecade = new int[yearArr.size()];
        checkDecadeCount = new int[yearArr.size()];
        priceArr = new double[yearArr.size()];

        itr = yearArr.iterator();
        for (int i = 0; i< yearArr.size(); i++) {
            checkDecade[i] = itr.next();
        }

        for (int i = 0; i < yearArr.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if (checkDecade[i] == (books.get(j).getPublishedYear() / 10)) {
                    priceArr[i] += books.get(j).getPrice();
                    checkDecadeCount[i]++;
                }
            }
        }


        for (int j = 0; j < yearArr.size(); j++) {
            if (checkDecadeCount[j] > 1) {
                totalPrice += priceArr[j] * DISCOUNT_RATE;
            } else {
                totalPrice += priceArr[j];
            }
        }




        return (int)totalPrice;
    }
}
