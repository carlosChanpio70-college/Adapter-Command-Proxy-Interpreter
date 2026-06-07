package com.example.adaptercommandproxy.expressions;

import com.example.adaptercommandproxy.AirConditionerAdapter;
import com.example.adaptercommandproxy.ICommand;
import com.example.adaptercommandproxy.IExpression;
import com.example.adaptercommandproxy.TurnOnCommand;

public class TurnOnAirConditionerExpression implements IExpression {
    private final AirConditionerAdapter airConditionerAdapter;

    public TurnOnAirConditionerExpression(AirConditionerAdapter airConditionerAdapter) {
        this.airConditionerAdapter = airConditionerAdapter;
    }

    @Override
    public ICommand interpret(String context) {
        String normalized = context == null ? "" : context.trim().toLowerCase();
        if (normalized.contains("air") && normalized.contains("conditioner") && normalized.contains("turn on")) {
            return new TurnOnCommand(airConditionerAdapter);
        }
        return null;
    }
}
