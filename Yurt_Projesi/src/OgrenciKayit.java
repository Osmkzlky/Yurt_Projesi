import java.awt.EventQueue;



import java.awt.Frame;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.lang.invoke.StringConcatFactory;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;



public class OgrenciKayit extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String isim,soyad,okul,bolum,newKullaniciAdi,newSifre,sifreTekrar,telefon,dogum;
	JOptionPane optionPane=new JOptionPane();
	private JTextField textIsim;
	private JTextField textSoyad;
	private JTextField textOkul;
	private JTextField textBolum;
	private JTextField textYeniKullanici;
	private JTextField textYeniSifre;
	private JPasswordField passSifreTekrar;

	
	
	OgrenciKayit() throws ParseException,IOException {
		setTitle("Ögrenci Kaydı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("İsim:");
		lblNewLabel.setBounds(110, 71, 61, 16);
		contentPane.add(lblNewLabel);
		
		textIsim = new JTextField();
		textIsim.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		textIsim.setColumns(10);
		textIsim.setBounds(110, 86, 250, 26);
		contentPane.add(textIsim);
		
		JLabel lblSoyisim = new JLabel("Soyisim:");
		lblSoyisim.setBounds(110, 134, 61, 16);
		contentPane.add(lblSoyisim);
		
		textSoyad = new JTextField();
		textSoyad.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		textSoyad.setColumns(10);
		textSoyad.setBounds(110, 152, 250, 26);
		contentPane.add(textSoyad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Okul:");
		lblNewLabel_1_1.setBounds(110, 202, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textOkul = new JTextField();
		textOkul.setColumns(10);
		textOkul.setBounds(110, 218, 250, 26);
		contentPane.add(textOkul);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Bölüm");
		lblNewLabel_1_1_1.setBounds(110, 267, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		textBolum = new JTextField();
		textBolum.setColumns(10);
		textBolum.setBounds(110, 284, 250, 26);
		contentPane.add(textBolum);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Kullanıcı Adınızı Oluşturunuz:");
		lblNewLabel_1_1_2.setBounds(110, 461, 250, 16);
		contentPane.add(lblNewLabel_1_1_2);
		
		textYeniKullanici = new JTextField();
		textYeniKullanici.setColumns(10);
		textYeniKullanici.setBounds(110, 478, 250, 26);
		contentPane.add(textYeniKullanici);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Şifre Oluşturunuz:");
		lblNewLabel_1_1_1_1.setBounds(110, 516, 250, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textYeniSifre = new JTextField();
		textYeniSifre.setColumns(10);
		textYeniSifre.setBounds(110, 530, 250, 26);
		contentPane.add(textYeniSifre);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Şifrenizi Tekrar Giriniz:");
		lblNewLabel_1_1_1_1_1.setBounds(110, 568, 250, 16);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hesap Bilgileri");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(110, 433, 250, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnKaydet = new JButton("Kaydet");
		
		btnKaydet.setBounds(170, 627, 117, 29);
		contentPane.add(btnKaydet);
		
		passSifreTekrar = new JPasswordField();
		passSifreTekrar.setBounds(110, 589, 250, 26);
		contentPane.add(passSifreTekrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(110, 445, 250, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Öğrenci Bilgileri");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(110, 43, 250, 16);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(110, 53, 250, 12);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefon");
		lblNewLabel_1_2.setBounds(110, 322, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
	
		
		
		MaskFormatter mf=new MaskFormatter("(0###) ### - ## - ##");
		JFormattedTextField formattedTextField = new JFormattedTextField(mf);//
		formattedTextField.setBounds(110, 338, 250, 26);
		contentPane.add(formattedTextField);
		
		
		
		
		Image img=new ImageIcon(getClass().getResource("/duz.jpeg")).getImage();
		
		JLabel lblNewLabel_3 = new JLabel("Doğum Tarihi:");
		lblNewLabel_3.setBounds(110, 376, 250, 16);
		contentPane.add(lblNewLabel_3);
		
		MaskFormatter mf2=new MaskFormatter("##/##/####");
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(mf2);
		formattedTextField_1.setBounds(110, 395,250, 26);
		contentPane.add(formattedTextField_1);
		JLabel lblArkaPlan = new JLabel("");
		lblArkaPlan.setBounds(0, 6, 500, 670);
		contentPane.add(lblArkaPlan);
		lblArkaPlan.setIcon(new ImageIcon(img));
		
		
		setVisible(true);
		
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim = textIsim.getText();
	            soyad = textSoyad.getText();
	            okul = textOkul.getText();
	            bolum = textBolum.getText();
	            telefon=formattedTextField.getText();
	            dogum=formattedTextField_1.getText();
	            newKullaniciAdi = textYeniKullanici.getText();
	            newSifre = textYeniSifre.getText();
	            sifreTekrar = new String(passSifreTekrar.getPassword());
	            
	            

	            if (isim.equals("") || soyad.equals("") || okul.equals("") || bolum.equals("") || newKullaniciAdi.equals("") || newSifre.equals("") || sifreTekrar.equals("")) {
	            		JOptionPane.showMessageDialog(null, "Boş Alan Bulunmaktadır", "Ögrenci Kaydı", JOptionPane.WARNING_MESSAGE);
	            } else {
	                if (sifreTekrar.equals(newSifre)) {
	                    JOptionPane.showMessageDialog(null, "Sisteme Kaydınız Başarılı Bir Şekilde Yapılmıştır.", "Ögrenci Kaydı", JOptionPane.INFORMATION_MESSAGE);
	                    Ogrenciler ogrenciler=new Ogrenciler(isim, soyad, okul, bolum, telefon,dogum,newKullaniciAdi, newSifre);
	                    
	                    
	                    
	                    
	                    	FileOutputStream f;
	                    	BufferedOutputStream b;
	                    	ObjectOutputStream out;
	                    	try {
								f= new FileOutputStream("Ogrenciler.txt");
								b=new BufferedOutputStream(f);
								out=new ObjectOutputStream(b);
								out.writeObject(ogrenciler);
								out.flush();
								
								File file=new File("OgrenciListesi.txt");
								if(!file.exists()) {
									file.createNewFile();
								}
								
								FileWriter fWriter =new FileWriter(file,true);
								BufferedWriter bWriter=new BufferedWriter(fWriter);
								bWriter.write(ogrenciler.toString());bWriter.newLine();
						        bWriter.close();
						        
						        
							} catch (Exception e2) {
								e2.printStackTrace();
							}

	                    	
	                    	
	                } 
	                else {
	                    JOptionPane.showMessageDialog(null, "Şifre Eşleşmiyor", "Ögrenci Kaydı", JOptionPane.WARNING_MESSAGE);
	                }
	                dispose();
	                
	                
	            }
			}
		});
			
			
	}
}
