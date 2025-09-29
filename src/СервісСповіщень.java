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
     * Надіслати сповіщення
     * @param текст текст сповіщення
     * @return результат відправки
     */
    public boolean надіслати(String текст) {
        System.out.println("Відправка сповіщення: " + текст);
        return true;
    }
}