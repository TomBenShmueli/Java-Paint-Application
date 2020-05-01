
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        drawPanel = new DrawPanel();
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        drawPanel.setBackground(Color.WHITE);
        initiateAndAddButtons();
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(drawPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void initiateAndAddButtons()
    {
        /*
        initiate JButtons and JCheckBox + set icons for shape buttons
         */
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
        /*
        add button functionality
         */
        exitButton.addMouseListener(new MouseAdapter() { // exit button
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.repaint();
            }
        });

        colorButton.addMouseListener(new MouseAdapter() { // get color from the user. default is white.
            @Override
            public void mouseClicked(MouseEvent e) {
                currentColor = JColorChooser.showDialog(frame, "Choose a color", Color.RED);
                colorButton.setBackground(currentColor); // show user current color
                int negColor = 0xFFFFFF - currentColor.getRGB();
                colorButton.setForeground(new Color(negColor)); // make sure text is visible
            }
        });



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
