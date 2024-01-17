import java.awt.EventQueue;


import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class IzinAlma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner tarihSpinner1;
    private JSpinner tarihSpinner2;
    private String izinSebep,adres,telefon;
    private JTextArea txtSebep,txtAdres;
    private JFormattedTextField formattedTelefon;
    private String başlangıçTarih,bitişTarih;
    Ogrenciler ogrenciler;
    private String isim;
    private String soyad;
	
	public IzinAlma(String isim,String soyad) {
		this.isim=isim;
		this.soyad=soyad;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SpinnerDateModel model1 = new SpinnerDateModel();
        tarihSpinner1 = new JSpinner(model1);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(tarihSpinner1, "dd/MM/yyyy");
        tarihSpinner1.setEditor(editor1);
        tarihSpinner1.setBounds(46, 146, 137, 26);
        contentPane.add(tarihSpinner1);

       
        SpinnerDateModel model2 = new SpinnerDateModel();
        tarihSpinner2 = new JSpinner(model2);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(tarihSpinner2, "dd/MM/yyyy");
        tarihSpinner2.setEditor(editor2);
        tarihSpinner2.setBounds(279, 146, 137, 26);
		contentPane.add(tarihSpinner2);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Başlangıç Tarihi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 119, 137, 26);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 133, 137, 12);
		contentPane.add(separator);
		
		JLabel lblBitiTarihi = new JLabel("Bitiş Tarihi");
		lblBitiTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lblBitiTarihi.setBounds(269, 119, 137, 26);
		contentPane.add(lblBitiTarihi);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(269, 133, 137, 12);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Kaydet");
		
		btnNewButton.setBounds(186, 334, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("İzin Alma Sebebini Açıklayınız:");
		lblNewLabel_1.setBounds(46, 28, 257, 16);
		contentPane.add(lblNewLabel_1);
		
		txtSebep = new JTextArea();
		txtSebep.setToolTipText("Açıklayınız...");
		txtSebep.setTabSize(9);
		txtSebep.setBounds(120, 50, 283, 51);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 50, 372, 55);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(txtSebep);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Telefon numarası");
		lblNewLabel_2.setBounds(46, 198, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(0###) ### - ## - ##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		formattedTelefon = new JFormattedTextField(mf);
		formattedTelefon.setBounds(46, 215, 206, 26);
		
		
		contentPane.add(formattedTelefon);
		
		JLabel lblNewLabel_3 = new JLabel("Adresinizi Giriniz:");
		lblNewLabel_3.setBounds(46, 253, 370, 16);
		contentPane.add(lblNewLabel_3);
		
		txtAdres = new JTextArea();
		txtAdres.setBounds(46, 271, 370, 51);
		
		
		JScrollPane scrollAdres = new JScrollPane();
		scrollAdres.setBounds(46,275, 370, 55);
		contentPane.add(scrollAdres);
		scrollAdres.setViewportView(txtAdres);
		
		Image img =new ImageIcon(getClass().getResource("/IzınArkaPlan3.png")).getImage();
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 586, 492);
		lblNewLabel_4.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izinSebep=txtSebep.getText();
				adres=txtAdres.getText();
				telefon=formattedTelefon.getText();

				if(izinSebep.equals("") || adres.equals("") || telefon.equals("")){
					JOptionPane.showMessageDialog(null,"Boş Alan Bulunmamalıdır","Sistem Uyarısı",JOptionPane.WARNING_MESSAGE);
			
				}
				else {
					
				}
					Date secilenTarih1 = (Date) tarihSpinner1.getValue();
		            Date secilenTarih2 = (Date) tarihSpinner2.getValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			        başlangıçTarih=dateFormat.format(secilenTarih1);
			        bitişTarih=dateFormat.format(secilenTarih2);
			        String mesaj =başlangıçTarih + "-"+bitişTarih+" arasındaki izin aldınız.\nİzin tarihlerine uygun hareket etmenizi önemle rica ederiz.";
			        JOptionPane.showMessageDialog(null,mesaj,"Bilgi",JOptionPane.INFORMATION_MESSAGE);
			        dispose();
			        
			       
			        
			        try {
			        	File file2=new File("IzinListesi.txt");
						if(!file2.exists()) {
							file2.createNewFile();
						}
				
						FileWriter fWriter =new FileWriter(file2,true);
						BufferedWriter bWriter=new BufferedWriter(fWriter);
						bWriter.write(isim+";"+soyad+";"+izinSebep+";"+başlangıçTarih+";"+bitişTarih+";"+telefon+";"+adres);bWriter.newLine();
				        bWriter.close();
				        
					} catch (Exception e2) {
						// TODO: handle exception
					}
				
				
				
			}
		});
		
		
		setVisible(true);
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
