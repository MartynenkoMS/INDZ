/**
 * Клас для демонстрації роботи системи
 */
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів системи
        Meteorologist meteorologist = new Meteorologist(1, "Peter Johnson", "Forecaster");
        NotificationService service = new NotificationService();
        
        // Додавання підписників та отримувачів
        service.addSubscriber(new Subscriber("John Smith"));
        service.addRecipient("weather.com");

        // Демонстрація
        meteorologist.publishForecast();
        meteorologist.publishWarning();
        meteorologist.analyzeAccuracy();
        
        String notification = meteorologist.formNotification();
        service.send(notification);
    }
}