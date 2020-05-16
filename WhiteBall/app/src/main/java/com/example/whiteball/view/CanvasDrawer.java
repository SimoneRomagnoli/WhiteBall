package com.example.whiteball.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.whiteball.Constants;
import com.example.whiteball.model.entities.EntityType;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class CanvasDrawer {
    private static final Map<EntityType, Drawer> DRAWER_MAP;

    static {
        DRAWER_MAP = ImmutableMap.of(
                EntityType.BALL, CanvasDrawer::drawBall,
                EntityType.SQUARE, CanvasDrawer::drawSquare
        );
    }

    public static void drawCanvas(Canvas canvas, ViewEntity viewEntity) {
        DRAWER_MAP.get(viewEntity.getType()).draw(canvas, viewEntity.getPosition(), viewEntity.getDimension());
    }

    private static void drawBall(Canvas canvas, Point position, Integer dimension) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle(position.x, position.y, dimension, paint);
    }

    private static void drawSquare(Canvas canvas, Point position, Integer dimension) {
        final Rect rectangle = new Rect(position.x, position.y, position.x + dimension, position.y + dimension);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(rectangle, paint);
    }

    @FunctionalInterface
    private interface Drawer {
        void draw(Canvas canvas, Point position, Integer dimension);
    }
}
