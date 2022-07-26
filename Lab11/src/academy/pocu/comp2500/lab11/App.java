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

    public void run(BufferedReader in, PrintStream out, PrintStream err) throws IOException, IllegalAccessException {
        // in : 사용자 입력, out : 텍스트 출력, err : 오류 코드 출력
        StringBuilder builder = new StringBuilder();
        builder.append("WAREHOUSE: Choose your warehouse!");
        builder.append(System.lineSeparator());
        builder.append("1. ");
        builder.append(WarehouseType.APPLE);
        builder.append(System.lineSeparator());
        builder.append("2. ");
        builder.append(WarehouseType.MICROSOFT);
        builder.append(System.lineSeparator());
        builder.append("3. ");
        builder.append(WarehouseType.SAMSUNG);

        // 목록 출력


        boolean check = true;
        int count = 0;
        int count1 = 0;
        String s;
        User user;
        Wallet wallet;
        Warehouse warehouse;
        ArrayList<Product> arrayList;
        do {
            System.out.println(builder.toString());
            s = in.readLine();

            if (s.equals("exit")) {
                return;
            }

            try {
                count = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (s) {
                case "1":
                    user = new User();
                    wallet = null;

                    count1 = 0;

                    try {
                        wallet = new SafeWallet(user);
                    } catch (PermanentlyClosedException e) {
                        err.println("AUTH_ERROR");
                    }
                    if (wallet != null) {
                        out.printf("BALANCE: %d\n", wallet.getAmount());
                    }

                    do {
                        warehouse = new Warehouse(WarehouseType.APPLE);
                        arrayList = warehouse.getProducts();

                        if (arrayList.size() == 0) {
                            return;
                        }

                        out.println("PRODUCT_LIST: Choose the product you want to buy!");
                        for (int i = 0; i < arrayList.size(); i++) {
                            out.printf("%d. %s\t\t%d\n", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice());
                        }

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
                                //warehouse.removeProduct(arrayList.get(count - 1).getId());
                                out.printf("BALANCE: %d\n", wallet.getAmount());
                            }
                        }

                    } while (check);

                    break;
                case "2":
                    user = new User();
                    wallet = null;

                    warehouse = new Warehouse(WarehouseType.MICROSOFT);
                    arrayList = warehouse.getProducts();


                    count1 = 0;

                    try {
                        wallet = new SafeWallet(user);
                    } catch (PermanentlyClosedException e) {
                        err.println("AUTH_ERROR");
                    }
                    if (wallet != null) {
                        out.printf("BALANCE: %d\n", wallet.getAmount());
                    }

                    do {
                        out.println("PRODUCT_LIST: Choose the product you want to buy!");
                        for (int i = 0; i < arrayList.size(); i++) {
                            out.printf("%d. %s\t\t%d\n", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice());
                        }

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
                                out.printf("BALANCE: %d\n", wallet.getAmount());
                            }
                        }

                    } while (check);
                    break;
                case "3":
                    user = new User();
                    wallet = null;

                    warehouse = new Warehouse(WarehouseType.SAMSUNG);
                    arrayList = warehouse.getProducts();


                    count1 = 0;

                    try {
                        wallet = new SafeWallet(user);
                    } catch (PermanentlyClosedException e) {
                        err.println("AUTH_ERROR");
                    }
                    if (wallet != null) {
                        out.printf("BALANCE: %d\n", wallet.getAmount());
                    }

                    do {
                        out.println("PRODUCT_LIST: Choose the product you want to buy!");
                        for (int i = 0; i < arrayList.size(); i++) {
                            out.printf("%d. %s\t\t%d\n", i + 1, arrayList.get(i).getName(), arrayList.get(i).getPrice());
                        }

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
                                out.printf("BALANCE: %d\n", wallet.getAmount());
                            }
                        }

                    } while (check);
                    break;
                default:
                    out.println("you picked the wrong number fool!");
                    System.out.println(builder.toString());
                    continue;
            }
        } while (count < 1 || count > 3);
    }
}