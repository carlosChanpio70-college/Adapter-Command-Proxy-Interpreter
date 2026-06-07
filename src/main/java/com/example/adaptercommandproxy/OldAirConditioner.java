package com.example.adaptercommandproxy;

public class OldAirConditioner {
    private boolean energyApplied;

    public void applyEnergy() {
        energyApplied = true;
        System.out.println("Old air conditioner has received energy.");
    }

    public boolean isEnergyApplied() {
        return energyApplied;
    }
}
