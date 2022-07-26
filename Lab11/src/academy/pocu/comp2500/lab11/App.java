package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

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
                out.println("exited");
                return;
            }

            try {
                count = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (s) {
                case "1":
/*                    String firstName;
                    String lastName;
                    Department department = Department.ENGINEERING;
                    out.println("APPLE choosed");
                    out.println("Input user information");
                    out.println("firstname: ");
                    firstName = in.readLine();
                    out.println("lastname: ");
                    lastName = in.readLine();

                    int count;
                    do {
                        out.println("department: ");
                        out.println("1. ENGINEERING");
                        out.println("2. OPERATION");
                        out.println("3. QUALITY_ASSURANCE");
                        out.println("4. HUMAN_RESOURCES");
                        count = in.read();
                        switch (count) {
                            case 1:
                                department = Department.ENGINEERING;
                                break;
                            case 2:
                                department = Department.OPERATION;
                                break;
                            case 3:
                                department = Department.QUALITY_ASSURANCE;
                                break;
                            case 4:
                                department = Department.HUMAN_RESOURCES;
                                break;
                            default:
                                out.println("department: ");
                        }
                    }while (count < 1 || count > 4);*/

                    //User user = new User(firstName, lastName, department);
                    user = new User();
                    wallet = null;

                    warehouse = new Warehouse(WarehouseType.APPLE);
                    arrayList = warehouse.getProducts();


                    count1 = 0;
                    do {
                        try {
                            wallet = new SafeWallet(user);
                        } catch (PermanentlyClosedException e) {
                            err.println("AUTH_ERROR");
                        }
                        if (wallet != null) {
                            out.printf("BALANCE: %d\n", wallet.getAmount());
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
                            boolean check = wallet.withdraw(arrayList.get(count1 - 1).getPrice());
                            if (!check) {
                                continue;
                            } else {
                                out.printf("wallet : %d\n", wallet.getAmount());
                            }
                        }

                    } while (count1 < 1 || count1 > arrayList.size());

                    break;
                case "2":
                    out.println("MS choosed");


                    user = new User();
                    wallet = null;

                    warehouse = new Warehouse(WarehouseType.MICROSOFT);
                    arrayList = warehouse.getProducts();


                    count1 = 0;
                    do {
                        try {
                            wallet = new SafeWallet(user);
                        } catch (PermanentlyClosedException e) {
                            err.println("AUTH_ERROR");
                        }
                        if (wallet != null) {
                            out.printf("BALANCE: %d\n", wallet.getAmount());
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
                            boolean check = wallet.withdraw(arrayList.get(count1 - 1).getPrice());
                            if (!check) {
                                continue;
                            } else {
                                out.printf("wallet : %d\n", wallet.getAmount());
                            }
                        }

                    } while (count1 < 1 || count1 > arrayList.size());
                    break;
                case "3":
                    out.println("SAMSUNG choosed");


                    user = new User();
                    wallet = null;

                    warehouse = new Warehouse(WarehouseType.SAMSUNG);
                    arrayList = warehouse.getProducts();


                    count1 = 0;
                    do {
                        try {
                            wallet = new SafeWallet(user);
                        } catch (PermanentlyClosedException e) {
                            err.println("AUTH_ERROR");
                        }
                        if (wallet != null) {
                            out.printf("BALANCE: %d\n", wallet.getAmount());
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
                            boolean check = wallet.withdraw(arrayList.get(count1 - 1).getPrice());
                            if (!check) {
                                continue;
                            } else {
                                out.printf("wallet : %d\n", wallet.getAmount());
                            }
                        }

                    } while (count1 < 1 || count1 > arrayList.size());
                    break;
                default:
                    out.println("you picked the wrong number fool!");
                    System.out.println(builder.toString());
                    continue;
            }
        } while (count < 1 || count > 3);

    }
}