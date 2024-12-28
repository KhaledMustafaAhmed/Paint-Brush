import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    private Color color;
    private int xPosition, yPosition;
    private int width, height;
    private boolean isFilled;

    // Default Constructor
    public Shape() {
        this.color = Color.BLACK;
        this.xPosition = 0;
        this.yPosition = 0;
        this.width = 0;
        this.height = 0;
        this.isFilled = false;
    }

    // Constructor with parameters
    public Shape(Color color, int xPosition, int yPosition, int width, int height, boolean isFilled) {
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.isFilled = isFilled;
    }

    // Getters and Setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    // Abstract method to be implemented by subclasses
    public abstract void draw(Graphics g);
}
