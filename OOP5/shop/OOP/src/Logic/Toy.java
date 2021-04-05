package Logic;



public class Toy extends Commodity {

    final private String productMaterial;
    final static private String typeCommodity = "Игрушка";

    /**
     *
     * @param name - toy name
     * @param price - toy price
     */
    public Toy(String name, int price, String productMaterial) {
        super(name, price, typeCommodity);
        this.productMaterial = productMaterial;
    }

    @Override
    public String canUse(){
        String result = "";
        if(checkQuality()){
            result += ("Игрушка из хорошего материала! Можно играть!");
        }else{
            result += ("Игрушка из плохого материала! Такой не рекомендуется играть!");
        }
        return result;
    }

    @Override
    public String getTypeCommodity(){
        return "Игрушка";
    }

    @Override
    protected boolean checkQuality() {
        boolean result = true;
        switch(productMaterial){
            case "железо":
            case "дерево":
                result = true;
                break;
            case "стекло":
            case "пластик":
                result = false;
                break;
        }
        return result;
    }

    public String toString(){
        return ("Имя товара: " + getName() + "; Цена товара: " + getPrice() +
                "; Тип товара: " + getTypeCommodity());

    }
}
