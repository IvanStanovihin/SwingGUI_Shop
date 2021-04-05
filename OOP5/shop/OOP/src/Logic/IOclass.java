package Logic;

import java.io.*;
import java.util.*;

public class IOclass {

    static Scanner scanner = new Scanner(System.in);

    public static Calendar readDateFromFile(String fileName){
        int day = 1, month = 1, year = 1;
        Calendar manufactureDate = new GregorianCalendar();
        try(Scanner scanner2 = new Scanner(new File(fileName))){

            day = scanner2.nextInt();
            month = scanner2.nextInt();
            month--;
            year = scanner2.nextInt();
            manufactureDate.set(Calendar.DAY_OF_MONTH, day);
            manufactureDate.set(Calendar.MONTH, month);
            manufactureDate.set(Calendar.YEAR, year);
        }catch(NumberFormatException ex1){
            System.out.println("Дата имеет неверный тип!");
        }
        catch(FileNotFoundException ex2){
            System.out.println("Файл не найден! Повторите ввод!");
            manufactureDate =readDateFromFile(fileName);
        }
        return manufactureDate;
    }

    public static String readMaterialFromFile(String fileName){
        System.out.println("Укажите путь к файлу в который записан материал из которого произведена игрушка: ");
        String material = "";
        try{
            Scanner scanner2 = new Scanner(new File(fileName));
           material = scanner2.nextLine();
        }catch(IOException ex1){
            System.out.println("Файл не найден! Повторите ввод!");
            material = readMaterialFromFile(fileName);
        }
        return material.trim();
    }

    //метод читает информацию о товарах из файла накладной.(Формат данных в файле: "Тип продукта"  "Название" "Цена"
    // "Дата производства"). Возвращает список строк, где каждая строка - это информация об одом объекте.
    public static List<String> readListCommodity(String fileName) throws IOException {
        String result = "";
        List<String>listCommodity = new ArrayList<String>();
        File file = new File(fileName);
        char[] CB = new char[(int) file.length()];
        Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        int simbol;
        while((simbol = (int)reader.read()) != -1){
          while(simbol != 13 && simbol != -1){
              if (simbol != 10) {
                  result += (char) simbol;
              }
              simbol = reader.read();
          }
           listCommodity.add(result);
          result ="";
        }
        return listCommodity;
    }

}
