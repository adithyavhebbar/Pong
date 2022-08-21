package org.hebbar.entities;

import com.raylib.Jaylib;
import org.hebbar.constants.BallConstants;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Ball extends Entity {
    int ballX = GetScreenWidth() / 2, ballY = GetScreenHeight() / 2;
    float ballRadius = 10.0f;

    private Color color = WHITE;

    public int ballSpeedY = 300, ballSpeedX = 300;

    public Ball(int x, int y, float radius, Color color) {
        this.ballX = x;
        this.ballY = y;
        this.ballRadius = radius;
        this.color = color;
    }

    public Ball(int x, int y, float radius) {
        this.ballX = x;
        this.ballY = y;
        this.ballRadius = radius;
    }

    public void updateBallPos() {
        this.ballX = (int) (this.ballX + (ballSpeedX * GetFrameTime()));
        this.ballY = (int) (this.ballY + (ballSpeedY * GetFrameTime()));
    }

    public void checkAndUpdateOutOfBounds() {
        if (this.ballY > GetScreenHeight()) {
            this.ballY = GetScreenHeight();
            this.ballSpeedY *= -1;
        }

        if (this.ballY < 0) {
            this.ballY = 0;
            this.ballSpeedY *= -1;
        }
    }

    @Override
    public void Draw() {
        DrawCircle(ballX, ballY, ballRadius, RAYWHITE);
    }

    public int getBallXPos() {
        return this.ballX;
    }

    public int getBallYPos() {
        return this.ballY;
    }

    public float getBallRadius() {
        return ballRadius;
    }
    public void setBallYPos(int y) {
        this.ballY = y;
    }

    public void setBallXPos(int x) {
        this.ballX = x;
    }

    public void reset() {
        ballX = GetScreenWidth() / 2;
        ballY = GetScreenHeight() / 2;
        ballSpeedY = 300;
        ballSpeedX = 300;
    }
}
