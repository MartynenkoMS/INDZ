/**
 * Клас, що представляє техніка
 */
public class Технік extends УчасникМетеосистеми implements IПланСповіщень {
    private String рівень;

    public Технік(int id, String name, String рівень) {
        super(id, name);
        this.рівень = рівень;
    }

    public void обслуговуватиСенсори() {
        System.out.println("Технік " + getName() + " обслуговує сенсори");
    }

    public void обслуговуватиРадар() {
        System.out.println("Технік " + getName() + " обслуговує радар");
    }

    @Override
    public String сформуватиСповіщення() {
        return "Сповіщення від техніка " + getName() + " (" + рівень + ")";
    }
}