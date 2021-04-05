package Logic;



import java.util.Calendar;
import java.util.GregorianCalendar;

public class MilkProduct extends Product {

    //срок годности молочных продуктов - 10 дней
    final static int milkProductShelfLife = 10;
    final static String commodityType = "Молочный продукт";


    public MilkProduct(String name, int price, String dateManufacture){
        super (name, price, milkProductShelfLife, dateManufacture, commodityType);
    }

    @Override
    public String getTypeCommodity(){
        return "Молочный продукт";
    }

    /**
     * Check if the product can be eaten. If method checkExpirationDate return true value - means expiration date has
     * NOT expired. If method checkExpirationDate return false value - means product expired.
     */

    @Override
    public String canUse(){
        String result = "";
        Calendar endShelfLife = getEndShelfLife();
        if (endShelfLife.getTime() != new GregorianCalendar().getTime()){

            result += ("Срок годности продукта истекает: " + endShelfLife.getTime());
            if (checkQuality()){
                result+=("\nПродукт можно употреблять в пищу!");
            }else{
                result+=("\nПродукт просрочен!");
            }
        }
        return result;
    }

    public String toString(){
        return ("Имя товара: " + getName() + "; Цена товара: " + getPrice() +
                "; Тип товара: " + getTypeCommodity());

    }
}
