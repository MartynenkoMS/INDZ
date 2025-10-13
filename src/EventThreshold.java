/**
 * Class for representing event threshold
 */
public class EventThreshold {
    private int dangerLevel;

    public EventThreshold(int level) {
        this.dangerLevel = level;
    }

    public int getLevel() {
        return dangerLevel;
    }
}