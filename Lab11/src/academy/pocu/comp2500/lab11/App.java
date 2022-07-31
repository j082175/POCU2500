package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) throws IOException {
        // in : 사용자 입력, out : 텍스트 출력, err : 오류 코드 출력
        StringBuilder builder = new StringBuilder();

        builder.append("WAREHOUSE: Choose your warehouse!");
        builder.append(System.lineSeparator());
        {
            int i = 1;
            for (var a : WarehouseType.values()) {
                builder.append(String.format("%d. %s", i, a));
                i++;

                builder.append(System.lineSeparator());

            }
        }

        // 목록 출력
        int count = 0;
        String s;
        do {
            out.print(builder);

            s = in.readLine();

            if (s.equals("exit")) {
                return;
            }

            try {
                count = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                continue;
            }

            {
                int i = 1;
                for (var a : WarehouseType.values()) {
                    if (s.equals(String.valueOf(i))) {
                        if (!printScreen(in, out, err, a)) {
                            return;
                        }
                    }
                    i++;
                }
            }
        } while (count < 1 || count > WarehouseType.values().length);
    }

    private boolean printScreen(BufferedReader in, PrintStream out, PrintStream err, WarehouseType warehouseType) throws IOException {
        boolean check = true;
        String s;
        User user = new User();
        Wallet wallet = null;
        StringBuilder builder = new StringBuilder();

        Warehouse warehouse = new Warehouse(warehouseType);
        ArrayList<Product> arrayList = warehouse.getProducts();


        int count1 = 0;

        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return false;
        }

        do {
/*            builder.append("PRODUCT_LIST: Choose the product you want to buy!");
            builder.append(System.lineSeparator());
            for (int i = 0; i < arrayList.size(); i++) {
                builder.append(String.format("%d. %s\t\t%d", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice()));
                builder.append(System.lineSeparator());
            }*/

            out.print("PRODUCT_LIST: Choose the product you want to buy!");
            out.print(System.lineSeparator());
            for (int i = 0; i < arrayList.size(); i++) {
                out.print(String.format("%d. %s\t\t%d", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice()));
                out.print(System.lineSeparator());
            }

            if (arrayList.size() == 0) {
                return false;
            }

            if (wallet != null) {
                out.println(String.format("BALANCE: %d", wallet.getAmount()));
            }

            //out.print(builder);

            s = in.readLine();

            if (s.equals("exit")) {
                return false;
            }

            try {
                count1 = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                continue;
            }

            if (count1 > 0 && count1 <= arrayList.size()) {
                int price = arrayList.get(count1 - 1).getPrice(); // 기존에 봤던 제품 가격
                int amount = wallet.getAmount(); // 기존 지갑 잔고
                check = wallet.withdraw(arrayList.get(count1 - 1).getPrice());

                if (check) {
                    try {
                        warehouse.removeProduct(arrayList.get(count1 - 1).getId());
                    } catch (ProductNotFoundException e) {
                        wallet.deposit(amount - wallet.getAmount());
                        throw new ProtocolException("productnotfound");
                    }


/*                    if (wallet.getAmount() != amount - price) { //
                        wallet.deposit(amount - wallet.getAmount());
                    }*/

                }


            } else {
                continue;
            }


        } while (check);

        return true;
    }
}