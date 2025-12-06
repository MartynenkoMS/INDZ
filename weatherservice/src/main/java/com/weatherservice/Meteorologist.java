package com.weatherservice;

/**
 * Class representing a meteorologist
 */
public class Meteorologist extends WeatherSystemParticipant implements INotificationPlan {
    private String specialization;

    /**
     * Constructor for Meteorologist class
     * @param id meteorologist identifier
     * @param name meteorologist name
     * @param spec meteorologist specialization
     */
    public Meteorologist(int id, String name, String spec) {
        super(id, name);
        this.specialization = spec;
    }

    /**
     * Publish forecast
     */
    public void publishForecast() {
        System.out.println("Метеоролог " + getName() + " публікує прогноз погоди");
    }

    /**
     * Publish warning
     */
    public void publishWarning() {
        System.out.println("Метеоролог " + getName() + " публікує попередження про небезпечні явища");
    }

    /**
     * Final method for analyzing forecast accuracy
     */
    public final void analyzeAccuracy() {
        System.out.println("Метеоролог " + getName() + " аналізує точність прогнозів");
    }

    @Override
    public String formNotification() {
        return "Сповіщення від метеоролога " + getName() + " (" + specialization + ")";
    }
}