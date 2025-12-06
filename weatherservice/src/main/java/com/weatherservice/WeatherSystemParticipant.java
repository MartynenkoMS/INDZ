package com.weatherservice;

/**
 * Abstract class representing a weather system participant
 */
public abstract class WeatherSystemParticipant {
    private int id;
    private String name;

    /**
     * Constructor for WeatherSystemParticipant
     * @param id participant identifier
     * @param name participant name
     */
    public WeatherSystemParticipant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get participant name
     * @return participant name
     */
    public String getName() {
        return name;
    }

    /**
     * Get participant ID
     * @return participant identifier
     */
    public int getId() {
        return id;
    }
}