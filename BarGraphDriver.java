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
import java.awt.geom.Line2D;

public class BarGraphDriver extends JComponent
{
    private double[] values;
    private int barGraphHeight;
    private int barGraphLength;
    private double barLength;
    private double baseZero;
    private double barRatio;
    private double valuesUpper;
    private double valuesLower;
    
    
    public BarGraphDriver()
    {
        values = new double[] {444.1,-1000, 2102.2, 30, 100};
        barGraphLength = 1000;
        barGraphHeight = 1000;
        barLength = (double)barGraphLength/values.length;
    }
    
    public void setRatio()
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
        barRatio = (double)(valuesUpper - valuesLower) / barGraphHeight;
    }
    
    public void setBaseZero()
    {
        baseZero = 400;
    }
        
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        Color[] palette = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta, Color.pink, Color.black};
                  
        setRatio();
        setBaseZero();
        g2.drawLine(0,(int)baseZero, barGraphLength,(int)baseZero);
        for (int i = 0; i < values.length; i++)
        {
            g2.setColor(palette[i%8]);
            if (values[i]>=0)
            {
                g2.drawRect((int)barLength*i, (int)(baseZero-(barRatio*values[i])), (int)barLength, (int)(barRatio*values[i]));        
                g2.fill(new Rectangle((int)barLength*i, (int)(baseZero-(barRatio*values[i])), (int)barLength, (int)(barRatio*values[i])));
                g2.setColor(Color.black);
                g2.drawString(""+values[i],(int)barLength*i,(int)(baseZero-(barRatio*values[i])));
            }
            else
            {
                 g2.drawRect((int)barLength*i, (int)baseZero, (int)barLength, (int)Math.abs(barRatio*values[i]));
                 g2.fill(new Rectangle((int)barLength*i, (int)baseZero, (int)barLength, (int)Math.abs(barRatio*values[i])));
                 g2.setColor(Color.black);
                 g2.drawString(""+values[i],(int)barLength*i,(int)baseZero+(int)(Math.abs(barRatio*values[i])+10));
            }
        }
    }
}
