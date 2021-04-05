package Logic;

import java.util.Calendar;
import java.util.Date;

public abstract class Commodity {

    private int price;
    private String name;
    private String typeCommodity;


    /**
     * Constructor for products. Logic.Product's shelfLife read from file.
     * @param name Logic.Product's name.
     * @param price Logic.Product's price.
     *
     */
    public Commodity(String name, int price, String typeCommodity){
        this.name = name;
        this.price = price;
        this.typeCommodity = typeCommodity;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getTypeCommodity(){
        return typeCommodity;
    }

    public String toString(){
        return "Тип товара: " + typeCommodity + "; Название товара: " + name + "; Цена товара" + price;
    }

    abstract public String canUse();

    //проверка срока годности продукта
    abstract protected boolean checkQuality();

}
