package Grafica;

import java.awt.Graphics;

import java.awt.Image;

import java.io.File;

import java.io.IOException;

import java.net.MalformedURLException;





import javax.imageio.ImageIO;


import javax.swing.ImageIcon;

import javax.swing.JPanel;


public class Sfondo extends JPanel {
	   private Image img;
           private boolean mantieniProporzioni = false;
           public Sfondo(String percorsoImmagineDiSfondo, boolean mantieniProporzioni)
            {
               this(percorsoImmagineDiSfondo);
               this.mantieniProporzioni = mantieniProporzioni;
            }
	   public Sfondo(String percorsoImmagineDiSfondo)
	   {
               try
               {
                   this.img = ImageIO.read(new File(percorsoImmagineDiSfondo));
               }
               catch (MalformedURLException e) {}
               catch (IOException e) {}
           }
    @Override
	   public void paintComponent(Graphics g) {
            if (mantieniProporzioni == false)
            {
			   ImageIcon icon = new ImageIcon(this.img);
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
                else
                {
                    
/////////////ROTAZIONE INIZIO
//		//	int angle = 90;
//			Graphics2D g2 = (Graphics2D)g;
//	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//	        AffineTransform aT = g2.getTransform();
//	        Shape oldshape = g2.getClip();
//	        double x1 = getWidth()/2.0;
//	        double y1 = getHeight()/2.0;
//	        aT.rotate(Math.toRadians(angle), x1, y1);
//	        g2.setTransform(aT);
//	        g2.setClip(oldshape);
//	        ///// ROTAZIONE FINE
		 ImageIcon icon = new ImageIcon(this.img);
		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		double iconAspect = (double) iconHeight / iconWidth;

		int w = getWidth();
		int h = getHeight();
		double canvasAspect = (double) h / w;

		int x = 0, y = 0;

		// Maintain aspect ratio.
		if(iconAspect < canvasAspect)
		{
			// Drawing space is taller than image.
			y = h;
			h = (int) (w * iconAspect);
			y = (y - h) / 2; // center it along vertical
                //        y = (y - h); // OK PER LA STECCA GIU///////////////////

		}
		else
		{
			// Drawing space is wider than image.
			x = w;
			w = (int) (h / iconAspect);
			x = (x - w) / 2; // center it along horizontal
                //       x = (x - w) ; // OK PER LA STECCA A DESTRA///////////////////
		}
		Image img = icon.getImage();
//		g.drawImage(img, x, y, w + x, h + y, 0, 0, iconWidth, iconHeight, null);

        //super.paintComponent(g);
        g.drawImage(img, x, y, w + x, h + y, 0, 0, iconWidth, iconHeight, null);
	
                }
            }



}

