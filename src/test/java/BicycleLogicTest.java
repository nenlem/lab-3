import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для модульного тестування логіки роботи з об'єктами спортивного інвентарю.
 * <p>
 * Перевіряє правильність роботи методів порівняння (equals), 
 * сортування за двома критеріями та пошуку елемента в масиві.
 */
public class BicycleLogicTest {

    /**
     * Тестує метод {@code equals} класу {@link Bicycle}.
     * <p>
     * Перевіряє дві ситуації:
     * 1. Два об'єкти з абсолютно однаковими полями повинні вважатися рівними.
     * 2. Два об'єкти з різними полями не повинні вважатися рівними.
     */
    @Test
    public void testBicycleEquals() {
        Bicycle bike1 = new Bicycle("Trek", "Aluminium", true, 11.0, 20000);
        Bicycle bike2 = new Bicycle("Trek", "Aluminium", true, 11.0, 20000); 
        Bicycle bike3 = new Bicycle("Giant", "Carbon", false, 12.3, 55000);

        // Перевіряємо, що однакові велосипеди ідентичні
        assertEquals(bike1, bike2, "Bicycles with the same parameters should be equal");

        // Перевіряємо, що різні велосипеди не ідентичні
        assertNotEquals(bike1, bike3, "Bicycles with different parameters should not be equal");
    }

    /**
     * Тестує метод сортування {@code sortBicycles} класу {@link Main}.
     * <p>
     * Створює тестовий масив велосипедів і перевіряє правильність його сортування
     * за складним правилом: спочатку за ціною за зростанням, а якщо ціни рівні — 
     * за вагою за спаданням.
     */
    @Test
    public void testSortBicycles() {

        Bicycle[] bikes = new Bicycle[]{
            new Bicycle("Pride", "Aluminium", true, 15.6, 23000),
            new Bicycle("Giant", "Carbon", false, 12.3, 55000),
            new Bicycle("Trek", "Aluminium", true, 11.0, 20000),
            new Bicycle("Merida", "Aluminium", true, 14.5, 20000),
        };

        // Викликаємо метод сортування
        Main.sortBicycles(bikes);

        assertEquals("Merida", bikes[0].getBrand()); 

        assertEquals("Trek", bikes[1].getBrand()); 

        assertEquals("Pride", bikes[2].getBrand()); 

        assertEquals("Giant", bikes[3].getBrand()); 
    }

    /**
     * Тестує метод пошуку {@code findBicycleIndex} класу {@link Main}.
     * <p>
     * Перевіряє здатність методу знаходити індекс заданого об'єкта в масиві.
     * Тестує як успішний пошук (наявний об'єкт), так і безуспішний (відсутній об'єкт).
     */
    @Test
    public void testFindBicycleIndex() {
        Bicycle[] bikes = new Bicycle[]{
            new Bicycle("Giant", "Carbon", false, 12.3, 55000),
            new Bicycle("Trek", "Aluminium", true, 11.0, 20000),
        };

        // Об'єкт, який є у масиві
        Bicycle targetExisting = new Bicycle("Trek", "Aluminium", true, 11.0, 20000);
        // Об'єкт, якого немає у масиві
        Bicycle targetMissing = new Bicycle("Kellys", "Aluminium", true, 13.0, 18000);

        // Перевіряємо пошук існуючого велосипеда
        int foundIndex = Main.findBicycleIndex(bikes, targetExisting);
        assertEquals(1, foundIndex, "Should find Trek on the index 1");

        // Перевіряємо поведінку методу, якщо об'єкта не існує
        int notFoundIndex = Main.findBicycleIndex(bikes, targetMissing);
        assertEquals(-1, notFoundIndex, "If the object does not exist, the method should return -1");
    }
}