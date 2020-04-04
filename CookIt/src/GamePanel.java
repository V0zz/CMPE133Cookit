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
	
	private String[] images;
	
	private class FoodListRenderer extends DefaultListCellRenderer {

	    Font font = new Font("helvitica", Font.BOLD, 24);

	    @Override
	    public Component getListCellRendererComponent(
	            JList list, Object value, int index,
	            boolean isSelected, boolean cellHasFocus) {

	        JLabel label = (JLabel) super.getListCellRendererComponent(
	                list, value, index, isSelected, cellHasFocus);
	        BufferedImage img = null;
			try {
				img = ImageIO.read(new File("./src/ingredients/raw/" + ((String) value)));
			} catch (IOException e) {
			}
			Image temp = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        label.setIcon(new ImageIcon(temp));
	        label.setHorizontalTextPosition(JLabel.RIGHT);
	        label.setFont(font);
	        return label;
	    }
	}
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public GamePanel() throws IOException {
		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1600, 900));
		setLayout(null);
		
		JList instructions = new JList();
		instructions.setBounds(105, 189, 276, 598);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) instructions.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		add(instructions);
		
		File folder = new File("./src/ingredients/raw");
		images = folder.list();
		JList ingredients = new JList(images);
		ingredients.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		ingredients.setCellRenderer(new FoodListRenderer());
		ingredients.setBounds(382, 10, 801, 169);
		JScrollPane scroll = new JScrollPane(ingredients);
		scroll.setSize(900, 160);
		scroll.setLocation(385, 30);
        scroll.setPreferredSize(new Dimension(300, 400));
		add(scroll);
		
		JLabel Pot = new JLabel("Pot");
		Pot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = ingredients.getSelectedValue();
				if(obj != null) {
					System.out.println((String) obj);
				}
				else System.out.println("null");
			}
		});
		Pot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Pot.setForeground(Color.WHITE);
		Pot.setHorizontalAlignment(SwingConstants.CENTER);
		Pot.setBackground(Color.WHITE);
		Pot.setBounds(718, 355, 336, 259);
		BufferedImage img = ImageIO.read(new File("./src/kitchen tools/cooking pot.png"));
		Image dimg = img.getScaledInstance(Pot.getWidth(), Pot.getHeight(), Image.SCALE_SMOOTH);
		Pot.setIcon(new ImageIcon(dimg));
		add(Pot);
	}
}