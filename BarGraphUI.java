
/**
 * Write a description of class BarGraphUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
public class BarGraphUI
{
    /**
     * Creates new frame with title.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Bar Graph Shmap");
        BarGraphDriver testfire = new BarGraphDriver();
        frame.add(testfire);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
