package certificate;

import forms.MainForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generate {
	
    public void eatheletic() throws IOException {
        FileOutputStream fout;
        String iname;
			
        int i=1;


        String first = "Chinnasway Mutthuswamy";
        String last = "Venugopal Aiyer";
        String event = "Robowars - 60kg";
	        

        //Display values
        iname = JOptionPane.showInputDialog(null, "Give path to blank certificate", "Blank Certificate", JOptionPane.QUESTION_MESSAGE);
//        iname = new String("/home/vineet/Devangi/Athletic.jpg");
	    BufferedImage im = ImageIO.read(new File(iname));
	    Point pointName = new Point(MainForm.getxName(), MainForm.getyName());
	    Point pointEvent = new Point(MainForm.getxEventName(), MainForm.getyEventName());
	       
        byte[] b = mergeImageAndText(im, first + " "+last, event, pointName, pointEvent);
        fout = new FileOutputStream("Athletic "+i+".jpg ");
        fout.write(b);
        fout.close();
        i++;
        System.out.println("First: " + first);
        System.out.println("Last: " + last);
	        
	   System.out.println("Goodbye!");
	}//end main
	//end JDBCExample

	private static byte[] mergeImageAndText(BufferedImage im, String name, String event, Point pointName, Point pointEvent) throws IOException {
		Graphics2D g2 = im.createGraphics(); //graohics obj banaya to draw
		System.out.println(name);
		g2.setFont(new Font("TimesRoman", Font.BOLD,28));
		g2.setColor(Color.BLACK);
		g2.drawString(name, pointName.x, pointName.y);//write text
		g2.drawString(event, pointEvent.x, pointEvent.y);//write text
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(im, "jpg", baos);
		return baos.toByteArray();
	}

}


