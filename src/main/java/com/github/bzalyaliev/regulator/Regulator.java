package com.github.bzalyaliev.regulator;

import java.util.List;

public interface Regulator {
    void setTemperature(double temperature);
    List<Double> getTemperatureValues();
    void clearTemperatureValues();

}
