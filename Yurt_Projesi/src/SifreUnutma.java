import java.awt.EventQueue;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class SifreUnutma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsim;
	private JTextField txtSoyad;
	private JTextField txtKullanici;
	private String isim,soyad,dogum,kullaniciAdi;
	private JFormattedTextField formattedTextField;
	private JLabel lblNewLabel_4;

	public SifreUnutma() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adınızı Giriniz:");
		lblNewLabel.setBounds(95, 49, 147, 16);
		contentPane.add(lblNewLabel);
		
		txtIsim = new JTextField();
		txtIsim.setToolTipText("Büyük harfle başla");
		txtIsim.setBounds(95, 66, 232, 26);
		contentPane.add(txtIsim);
		txtIsim.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Soyadınızı Giriniz:");
		lblNewLabel_1.setBounds(95, 102, 147, 16);
		contentPane.add(lblNewLabel_1);
		
		txtSoyad = new JTextField();
		txtSoyad.setToolTipText("Büyük harfle başla");
		txtSoyad.setBounds(95, 119, 232, 26);
		contentPane.add(txtSoyad);
		txtSoyad.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kullanıcı Adınızı Giriniz:");
		lblNewLabel_2.setBounds(95, 157, 151, 16);
		contentPane.add(lblNewLabel_2);
		
		txtKullanici = new JTextField();
		txtKullanici.setBounds(95, 176, 232, 26);
		contentPane.add(txtKullanici);
		txtKullanici.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Doğum Tarihini Giriniz:");
		lblNewLabel_3.setBounds(99, 214, 158, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAra = new JButton("Ara");
		
		btnAra.setBounds(153, 260, 117, 29);
		contentPane.add(btnAra);
		
		MaskFormatter mf2=new MaskFormatter("##/##/####");
		formattedTextField = new JFormattedTextField(mf2);
		formattedTextField.setBounds(95, 232, 232, 26);
		contentPane.add(formattedTextField);
		
		Image img =new ImageIcon(getClass().getResource("/ArkaPlanBeyaz.png")).getImage();
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, -13, 482, 346);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(img));
		setVisible(true);
		
		
		
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim=txtIsim.getText();
				soyad=txtSoyad.getText();
				dogum=formattedTextField.getText();
				kullaniciAdi=txtKullanici.getText();
				
				try {
					FileReader fReader=new FileReader("OgrenciListesi.txt");
					BufferedReader bReader=new BufferedReader(fReader);
					String line;
					boolean flag=true;
					while ((line=bReader.readLine())!=null) {
						String[] ogrenci=line.split(";");
						
						if(isim.equals(ogrenci[0]) && soyad.equals(ogrenci[1]) && dogum.equals(ogrenci[5]) && kullaniciAdi.equals(ogrenci[6])) {
							JOptionPane.showMessageDialog(null,"Sifreniz:"+ogrenci[7],"Şifremi Unuttum",JOptionPane.WARNING_MESSAGE);
							flag=false;
							dispose();
						}

					}
					if(flag) {
						JOptionPane.showMessageDialog(null,"Kullanıcı Bulunmadı","Şifremi Unuttum",JOptionPane.WARNING_MESSAGE);
					}
					bReader.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
	}
}
