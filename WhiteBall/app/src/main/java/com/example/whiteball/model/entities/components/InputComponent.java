package com.example.whiteball.model.entities.components;

import com.example.whiteball.controller.Command;
import com.example.whiteball.controller.InputManager;
import com.example.whiteball.model.entities.Velocity;
import com.example.whiteball.model.entities.VelocityImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Component} that handles inputs.
 */
public class InputComponent extends AbstractComponent {
    private List<Command> inputs;

    public InputComponent() {
        super(ComponentType.INPUT);
        this.inputs = new ArrayList<>();
    }

    @Override
    public void update(long dt) {
        if (this.isEnabled()) {
            final Velocity velocity = new VelocityImpl(0, 0);
            for (Command command: inputs) {
                velocity.setX((int)(velocity.getX() + InputManager.GYROSCOPE_SENSITIVITY * (-(int)command.getValue())));
            }
            this.getParent().setVelocity(velocity);
        }
    }

    public void collectInputs(List<Command> inputs) {
        this.inputs = inputs;
    }
}
