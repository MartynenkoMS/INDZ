package com.weatherservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing a region
 */
public class Region {
    private String name;
    private List<Warning> warnings;

    public Region(String name) {
        this.name = name;
        this.warnings = new ArrayList<>();
    }

    public void addWarning(Warning w) {
        warnings.add(w);
    }

    public String getName() {
        return name;
    }
}