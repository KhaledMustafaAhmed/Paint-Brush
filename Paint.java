import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Paint extends Applet {

    public static final int SHAPE_RECTANGLE = 1;
    public static final int SHAPE_LINE = 2;
    public static final int SHAPE_OVAL = 3;

    public int currentShapeType;
    
    private boolean SHAPE_ISFILL = false;
    private Color currentColor = Color.BLACK;
    private Shape activeShape = null;
    
    /* Color Buttons */
    private Button redColorButton;
    private Button blackColorButton;
    private Button greenColorButton;
    private Button blueColorButton;
    
    
    /* Shape Buttons */
    private Button lineShapeButton;
    private Button ovalShapeButton;
    private Button rectangleShapeButton;

    /* Fill State Buttons */
    private Button solidStateButton;
    private Button dottedStateButton;

    /* Clear Screen */
    private Button clearScreenButton;

    private boolean isDragging = false;
    private ArrayList<Shape> shapes = new ArrayList<>();
    
    @Override
    public void init() {
        /* Clear Screen */
        clearScreenButton = new Button("CLEAR");
        /* Constructing State Buttons */
        solidStateButton = new Button("SOLID");
        dottedStateButton = new Button("DOTTED");

		/* Constructing Colors Buttons */
        redColorButton = new Button("RED"); redColorButton.setBackground(Color.RED);
		blackColorButton = new Button("BLACK"); blackColorButton.setBackground(Color.BLACK);
		greenColorButton = new Button ("GREEN"); greenColorButton.setBackground(Color.GREEN);
		blueColorButton = new Button ("BLUE"); blueColorButton.setBackground(Color.BLUE);
		
		/* Constructing Shapes Buttons */
        lineShapeButton = new Button("LINE");
		ovalShapeButton = new Button("OVAL");
		rectangleShapeButton = new Button("RECTANGLE");
		
        clearScreenButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                repaint();
            }
        });

        /* Add Action Listeners for Fill state buttons */
        solidStateButton.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                SHAPE_ISFILL = true;
            }
        });

        dottedStateButton.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                SHAPE_ISFILL = false;
            }
        });


        /* Add Action Listeners for Colors Buttons */
		redColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
            }
        });
		
		blackColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
            }
        });
		
		blueColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
            }
        });
		
		greenColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GREEN;
            }
        });
		
		/* Add action listener for Shapes Buttons */
        lineShapeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShapeType = SHAPE_LINE;
            }
        });
		
		ovalShapeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShapeType = SHAPE_OVAL;
            }
        });
		
		rectangleShapeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShapeType = SHAPE_RECTANGLE;
            }
        });
        
		/* Add Buttons to Applet frame */
        add(lineShapeButton);
		add(rectangleShapeButton);
		add(ovalShapeButton);
        add(redColorButton);
		add(greenColorButton);
		add(blueColorButton);
		add(blackColorButton);
        add(solidStateButton);
        add(dottedStateButton);
        add(clearScreenButton);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                activeShape = createShape(currentShapeType, currentColor, e.getX(), e.getY(), SHAPE_ISFILL);
                if (activeShape != null) {
                    shapes.add(activeShape);
                    isDragging = true;
                }
            }

            public void mouseReleased(MouseEvent e) {
                isDragging = false;
                activeShape = null; 
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging && activeShape != null) {
					switch(currentShapeType){
                            case SHAPE_LINE:
                                activeShape.setWidth(e.getX());
                                activeShape.setHeight(e.getY());
                                break;
                        case SHAPE_RECTANGLE:
                                int Rect_x = e.getX();
                                int Rect_y = e.getY();
                                int Rect_width = Math.abs(Rect_x- activeShape.getXPosition());
                                int Rect_height = Math.abs(Rect_y - activeShape.getYPosition());
                                activeShape.setXPosition(Math.min(activeShape.getXPosition(), Rect_x));
                                activeShape.setYPosition(Math.min(activeShape.getYPosition(), Rect_y));
                                activeShape.setWidth(Rect_width);
                                activeShape.setHeight(Rect_height);
                                break;    
                        case SHAPE_OVAL:
                                int Oval_x = e.getX();
                                int Oval_y = e.getY();
                                int Oval_width = Math.abs(Oval_x - activeShape.getXPosition());
                                int Oval_height = Math.abs(Oval_y - activeShape.getYPosition());
                                activeShape.setXPosition(Math.min(activeShape.getXPosition(), Oval_x));
                                activeShape.setYPosition(Math.min(activeShape.getYPosition(), Oval_y));
                                activeShape.setWidth(Oval_width);
                                activeShape.setHeight(Oval_height);
                                break;        
					}
                    repaint();
                }
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        for (Shape shape : shapes) {
				shape.draw(g);
        }
    }
    private Shape createShape(int shapeType, Color color, int x, int y, boolean SHAPE_ISFILL) {
        switch (shapeType) {
            case SHAPE_LINE:
                return new Line(color, x, y, 0, 0, SHAPE_ISFILL);
            case SHAPE_RECTANGLE:
                return new Rectangle(color, x, y,0, 0, SHAPE_ISFILL);
            case SHAPE_OVAL:
                return new Oval(color, x, y, 0, 0, SHAPE_ISFILL);
            default:
                return null;
        }
    }
}
