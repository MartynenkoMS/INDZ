import java.util.ArrayList;
import java.util.List;

/**
 * Клас для відправки сповіщень
 */
public class СервісСповіщень {
    private List<String> адресати;

    /**
     * Конструктор класу СервісСповіщень
     */
    public СервісСповіщень() {
        this.адресати = new ArrayList<>();
    }

    /**
     * Додає адресата до списку
     * @param адресат адрес електронної пошти або ім'я
     */
    public void додатиАдресата(String адресат) {
        адресати.add(адресат);
    }

    /**
     * Надіслати сповіщення
     * @param текст текст сповіщення
     * @return результат відправки
     */
    public boolean надіслати(String текст) {
        if (адресати.isEmpty()) {
            System.out.println("Немає адресатів для надсилання сповіщення.");
            return false;
        }
        for (String адресат : адресати) {
            System.out.println("Відправка сповіщення: '" + текст + "' до " + адресат);
        }
        return true;
    }
}