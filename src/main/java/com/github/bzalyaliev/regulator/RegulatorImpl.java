package com.github.bzalyaliev.regulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegulatorImpl implements Regulator {

    private static RegulatorImpl instance;
    private final List<Double> temperatureValues;

    private RegulatorImpl() {
        temperatureValues = new ArrayList<>();
    }

    public static RegulatorImpl getInstance() {
        if (instance == null) {
            instance = new RegulatorImpl();
        }
        return instance;
    }

    public static void deleteInstance() {
        instance = null;
    }

    @Override
    public void setTemperature(double temperature) {
        if (!temperatureValues.isEmpty()) {
            double lastValue = temperatureValues.get(temperatureValues.size() - 1);
            int steps = 3 + new Random().nextInt(6);
            double stepSize = (temperature - lastValue) / steps;
            for (int i = 0; i < steps; i++) {
                lastValue += stepSize;
                temperatureValues.add(lastValue);
            }
        } else {
            temperatureValues.add(temperature);
        }
    }

    @Override
    public List<Double> getTemperatureValues() {
        return temperatureValues;
    }

    @Override
    public void clearTemperatureValues() {
        temperatureValues.clear();
    }


}
