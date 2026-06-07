package com.example.adaptercommandproxy;

import java.util.LinkedList;
import java.util.Queue;

public class VoiceAssistant {
    private final IExpression interpreter;
    private final Queue<ICommand> commandQueue;

    public VoiceAssistant(IExpression interpreter) {
        this.interpreter = interpreter;
        this.commandQueue = new LinkedList<>();
    }

    public void receiveVoiceCommand(String text) {
        ICommand command = interpreter.interpret(text);
        if (command != null) {
            commandQueue.offer(command);
        }
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            ICommand command = commandQueue.poll();
            command.execute();
        }
    }

    public boolean hasPendingCommands() {
        return !commandQueue.isEmpty();
    }
}
