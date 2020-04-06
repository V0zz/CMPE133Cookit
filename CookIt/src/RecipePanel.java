
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;

public class RecipePanel extends JPanel {

	Font titleFont = new Font("Castellar", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 50); 
	
	public void switchPanels(JPanel panel) {
		MainFrame.layeredPane_1.removeAll();
		MainFrame.layeredPane_1.add(panel);
		MainFrame.layeredPane_1.repaint();
		MainFrame.layeredPane_1.revalidate();
	}
	
	/**
	 * Create the panel.
	 */
	public RecipePanel() {
		setPreferredSize(new Dimension(1600, 900));
		setBackground(Color.BLACK);
		setLayout(null);
		
		JList info = new JList();
		info.setBounds(846, 246, 291, 341);
		add(info);
		
		File folder = new File("./src/final dish");
		String[] recipes = folder.list();
		JList recipeList = new JList(recipes);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) recipeList.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		recipeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					info.setListData(new String[] {(String) recipeList.getSelectedValue()});
				}
			}
		});
		
		recipeList.setBounds(432, 246, 291, 341);
		add(recipeList);
		
		JLabel Title = new JLabel("Recipe List");
		Title.setForeground(Color.ORANGE);
		//Title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(598, 118, 400,87);
		add(Title);
		Title.setFont(titleFont);
		
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
