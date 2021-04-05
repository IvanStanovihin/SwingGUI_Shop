package GUI.Model;

import Logic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public Purse purse;
    public List<Commodity> listCommodity = new ArrayList<Commodity>();

    public Shop(Purse purse){
        createCommodityList();
        this.purse = purse;
    }

    public List<Commodity> getListCommodity(){
        return listCommodity;
    }

    public Purse getPurse() {
        return purse;
    }

    /**
     * печатает список товаров которые есть в магазине
     */
    public void printAssortiment(){
        int i = 0;
        for (Commodity commodity: listCommodity){
            System.out.println( ++i + ") " + commodity);
        }
    }

    public void printCommodityInfo(Commodity commodity){
        System.out.println("----------------------------------------------------------------");
        commodity.canUse();
    }

    /**
     * Удаляет товар переданный параметром, из списка товаров. Снимает со счёта цену товара.
     * @param commodity - товар который будет удалён.
     */
    public boolean buyCommodity(Commodity commodity) {
        boolean result;
        if (commodity.getPrice() <= purse.getAmountMoney()) {
            int removeIndex = -1;
            for (int i = 0; i < listCommodity.size(); i++) {
                if (compareCommodity(listCommodity.get(i), commodity)) {
                    removeIndex = i;
                }
            }
            if (removeIndex != -1) {
                listCommodity.remove(removeIndex);
            }
            purse.withdrawMoney(commodity.getPrice());
            result = true;
        }else
        {
            result = false;
        }
        return result;
    }

    /**
     * Метод заполняет список товаров данными из файла.
     */
    private void createCommodityList()  {
        try {
            List<String> stringsWithCommodityInfo = IOclass.readListCommodity(
                    "../deliverCommodity.txt");
            for (String infoForCommodity : stringsWithCommodityInfo) {
                String[] info = infoForCommodity.split(" ");
                if (info[0].contains("МП")) {
                    listCommodity.add(new MilkProduct(info[1], Integer.parseInt(info[2]), info[3]));
                } else {
                    if (info[0].contains("И")) {
                        listCommodity.add(new Toy(info[1], Integer.parseInt(info[2]), info[3]));
                    }
                }
            }
        }catch(IOException ex1){
            System.out.println("При чтении файла возникла ошибка!");
        }
    }

    /**
     * Сравнение двух товаров на равенство по их параметрам
     * @return true - товары равны, false - товары не равны.
     */
    private boolean compareCommodity(Commodity c1, Commodity c2){
        boolean result = false;
        if (c1.getName().equals(c2.getName()) && c1.getPrice() == c2.getPrice() &&
                c1.getTypeCommodity().equals(c2.getTypeCommodity())){
            result = true;
        }
        return result;
    }
}


