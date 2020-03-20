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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		File folder = new File("./src/final dish");
		String[] recipes = folder.list();
		JList list = new JList(recipes);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					System.out.println(list.getSelectedValue());
				}
			}
		});
		
		list.setBounds(197, 97, 291, 341);
		add(list);
		
		JLabel Title = new JLabel("Recipe Selection");
		Title.setForeground(Color.ORANGE);
		Title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(197, 10, 291, 68);
		add(Title);

	}
}
