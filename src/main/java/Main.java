import java.util.Arrays;
import java.util.Comparator;

/**
 * Виконавчий клас програми.
 * <p>
 * Створює масив об'єктів спортивного інвентарю, сортує його за двома критеріями 
 * та виконує пошук заданого об'єкта.
 */
public class Main{

    /**
     * Сортує масив велосипедів за двома критеріями.
     * <p>
     * Первинне сортування відбувається за полем ціни за зростанням. 
     * Якщо ціни збігаються, застосовується вторинне сортування за вагою за спаданням.
     *
     * @param bikes масив об'єктів {@link Bicycle}, який потрібно відсортувати
     */
    public static void sortBicycles(Bicycle[] bikes) {
        Arrays.sort(bikes, Comparator.comparing(Bicycle::getPrice).thenComparing(Comparator.comparing(Bicycle::getWeight).reversed())
        );
    }

    /**
     * Шукає ідентичний велосипед у масиві.
     *
     * @param bikes      масив велосипедів, у якому здійснюється пошук
     * @param targetBike об'єкт велосипеда, який потрібно знайти
     * @return індекс знайденого об'єкта у масиві, або {@code -1}, якщо об'єкт не знайдено
     */
    public static int findBicycleIndex(Bicycle[] bikes, Bicycle targetBike) {
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i].equals(targetBike)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Головний виконавчий метод програми.
     * <p>
     * Описує та ініціалізує змінні, наповнює масив, викликає методи сортування 
     * та пошуку, а також виводить результати у консоль.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        
        Bicycle[] bikes = new Bicycle[4];
        
        bikes[0] = new Bicycle("Pride", "Aluminium", true, 15.6, 23000);
        bikes[1] = new Bicycle("Giant", "Carbon", false, 12.3, 55000);
        bikes[2] = new Bicycle("Trek", "Aluminium", true, 11.0, 20000);
        bikes[3] = new Bicycle("Merida", "Aluminium", true, 14.5, 20000);

        System.out.println("\nBefore sorting");
        for (Bicycle b : bikes) {
            System.out.println(b.toString());
        }

        // Виклик методу сортування
        sortBicycles(bikes);

        System.out.println("\nAfter sorting (Price increase ↑, Weight decline ↓)");
        for (Bicycle b : bikes) {
            System.out.println(b.toString());
        }

        // Створення об'єкта для пошуку.
        Bicycle targetBike = new Bicycle("Trek", "Aluminium", true, 11.0, 20000);

        System.out.println("\nSearch for a given object");

        // Виклик методу пошуку
        int foundIndex = findBicycleIndex(bikes, targetBike);

        // Виведення результатів пошуку
        if (foundIndex != -1) {
            System.out.println("\nObject found at position: " + foundIndex);
            //System.out.println("\nObject found at position: " + (foundIndex + 1));
            System.out.println("\nFound object: " + bikes[foundIndex].toString());
        } else {
            System.out.println("\nNo such object found in the array.");
        }
    }
}
