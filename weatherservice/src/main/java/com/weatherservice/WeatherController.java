package com.weatherservice;

import java.util.List;

import com.google.inject.Inject;

/**
 * Контролер для управління метеорологічними даними.
 * Реалізує патерн MVC як проміжну ланку між View та Model.
 */
public class WeatherController {
    private final ServiceNotifier serviceNotifier;

    /**
     * Конструктор з впровадженням залежності ServiceNotifier (Model).
     *
     * @param serviceNotifier модель для управління підписниками та сповіщеннями
     */
    @Inject
    public WeatherController(ServiceNotifier serviceNotifier) {
        this.serviceNotifier = serviceNotifier;
    }

    /**
     * Отримує всіх підписників з бази даних.
     *
     * @return список всіх підписників
     */
    public List<Subscriber> getAllSubscribers() {
        return serviceNotifier.getAllSubscribers();
    }

    /**
     * Додає нового підписника до системи.
     *
     * @param subscriber новий підписник
     */
    public void addSubscriber(Subscriber subscriber) {
        serviceNotifier.addSubscriber(subscriber);
    }

    /**
     * Відправляє сповіщення всім підписникам.
     *
     * @param message текст сповіщення
     * @return результат відправки
     */
    public boolean sendNotification(String message) {
        return serviceNotifier.send(message);
    }
}
