
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
    }
