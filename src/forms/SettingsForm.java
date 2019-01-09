package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsForm {
	private JTextField xNameText;
	private JTextField yNameText;
	private JTextField xEventText;
	private JTextField yEventText;
	private JButton chooseBlankCertificateButton;
	private JPanel panel;
	private JButton cancelButton;
	private JButton saveButton;
	
	SettingsForm() {
		chooseBlankCertificateButton.setVisible(false);
		JFrame frame = new JFrame("SettingsForm");
		
		chooseBlankCertificateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				new JFileChooser().showOpenDialog(null);
 			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				frame.dispose();
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					MainForm.setxName(Integer.parseInt(xNameText.getText()));
					MainForm.setyName(Integer.parseInt(yNameText.getText()));
					MainForm.setxEventName(Integer.parseInt(xEventText.getText()));
					MainForm.setyEventName(Integer.parseInt(yEventText.getText()));
				} catch (NumberFormatException ne) {
					System.out.println("Invalid type");
				}
				frame.dispose();
			}
		});
		
		frame.setContentPane(this.panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
}
