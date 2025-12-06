package com.weatherservice;

/**
 * Class for representing a subscriber
 */
public class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    /**
     * Додаємо геттер, щоб можна було отримати ім'я
     */
    public String getName() {
        return name;
    }

    public void deliverMessage(String text) {
        System.out.println("Підписник " + name + " отримав повідомлення: " + text);
    }
}
