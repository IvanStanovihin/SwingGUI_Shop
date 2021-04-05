//package Logic;
//
//import Main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Menu {
//
//    public static void startMenu(Shop shop){
//        int command = -1;
//        while(command != 0) {
//            Main.markup();
//            System.out.println("***Главное меню*** \n1)Выбрать товар \n2)Пополнить счёт \n0)Выход");
//            System.out.print("Выберите команду >>>");
//            command = Main.inputCommand(2);
//            switch(command){
//                case 1:
//                    menuChoiseCommodity(shop);
//                    break;
//                case 2:
//                    fillUpPurse(shop.purse);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    //Метод представляющий собой меню для выбора товара из списка товаров имеющихся в наличии в магазине. Из этого метода
//    //запускается меню menuChoiseCommodity2.
//    private static void menuChoiseCommodity(Shop shop){
//        int command = -1;
//        do {
//            Main.markup();
//            shop.printAssortiment();
//            System.out.println("0)Вернуться назад.");
//            System.out.print("Выберите товар >>> ");
//            command = Main.inputCommand(shop.getListCommodity().size());
//            if (command !=0) {
//                Commodity selectedCommodity = shop.listCommodity.get(command - 1);
//                menuChoiseCommodity2(shop, selectedCommodity);
//            }
//        }while(command != 0);
//
//    }
//
//    /**
//     * Метод представляющий собой меню, в котором происходит покупка(удаление из списка наличия в магазине) товара, или
//     * отказ от покупки.
//     * @param shop магазин в котором совершаются покупки.
//     * @param commodity выбранный товар.
//     */
//    private static void menuChoiseCommodity2(Shop shop, Commodity commodity){
//        int command = -1;
//        do {
//            Main.markup();
//            System.out.println("Вы выбрали товар - " + commodity.getName() + "\n1)Проверить качество товара \n2)Купить " +
//                    "\n0)Выбрать другой товар");
//            System.out.print("Выберите команду >>>");
//            command = Main.inputCommand(2);
//            switch(command){
//                case 1:
//                    commodity.canUse();
//                    break;
//                case 2:
//                    if (checkAmountMoney(shop.purse, commodity.getPrice())) {
//                        shop.buyCommodity(commodity);
//                        Main.markup();
//                        System.out.println("Вы успешно купили товар, остаток средств - " + shop.purse.getAmountMoney());
//                    }else{
//                        notEnoughMoney(shop, commodity);
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }while(command != 2 && command != 0);
//    }
//
//    /**
//     * Метод для проверки хватает ли нам денег в кошельке для покупки товара.
//     * @param purse Кошелёк пользователя.
//     * @param money Стоймость товара.
//     * @return true - если в кошельке пользователя хватает денег для покупки товара. false - денег в кошельке
//     * недостаточно.
//     */
//    private static boolean checkAmountMoney(Purse purse, int money){
//        if (purse.getAmountMoney() >= money){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    private static void  fillUpPurse(Purse purse){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            Main.markup();
//            System.out.println("Введите сумму на которую хотите пополнить баланс вашего кошелька: ");
//            int fillUpMoney = Integer.parseInt(reader.readLine());
//            if (fillUpMoney < 0){
//                throw new IOException();
//            }
//            purse.topUpAmountMoney(fillUpMoney);
//            System.out.println("Счёт успешно пополнен! Баланс вашего кошелька - " + purse.getAmountMoney());
//        }
//        catch(NumberFormatException ex1){
//            Main.markup();
//            System.out.println("Сумма должна быть числом! Повторите ввод!");
//            fillUpPurse(purse);
//        }
//        catch(IOException ex2){
//            System.out.println("Ошибка при вводе суммы! Повторите ввод!");
//            fillUpPurse(purse);
//        }
//    }
//
//    private static void notEnoughMoney(Shop shop, Commodity commodity){
//        Scanner scanner = new Scanner(System.in);
//        Main.markup();
//        System.out.println("На счёте недостаточо средств! " + commodity.getName() + " имеет цену - " +
//
//                commodity.getPrice() + ". На счёте вашего кошелька - " + shop.purse.getAmountMoney());
//            System.out.println("Пополнить счёт? 1 - пополнить, 2 - продолжить покупки.");
//            int flag = Main.inputCommand(2);
//            if (flag == 1) {
//                fillUpPurse(shop.purse);
//            }
//    }
//
//}
