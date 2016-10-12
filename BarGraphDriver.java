
/**
 * Write a description of class BarGraphDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class BarGraphDriver extends JComponent
{
    private double[] values;
    private int barGraphHeight;
    private int barGraphLength;
    private int barLength;
    private double baseLine;
    private double barRatio;
    private double valuesUpper;
    private double valuesLower;
    
    
    public BarGraphDriver()
    {
        values[] = {4,-610.5, 2102};
        barGraphLength = 1000;
        
        barLength = barGraphLength/values.length;
    }
    
    public void setterMaxMin()
    {
        double varsCur = 0;
        for(int i = 0; i < values.length; i ++)
        {
            valuesUpper = Math.max(varsCur, values[i]);
            valuesLower = Math.min(varsCur, values[i]);
        }
        if (valuesLower > 0)
        {
            valuesLower = 0;
        }
        if (valuesUpper < 0)
        {
            valuesLower = 0;
        }
        public void draw()
    {
        Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray,
                  Color.green, Color.lightGray, Color.magenta, Color.magenta,
                  Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
        
       public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray,
                  Color.green, Color.lightGray, Color.magenta, Color.magenta,
                  Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
        
        for (int i = 0; i < values.length; i++)
        {
            g.setColor(colors[i]);
            if (values[i]>=0)
            {
                g2.drawRect(barLength, (int)(baseLine-(barRatio*values[i])), (int)barLength+(barLength*i), (int)barRatio-500);          
            }
            else
            {
                 g2.drawRect(barLength, barGraphHeight, (int)(barLength+(barLength*i)), (int)baseLine);
            }
        }
    }
    }
