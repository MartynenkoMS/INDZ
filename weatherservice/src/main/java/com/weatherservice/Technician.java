package com.weatherservice;

/**
 * Class representing a technician
 */
public class Technician extends WeatherSystemParticipant implements INotificationPlan {
    private String level;

    public Technician(int id, String name, String level) {
        super(id, name);
        this.level = level;
    }

    public void maintainSensors() {
        System.out.println("Technician " + getName() + " maintains sensors");
    }

    public void maintainRadar() {
        System.out.println("Technician " + getName() + " maintains radar");
    }

    @Override
    public String formNotification() {
        return "Notification from technician " + getName() + " (" + level + ")";
    }
}