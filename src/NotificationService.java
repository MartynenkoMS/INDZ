import java.util.ArrayList;
import java.util.List;

/**
 * Class for sending notifications
 */
public class NotificationService {
    private List<String> recipients;
    private List<Subscriber> subscribers = new ArrayList<>();

    /**
     * Constructor for NotificationService class
     */
    public NotificationService() {
        this.recipients = new ArrayList<>();
    }

    /**
     * Add recipient to the list
     * @param recipient email address or name
     */
    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    /**
     * Add subscriber
     */
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * Send notification
     * @param text notification text
     * @return sending result
     */
    public boolean send(String text) {
        if (recipients.isEmpty() && subscribers.isEmpty()) {
            System.out.println("No recipients or subscribers for sending notification.");
            return false;
        }
        for (String recipient : recipients) {
            System.out.println("Sending notification: '" + text + "' to " + recipient);
        }
        for (Subscriber subscriber : subscribers) {
            subscriber.deliverMessage(text);
        }
        return true;
    }
}