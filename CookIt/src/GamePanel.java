
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
	
	String item = "None";
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 40); 
	
	public void switchPanels(JPanel panel) {
		MainFrame.layeredPane_1.removeAll();
		MainFrame.layeredPane_1.add(panel);
		MainFrame.layeredPane_1.repaint();
		MainFrame.layeredPane_1.revalidate();
	}

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public GamePanel(String recipeName) throws IOException {

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1600, 900));
		setLayout(null);
		
		JLabel final_dish = new JLabel(recipeName.split(".txt")[0].toUpperCase());
		final_dish.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		BufferedImage temp = null;
		final_dish.setBounds(50, 35, 315, 250);
		try {
		    temp = ImageIO.read(new File("./src/images/final dish/"+recipeName.replace(".txt", ".png")));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image temp_dimg = temp.getScaledInstance(final_dish.getWidth(), final_dish.getHeight(),
		        Image.SCALE_SMOOTH);
		final_dish.setIcon(new ImageIcon(temp_dimg));
		final_dish.setHorizontalTextPosition(JLabel.CENTER);
		final_dish.setVerticalTextPosition(JLabel.CENTER);
		add(final_dish);
		
		
		DefaultListModel<String> actual_order = new DefaultListModel<>();
		BufferedReader br = new BufferedReader(new FileReader("./src/images/recipes/"+"boiled egg.txt"));  
		String line = null;  
		while ((line = br.readLine()) != null)  
		{  
			if(line.equals("Game Order:")) {
				String tempLine = null;
				while ((tempLine = br.readLine()) != null) {
					if(tempLine.trim().length() > 0)
						actual_order.addElement((tempLine+".png"));
				}
				break;
			}
		} 
		
		DefaultListModel<String> selectedOrder = new DefaultListModel<>();
		
		JList instructions = new JList(selectedOrder);
		instructions.setLayoutOrientation(JList.VERTICAL);
		instructions.setCellRenderer(new FoodListRenderer());
		JScrollPane ins_scroll = new JScrollPane(instructions);
//		instructions.setBackground(Color.CYAN);
		ins_scroll.setBounds(50,  300, 325, 500);
		add(ins_scroll);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(375, 35, 1100, 250);

		for (String title : new String[] { "raw", "rice_wheat", "sauce", "vegetables", "kitchen tools" }) {
			File folder = new File("./src/images/" + title);
			JList ingredients = new JList(folder.list());
			ingredients.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			ingredients.setVisibleRowCount(4);
			ingredients.setCellRenderer(new FoodListRenderer());
			ingredients.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(item.equals("None")) {
						item = (String) ingredients.getSelectedValue();
					}
				}
			});
			JScrollPane ing_scroll = new JScrollPane(ingredients);
//			ingredients.setBackground(Color.CYAN);
			tabbedPane.add(title, ing_scroll);
		}
		
		add(tabbedPane);

		JLabel Pot = new JLabel("Pot");
		Pot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!item.equals("None")) {
					selectedOrder.addElement(item);
					item = "None";
					
					boolean win = true;
					if(actual_order.size() == selectedOrder.size()) {
						
						for(int i=0;i<actual_order.size();i++) {
							if(!selectedOrder.get(i).equals(actual_order.get(i))) {
								win = false;
								break;
							}
						}
						
						if(win) {
							System.out.println("You win!!");
							switchPanels(MainFrame.MainMenuPanel);
						}
					}
				}
			}
		});
		Pot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Pot.setForeground(Color.WHITE);
		Pot.setHorizontalAlignment(SwingConstants.CENTER);
		Pot.setBackground(Color.WHITE);
		Pot.setBounds(735, 476, 336, 259);
		BufferedImage img = ImageIO.read(new File("./src/images/kitchen tools/cooking pot.png"));
		Image dimg = img.getScaledInstance(Pot.getWidth(), Pot.getHeight(), Image.SCALE_SMOOTH);
		Pot.setIcon(new ImageIcon(dimg));
		add(Pot);
		
		JButton Back = new JButton("Quit");
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
		Back.setBounds(1300, 700, 271, 82);
		add(Back);
	}
}
