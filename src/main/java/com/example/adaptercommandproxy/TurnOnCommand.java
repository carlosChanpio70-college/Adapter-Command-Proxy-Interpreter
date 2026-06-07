package com.example.adaptercommandproxy;

public class TurnOnCommand implements ICommand {
    private final IDevice receiver;

    public TurnOnCommand(IDevice receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }
}
