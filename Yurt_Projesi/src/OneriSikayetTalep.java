import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class OneriSikayetTalep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JOptionPane optionPane;
	private String isim,soyad;

	
	

	public OneriSikayetTalep(String isim,String soyad) {
		this.isim=isim;
		this.soyad=soyad;
		
		setTitle("Öneri/Şikayet/Talep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea txtrYaznz = new JTextArea();
		txtrYaznz.setTabSize(9);
		txtrYaznz.setText("Yazınız...");
		txtrYaznz.setBounds(120, 58, 283, 128);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 60, 372, 151);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(txtrYaznz);
		
		JLabel lblNewLabel = new JLabel("Öneri Şikayet ya da Talebiniz:");
		lblNewLabel.setBounds(36, 32, 249, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnGonder = new JButton("Gönder");
		
		btnGonder.setBounds(168, 223, 117, 29);
		contentPane.add(btnGonder);
		setVisible(true);
		
		btnGonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtrYaznz.getText().equals("Yazınız...") || txtrYaznz.getText().equals("")) {
					optionPane.showMessageDialog(null,"Mesajınızı Girmediniz","Öneri/Şikayet/Talep",optionPane.WARNING_MESSAGE);
				}
				else {
					try {
						File file=new File("OneriSikayetTalep.txt");
						if(!file.exists()) {
							file.createNewFile();
						}
						FileWriter fileWriter =new FileWriter(file,true);
						BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
						bufferedWriter.write(txtrYaznz.getText()+";"+isim+" "+soyad);
						bufferedWriter.newLine();
						bufferedWriter.close();
						optionPane.showMessageDialog(null,"Mesajınız Gönderilmiştir","Öneri/Şikayet/Talep",optionPane.INFORMATION_MESSAGE);
						dispose();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
			}
		});
		
		
	}



	public String getIsim() {
		return isim;
	}



	public void setIsim(String isim) {
		this.isim = isim;
	}



	public String getSoyad() {
		return soyad;
	}



	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
}
