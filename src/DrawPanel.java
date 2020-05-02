import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {


    private ArrayList<MyShape> shapeList;

    private boolean isFilled;
    private ShapeType currentShape;
    private MyShape draggedShape;
    private Color currentColor;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DrawPanel() {
        draggedShape = new MyLine(0,0,0,0,Color.WHITE);
        shapeList = new ArrayList<>();
        this.isFilled = false;
        this.currentShape = ShapeType.LINE;
        this.currentColor = Color.WHITE;
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void setCurrentShapeType(ShapeType type) {
        this.currentShape = type;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setStartingPosition(int x1, int y1)
    {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setEndPosition(int x2,int y2)
    {
        this.x2 = x2;
        this.y2 = y2;
    }

    public void addNewShape()
    {
        if (currentShape != ShapeType.LINE)
        {
            checkReverseXCoordinates();
        }
        switch (this.currentShape)
        {
            case LINE:
                shapeList.add(new MyLine(this.x1,this.x2,this.y1,this.y2,currentColor));
                break;
            case RECTANGLE:
                shapeList.add(new MyRectangle(this.x1,this.x2,this.y1,this.y2,currentColor,this.isFilled));
                break;
            case ROUND_RECTANGLE:
                shapeList.add(new MyRoundRectangle(this.x1,this.x2,this.y1,this.y2,currentColor,this.isFilled));
                break;
            case OVAL:
                shapeList.add(new MyOval(this.x1,this.x2,this.y1,this.y2,currentColor,this.isFilled));
                break;
        }
    }

    public void clearShapes()
    {
        shapeList.clear();
        repaint();
    }

    public void removeLastShape()
    {
        if(shapeList.size() == 0)
            return;
        shapeList.remove(shapeList.size()-1);
        repaint();
    }

    public void drawCurrentDraggedShape() //draw shape on drag
    {
        if (currentShape != ShapeType.LINE)
        {
            checkReverseXCoordinates();
        }
        switch (currentShape)
            {
                case LINE:
                    draggedShape = new MyLine(x1,x2,y1,y2,currentColor);
                    break;
                case RECTANGLE:
                    draggedShape = new MyRectangle(x1,x2,y1,y2,currentColor,isFilled);
                    break;
                case ROUND_RECTANGLE:
                    draggedShape = new MyRoundRectangle(x1,x2,y1,y2,currentColor,isFilled);
                    break;
                case OVAL:
                    draggedShape = new MyOval(x1,x2,y1,y2,currentColor,isFilled);
                    break;
            }
    }

    public void removeDraggedShape()
    {
        draggedShape = new MyLine(0,0,0,0,Color.WHITE);
    }

    private void checkReverseXCoordinates()
    {
        int temp;
        if (x2 < x1)
        {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y2 < y1)
        {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
    }

    private void checkReverseDragging()
    {
        int xGap = Math.abs(x2-x1);
        int yGap = Math.abs(y2-y1);
        if (x2 < x1)
        {
            x1 -= 2*x2;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("x1 " + x1 + " x2 " +  x2 + " y1 " + y1 +  " y2 " + y2 + " color " + currentColor + " isfilled " + isFilled + " shape " + currentShape);
        System.out.println("DRAGGED x1 " + draggedShape.getX1() + " x2 " +  draggedShape.getX2() + " y1 " + draggedShape.getY1() +  " y2 " + draggedShape.getY2() + " color " + draggedShape.getColor() + " isfilled " + isFilled + " shape " + draggedShape.getClass());

        super.paintComponent(g);
        draggedShape.draw(g);
        for (MyShape shape : shapeList )
        {
            shape.draw(g);
        }
    }

}
