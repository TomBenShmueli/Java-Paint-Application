
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame
{
    Color currentColor = Color.WHITE;
    JFrame frame;
    JPanel buttonPanel;
    JPanel drawPanel;
    JButton exitButton, undoButton, clearButton, colorButton , lineButton, rectangleButton , roundRectangleButton , ovalButton;
    JColorChooser colorChooser;
    JCheckBox isFilledBox;

    public DrawFrame()
    {
        createAndRunGUI();
    }

    private void createAndRunGUI()
    {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(700,500));
        frame.setResizable(false);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        LayoutManager gridLayout = new GridLayout(0,9,0,10);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);
        drawPanel = new JPanel();
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        drawPanel.setBackground(Color.WHITE);
        initiateAndAddButtons();
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(drawPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void initiateAndAddButtons()
    {
        isFilledBox = new JCheckBox("Filled?");
        exitButton = new JButton("Exit");
        clearButton = new JButton("Clear");
        undoButton = new JButton("Undo");
        colorButton = new JButton("Color");
        

        lineButton = new JButton();
        try {
            lineButton.setBackground(Color.WHITE);
            Image img = ImageIO.read(getClass().getResource("resources/lineIcon.png"));
            lineButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        rectangleButton = new JButton();
        try {
            rectangleButton.setBackground(Color.WHITE);
            Image img = ImageIO.read(getClass().getResource("resources/rectangleIcon.png"));
            rectangleButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        roundRectangleButton = new JButton();
        try {
            roundRectangleButton.setBackground(Color.WHITE);
            Image img = ImageIO.read(getClass().getResource("resources/roundRectangleIcon.png"));
            roundRectangleButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        ovalButton = new JButton();
        try {
            ovalButton.setBackground(Color.WHITE);
            Image img = ImageIO.read(getClass().getResource("resources/circleIcon.png"));
            ovalButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        buttonPanel.add(exitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(roundRectangleButton);
        buttonPanel.add(ovalButton);
        buttonPanel.add(colorButton);
        buttonPanel.add(isFilledBox);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setVisible(true);
    }

    public static void main(String args[])
    {
        DrawFrame df = new DrawFrame();
    }

}
