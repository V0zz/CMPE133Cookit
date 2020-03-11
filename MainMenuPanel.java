

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
	private JLayeredPane layeredPane;
	

	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1582, 853);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		mainMenuPan = new JPanel();
		layeredPane.add(mainMenuPan, "name_1876842692619100");
		mainMenuPan.setLayout(null);
		
		JButton playButton = new JButton("Play");
		
		mainMenuPan.add(playButton);
		playButton.setBorder(null);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("New game button");
			}
		});
		playButton.setIcon(null);
		playButton.setBounds(822, 390, 271, 82);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBorder(null);
		btnHelp.setBounds(822, 518, 271, 82);
		mainMenuPan.add(btnHelp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(null);
		btnExit.setBounds(822, 640, 271, 82);
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
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		mainMenu.setIcon(new ImageIcon(img));
		mainMenu.setBounds(0, 0, 1582, 853);
		mainMenuPan.add(mainMenu);
		
		
	}
	
	
}
