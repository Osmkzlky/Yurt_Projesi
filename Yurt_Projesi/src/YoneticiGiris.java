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
import java.text.ParseException;
import javax.swing.UIManager;

public class YoneticiGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	OgrenciKayit ogrenciKayit;
	OgrenciEkrani ogrenciEkrani;
	
	JOptionPane optionPane=new JOptionPane();
	JFrame frame=new JFrame();
	private JTextField textKullanici;
	private JPasswordField password;
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    YoneticiGiris frame = new YoneticiGiris();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


	

	public YoneticiGiris() {
		setTitle("Yönetici Girişi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblSifre = new JLabel("Şifrenizi Giriniz:");
		lblSifre.setBounds(99, 110, 250, 16);
		contentPane.add(lblSifre);
		
		textKullanici = new JTextField();
		textKullanici.setText("Yonetici123");
		textKullanici.setColumns(10);
		textKullanici.setBounds(99, 54, 250, 26);
		contentPane.add(textKullanici);
		
		JButton btnGiris = new JButton("GİRİŞ");
		
		btnGiris.setBackground(UIManager.getColor("Button.background"));
		btnGiris.setBounds(148, 180, 149, 26);
		contentPane.add(btnGiris);
		
		password = new JPasswordField();
		password.setToolTipText("123");
		password.setBounds(99, 138, 250, 26);
		contentPane.add(password);
		
		 
		JLabel lblKullanici = new JLabel("Kullanıcı Adınızı Giriniz:");
		lblKullanici.setBounds(99, 36, 250, 16);
		contentPane.add(lblKullanici);
		Image img=new ImageIcon(getClass().getResource("/ArkaPlan1.png")).getImage();
		
		JLabel lblArkaPlan = new JLabel("");
		lblArkaPlan.setBounds(-47, -40, 511, 312);
		contentPane.add(lblArkaPlan);
		lblArkaPlan.setIcon(new ImageIcon(img));
		
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici=textKullanici.getText();
	            String sifre=new String(password.getPassword());
	            if(kullanici.equals("Yonetici123") && sifre.equals("123")) {
	                JOptionPane.showMessageDialog(frame,"Sisteme Hoşgendiniz","Yonetici Girişi",optionPane.INFORMATION_MESSAGE);
	                YoneticiEkrani yoneticiEkrani=new YoneticiEkrani();
	                dispose();
	            }
	            else {
	                JOptionPane.showMessageDialog(frame,"Kişi Bulunamadı. Tekrar Deneyin ","Yonetici Girişi",optionPane.WARNING_MESSAGE);
	            }
			}
		});
		setVisible(true);
	}
}
