import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;

public class ScribbleShop extends JFrame {
	
	static JDesktopPane desktop;
	JMenuBar menuBar;
	JMenu fileMenu,aboutMenu;
	JMenuItem newItem, closeItem, closeAllItem, exitItem, helpItem, authorItem;
	
	
	public ScribbleShop(){
		setGUI();
	}

	public void setGUI(){
		desktop = new JDesktopPane();
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		newItem = new JMenuItem("New");
		closeItem = new JMenuItem("Close");
		closeAllItem = new JMenuItem("Close All");
		exitItem = new JMenuItem("Exit");
		
		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(closeItem);
		fileMenu.add(closeAllItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
		aboutMenu = new JMenu("About");
		helpItem = new JMenuItem("Help");
		authorItem = new JMenuItem("Author");
		
		aboutMenu.add(helpItem);
		aboutMenu.add(authorItem);
		
		menuBar.add(aboutMenu);
		
		setJMenuBar(menuBar);
		setMenuAction();
		setContentPane(desktop);
	}
	
	private void setMenuAction() {
		
		fileMenu.setMnemonic('f');
		aboutMenu.setMnemonic('a');
		
		newItem.setAccelerator(KeyStroke.getKeyStroke((KeyEvent.VK_N),ActionEvent.CTRL_MASK));
		newItem.addActionListener(new MenuListener());
		
		closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		closeItem.addActionListener(new MenuListener());
		
		closeAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.SHIFT_MASK));
		closeAllItem.addActionListener(new MenuListener());
		
		exitItem.addActionListener(new MenuListener());
		
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpItem.addActionListener(new MenuListener());
		
		authorItem.addActionListener(new MenuListener());
		
	}
	
	public static void newWindow(){
		ScribbleApplet prog = new ScribbleApplet();
		prog.setSize(500, 600);
		prog.setVisible(true);
		desktop.add(prog);
		try {
			prog.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() 
			{
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		ScribbleShop mainProgram = new ScribbleShop();
		mainProgram.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		mainProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainProgram.pack();
		mainProgram.setVisible(true);
		
	}
	
	class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			AbstractButton src = (AbstractButton) e.getSource();
			if (src.getText().equals("New")){
				ScribbleShop.newWindow();
			} else if (src.getText().equals("Close")){
				try {
					if(ScribbleShop.desktop.getSelectedFrame() != null){
					ScribbleShop.desktop.getSelectedFrame().setClosed(true);}
					
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (src.getText().equals("Close All")){
					while(ScribbleShop.desktop.getSelectedFrame() != null){
					try {
						ScribbleShop.desktop.getSelectedFrame().setClosed(true);
						
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
			} else if (src.getText().equals("Exit")){
					System.exit(0);
			} else if (src.getText().equals("Help")){
					doHelp();
			} else if (src.getText().equals("Author")){
					doAuthor();
			}
			
		}

		private void doHelp() {
			final JDialog help = new JDialog();
			help.setSize(500,300);
			JLabel txt = new JLabel();
			txt.setVerticalAlignment(JLabel.CENTER);
			txt.setHorizontalAlignment(JLabel.CENTER);
			txt.setFont(new Font("Cooper",Font.BOLD, 25));
			txt.setForeground(Color.RED);
			txt.setText("HELP YOURSELF !!!!");
			help.getContentPane().add(txt);
			
			help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			help.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					help.dispose();
				}
			});
			help.setModal(true);
			help.setLocationRelativeTo(null);
			help.setResizable(false);
			help.setVisible(true);
		}

		private void doAuthor() {
			final JDialog author = new JDialog();
			author.setLayout(new BorderLayout());
			author.getContentPane().add(new MyAvatar(), BorderLayout.CENTER);
			author.addMouseListener(new MouseAdapter(){
				public void mouseClicked(ActionEvent e){
					author.dispose();
				}
			});
			author.setModal(true);
			author.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			author.setSize(700,800);
			author.setLocationRelativeTo(null);
			author.setResizable(false);
			author.setVisible(true);
		}
		
	}
}
