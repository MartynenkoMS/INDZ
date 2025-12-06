package com.weatherservice;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервіс для збереження даних підписників у базу даних SQLite.
 */
public class SubscriberService {

    private Connection connection;

    // -------------------------------------
    // ❌ Конструктор закоментовано раніше (пункт 3.1)
    // -------------------------------------
    /*
    @Inject
    public SubscriberService(Connection connection) {
        this.connection = connection;
    }
    */

    // ---------------------------
    // ✔ Setter injection (пункт 3.2)
    // ---------------------------
    @Inject
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Зберігає підписника в базу даних.
     */
    public void saveSubscriber(Subscriber subscriber) {
        String sql = "INSERT INTO subscribers (name) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, subscriber.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save subscriber", e);
        }
    }

    /**
     * Отримує всіх підписників з бази даних.
     * @return список всіх підписників
     */
    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        String sql = "SELECT name FROM subscribers";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                subscribers.add(new Subscriber(name));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve subscribers", e);
        }

        return subscribers;
    }
}