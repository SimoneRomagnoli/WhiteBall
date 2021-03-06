package com.example.whiteball.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.whiteball.model.entities.EntityType;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Random;

public class CanvasDrawer {
    private static final Map<EntityType, Drawer> DRAWER_MAP;

    static {
        DRAWER_MAP = ImmutableMap.of(
                EntityType.PLAYER, CanvasDrawer::drawWhiteBall,
                EntityType.BALL, CanvasDrawer::drawBall,
                //EntityType.SHIELD, CanvasDrawer::drawShield,
                EntityType.SQUARE, CanvasDrawer::drawSquare,
                EntityType.TRIANGLE, CanvasDrawer::drawTriangle,
                EntityType.RHOMBUS, CanvasDrawer::drawRhombus
        );
    }



    public static void drawCanvas(Canvas canvas, ViewEntity viewEntity) {
        DRAWER_MAP.get(viewEntity.getType()).draw(canvas, viewEntity.getPosition(), viewEntity.getDimension(), viewEntity.getPaint());
    }

    private static void drawWhiteBall(Canvas canvas, Point position, Integer dimension, Paint paint) {
        paint.setColor(Color.WHITE);
        canvas.drawCircle(position.x, position.y, dimension, paint);
    }

    private static void drawShield(Canvas canvas, Point position, Integer dimension, Paint paint) {
        paint.setColor(Color.CYAN);
        canvas.drawCircle(position.x, position.y, dimension, paint);
    }

    private static void drawBall(Canvas canvas, Point position, Integer dimension, Paint paint) {
        canvas.drawCircle(position.x, position.y, dimension, paint);
    }

    private static void drawSquare(Canvas canvas, Point position, Integer dimension, Paint paint) {
        final Rect rectangle = new Rect(position.x - dimension / 2, position.y - dimension / 2, position.x + dimension / 2, position.y + dimension / 2);
        canvas.drawRect(rectangle, paint);
    }

    private static void drawTriangle(Canvas canvas, Point position, Integer dimension, Paint paint) {
        int halfWidth = dimension / 2;

        Path path = new Path();
        path.moveTo(position.x, position.y - halfWidth); // Top
        path.lineTo(position.x - halfWidth, position.y + halfWidth); // Bottom left
        path.lineTo(position.x + halfWidth, position.y + halfWidth); // Bottom right
        path.lineTo(position.x, position.y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

    private static void drawRhombus(Canvas canvas, Point position, Integer dimension, Paint paint) {
        int halfWidth = dimension / 2;

        Path path = new Path();
        path.moveTo(position.x, position.y + halfWidth); // Top
        path.lineTo(position.x - halfWidth, position.y); // Left
        path.lineTo(position.x, position.y - halfWidth); // Bottom
        path.lineTo(position.x + halfWidth, position.y); // Right
        path.lineTo(position.x, position.y + halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

    @FunctionalInterface
    private interface Drawer {
        void draw(Canvas canvas, Point position, Integer dimension, Paint paint);
    }
}
