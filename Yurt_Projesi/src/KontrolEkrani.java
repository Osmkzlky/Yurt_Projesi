import java.awt.EventQueue;

import java.awt.Frame;
import java.awt.Image;
import java.awt.TexturePaint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.midi.Soundbank;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.security.PublicKey;
import java.text.ParseException;
import javax.swing.UIManager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JSeparator;

public class KontrolEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textKullanici;
	private JPasswordField password;
	private String isim,soyad;
	OgrenciKayit ogrenciKayit;
	SifreUnutma sifreUnutma;
	YoneticiGiris yoneticiGiris;
	OgrenciEkrani ogrenciEkrani;
	boolean flag=true;
	

	public KontrolEkrani() {
		
		
		setTitle("Ögrenci Girişi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblSifre = new JLabel("Şifrenizi Giriniz:");
		lblSifre.setBounds(110, 84, 250, 16);
		contentPane.add(lblSifre);
		
		textKullanici = new JTextField();
		textKullanici.setColumns(10);
		textKullanici.setBounds(110, 46, 250, 26);
		contentPane.add(textKullanici);
		
		JButton btnGiris = new JButton("Sisteme Giriş");
		
		btnGiris.setBackground(new Color(0, 249, 0));
		btnGiris.setBounds(110, 150, 250, 26);
		contentPane.add(btnGiris);
		
		JButton btnYeni = new JButton("Sisteme Kayıt Olmak İçin Tıklayınız");
		
		btnYeni.setBounds(110, 239, 250, 26);
		contentPane.add(btnYeni);
		
		password = new JPasswordField();
		password.setBounds(110, 112, 250, 26);
		contentPane.add(password);
		
		 
		JLabel lblKullanici = new JLabel("Kullanıcı Adınızı Giriniz:");
		lblKullanici.setBounds(110, 18, 250, 16);
		contentPane.add(lblKullanici);
		
		
		Image img=new ImageIcon(getClass().getResource("/ArkaPlan1.png")).getImage();
		Image img2=new ImageIcon(getClass().getResource("/Galata 4.png")).getImage();
		
		JButton btnNewButton = new JButton("Şifremi Unuttum");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sifreUnutma=new SifreUnutma();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setToolTipText("Şifremi Unuttum");
		btnNewButton.setBounds(114, 277, 117, 29);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Yönetici Giriş");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yoneticiGiris=new YoneticiGiris();
				dispose();
			}
		});
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBounds(243, 277, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblArkaPlan = new JLabel("");
		lblArkaPlan.setBounds(0, -13, 533, 363);
		contentPane.add(lblArkaPlan);
		lblArkaPlan.setIcon(new ImageIcon(img));
		
		
		btnYeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ogrenciKayit=new OgrenciKayit();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

			}
		});
		
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici=textKullanici.getText();
	            String sifre=new String(password.getPassword());
	            
	            
	            try(ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.txt")))) {
	            Ogrenciler obj=(Ogrenciler)in.readObject();
	            
	            
	            revalidate();
	            repaint();
	            
	            if(kullanici.equals(obj.getKullaniciAdi()) && sifre.equals(obj.getSifre())) {

	            	JOptionPane.showMessageDialog(null,"Sisteme Hoşgeldiniz "+obj.getIsim()+" "+obj.getSoyad(),"Kontrol Ekranı",JOptionPane.INFORMATION_MESSAGE);
	            	
	            	ogrenciEkrani=new OgrenciEkrani(obj.getIsim(),obj.getSoyad());
	   
	            	dispose();
	            	flag=false;
	            	
	          }
	            
	            
	            
	            
	            else {
	            	FileReader fileReader=new FileReader("OgrenciListesi.txt");
	            	BufferedReader bufferedReader=new BufferedReader(fileReader);
	            	String line;
	            	
	            	while((line=bufferedReader.readLine())!=null) {
	            		String[] ogrenci=line.split(";");
	            		
	            		if(kullanici.equals(ogrenci[6]) && sifre.equals(ogrenci[7])){
	            			
	            			JOptionPane.showMessageDialog(null,"Sisteme Hoşgeldiniz "+ogrenci[0]+" "+ogrenci[1],"Kontrol Ekranı",JOptionPane.INFORMATION_MESSAGE);
	            			bufferedReader.close();
	            			

	            			dispose();
	            			OgrenciEkrani ogrenciEkrani=new OgrenciEkrani(ogrenci[0],ogrenci[1]);
	            			flag=false;
	            			break;
	            			
	            		}
	            	}

	            	
	            }  
	            
	           
				} catch (Exception e2) {
					// TODO: handle exception
				}
	             if(flag) {
	            	 JOptionPane.showMessageDialog(null,"Kullanıcı Bulunamadı","Kontrol Ekranı",JOptionPane.WARNING_MESSAGE);
	            }
			}

			
		});
		setVisible(true);
		
		
		
		
	}
}
