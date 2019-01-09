package forms;

import certificate.Generate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm {
	private JPanel panel1;
	private JButton settingsButton;
	private JButton generateButton;
	
	private static int xName, yName;
	private static int xEventName;
	
	public static int getxName() {
		return xName;
	}
	
	static void setxName(int xName) {
		MainForm.xName = xName;
	}
	
	public static int getyName() {
		return yName;
	}
	
	static void setyName(int yName) {
		MainForm.yName = yName;
	}
	
	public static int getxEventName() {
		return xEventName;
	}
	
	static void setxEventName(int xEventName) {
		MainForm.xEventName = xEventName;
	}
	
	public static int getyEventName() {
		return yEventName;
	}
	
	static void setyEventName(int yEventName) {
		MainForm.yEventName = yEventName;
	}
	
	private static int yEventName;
	private MainForm() {
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Opening Settings");
				new SettingsForm();
			}
		});
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					new Generate().eatheletic();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("MainForm");
		frame.setContentPane(new MainForm().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
