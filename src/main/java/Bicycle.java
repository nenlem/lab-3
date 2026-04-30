import java.util.Objects;

/**
 * Клас, що представляє спортивний інвентар (Велосипед).
 * <p>
 * Містить основні характеристики велосипеда, такі як бренд, матеріал рами, 
 * наявність жорсткої вилки, вага та ціна. Клас включає перевизначені методи 
 * для порівняння об'єктів на ідентичність.
 */
public class Bicycle {
    private String brand;
    private String frameMaterial;
    private boolean hasRigidFork;
    private double weight;
    private int price;

    /**
     * Створює новий об'єкт велосипеда із заданими характеристиками.
     *
     * @param brand         назва виробника (наприклад, "Trek" або "Giant")
     * @param frameMaterial матеріал, з якого виготовлена рама
     * @param hasRigidFork  {@code true}, якщо встановлена жорсткова вилка, інакше {@code false}
     * @param weight        вага велосипеда у кілограмах
     * @param price         вартість велосипеда у гривнях
     */

    public Bicycle(String brand, String frameMaterial, boolean hasRigidFork, double weight, int price){
        this.brand = brand;
        this.frameMaterial = frameMaterial;
        this.hasRigidFork = hasRigidFork;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Повертає вагу велосипеда.
     *
     * @return вага у кілограмах
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Повертає ціну велосипеда.
     *
     * @return ціна у гривнях
     */
    public int getPrice(){
        return price;
    }

    /**
     * Повертає бренд велосипеда.
     *
     * @return назва бренду
     */
    public String getBrand(){
        return brand;
    }

    /**
     * Повертає рядкове представлення характеристик велосипеда.
     *
     * @return рядок з даними про об'єкт у зручному для читання форматі
     */
    @Override
    public String toString(){
        return "Bicycle {" +
        "brand='" + brand + '\'' +
        ", frameMaterial='" + frameMaterial + '\'' +
        ", rigidFork=" + (hasRigidFork ? "Yes" : "No") +
        ", weight=" + weight + " kg" +
        ", price=" + price + " UAH" +
        '}';
    }    

    /**
     * Порівнює цей велосипед з іншим об'єктом на ідентичність.
     * <p>
     * Два велосипеди вважаються ідентичними, якщо збігаються всі їхні 5 полів: 
     * бренд, матеріал рами, тип вилки, вага та ціна.
     *
     * @param obj об'єкт для порівняння з поточним велосипедом
     * @return {@code true}, якщо об'єкти ідентичні за всіма параметрами; інакше {@code false}
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Bicycle bicycle = (Bicycle) obj;

        return Double.compare(bicycle.weight, weight) == 0 &&
               price == bicycle.price &&
               hasRigidFork == bicycle.hasRigidFork &&
               Objects.equals(brand, bicycle.brand) &&
               Objects.equals(frameMaterial, bicycle.frameMaterial);
    }

    /**
     * Генерує хеш-код для об'єкта велосипеда.
     *
     * @return цілочисельне значення хеш-коду
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, frameMaterial, hasRigidFork, weight, price);
    }
}