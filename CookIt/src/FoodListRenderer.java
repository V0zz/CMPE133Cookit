import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class FoodListRenderer extends DefaultListCellRenderer {
		
		String[] folders = new String[] {"raw", "rice_wheat", "sauce", "vegetables", "kitchen tools"};
		Font font = new Font("helvitica", Font.BOLD, 24);
		
		public FoodListRenderer() {
			super();
		}
		
		public FoodListRenderer(String[] folders) {
			this.folders = folders.clone();
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			String param = (String) value;
			String name = param.split("\\.")[0];
			param = name+".png";
			JLabel label = (JLabel) super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
			
			String temp = null;
			for (String title : folders) {
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
				System.out.println("Couldn't find image "+param);
			}
			label.setIcon(new ImageIcon(img));
			label.setHorizontalTextPosition(JLabel.RIGHT);
			label.setFont(font);
			return label;
		}
}