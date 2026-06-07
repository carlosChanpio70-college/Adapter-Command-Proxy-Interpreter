package com.example.adaptercommandproxy;

import com.example.adaptercommandproxy.expressions.TurnOnAirConditionerExpression;
import com.example.adaptercommandproxy.expressions.TurnOnLampExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VoiceAssistantTest {
    private ModernLamp lamp;
    private OldAirConditioner oldAirConditioner;
    private AirConditionerAdapter airConditionerAdapter;
    private VoiceAssistant assistant;

    @BeforeEach
    public void setUp() {
        lamp = new ModernLamp();
        oldAirConditioner = new OldAirConditioner();
        airConditionerAdapter = new AirConditionerAdapter(oldAirConditioner);
        SentenceInterpreter interpreter = new SentenceInterpreter(List.of(
                new TurnOnLampExpression(lamp),
                new TurnOnAirConditionerExpression(airConditionerAdapter)
        ));
        assistant = new VoiceAssistant(interpreter);
    }

    @Test
    public void shouldInterpretAndExecuteLampCommand() {
        assistant.receiveVoiceCommand("Please turn on the lamp");
        assertTrue(assistant.hasPendingCommands());

        assistant.executeCommands();
        assertFalse(assistant.hasPendingCommands());
        assertTrue(lamp.isOn());
    }

    @Test
    public void shouldInterpretAndExecuteAirConditionerCommand() {
        assistant.receiveVoiceCommand("Turn on the air conditioner");
        assertTrue(assistant.hasPendingCommands());

        assistant.executeCommands();
        assertFalse(assistant.hasPendingCommands());
        assertTrue(oldAirConditioner.isEnergyApplied());
    }

    @Test
    public void shouldIgnoreUnknownCommand() {
        assistant.receiveVoiceCommand("Open the garage door");
        assertFalse(assistant.hasPendingCommands());
    }
}
