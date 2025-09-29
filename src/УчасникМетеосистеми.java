/**
 * Абстрактний клас, що представляє учасника метеосистеми
 */
public abstract class УчасникМетеосистеми {
    private int id;
    private String name;

    /**
     * Конструктор класу УчасникМетеосистеми
     * @param id ідентифікатор учасника
     * @param name ім'я учасника
     */
    public УчасникМетеосистеми(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Отримати ім'я учасника
     * @return ім'я учасника
     */
    public String getName() {
        return name;
    }
}