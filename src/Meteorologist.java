/**
 * Class representing a meteorologist
 */
public class Meteorologist extends WeatherSystemParticipant implements INotificationPlan {
    private String specialization;

    /**
     * Constructor for Meteorologist class
     * @param id meteorologist identifier
     * @param name meteorologist name
     * @param spec meteorologist specialization
     */
    public Meteorologist(int id, String name, String spec) {
        super(id, name);
        this.specialization = spec;
    }

    /**
     * Publish forecast
     */
    public void publishForecast() {
        System.out.println("Meteorologist " + getName() + " publishes weather forecast");
    }

    /**
     * Publish warning
     */
    public void publishWarning() {
        System.out.println("Meteorologist " + getName() + " publishes warning about dangerous phenomena");
    }

    /**
     * Final method for analyzing forecast accuracy
     */
    public final void analyzeAccuracy() {
        System.out.println("Meteorologist " + getName() + " analyzes forecast accuracy");
    }

    @Override
    public String formNotification() {
        return "Notification from meteorologist " + getName() + " (" + specialization + ")";
    }
}