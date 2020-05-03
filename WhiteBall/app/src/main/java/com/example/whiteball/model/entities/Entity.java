package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public interface Entity {

    EntityType getType();

    Position getPosition();
}
