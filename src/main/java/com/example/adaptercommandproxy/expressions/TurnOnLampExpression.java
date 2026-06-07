package com.example.adaptercommandproxy.expressions;

import com.example.adaptercommandproxy.ICommand;
import com.example.adaptercommandproxy.IExpression;
import com.example.adaptercommandproxy.ModernLamp;
import com.example.adaptercommandproxy.TurnOnCommand;

public class TurnOnLampExpression implements IExpression {
    private final ModernLamp lamp;

    public TurnOnLampExpression(ModernLamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public ICommand interpret(String context) {
        String normalized = context == null ? "" : context.trim().toLowerCase();
        if (normalized.contains("lamp") && normalized.contains("turn on")) {
            return new TurnOnCommand(lamp);
        }
        return null;
    }
}
