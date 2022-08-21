package org.hebbar;

import org.hebbar.entities.Ball;
import org.hebbar.entities.Paddle;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class App {
    public static final int WIDTH = 1300;
    public static final int HEIGHT = 1000;
    public static final String TITLE = "Pong";

    public static void main(String[] args) {
        InitWindow(WIDTH, HEIGHT, TITLE);
        SetTargetFPS(60);
        int rectHeight = 150;
        int rectOffSet = 50;
        int rectWidth = 10;

        float ballRadius = 10.0f;


        Ball ball = new Ball(GetScreenWidth() / 2, GetScreenHeight() / 2, ballRadius, RAYWHITE);
        Paddle leftPaddle = new Paddle(rectOffSet, GetScreenHeight() / 2 - (rectHeight / 2), rectWidth, rectHeight);
        Paddle rightPaddle = new Paddle(GetScreenWidth() - rectOffSet - rectWidth, GetScreenHeight() / 2 - (rectHeight / 2), rectWidth, rectHeight);

        while (!WindowShouldClose()) {

            ball.updateBallPos();

            ball.checkAndUpdateOutOfBounds();

            if (IsKeyDown(KEY_W)) {
                if (leftPaddle.getPaddleY() <= 0) {
                    leftPaddle.setPaddleY(0);
                } else {
                    leftPaddle.movePaddleUp();
                }
            }

            if (IsKeyDown(KEY_S)) {
                if (leftPaddle.getPaddleY() + leftPaddle.paddleHeight >= GetScreenHeight()) {
                    leftPaddle.setPaddleY(GetScreenHeight() - leftPaddle.paddleHeight);
                } else {
                    leftPaddle.movePaddleDown();
                }
            }

            if (IsKeyDown(KEY_UP)) {
                if (rightPaddle.getPaddleY() <= 0) {
                    rightPaddle.setPaddleY(0);
                } else {
                    rightPaddle.movePaddleUp();
                }
            }

            if (IsKeyDown(KEY_DOWN)) {
                if (rightPaddle.getPaddleY() + rightPaddle.paddleHeight >= GetScreenHeight()) {
                    rightPaddle.setPaddleY(GetScreenHeight() - rightPaddle.paddleHeight);
                } else {
                    rightPaddle.movePaddleDown();
                }
            }

            BeginDrawing();

            DrawFPS(20, 20);

            ClearBackground(BLACK);

            leftPaddle.Draw();

            ball.Draw();

            rightPaddle.Draw();

            EndDrawing();

        }


        CloseWindow();
    }
}
