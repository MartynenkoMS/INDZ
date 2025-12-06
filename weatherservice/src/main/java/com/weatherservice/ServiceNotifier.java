package com.weatherservice;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас сервісу сповіщень, який містить список підписників (композиція)
 * та викликає збереження їхніх даних у базу SQLite.
 */
public class ServiceNotifier {

    private List<Subscriber> subscribers = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();

    private SubscriberService subscriberService;

    // -------------------------------------
    // ❌ Конструктор закоментовано раніше (пункт 3.1)
    // -------------------------------------
    /*
    @Inject
    public ServiceNotifier(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }
    */

    // ---------------------------
    // ✔ Setter injection (пункт 3.2)
    // ---------------------------
    @Inject
    public void setSubscriberService(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    public void addAddress(String address) {
        addresses.add(address);
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);

        // Викликаємо збереження у БД
        if (subscriberService != null) {
            subscriberService.saveSubscriber(subscriber);
        }
    }

    public boolean send(String text) {
        for (Subscriber s : subscribers) {
            s.deliverMessage(text);
        }
        return true;
    }

    /**
     * Отримує всіх підписників з бази даних.
     * Демонструє читання даних через сервіс для отримання з БД.
     * @return список всіх підписників з бази даних
     */
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }
}
