package com.weatherservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.weatherservice.webserver.JavalinWebServer;
import com.weatherservice.webserver.WebServer;

public class weatherserviceModule extends AbstractModule {

    @Override
    protected void configure() {
        // Прив'язування JDBC URL до SQLite бази
        bind(String.class)
                .annotatedWith(Names.named("JDBC URL"))
                .toInstance("jdbc:sqlite:target/weatherservice.db");
        
        // Прив'язування ServiceNotifier як singleton для всієї програми
        bind(ServiceNotifier.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    /**
     * Створює таблицю subscribers, якщо вона ще не існує
     * У таблиці зберігатиметься інформація про підписників:
     *  - ім'я (TEXT)
     */
    private void createTableIfNotExists(Connection connection) {
        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS subscribers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }

    @Provides
    @Singleton
    WebServer provideWebServer() {
        return new JavalinWebServer();
    }
}
