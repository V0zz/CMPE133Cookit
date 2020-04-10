
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {

	private class FoodListRenderer extends DefaultListCellRenderer {

		Font font = new Font("helvitica", Font.BOLD, 24);

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			String param = (String) value;
			String name = param.replace(".png", "");
			JLabel label = (JLabel) super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
			
			String temp = null;
			for (String title : new String[] { "raw", "rice_wheat", "sauce", "vegetables", "kitchen tools"}) {
				File folder = new File("./src/images/" + title);
				String[] values = folder.list();
				for(String s: values) {
					if(s.equals(param)) {
						temp = title;
						break;
					}
				}
				if(temp != null) break;
			}
			
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("./src/images/" + temp + "/" + param));	
			} catch (IOException e) {
				System.out.println("Couldn't find image");
			}
			label.setIcon(new ImageIcon(img));
			label.setHorizontalTextPosition(JLabel.RIGHT);
			label.setFont(font);
			return label;
		}
	}

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public GamePanel() throws IOException {

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1600, 900));
		setLayout(null);
		
		File f = new File("./src/images/kitchen tools");
		JList instructions = new JList(f.list());
		instructions.setLayoutOrientation(JList.VERTICAL);
		instructions.setCellRenderer(new FoodListRenderer());
		JScrollPane ins_scroll = new JScrollPane(instructions);
		instructions.setBackground(Color.CYAN);
		ins_scroll.setBounds(50,  300, 325, 500);
		add(ins_scroll);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(375, 35, 1100, 250);

		for (String title : new String[] { "raw", "rice_wheat", "sauce", "vegetables" }) {
			File folder = new File("./src/images/" + title);
			JList ingredients = new JList(folder.list());
			ingredients.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			ingredients.setVisibleRowCount(4);
			ingredients.setCellRenderer(new FoodListRenderer());
			JScrollPane ing_scroll = new JScrollPane(ingredients);
			ingredients.setBackground(Color.CYAN);
			tabbedPane.add(title, ing_scroll);
		}
		add(tabbedPane);

		JLabel Pot = new JLabel("Pot");
		Pot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = "TEMP";
				if (obj != null) {
					System.out.println((String) obj);
				} else
					System.out.println("null");
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
	}
}
