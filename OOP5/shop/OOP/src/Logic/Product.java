package Logic;

import Logic.Commodity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Product extends Commodity {

    private Calendar endShelfLife;
    int storagePeriod;
    private Calendar shelfLife;


    /**
     * Инициализирует поля объекта
     * @param name Имя продукта
     * @param price Цена продукта
     * @param storagePeriod Срок хранения продукта
     * @param dateManufacture Дата производства продукта(типа String в виде: день/месяц/год).
     */
    public Product(String name, int price, int storagePeriod, String dateManufacture, String typeCommodity) {
        super(name, price, typeCommodity);
        this.storagePeriod = storagePeriod;
        this.shelfLife = createShelfLifeDate(dateManufacture);
    }


    public Calendar getShelfLife(){
        return shelfLife;
    }


    //метод возвращает дату когода истекает срок годности продукта
    public Calendar getEndShelfLife(){
        endShelfLife = getShelfLife();
        endShelfLife.add(Calendar.DAY_OF_MONTH,storagePeriod);
        return endShelfLife;
    }


    /**
     *
     * @param dateInString Дата производства продукта(типа String в виде: день/месяц/год).
     * @return Дату производства продукта типа Calendar(такое преобразование нужно для дальнейшего вычисления даты
     * конца срока годности продукта)
     */
    private Calendar createShelfLifeDate(String dateInString){
        String[] dateInfo = dateInString.split("/");
        int day = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        month--;
        int year = Integer.parseInt(dateInfo[2]);
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);
        return date;
    }


    /**
     * Method compares the expiration date on the packaging and the expiration date for milk products.
     * @return True - expiration date has not expired. False - product expired.
     */
    @Override
    protected boolean checkQuality() {
        Calendar currentDate = new GregorianCalendar();
        Calendar endShelfLifeDate = endShelfLife;
        if (endShelfLifeDate.after(currentDate)){
            return true;
        }else{
            return false;
        }
    }



}

