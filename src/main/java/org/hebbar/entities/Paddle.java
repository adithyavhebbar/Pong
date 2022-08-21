package org.hebbar.entities;

import com.raylib.Jaylib;
import com.raylib.Raylib.*;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Paddle extends Entity{

    private int paddleX, paddleY;
    public int paddleWidth, paddleHeight;

    public Color color = RAYWHITE;

    public int speed = 500;

    public Paddle(int x, int y, int width, int height, Color color) {
        this.paddleX = x;
        this.paddleY = y;
        this.paddleHeight = height;
        this.paddleWidth = width;
        this.color = color;
    }

    public Paddle(int x, int y, int width, int height) {
        this.paddleX = x;
        this.paddleY = y;
        this.paddleHeight = height;
        this.paddleWidth = width;
    }

    public void movePaddleUp() {
        this.paddleY -= (this.speed * GetFrameTime());
    }

    public void movePaddleDown() {
        this.paddleY += (this.speed * GetFrameTime());
    }


    @Override
    public void Draw() {
        DrawRectangle(paddleX, paddleY, paddleWidth, paddleHeight, color);
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }

    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }

    public void setPaddleY(int paddleY) {
        this.paddleY = paddleY;
    }
}
