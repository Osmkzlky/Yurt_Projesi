import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
public class YoneticiEtkinlikGoster extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] etkinlik1,etkinlik2;

	public YoneticiEtkinlikGoster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblGunVeSaat1 = new JLabel("Saat ve Gün");
		lblGunVeSaat1.setBounds(10, 17, 207, 16);
		panel_1.add(lblGunVeSaat1);
		
		JLabel lblEtkinlikIsmi1 = new JLabel("Etkinlik ismi");
		lblEtkinlikIsmi1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtkinlikIsmi1.setBounds(0, 0, 434, 16);
		panel_1.add(lblEtkinlikIsmi1);
		
		JLabel lblAdres1 = new JLabel("Adres");
		lblAdres1.setBounds(10, 45, 207, 16);
		panel_1.add(lblAdres1);
		

		JButton btn1 = new JButton("Düzenle");
		
		btn1.setBounds(323, 17, 117, 29);
		panel_1.add(btn1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		JLabel lblGunVeSaat2 = new JLabel("Saat ve Gün");
		lblGunVeSaat2.setBounds(6, 15, 207, 16);
		panel_2.add(lblGunVeSaat2);
		
		JLabel lblEtkinlikIsmi2 = new JLabel("Etkinlik ismi");
		lblEtkinlikIsmi2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtkinlikIsmi2.setBounds(0, 0, 434, 16);
		panel_2.add(lblEtkinlikIsmi2);
		
		JLabel lblAdres2 = new JLabel("Adres");
		lblAdres2.setBounds(6, 43, 207, 16);
		panel_2.add(lblAdres2);
		
		JButton btn2 = new JButton("Düzenle");
		
		btn2.setBounds(323, 15, 117, 29);
		panel_2.add(btn2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(166, 17, 117, 29);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		try {
			
			FileReader fileReader=new FileReader("EtkinlikListesi.txt");
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line;
			while((line=bufferedReader.readLine())!=null) {
				etkinlik1=line.split("/");
				break;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		} 
		
		lblEtkinlikIsmi1.setText(etkinlik1[0]);
		lblGunVeSaat1.setText(etkinlik1[2]+" "+etkinlik1[1]);
		lblAdres1.setText(etkinlik1[3]);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(171, 10, 97, 12);
		panel_1.add(separator);
		
		
		
		
		try {
			
			FileReader fileReader=new FileReader("EtkinlikListesi.txt");
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line;
			while((line=bufferedReader.readLine())!=null) {
				etkinlik2=line.split("/");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		} 
		
		lblEtkinlikIsmi2.setText(etkinlik2[0]);
		lblGunVeSaat2.setText(etkinlik2[2]+" "+etkinlik2[1]);
		lblAdres2.setText(etkinlik2[3]);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(171, 10, 97, 12);
		panel_2.add(separator_1);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					File file=new File("EtkinlikListesi.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				YoneticiEtkinlik yoneticiEtkinlik=new YoneticiEtkinlik(etkinlik1[0],etkinlik1[1],etkinlik1[2],etkinlik1[3],etkinlik1[4],etkinlik1[5],etkinlik1[6]);
				FileWriter fileWriter=new FileWriter(file,false);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				bufferedWriter.write(etkinlik2[0]+"/"+etkinlik2[1]+"/"+etkinlik2[2]+"/"+etkinlik2[3]+"/"+etkinlik2[4]+"/"+etkinlik2[5]+"/"+etkinlik2[6]);
				bufferedWriter.newLine();
				bufferedWriter.close();
				
				
				dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
			}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
							
					File file=new File("EtkinlikListesi.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter=new FileWriter(file,false);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				bufferedWriter.write(etkinlik1[0]+"/"+etkinlik1[1]+"/"+etkinlik1[2]+"/"+etkinlik1[3]+"/"+etkinlik1[4]+"/"+etkinlik1[5]+"/"+etkinlik1[6]);
				bufferedWriter.newLine();
				bufferedWriter.close();
				YoneticiEtkinlik yoneticiEtkinlik=new YoneticiEtkinlik(etkinlik2[0],etkinlik2[1],etkinlik2[2],etkinlik2[3],etkinlik2[4],etkinlik2[5],etkinlik2[6]);	
				dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
					
				
			}
		});
		
		
		setVisible(true);
		
	}
}
