package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SkyIsTheLimit { // Cart 클래스도 변경
    private int price;

    public SkyIsTheLimit(int price) {
        this.price = price;
    }


    public int getTotalPrice(ArrayList<Book> books) {//계산은 double 로
        double sum = 0;
        double totalPrice = 0;
        double priceArr[] = new double[books.size()];
        for (int i = 0; i < books.size(); i++) {
            sum += books.get(i).getPrice();
            priceArr[i] = books.get(i).getPrice();
        }

        if (sum >= this.price) {
            totalPrice = calculateDiscount(priceArr);
        } else {
            totalPrice = sum;
        }


        return (int) totalPrice;
    }

    private double calculateDiscount(double priceArr[]) {
        double max = priceArr[0];
        double max2 = 0;
        double totalPrice = 0;
        int index = 0;
        for (int i = 1; i < priceArr.length; i++) {
            if (priceArr[i] > max) {
                max = priceArr[i];
                index = i;
            }
        }

        priceArr[index] = 0;

        for (int i = 0; i < priceArr.length; i++) {
            if (priceArr[i] > max2) {
                max2 = priceArr[i];
                index = i;
            }
        }

        priceArr[index] = 0;

        for (int i = 0; i < priceArr.length; i++) {
            totalPrice += priceArr[i];
        }

        totalPrice += (max + max2) * 0.5;
        return totalPrice;
    }
}
