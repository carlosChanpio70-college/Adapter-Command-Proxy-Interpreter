package com.example.adaptercommandproxy;

public class ModernLamp implements IDevice {
    private boolean on;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Modern lamp is now on.");
    }

    public boolean isOn() {
        return on;
    }
}
