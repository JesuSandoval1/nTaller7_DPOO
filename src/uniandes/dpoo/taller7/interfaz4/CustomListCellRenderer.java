package uniandes.dpoo.taller7.interfaz4;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CustomListCellRenderer extends DefaultListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		String text = (String) value;
		String[] parts = text.split(" ..... ");
		setText((index + 1) + "   " + parts[0] + "   " + parts[1]);
		setHorizontalAlignment(SwingConstants.CENTER);

		return this;
	}
}