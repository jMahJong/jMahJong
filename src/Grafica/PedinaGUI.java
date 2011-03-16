package Grafica;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;



import javax.swing.*;

import Gioco.Costanti;
import Gioco.Pedina;
import java.awt.Color;

public class PedinaGUI extends JLabel{
	private static final long serialVersionUID = 1L;
	int seme;
	int valore;
	String nomeImmagine;
	int angle = 0;
	public PedinaGUI(String immagine,int gradi)
	{
		this.nomeImmagine = immagine;
		impostaImmagine();
	}
	public PedinaGUI(int gradi)
	{
		this.angle=gradi;
		nomeImmagine = "background.png";
		impostaImmagine();
	}
	public PedinaGUI(Pedina pedina,int gradi)
	{
		seme = pedina.getSeme();
		valore = pedina.getValore();
		
		nomeImmagine=null;
		if (seme == Costanti.DRAGHI)
		{
			nomeImmagine = "DRAGHI_";
		}	
		if (seme == Costanti.VENTI)
		{
			nomeImmagine = "VENTI_";
		}
		if (seme == Costanti.FIORI)
		{
			nomeImmagine = "FIORI_";
		}
		if (seme == Costanti.STAGIONI)
		{
			nomeImmagine = "STAGIONI_";
		}	
		if (seme == Costanti.CANNE)
		{
			nomeImmagine = "CANNE_";
		}
		if (seme == Costanti.PALLE)
		{
			nomeImmagine = "PALLE_";
		}
		if (seme == Costanti.SCRITTI)
		{
			nomeImmagine = "SCRITTI_";
		}
		nomeImmagine = nomeImmagine+valore;
		
		nomeImmagine = nomeImmagine+".png";
		impostaImmagine();
	}
	private void impostaImmagine()
	{
		this.setIcon(new ImageIcon("images/"+nomeImmagine));
	}
    @Override
	protected void paintComponent(Graphics g)
	 {
		ImageIcon icon = createRotatedImage(new JLabel(),  getIcon(), angle);
	//	ImageIcon icon = (ImageIcon) getIcon();
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
			//y = (y - h) / 2; // center it along vertical
                        y = (y - h); // OK PER LA STECCA GIU///////////////////

		}
		else
		{
			// Drawing space is wider than image.
			x = w;
			w = (int) (h / iconAspect);
			//x = (x - w) / 2; // center it along horizontal
                        x = (x - w) ; // OK PER LA STECCA A DESTRA///////////////////
		}
		Image img = icon.getImage();
                /*switch(angle){
                    case 0:{
                        y+=25;
                        break;
                    }
                    case 90:{
                        x-=22;
                        break;
                    }
                    case 180:{
                        y-=13;
                        break;
                    }
                    case 270:{
                        x+=30;
                        break;
                    }
                }*/
                g.drawImage(img, x, y, w + x, h + y, 0, 0, iconWidth, iconHeight, null);
	}
	final static double DEGREE_90 = 90.0 * Math.PI / 180.0;

    /**
     * Creates a rotated version of the input image.
     *
     * @param c            The component to get properties useful for painting, e.g. the foreground
     *                     or background color.
     * @param icon         the image to be rotated.
     * @param rotatedAngle the rotated angle, in degree, clockwise. It could be any double but we
     *                     will mod it with 360 before using it.
     *
     * @return the image after rotating.
     */
    public static ImageIcon createRotatedImage(Component c, Icon icon, double rotatedAngle) {
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
}
