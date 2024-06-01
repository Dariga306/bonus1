package zetcode;

import javax.swing.ImageIcon;

public class Ball extends Sprite {

    private int xdir;
    private int ydir;

    public Ball() {
        initBall();
    }

    private void initBall() {
        xdir = 2;  // Increased speed
        ydir = -2; // Increased speed

        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() {
        try {
            var ii = new ImageIcon("src/resources/ball.png");
            image = ii.getImage();
        } catch (Exception e) {
            System.err.println("Error loading ball image: " + e.getMessage());
        }
    }

    void move() {
        x += xdir;
        y += ydir;

        if (x < 0) {
            setXDir(2);  // Adjust to new speed
        } else if (x > Commons.WIDTH - imageWidth) {
            setXDir(-2); // Adjust to new speed
        }

        if (y < 0) {
            setYDir(2);  // Adjust to new speed
        } else if (y > Commons.HEIGHT - imageHeight) {
            resetState();  // Example: reset state if ball goes out of bounds
        }
    }

    void increaseSpeed() {
        xdir = xdir < 0 ? xdir - 1 : xdir + 1;
        ydir = ydir < 0 ? ydir - 1 : ydir + 1;
    }

    void decreaseSpeed() {
        if (Math.abs(xdir) > 1 && Math.abs(ydir) > 1) {
            xdir = xdir < 0 ? xdir + 1 : xdir - 1;
            ydir = ydir < 0 ? ydir + 1 : ydir - 1;
        }
    }

    private void resetState() {
        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {
        xdir = x;
    }

    void setYDir(int y) {
        ydir = y;
    }

    int getYDir() {
        return ydir;
    }
}
