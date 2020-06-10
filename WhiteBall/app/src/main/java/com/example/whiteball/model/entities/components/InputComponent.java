package com.example.whiteball.model.entities.components;

import com.example.whiteball.controller.Command;
import com.example.whiteball.controller.CommandType;
import com.example.whiteball.controller.InputManager;
import com.example.whiteball.model.entities.properties.Vector2D;
import com.example.whiteball.model.entities.properties.Vector2DImpl;

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
            final Vector2D velocity = new Vector2DImpl(0, 0);
            for (Command command: inputs) {
                if(command.getType().equals(CommandType.MOVE_LEFT) || command.getType().equals(CommandType.MOVE_RIGHT)) {
                    velocity.setX((int)(velocity.getX() + InputManager.GYROSCOPE_SENSITIVITY * ((int)command.getValue())));
                }
                if(command.getType().equals(CommandType.MOVE_UP) || command.getType().equals(CommandType.MOVE_DOWN)) {
                    velocity.setY((int)(velocity.getY() + InputManager.GYROSCOPE_SENSITIVITY * ((int)command.getValue())));
                }
            }
            this.getParent().setVelocity(velocity);
        }
    }

    public void collectInputs(List<Command> inputs) {
        this.inputs = inputs;
    }
}
