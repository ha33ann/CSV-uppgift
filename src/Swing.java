import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Swing {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1300, 800);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hassan");
		frame.getContentPane().setLayout(null);
		JButton btn = new JButton();
		btn.setBounds(500, 300, 300, 50);
		btn.setText("Click here to read csv file");
		
		frame.add(btn);
		btn.revalidate();
		btn.repaint();
		
		
		ActionListener ac = new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fch = new JFileChooser();
				
				fch.setFileFilter(new FileNameExtensionFilter("Open:", ".txt", ".csv", ".json"));
				fch.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
				fch.addChoosableFileFilter(new FileNameExtensionFilter(".csv", "csv"));
				fch.addChoosableFileFilter(new FileNameExtensionFilter(".json", "json"));
				int showOpenDialog = fch.showOpenDialog(null);	
				String path = fch.getSelectedFile().getPath();
				String line = "";
				
				
					
					try {
						BufferedReader br = new BufferedReader(new FileReader(path));
						while((line = br.readLine()) != null) {

							String[] values = line.split(",");
							Arrays.sort(values);
							
							
							
							JFrame window = new JFrame("JFrame with text"); 
							window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							window.setLayout(new BorderLayout());
						    window.setPreferredSize(new Dimension(800, 800));
							window.pack();
							JTextArea jTextArea = new JTextArea();
							jTextArea.read(br, line);
							window.add(jTextArea);
							window.pack();
							window.setVisible(true);
							window.setLocationRelativeTo(null);
							window.setResizable(true);
							frame.setVisible(false);
							
							break;
							
											}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
			}
			
		};
		
		btn.addActionListener(ac);
		
	}

}

