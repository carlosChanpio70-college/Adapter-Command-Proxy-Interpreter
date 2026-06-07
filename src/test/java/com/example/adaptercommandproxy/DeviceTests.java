package com.example.adaptercommandproxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceTests {

    @Test
    public void modernLampTurnsOn() {
        ModernLamp lamp = new ModernLamp();
        assertFalse(lamp.isOn());

        lamp.turnOn();
        assertTrue(lamp.isOn());
    }

    @Test
    public void adapterTurnsOnOldAirConditioner() {
        OldAirConditioner oldAirConditioner = new OldAirConditioner();
        AirConditionerAdapter adapter = new AirConditionerAdapter(oldAirConditioner);

        assertFalse(oldAirConditioner.isEnergyApplied());
        adapter.turnOn();
        assertTrue(oldAirConditioner.isEnergyApplied());
    }

    @Test
    public void securityProxyAllowsAuthorizedUser() {
        ModernLamp lamp = new ModernLamp();
        SecurityProxy proxy = new SecurityProxy(lamp, "AUTHORIZED");

        proxy.turnOn();
        assertTrue(lamp.isOn());
        assertTrue(proxy.hasPermission());
    }

    @Test
    public void securityProxyDeniesUnauthorizedUser() {
        ModernLamp lamp = new ModernLamp();
        SecurityProxy proxy = new SecurityProxy(lamp, "UNAUTHORIZED");

        assertFalse(proxy.hasPermission());
        assertThrows(SecurityException.class, proxy::turnOn);
        assertFalse(lamp.isOn());
    }
}
