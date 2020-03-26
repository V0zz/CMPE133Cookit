
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
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class MainMenuPanel extends JFrame {

	private JPanel contentPane, mainMenuPan, gameMenuPan, GamePanel;
	private JPanel titleNamePanel, pot, plate, grill, namePanel;
	private JLabel titleNameLabel, nameLabel, potLabel, plateLabel, grillLabel;

	private JPanel optionPanel, buttonMenuPanel;
	// private JTextArea optionArea;

	Font titleFont = new Font("Castellar", Font.PLAIN, 120);
	Font titleFont2 = new Font("Castellar", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font nameFont = new Font("Times New Roman", Font.PLAIN, 20);

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	BackHandler backHandler = new BackHandler();
	private JLayeredPane layeredPane_1;
	private JButton btnRecipeInformation;

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./resources/cook.png")));
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

	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public MainMenuPanel() {

		MainMenu();
		optionGameScreen();
		switchPanels(mainMenuPan);
	}

	private void MainMenu() {
		// Sets the Icon at the top left
		setIcon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		// CONTENTPANE
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// MAINMENUPAN
		mainMenuPan = new JPanel();
		//layeredPane.add(mainMenuPan);
		mainMenuPan.setLayout(null);
		mainMenuPan.setBackground(Color.black);

		// GamePan
		gameMenuPan = new JPanel();
		contentPane.add(gameMenuPan);
		gameMenuPan.setLayout(null);
		gameMenuPan.setBackground(Color.black);

		// TITLE CREATED HERE "COOK IT"
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(400, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);

		titleNameLabel = new JLabel("COOK IT!");
		titleNameLabel.setForeground(Color.white);
		titleNamePanel.add(titleNameLabel);
		mainMenuPan.add(titleNamePanel);
		titleNameLabel.setFont(titleFont);

		// POT IMAGE
		pot = new JPanel();
		pot.setBounds(400, 480, 100, 150);
		pot.setBackground(Color.orange);
		mainMenuPan.add(pot);

		potLabel = new JLabel("");
		potLabel.setIcon(new ImageIcon("./src/resources/pot.png"));
		potLabel.setBounds(200, 500, 600, 150);
		pot.add(potLabel);

		// PLATE IMAGE
		plate = new JPanel();
		plate.setBounds(800, 480, 100, 150);
		plate.setBackground(Color.orange);
		mainMenuPan.add(plate);

		plateLabel = new JLabel("");
		plateLabel.setIcon(new ImageIcon("./src/resources/plate.png"));
		plateLabel.setBounds(200, 500, 600, 150);
		plate.add(plateLabel);

		// GRILL IMAGE
		grill = new JPanel();
		grill.setBounds(100, 480, 100, 150);
		grill.setBackground(Color.orange);
		// mainMenuPan.add(grill);

		grillLabel = new JLabel("");
		grillLabel.setIcon(new ImageIcon("./src/resources/grill.png"));
		grillLabel.setBounds(200, 500, 600, 150);
		// grill.add(grillLabel);

		// CREATORS
		namePanel = new JPanel();
		namePanel.setBounds(400, 250, 600, 150);
		namePanel.setBackground(Color.black);
		namePanel.setLayout(null);

		nameLabel = new JLabel("By Richard Arcangel, Krish Ghiya, Veida Hernandez, Huan Tran");
		nameLabel.setBounds(37, 5, 526, 24);
		nameLabel.setForeground(Color.orange);
		namePanel.add(nameLabel);
		mainMenuPan.add(namePanel);
		nameLabel.setFont(nameFont);

		// PLAY BUTTON

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
				btnPlay.addActionListener(tsHandler);
			}
		});
		btnPlay.setIcon(null);
		btnPlay.setBounds(522, 390, 271, 82);
		
		GamePanel = new GamePanel();
		btnRecipeInformation = new JButton("Recipes");
		btnRecipeInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2) {
					switchPanels(GamePanel);
				}
			}
		});
		btnRecipeInformation.setForeground(Color.WHITE);
		btnRecipeInformation.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnRecipeInformation.setBorder(null);
		btnRecipeInformation.setBackground(Color.BLACK);
		btnRecipeInformation.setBounds(522, 625, 271, 82);
		mainMenuPan.add(btnRecipeInformation);

		// HELP BUTTON
		JButton btnHelp = new JButton("Help");
		btnHelp.setBackground(Color.black);
		btnHelp.setForeground(Color.white);
		btnHelp.setFont(normalFont);

		btnHelp.setBorder(null);
		btnHelp.setBounds(522, 518, 271, 82);
		mainMenuPan.add(btnHelp);

		// EXIT BUTTON
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.black);
		btnExit.setForeground(Color.white);
		btnExit.setFont(normalFont);

		btnExit.setBorder(null);
		btnExit.setBounds(522, 732, 271, 82);
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

		// JLabel mainMenu = new JLabel("");

		// Image img = new
		// ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		// mainMenu.setIcon(new ImageIcon(img));
		// mainMenu.setBounds(0, 0, 1582, 853);
		// mainMenuPan.add(mainMenu);

	}

	public void optionGameScreen() {
		// mainMenuPan.setVisible(false);
		// titleNamePanel.setVisible(false);
		// pot.setVisible(false);
		// plate.setVisible(false);
		// namePanel.setVisible(false);

		

		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(0, 0, 1582, 853);
		contentPane.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));

		optionPanel = new JPanel();
		// optionPanel.setBounds(600,200,300,500);
		optionPanel.setLayout(null);
		optionPanel.setBackground(Color.black);
		layeredPane_1.add(optionPanel);

		buttonMenuPanel = new JPanel();
		buttonMenuPanel.setBounds(220, 100, 900, 100);
		buttonMenuPanel.setBackground(Color.black);

		titleNameLabel = new JLabel("Pick a level");
		titleNameLabel.setForeground(Color.white);
		buttonMenuPanel.add(titleNameLabel);
		optionPanel.add(buttonMenuPanel);
		titleNameLabel.setFont(titleFont2);

		JButton easy = new JButton("Easy");
		easy.setBackground(Color.black);
		easy.setForeground(new Color(153, 255, 153));
		easy.setFont(normalFont);

		easy.setBorder(null);
		easy.setBounds(522, 200, 271, 82);
		optionPanel.add(easy);

		JButton medium = new JButton("Medium");
		medium.setBackground(Color.black);
		medium.setForeground(new Color(255, 255, 153));
		medium.setFont(normalFont);

		medium.setBorder(null);
		medium.setBounds(522, 300, 271, 82);
		optionPanel.add(medium);

		JButton hard = new JButton("Hard");
		hard.setBackground(Color.black);
		hard.setForeground(new Color(255, 153, 153));
		hard.setFont(normalFont);

		hard.setBorder(null);
		hard.setBounds(522, 400, 271, 82);
		optionPanel.add(hard);

		JButton back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(normalFont);
		back.addActionListener(backHandler);
		back.setBorder(null);
		back.setBounds(522, 700, 271, 82);
		optionPanel.add(back);

	}

	public class TitleScreenHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			switchPanels(optionPanel);
		}

	}

	public class BackHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			switchPanels(mainMenuPan);
		}
	}
}
