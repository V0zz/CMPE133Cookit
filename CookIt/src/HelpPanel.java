

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HelpPanel extends JPanel {

	Font titleFont = new Font("Castellar", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 50); 
	
	public void switchPanels(JPanel panel) {
		MainFrame.layeredPane_1.removeAll();
		MainFrame.layeredPane_1.add(panel);
		MainFrame.layeredPane_1.repaint();
		MainFrame.layeredPane_1.revalidate();
	}
	
	public HelpPanel() {
		setPreferredSize(new Dimension(1600, 900));
		setBackground(Color.BLACK);
		setLayout(null);
		
		
		
		JLabel Title = new JLabel("Help");
		Title.setForeground(Color.ORANGE);
		//Title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(598, 118, 400,87);
		add(Title);
		Title.setFont(titleFont);
		
		
		JLabel optionArea = new JLabel("How to Play");
		optionArea.setBounds(100,300,600,250);
		optionArea.setBackground(Color.black);
		optionArea.setForeground(Color.white);
		optionArea.setFont(normalFont);
		//optionArea.setLineWrap(true);
		add(optionArea);
		
		
		JButton Back = new JButton("Back");
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					switchPanels(MainFrame.MainMenuPanel);
				}
			}
		});
		Back.setBackground(Color.black);
		Back.setForeground(Color.white); 
		Back.setFont(normalFont);
		Back.setBorder(null);
		Back.setBounds(650, 700, 271, 82);
		add(Back);
	}
}
