import java.awt.*;
import java.awt.image.ImageProducer;

import javax.swing.*;


public class ScrollingImage extends JFrame {

	public ScrollingImage(){
		
		Container cp=getContentPane();
		JLabel lb = new JLabel(new ImageIcon("Sunset.jpg"));
		//ScrollPane is a pane with scroll bars
		cp.add(new JScrollPane(lb));
		
		
		setSize(400,400);
		setTitle("Scrolling Image Demo");
		setVisible(true);		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ScrollingImage myScrollingImage=new ScrollingImage();
		

	}

}
