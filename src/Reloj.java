import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;



public class Reloj extends JPanel{
    private final int radius = 90;
    private final int Xcenter = 315 + radius;
    private final int Ycenter = 78 + radius;

    int [] time = {0, 0, 0};
    public double angleForSeconds = 0;
    public double angleForMinutes = 0;
    public double angleForHours = 0;
    

    public Reloj() {
        setOpaque(false); // Hacer el panel transparente
    }
    
    @Override
    public void paintComponent(Graphics g){    
        Graphics2D lineas = (Graphics2D) g;
        float guines[] = {4};
        float guines2[] = {2};

        
        super.paintComponent(g);
        System.out.println(time[0]+":"+time[1]+":"+time[2]);

        lineas.setStroke(new BasicStroke(4, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, guines, 0));
        int x = (int) (Xcenter + (radius-25) * Math.sin(angleForHours));
        int y = (int) (Ycenter - (radius-25) * Math.cos(angleForHours)); 
        g.drawLine(Xcenter, Ycenter, x, y);  
        
        lineas.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, guines2, 0));
        g.setColor(Color.RED);
        x = (int) (Xcenter + radius * Math.sin(angleForSeconds));
        y = (int) (Ycenter - radius * Math.cos(angleForSeconds)); 
        lineas.drawLine(Xcenter, Ycenter, x, y);        
        
        lineas.setStroke(new BasicStroke(4, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, guines, 0));
        g.setColor(Color.BLACK);
        x = (int) (Xcenter + radius * Math.sin(angleForMinutes));
        y = (int) (Ycenter - radius * Math.cos(angleForMinutes)); 
        lineas.drawLine(Xcenter, Ycenter, x, y);       

        
        // int x = (int) (Xcenter + radius * Math.sin(angleForHours));
        // int y = (int) (Ycenter - radius * Math.cos(angleForHours)); 
        // g.drawLine(Xcenter, Ycenter, x, y);       
        

    }

    public void updateTime(int newTime[]){
        time = newTime.clone();  
        angleForSeconds = Math.toRadians(360 / 60 * time[2]);
        angleForMinutes = Math.toRadians(360 / 60 * time[1]);
        angleForHours = Math.toRadians(360 / 12 * time[0]);
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    
}