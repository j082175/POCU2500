package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.PermanentlyClosedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

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
                        printScreen(in, out, err, a);
                    }
                    i++;
                }
            }
        } while (count < 1 || count > WarehouseType.values().length);
    }

    private void printScreen(BufferedReader in, PrintStream out, PrintStream err, WarehouseType warehouseType) throws IOException {
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
        } catch (PermanentlyClosedException e) {
            err.println("AUTH_ERROR");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (wallet != null) {
            out.println(String.format("BALANCE: %d", wallet.getAmount()));
        }

        builder.append("PRODUCT_LIST: Choose the product you want to buy!");
        builder.append(System.lineSeparator());
        for (int i = 0; i < arrayList.size(); i++) {
            builder.append(String.format("%d. %s\t\t%d", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice()));
            builder.append(System.lineSeparator());
        }

        do {
            out.print(builder);

            s = in.readLine();

            if (s.equals("exit")) {
                return;
            }

            try {
                count1 = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                continue;
            }

            if (count1 > 0 && count1 <= arrayList.size()) {
                check = wallet.withdraw(arrayList.get(count1 - 1).getPrice());
                if (check) {
                    out.println(String.format("BALANCE: %d", wallet.getAmount()));
                }
            }

        } while (check);
    }
}