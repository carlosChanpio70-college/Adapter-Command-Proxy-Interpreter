package com.example.adaptercommandproxy;

public class SecurityProxy implements IDevice {
    private final IDevice realDevice;
    private final String userToken;

    public SecurityProxy(IDevice realDevice, String userToken) {
        this.realDevice = realDevice;
        this.userToken = userToken;
    }

    @Override
    public void turnOn() {
        if (!hasPermission()) {
            throw new SecurityException("User does not have permission to turn on this device.");
        }
        realDevice.turnOn();
    }

    public boolean hasPermission() {
        return "AUTHORIZED".equals(userToken);
    }
}
