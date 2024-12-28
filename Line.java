import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

    // Default Constructor
    public Line() {
        super();
    }

    // Parameterized Constructor
    public Line(Color color, int xPosition, int yPosition, int width, int height, boolean isFilled) {
        super(color, xPosition, yPosition, width, height, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getXPosition(), getYPosition(), getWidth(), getHeight());
    }
}
