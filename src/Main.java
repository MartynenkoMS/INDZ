/**
 * Клас для демонстрації роботи системи
 */
public class Main {
    public static void main(String[] args) {
        // Creating system objects
        Meteorologist meteorologist = new Meteorologist(1, "Peter Johnson", "Forecaster");
        NotificationService service = new NotificationService();

        // Demonstration
        meteorologist.publishForecast();
        meteorologist.publishWarning();
        meteorologist.analyzeAccuracy();
        
        String notification = meteorologist.formNotification();
        service.send(notification);
    }
}