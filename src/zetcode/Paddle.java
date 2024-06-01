package zetcode;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite {

    private int dx;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public Paddle() {
        initPaddle();
    }

    private void initPaddle() {
        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() {
        try {
            var ii = new ImageIcon("src/resources/paddle.png");
            image = ii.getImage();
        } catch (Exception e) {
            System.err.println("Error loading paddle image: " + e.getMessage());
        }
    }

    void move() {
        x += dx;

        if (x <= 0) {
            x = 0;
        }

        if (x >= Commons.WIDTH - imageWidth) {
            x = Commons.WIDTH - imageWidth;
        }
    }

    void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        updateDirection();
    }

    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        updateDirection();
    }

    private void updateDirection() {
        if (leftPressed && !rightPressed) {
            dx = -2;
        } else if (!leftPressed && rightPressed) {
            dx = 2;
        } else {
            dx = 0;
        }
    }

    private void resetState() {
        x = Commons.INIT_PADDLE_X;
        y = Commons.INIT_PADDLE_Y;
    }
}
