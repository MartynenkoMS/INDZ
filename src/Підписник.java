/**
 * Клас для представлення підписника
 */
public class Підписник {
    private String імя;

    public Підписник(String імя) {
        this.імя = імя;
    }

    public void deliverMessage(String текст) {
        System.out.println("Підписник " + імя + " отримав повідомлення: " + текст);
    }
}