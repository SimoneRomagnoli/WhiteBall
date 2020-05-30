package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.utility.Constants;
import com.example.whiteball.model.entities.components.CollisionComponent;
import com.example.whiteball.model.entities.components.GravityComponent;
import com.example.whiteball.model.entities.components.InputComponent;
import com.example.whiteball.model.entities.components.MovementComponent;
import com.example.whiteball.model.entities.components.ToroidalComponent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Random;

/**
 * Implementation of the Factory Method pattern.
 */
public class EntityFactoryImpl implements EntityFactory {
    private static final Random RANDOM = new Random();
    private static final ImmutableList<EntityType> ENTITY_TYPES = ImmutableList.copyOf(EntityType.values());
    private static final Map<EntityType, Creator> ENTITY_MAP;

    static {
        ENTITY_MAP = ImmutableMap.of(
                EntityType.BALL, EntityFactoryImpl::createBall,
                EntityType.SQUARE, EntityFactoryImpl::createSquare,
                EntityType.TRIANGLE, EntityFactoryImpl::createTriangle,
                EntityType.RHOMBUS, EntityFactoryImpl::createRhombus
        );
    }

    @Override
    public Entity createEntity(Point position) {
        return this.ENTITY_MAP.get(this.getRandomEntityType()).create(position);
    }

    /**
     * Creates a new {@link Ball} instance.
     * @param position
     * @return a new {@link Ball}.
     */
    public static Entity createBall(Point position) {
        final Entity entity = new Ball(position, Constants.PLAYER_RADIUS_INT);
        entity.addComponent(new InputComponent());
        entity.addComponent(new MovementComponent());
        entity.addComponent(new ToroidalComponent());
        entity.addComponent(new CollisionComponent());
        return entity;
    }

    /**
     * Creates a new {@link Square} instance.
     * @param position
     * @return a new {@link Square}.
     */
    public static Entity createSquare(Point position) {
        final Entity entity = new Square(position, Constants.SQUARE_EDGE / 2);
        entity.addComponent(new MovementComponent());
        return entity;
    }

    /**
     * Creates a new {@link Triangle} instance.
     * @param position
     * @return a new {@link Triangle}.
     */
    public static Entity createTriangle(Point position) {
        final Entity entity = new Triangle(position, Constants.TRIANGLE_EDGE / 2);
        entity.addComponent(new MovementComponent());
        entity.addComponent(new GravityComponent());
        return entity;
    }

    /**
     * Creates a new {@link Rhombus} instance.
     * @param position
     * @return a new {@link Rhombus}.
     */
    public static Entity createRhombus(Point position) {
        final Entity entity = new Rhombus(position, Constants.RHOMBUS_EDGE / 2);
        entity.addComponent(new MovementComponent());
        entity.addComponent(new GravityComponent());
        return entity;
    }

    private EntityType getRandomEntityType() {
        return this.ENTITY_TYPES.get(this.RANDOM.nextInt(this.ENTITY_TYPES.size()));
    }

    @FunctionalInterface
    private interface Creator {
        Entity create(Point position);
    }
}
