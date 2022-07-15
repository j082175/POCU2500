package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SimplePricing implements PriceModel { // 기본 가격 결정모델 Cart 도 변경해야함

    public SimplePricing() {
    }


    @Override
    public int getTotalPrice(ArrayList<Book> books) {
        int totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {
            totalPrice += books.get(i).getPrice();
        }

        return totalPrice;
    }
}
