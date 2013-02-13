import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class ScribbleApplet extends JInternalFrame implements InternalFrameListener {

	JPanel customizePanel;
	JPanel buttonPanel;
	JPanel topPanel;
	JPanel bottomPanel;
	JPanel sizePanel;
	JPanel colorPanel;
	JButton clear;
	Image img;


	JPanel rP, gP, bP;
	JLabel rL, gL, bL;

	JScrollBar rS,gS,bS,size;

	Color brush;
	int rV,gV,bV,sizeV=10;
	
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	


	public ScribbleApplet(){
		 super("Document #" + (++openFrameCount),
		          true, 
		          true,
		          true 
		          );
		    //...Create the GUI and put it in the window...
		    //...Then set the window size or call pack...
		 
		    //Set the window's location.
		    setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		super.addInternalFrameListener(this);
		setSize(500,600);
		setGUI();
	}
	
	public void setGUI(){
		img = createImage(1000,1000);
		setSize(400,500);
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		customizePanel = new JPanel();
		buttonPanel = new JPanel();
		sizePanel = new JPanel();
		colorPanel = new JPanel();

		setLayout(new GridLayout(2,1,5,5));
		add(topPanel);
		add(bottomPanel);


		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonPanel,BorderLayout.SOUTH);
		bottomPanel.add(customizePanel,BorderLayout.CENTER);


		size = new JScrollBar(JScrollBar.VERTICAL,10,0,1,20);
		customizePanel.setLayout(new BorderLayout());
		customizePanel.add(sizePanel,BorderLayout.WEST);
		customizePanel.add(colorPanel,BorderLayout.CENTER);

		sizePanel.setLayout(new GridLayout(1,1,0,0));
		sizePanel.add(size);


		colorPanel.setLayout(new GridLayout(3,1,1,1));


		rS = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,256);
		gS = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,256);
		bS = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,256);

		rP = new JPanel(new BorderLayout());
		rP.add(rS, BorderLayout.CENTER);
		rL = new JLabel("R(000)");
		rP.add(rL,BorderLayout.WEST);

		gP = new JPanel(new BorderLayout());
		gP.add(gS, BorderLayout.CENTER);
		gL = new JLabel("G(000)");
		gP.add(gL,BorderLayout.WEST);

		bP = new JPanel(new BorderLayout());
		bP.add(bS, BorderLayout.CENTER);
		bL = new JLabel("B(000)");
		bP.add(bL,BorderLayout.WEST);


		colorPanel.add(rP);
		colorPanel.add(gP);
		colorPanel.add(bP);

		rS.addAdjustmentListener(new SliderHandler());
		gS.addAdjustmentListener(new SliderHandler());
		bS.addAdjustmentListener(new SliderHandler());
		size.addAdjustmentListener(new SliderHandler());


		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(clear = new JButton("Clear Screen"));
		clear.addActionListener(new ButtonHandler());
	

	}






	class ButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
			/*JButton btt = (JButton)e.getSource();
			if (btt.getLabel().equals("Clear Screen")){
				Graphics g = drawingArea.getGraphics();

				g.setColor(Color.WHITE);
				g.fillRect(0,0,1000,1000);
				Graphics clearscreen = img.getGraphics();
				clearscreen.setColor(Color.WHITE);
				clearscreen.fillRect(0,0,1000,1000);
			}*/
		}
	}

	class SliderHandler implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			String vS = "";
			int v = ((JScrollBar) e.getSource()).getValue();
			if(v/10 == 0) vS = "00"+v;
			else if(v/100 == 0) vS = "0"+v;
			else vS = ""+v;

			if((JScrollBar) e.getSource() == rS){
				rV = v;
				rL.setText("R("+vS+")");

			}else if((JScrollBar) e.getSource() == gS){
				gV = v;
				gL.setText("G("+vS+")");

			}else if((JScrollBar) e.getSource() == bS){
				bV = v;
				bL.setText("B("+vS+")");
			}else if((JScrollBar) e.getSource() == size){
				sizeV = v;
			}
			brush = new Color(rV,gV,bV);
		}

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		if(openFrameCount!=1){
			openFrameCount--;}
			else openFrameCount = 0;
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	/*class MyCanvas extends JPanel{

		Image buffer;
		Graphics background;

		
		
		public MyCanvas(){
				addMouseMotionListener(new MouseMotionAdapter(){
					public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			Graphics draw = img.getGraphics();
			draw.setColor(brush);

			draw.fillOval(x-10,y-10,21-sizeV,21-sizeV);
			g.drawImage(img, 0, 0, drawingArea);

			e.consume();
			repaint();
				}
				});}


		public void paintComponent(Graphics g) {
			Dimension d = this.getSize();
			buffer = createImage(d.width,d.height);
			background = buffer.getGraphics();
			background.setColor(Color.WHITE);
			background.fillRect(0, 0, d.width, d.height);
			g.drawImage(buffer, 0, 0, this);
		}
		
		
	}
*/
	
	
}

