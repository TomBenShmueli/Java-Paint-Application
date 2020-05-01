import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {


    private ArrayList<MyShape> shapeList;

    private boolean isFilled;
    private MyShape currentShape;
    private Color currentColor;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DrawPanel() {
        shapeList = new ArrayList<MyShape>();
        this.isFilled = false;
        this.currentShape = null;
        this.currentColor = Color.WHITE;
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
    }
    
    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public MyShape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(MyShape currentShape) {
        this.currentShape = currentShape;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void getStartingPosition(int x1, int y1)
    {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void getEndPosition(int x2,int y2)
    {
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyShape shape : shapeList )
        {
            shape.draw(g);
        }
    }

}
