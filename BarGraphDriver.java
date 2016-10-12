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
    private int shiftX;
    private int shiftY;
    
    
    
    public BarGraphDriver()
    {
        values = new double[] {-444.1, -100000, 101022, 30, 100, 200, 100, 300, 500, 2, 1};
        barGraphHeight = 650;
        barGraphLength = 950;
        shiftX = 25;
        shiftY = 25;
        barLength = (double)barGraphLength/values.length;
    }
    
    public void setRatio()
    {
        valuesUpper = 0;
        valuesLower = 0;
        for(int i = 0; i < values.length; i ++)
        {
            
            valuesUpper = Math.max(valuesUpper, values[i]);
            valuesLower = Math.min(valuesLower, values[i]);
        }
        if (valuesLower > 0)
        {
            valuesLower = 0;
        }
        if (valuesUpper < 0)
        {
            valuesLower = 0;
        }
        barRatio = (double) barGraphHeight/(valuesUpper - valuesLower);
    }
    
    public void setBaseZero()
    {
        baseZero = valuesUpper*barRatio + shiftY;
    }
        
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        Color[] palette = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta, Color.pink, Color.lightGray};
                  
        setRatio();
        setBaseZero();
        g2.drawLine(0,(int)baseZero, barGraphLength,(int)baseZero);
        for (int i = 0; i < values.length; i++)
        {
            g2.setColor(palette[i%8]);
            if (values[i]>=0)
            {
                g2.drawRect((int)barLength*i + shiftX, (int)(baseZero-(barRatio*values[i])), (int)barLength, (int)(barRatio*values[i]));        
                g2.fill(new Rectangle((int)barLength*i  + shiftX, (int)(baseZero-(barRatio*values[i])), (int)barLength, (int)(barRatio*values[i])));
                g2.setColor(Color.black);
                g2.drawString(""+values[i],(int)(barLength*i) + shiftX,(int)(baseZero-(barRatio*values[i])));
            }
            else
            {
                 g2.drawRect((int)barLength*i + shiftX, (int)baseZero, (int)barLength, (int)Math.abs(barRatio*values[i]));
                 g2.fill(new Rectangle((int)barLength*i + shiftX, (int)baseZero, (int)barLength, (int)Math.abs(barRatio*values[i])));
                 g2.setColor(Color.black);
                 g2.drawString(""+values[i],(int)barLength*i + shiftX,(int)baseZero+(int)(Math.abs(barRatio*values[i])));
            }
        }
    }
}
