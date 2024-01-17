import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class YoneticiEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiEkrani frame = new YoneticiEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YoneticiEkrani() {
		setTitle("Yönetici Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Çalışan Listesi");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalısanListesi calısanListesi=new CalısanListesi();
			}
		});
		btnNewButton.setBounds(137, 132, 193, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Etkinlik Düzenleme");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				YoneticiEtkinlikGoster yoneticiEtkinlikGoster=new YoneticiEtkinlikGoster();
				
			}
		});
		btnNewButton_2.setBounds(137, 255, 193, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Öğrenci Listesi");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OgrenciListesi ogrenciListesi=new OgrenciListesi();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(137, 90, 193, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Öneri/Şikayet/Talep");
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiOneri yoneticiOneri=new YoneticiOneri();
			}
		});
		btnNewButton_6.setBounds(137, 335, 193, 29);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("İzin Listesi");
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				IzinListesi izinListesi=new IzinListesi();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		btnNewButton_7.setBounds(137, 173, 193, 29);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_1 = new JButton("Yemek Listesi");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiYemekListesi yoneticiYemekListesi=new YoneticiYemekListesi();
			}
		});
		btnNewButton_1.setBounds(137, 296, 193, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Çalışan Ekle");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CalısanEkle calısanEkle=new CalısanEkle();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(137, 214, 193, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Yurt İşlemleri");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 44, 193, 34);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(137, 72, 193, 12);
		contentPane.add(separator);
		
		Image img=new ImageIcon(getClass().getResource("/YoneticiArkaPlan2.png")).getImage();
		
		JButton btnNewButton_5 = new JButton("Mesaj Gönder");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String metinString=JOptionPane.showInputDialog(null,"Göndermek istediğiniz mesajı giriniz:","Mesaj Gönder",JOptionPane.INFORMATION_MESSAGE);
				try {
					File file=new File("Mesaj.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter=new FileWriter(file,true);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				bufferedWriter.write(metinString);
				bufferedWriter.newLine();
				JOptionPane.showConfirmDialog(null,"Mesajınız iletilmiştir","Mesaj Gönder",JOptionPane.PLAIN_MESSAGE);
				bufferedWriter.close();
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				}
			
		});
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton_5.setBounds(137, 369, 193, 29);
		contentPane.add(btnNewButton_5);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 491, 443);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_1);
		setVisible(true);
	}
}
