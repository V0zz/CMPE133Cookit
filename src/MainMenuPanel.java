

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class MainMenuPanel extends JFrame {

	private JPanel contentPane;
	private JPanel transferPan;
	private JPanel mainMenuPan;
	private JPanel titleNamePanel;
	private JPanel pot;
	private JPanel plate;
	private JPanel grill;
	private JPanel namePanel;
	private JLabel nameLabel;
	private JLabel titleNameLabel;
	private JLabel potLabel;
	private JLabel plateLabel;
	private JLabel grillLabel;
	Font titleFont = new Font("Castellar",Font.PLAIN, 120); 
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 50); 
	Font nameFont = new Font("Times New Roman",Font.PLAIN, 20); 
	private JLayeredPane layeredPane;

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("cook.png")));
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {


			public void run() {
				try {
					MainMenuPanel frame = new MainMenuPanel();
					frame.setPreferredSize(new Dimension(1600, 900));
					frame.setLocationRelativeTo(null);
					frame.pack();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}


	/**
	 * Create the frame.
	 */
	public MainMenuPanel() {
		//Sets the Icon at the top left
		setIcon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		//CONTENTPANE
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//LAYEREDPANE
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1582, 853);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		//MAINMENUPAN
		mainMenuPan = new JPanel();
		layeredPane.add(mainMenuPan);
		mainMenuPan.setLayout(null);
		mainMenuPan.setBackground(Color.black);

		// TITLE CREATED HERE "COOK IT"
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(400, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);

		titleNameLabel = new JLabel("COOK IT!");
		titleNameLabel.setForeground(Color.white);
		titleNamePanel.add(titleNameLabel);
		mainMenuPan.add(titleNamePanel);
		titleNameLabel.setFont(titleFont);

		//POT IMAGE 
		pot = new JPanel();
		pot.setBounds(400, 480, 100, 150);
		pot.setBackground(Color.orange);
		mainMenuPan.add(pot);

		potLabel = new JLabel("");
		potLabel.setIcon(new ImageIcon(MainMenuPanel.class.getResource("pot.png")));
		potLabel.setBounds(200, 500, 600, 150);
		pot.add(potLabel);

		//PLATE IMAGE 
		plate = new JPanel();
		plate.setBounds(800, 480, 100, 150);
		plate.setBackground(Color.orange);
		mainMenuPan.add(plate);

		plateLabel = new JLabel("");
		plateLabel.setIcon(new ImageIcon(MainMenuPanel.class.getResource("plate.png")));
		plateLabel.setBounds(200, 500, 600, 150);
		plate.add(plateLabel);

		//GRILL IMAGE
		grill = new JPanel();
		grill.setBounds(100,480, 100, 150);
		grill.setBackground(Color.orange);
		//mainMenuPan.add(grill);

		grillLabel = new JLabel("");
		grillLabel.setIcon(new ImageIcon(MainMenuPanel.class.getResource("grill.png")));
		grillLabel.setBounds(200, 500, 600, 150);
		//grill.add(grillLabel);

		// CREATORS
		namePanel = new JPanel();
		namePanel.setBounds(400, 250, 600, 150);
		namePanel.setBackground(Color.black);

		nameLabel = new JLabel("By Richard Arcangel, Krish Ghiya, Veida Hernandez, Huan Tran");
		nameLabel.setForeground(Color.orange);
		namePanel.add(nameLabel);
		mainMenuPan.add(namePanel);
		nameLabel.setFont(nameFont);



		//PLAY BUTTON 
		JButton btnPlay = new JButton("Play"); 
		btnPlay.setBackground(Color.black);
		btnPlay.setForeground(Color.white); 
		btnPlay.setFont(normalFont);

		mainMenuPan.add(btnPlay);
		btnPlay.setBorder(null);
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlay.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("New game button");
			}
		});
		btnPlay.setIcon(null);
		btnPlay.setBounds(522, 390, 271, 82);

		//HELP BUTTON
		JButton btnHelp = new JButton("Help");
		btnHelp.setBackground(Color.black);
		btnHelp.setForeground(Color.white); 
		btnHelp.setFont(normalFont);

		btnHelp.setBorder(null);
		btnHelp.setBounds(522, 518, 271, 82);
		mainMenuPan.add(btnHelp);

		//EXIT BUTTON
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.black);
		btnExit.setForeground(Color.white); 
		btnExit.setFont(normalFont);

		btnExit.setBorder(null);
		btnExit.setBounds(522, 640, 271, 82);
		mainMenuPan.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});


		JLabel mainMenu = new JLabel("");

		//Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		//mainMenu.setIcon(new ImageIcon(img));
		mainMenu.setBounds(0, 0, 1582, 853);
		mainMenuPan.add(mainMenu);


	}


}

