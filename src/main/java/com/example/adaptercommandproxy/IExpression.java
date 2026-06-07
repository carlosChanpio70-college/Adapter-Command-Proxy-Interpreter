package com.example.adaptercommandproxy;

public interface IExpression {
    ICommand interpret(String context);
}
