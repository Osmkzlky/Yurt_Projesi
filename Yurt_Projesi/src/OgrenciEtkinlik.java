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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OgrenciEtkinlik extends JFrame{
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JOptionPane optionPane=new JOptionPane();
	private JTextField txtEtkinlikİsmi;
	private JTextField txtEtkinlikGünü;
	private JTextField txtEtkinlikSaati;
	private JTextField txtEtkinlikFirmasi;
	private String isim,gun,saat,adres,firma,iletisim,not;
	

	public OgrenciEtkinlik(String isim,String gun,String saat,String adres,String firma, String iletisim,String not) throws ParseException {
		this.isim=isim;
		this.gun=gun;
		this.saat=saat;
		this.adres=adres;
		this.firma=firma;
		this.iletisim=iletisim;
		this.not=not;
		
		setTitle("Öğrenci Etkinlik");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Etkinlik Bilgileri");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(110, 43, 250, 16);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(110, 53, 250, 12);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Etkinlik İsmi:");
		lblNewLabel.setBounds(110, 71, 162, 16);
		contentPane.add(lblNewLabel);
		
		txtEtkinlikİsmi = new JTextField();
		txtEtkinlikİsmi.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtEtkinlikİsmi.setColumns(10);
		txtEtkinlikİsmi.setBounds(110, 86, 250, 26);
		contentPane.add(txtEtkinlikİsmi);
		
		JLabel lblSoyisim = new JLabel("Etkinliğin Günü:");
		lblSoyisim.setBounds(110, 134, 162, 16);
		contentPane.add(lblSoyisim);
		
		txtEtkinlikGünü = new JTextField();
		txtEtkinlikGünü.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtEtkinlikGünü.setColumns(10);
		txtEtkinlikGünü.setBounds(110, 152, 250, 26);
		contentPane.add(txtEtkinlikGünü);
		
		JLabel lblNewLabel_1_1 = new JLabel("Etkinliğin Saati:");
		lblNewLabel_1_1.setBounds(110, 202, 152, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtEtkinlikSaati = new JTextField();
		txtEtkinlikSaati.setColumns(10);
		txtEtkinlikSaati.setBounds(110, 218, 250, 26);
		contentPane.add(txtEtkinlikSaati);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Etkinliğin Adresi:");
		lblNewLabel_1_1_1.setBounds(110, 267, 152, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTextArea txtEtkinlikAdresi = new JTextArea();
		txtEtkinlikAdresi.setBounds(389, 157, 100, 100);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(110, 295, 250, 78);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(txtEtkinlikAdresi);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Etkinlik Firması:");
		lblNewLabel_1_1_2.setBounds(110, 385, 250, 16);
		contentPane.add(lblNewLabel_1_1_2);
		
		txtEtkinlikFirmasi = new JTextField();
		txtEtkinlikFirmasi.setColumns(10);
		txtEtkinlikFirmasi.setBounds(110, 402, 250, 26);
		contentPane.add(txtEtkinlikFirmasi);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Etkinlik Notu:");
		lblNewLabel_1_1_1_1.setBounds(110, 500, 250, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		
		JButton btnKaydet = new JButton("Geri");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		btnKaydet.setBounds(170, 607, 117, 29);
		contentPane.add(btnKaydet);
		
		JLabel lblNewLabel_1_2 = new JLabel("İletişim Bilgisi:");
		lblNewLabel_1_2.setBounds(110, 440, 152, 16);
		contentPane.add(lblNewLabel_1_2);
		MaskFormatter mf=new MaskFormatter("(0###) ### - ## - ##");
		JFormattedTextField formattedTextField = new JFormattedTextField(mf);
		formattedTextField.setBounds(110, 457, 250, 26);
		contentPane.add(formattedTextField);
		
	
		
		
		
		
		Image img=new ImageIcon(getClass().getResource("/duz.jpeg")).getImage();
		
		
		
		
		JTextArea txtEtkinlikNotu = new JTextArea();
		txtEtkinlikNotu.setBounds(0, 0, 246, 74);
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(110, 517, 250, 78);
		contentPane.add(scrollPane_1_1);
		scrollPane_1_1.setViewportView(txtEtkinlikNotu);
		
		
		
		
		txtEtkinlikİsmi.setText(isim);
        txtEtkinlikGünü.setText(gun);
        txtEtkinlikSaati.setText(saat);
        txtEtkinlikAdresi.setText(adres);
        txtEtkinlikFirmasi.setText(firma);
        txtEtkinlikNotu.setText(not);
        formattedTextField.setText(iletisim);
        
        txtEtkinlikİsmi.setEditable(false);
        txtEtkinlikGünü.setEditable(false);
        txtEtkinlikSaati.setEditable(false);
        txtEtkinlikAdresi.setEditable(false);
        txtEtkinlikFirmasi.setEditable(false);
        txtEtkinlikNotu.setEditable(false);
        formattedTextField.setEditable(false);
        
        JLabel lblArkaPlan = new JLabel("");
        lblArkaPlan.setBounds(0, 6, 500, 670);
        contentPane.add(lblArkaPlan);
        lblArkaPlan.setIcon(new ImageIcon(img));
        
        

		
		
		setVisible(true);
	}


	public String getIsim() {
		return isim;
	}


	public void setIsim(String isim) {
		this.isim = isim;
	}


	public String getGun() {
		return gun;
	}


	public void setGun(String gun) {
		this.gun = gun;
	}


	public String getSaat() {
		return saat;
	}


	public void setSaat(String saat) {
		this.saat = saat;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}


	public String getIletisim() {
		return iletisim;
	}


	public void setIletisim(String iletisim) {
		this.iletisim = iletisim;
	}

}
