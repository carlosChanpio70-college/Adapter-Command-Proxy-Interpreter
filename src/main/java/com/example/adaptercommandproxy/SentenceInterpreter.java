package com.example.adaptercommandproxy;

import java.util.List;

public class SentenceInterpreter implements IExpression {
    private final List<IExpression> expressions;

    public SentenceInterpreter(List<IExpression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public ICommand interpret(String context) {
        for (IExpression expression : expressions) {
            ICommand command = expression.interpret(context);
            if (command != null) {
                return command;
            }
        }
        return null;
    }
}
