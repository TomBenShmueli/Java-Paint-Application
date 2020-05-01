import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private boolean isFilled;
    private Shape currentShape;
    private Color currentColor;

    public DrawPanel(boolean isFilled, Shape currentShape, Color currentColor) {
        this.isFilled = false;
        this.currentShape = null;
        this.currentColor = Color.WHITE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

}
