package com.weatherservice;

import com.google.inject.Inject;
import com.weatherservice.webserver.HttpContext;
import com.weatherservice.webserver.WebServer;

/**
 * Веб-інтерфейс для відображення даних метеорологічної системи.
 * Надає REST API для отримання підписників та надсилання сповіщень.
 * Працює в GitHub Codespaces та інших серверних середовищах.
 */
public class WeatherWebView {
    private final WeatherController controller;
    private final WebServer server;

    /**
     * Конструктор для створення веб-сервера.
     *
     * @param controller контролер для обробки даних
     * @param server веб-сервер Javalin
     */
    @Inject
    public WeatherWebView(WeatherController controller, WebServer server) {
        this.controller = controller;
        this.server = server;
        setupRoutes();
    }

    /**
     * Налаштування маршрутів веб-додатку.
     */
    private void setupRoutes() {
        // CORS configuration для роботи з Live Server
        server.before(context -> {
            context.header("Access-Control-Allow-Origin", "*");
            context.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            context.header("Access-Control-Allow-Headers", "Content-Type");
        });

        // OPTIONS request для CORS preflight
        server.options("/*", context -> {
            context.status(200);
        });

        // API для отримання всіх підписників
        server.get("/api/subscribers", this::getAllSubscribers);

        // API для отримання інформації про систему
        server.get("/api/status", this::getStatus);
    }

    /**
     * Обробник GET-запиту для отримання всіх підписників з бази даних.
     *
     * @param context контекст HTTP запиту
     */
    private void getAllSubscribers(HttpContext context) {
        try {
            var subscribers = controller.getAllSubscribers();
            context.json(subscribers);
        } catch (Exception e) {
            context.status(500).result("Помилка при отриманні підписників: " + e.getMessage());
        }
    }

    /**
     * Обробник GET-запиту для отримання статусу системи.
     *
     * @param context контекст HTTP запиту
     */
    private void getStatus(HttpContext context) {
        try {
            var status = new java.util.HashMap<String, Object>();
            status.put("service", "Weather Service");
            status.put("version", "1.0");
            status.put("status", "running");
            status.put("subscribers_count", controller.getAllSubscribers().size());
            context.json(status);
        } catch (Exception e) {
            context.status(500).result("Помилка при отриманні статусу: " + e.getMessage());
        }
    }

    /**
     * Запускає веб-сервер на вказаному порту.
     *
     * @param port порт для запуску сервера
     */
    public void start(int port) {
        server.start(port);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Weather Service Web Server запущено!\n");
        System.out.println("REST API: http://localhost:" + port + "\n");
        System.out.println("Відкрийте src/main/resources/index.html");
        System.out.println("за допомогою Live Server (VS Code extension)\n");
        System.out.println("API Endpoints:");
        System.out.println("   GET  /api/subscribers - перегляд всіх підписників");
        System.out.println("   GET  /api/status      - статус системи");
        System.out.println("──────────────────────────────────────────────");
    }

    /**
     * Зупиняє веб-сервер.
     */
    public void stop() {
        server.stop();
    }
}
