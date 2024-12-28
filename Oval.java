import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {

    // Default Constructor
    public Oval() {
        super();
    }

    // Parameterized Constructor
    public Oval(Color color, int xPosition, int yPosition, int width, int height, boolean isFilled) {
        super(color, xPosition, yPosition, width, height, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isFilled()) {
            g.fillOval(getXPosition(), getYPosition(), getWidth(), getHeight());
        } else {
            g.drawOval(getXPosition(), getYPosition(), getWidth(), getHeight());
        }
    }
}
