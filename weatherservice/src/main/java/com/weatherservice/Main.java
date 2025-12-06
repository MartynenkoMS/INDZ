package com.weatherservice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.List;

/**
 * Клас для демонстрації роботи системи з використанням MVC архітектури
 * та веб-серверу Javalin.
 */
public class Main {
    public static void main(String[] args) {

        // Створення Injector з нашим Guice-модулем
        Injector injector = Guice.createInjector(new weatherserviceModule());

        // Отримання контролера для попередньої демонстрації
        WeatherController controller = injector.getInstance(WeatherController.class);

        // Додавання тестових підписників
        System.out.println("=== Додавання тестових підписників ===");
        controller.addSubscriber(new Subscriber("John Smith"));
        controller.addSubscriber(new Subscriber("Alice Johnson"));
        controller.addSubscriber(new Subscriber("Bob Wilson"));
        controller.addSubscriber(new Subscriber("Emma Davis"));
        controller.addSubscriber(new Subscriber("Michael Brown"));
        controller.addSubscriber(new Subscriber("Sarah Miller"));
        controller.addSubscriber(new Subscriber("James Wilson"));
        controller.addSubscriber(new Subscriber("Rachel Taylor"));
        controller.addSubscriber(new Subscriber("David Anderson"));
        controller.addSubscriber(new Subscriber("Jessica Thomas"));
        controller.addSubscriber(new Subscriber("Christopher Lee"));
        controller.addSubscriber(new Subscriber("Victoria Martinez"));
        System.out.println("✓ Додано 12 підписників\n");

        // Демонстрація роботи метеоролога
        System.out.println("=== Дії метеоролога ===");
        Meteorologist meteorologist = new Meteorologist(1, "Peter Johnson", "Forecaster");
        meteorologist.publishForecast();
        meteorologist.publishWarning();
        meteorologist.analyzeAccuracy();

        // Відправка сповіщення всім підписникам
        System.out.println("\n=== Відправка сповіщення ===");
        String notification = meteorologist.formNotification();
        controller.sendNotification(notification);

        // Отримання всіх підписників з бази даних
        System.out.println("\n=== Всі підписники в системі ===");
        List<Subscriber> allSubscribers = controller.getAllSubscribers();
        allSubscribers.forEach(s -> System.out.println("- " + s.getName()));

        // Запускаємо веб-сервер для перегляду
        runWebMode(injector);
    }

    /**
     * Запускає веб-режим з Javalin сервером.
     * Надає REST API для отримання даних з бази даних.
     *
     * @param injector Guice injector для отримання залежностей
     */
    private static void runWebMode(Injector injector) {
        WeatherWebView webView = injector.getInstance(WeatherWebView.class);
        webView.start(8080);

        // Додавання hook для завершення роботи
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n\nЗупинення веб-сервера...");
            webView.stop();
            System.out.println("Веб-сервер зупинено.");
        }));
    }
}
