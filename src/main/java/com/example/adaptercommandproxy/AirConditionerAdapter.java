package com.example.adaptercommandproxy;

public class AirConditionerAdapter implements IDevice {
    private final OldAirConditioner oldAC;

    public AirConditionerAdapter(OldAirConditioner oldAC) {
        this.oldAC = oldAC;
    }

    @Override
    public void turnOn() {
        oldAC.applyEnergy();
    }
}
