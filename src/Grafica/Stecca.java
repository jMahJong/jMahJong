package Grafica;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JLabel;
import javax.swing.JPanel;


import Gioco.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Stecca extends JPanel {
	JLabel immaginePedine[] = new JLabel[14];
	Giocatore giocatore;
        int posizione;
        private Image img;
	private static final long serialVersionUID = 1L;
	public Stecca(Giocatore giocatore, int posizione)
	{
		this(posizione);
		this.giocatore=giocatore;
                
	}
	public Stecca(int posizione) {
            try
            {
                this.img = ImageIO.read(new File("images/stecca.png"));
            }
            catch (IOException ex)
            {
                Logger.getLogger(Stecca.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.posizione=posizione;
            svuotaStecca();
	}

	public void aggiornaStecca()
	{
            ArrayList<Pedina> pedine = giocatore.getMano();
            if (posizione == Costanti.GIU)
            {
                for (int i=0;i<pedine.size();i++)
                {
                    immaginePedine[i] = new PedinaGUI(pedine.get(i),Costanti.GIU);
                }
            }
            else
            {
                for (int i=0;i<pedine.size();i++)
                {
                    immaginePedine[i] = new PedinaGUI(posizione);
                }
            } 
		
	}
	private void svuotaStecca()
	{
                 // DA COMMENTARE ALLA FINE
            if (posizione == Costanti.GIU)
		for (int i=0;i<immaginePedine.length;i++)
		{
			immaginePedine[i] = new PedinaGUI("DRAGHI_2.png",posizione);
			this.add(immaginePedine[i]);
                        
		}
            else
            {
                for (int i=0;i<immaginePedine.length;i++)
		{
			immaginePedine[i] = new PedinaGUI(posizione);
			this.add(immaginePedine[i]);
		}
            }

                // DA DECOMMENTARE ALLA FINE
//		for (int i=0;i<immaginePedine.length;i++)
//		{
//			immaginePedine[i] = new JLabel("");
//			this.add(immaginePedine[i]);
//		}
		for (int i=0;i<immaginePedine.length;i++)
		{
			immaginePedine[i].addMouseListener(new MouseAdapter() {

                @Override
				public void mousePressed(MouseEvent event) {
					immaginePremutaMouseMousePressed(event);
				}
			});
		}

	}
            @Override
	   public void paintComponent(Graphics g)
            {

                ImageIcon icon = createRotatedImage(new JPanel(),  new ImageIcon(this.img), posizione);
			//   ImageIcon icon = new ImageIcon(this.img);
				int iconWidth = icon.getIconWidth();
				int iconHeight = icon.getIconHeight();
				double iconAspect = (double) iconHeight / iconWidth;
				int w = getWidth();
				int h = getHeight();
				double canvasAspect = (double) h / w;
				int x = 0, y = 0;
				if(iconAspect < canvasAspect)
				{
					y = h;
					y = (y - h) / 2; // center it along vertical
				}
				else
				{
					x = w;
					x = (x - w) / 2; // center it along horizontal
				}
				Image immagine = icon.getImage();
				g.drawImage(immagine, x, y, w + x, h + y, 0, 0, iconWidth, iconHeight, null);
	   }
     public static ImageIcon createRotatedImage(Component c, Icon icon, double rotatedAngle)
     {
         double DEGREE_90 = 90.0 * Math.PI / 180.0;
                // convert rotatedAngle to a value from 0 to 360
                double originalAngle = rotatedAngle % 360;
                if (rotatedAngle != 0 && originalAngle == 0) {
                    originalAngle = 360.0;
                }

                // convert originalAngle to a value from 0 to 90
                double angle = originalAngle % 90;
                if (originalAngle != 0.0 && angle == 0.0) {
                    angle = 90.0;
                }

                double radian = Math.toRadians(angle);

                int iw = icon.getIconWidth();
                int ih = icon.getIconHeight();
                int w;
                int h;

                if ((originalAngle >= 0 && originalAngle <= 90) || (originalAngle > 180 && originalAngle <= 270)) {
                    w = (int) (iw * Math.sin(DEGREE_90 - radian) + ih * Math.sin(radian));
                    h = (int) (iw * Math.sin(radian) + ih * Math.sin(DEGREE_90 - radian));
                }
                else {
                    w = (int) (ih * Math.sin(DEGREE_90 - radian) + iw * Math.sin(radian));
                    h = (int) (ih * Math.sin(radian) + iw * Math.sin(DEGREE_90 - radian));
                }
                BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();
                Graphics2D g2d = (Graphics2D) g.create();

                // calculate the center of the icon.
                int cx = iw / 2;
                int cy = ih / 2;

                // move the graphics center point to the center of the icon.
                g2d.translate(w/2, h/2);

                // rotate the graphcis about the center point of the icon
                g2d.rotate(Math.toRadians(originalAngle));

                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                icon.paintIcon(c, g2d, -cx, -cy);

                g2d.dispose();
                return new ImageIcon(image);
        }
	private void immaginePremutaMouseMousePressed(MouseEvent event) {
		Object immaginePremuta = event.getSource();
		for (int i=0;i<immaginePedine.length;i++)
		{
			if (immaginePremuta == immaginePedine[i])
				System.out.println("premuta "+i);
		}

	}

}
