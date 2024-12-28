import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

    // Default Constructor
    public Rectangle() {
        super();
    }

    // Parameterized Constructor
    public Rectangle(Color color, int xPosition, int yPosition, int width, int height, boolean isFilled) {
        super(color, xPosition, yPosition, width, height, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isFilled()) {
            g.fillRect(getXPosition(), getYPosition(), getWidth(), getHeight());
        } else {
            g.drawRect(getXPosition(), getYPosition(), getWidth(), getHeight());
        }
    }
}
