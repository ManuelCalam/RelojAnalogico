import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sala{
    Reloj reloj = new Reloj();
    Animacion analogWatch = new Animacion(reloj);

    public Sala(){
        JFrame frame = new JFrame("Reloj análogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); 

        JPanel fondo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D figDegradado = (Graphics2D) g;
                GradientPaint degradado = new GradientPaint(280, 60, new Color(0x035E7B), 380, 160, new Color(0x00AAE2), false);
                
                ImageIcon imagenFondo = new ImageIcon("src/fondo.jpg");
                Image imagen = imagenFondo.getImage();
                g.drawImage(imagen, 0, 0, 900, 700, this);
                
                
                int radius = 100;
                int Xcenter = 300 + radius;
                int Ycenter = 90 + radius;
                
                g.setColor(Color.black);
                g.fillOval(278, 58, 234, 234);
                figDegradado.setPaint(degradado);
                figDegradado.fillOval(280, 60, 230, 230);
                g.setColor(Color.white);
                g.fillOval(295, 75, 200, 200);
        
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.setColor(Color.BLACK);
        
        
                for(int i = 1; i<13; i++){
                    double angulo = Math.toRadians(360 / 12 * i);
                    int x = (int) (Xcenter + (radius - 15) * Math.sin(angulo));
                    int y = (int) (Ycenter - (radius -15) * Math.cos(angulo)); 
                    g.drawString(String.valueOf(i), x-10, y-10);        
                }

            }
        };

        frame.setLocationRelativeTo(null);
        frame.setContentPane(fondo);

        
        reloj.setBounds(0, 0, 800, 600);
        frame.add(reloj);

        analogWatch.start();

        
        frame.setVisible(true);
    }
}
