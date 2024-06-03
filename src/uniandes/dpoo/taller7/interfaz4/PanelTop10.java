package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelTop10 extends JDialog {
	
	private CustomListCellRenderer customRender;

	public PanelTop10(JFrame parentFrame, String[] data) {
		super(parentFrame, "Top 10", true);
		setLayout(new BorderLayout());

		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String item : data) {
			listModel.addElement(item);
		}

		JList<String> list = new JList<>(listModel);
		customRender = new CustomListCellRenderer();
		list.setCellRenderer(customRender);
		add(new JScrollPane(list), BorderLayout.CENTER);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(okButton, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(parentFrame);
		setResizable(false);
		setVisible(true);
	}
}