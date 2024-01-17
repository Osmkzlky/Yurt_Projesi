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


public class CalısanEkle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String isim,soyad,calısmaAlani,telefon;
	JOptionPane optionPane=new JOptionPane();
	private JTextField textIsim;
	private JTextField textSoyad;
	private JTextField textCalısmaAlanı;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalısanEkle frame = new CalısanEkle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CalısanEkle() throws ParseException {
		setTitle("Ögrenci Kaydı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 445);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Çalışma Alanı:");
		lblNewLabel_1_1.setBounds(110, 202, 147, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textCalısmaAlanı = new JTextField();
		textCalısmaAlanı.setColumns(10);
		textCalısmaAlanı.setBounds(110, 218, 250, 26);
		contentPane.add(textCalısmaAlanı);
		
		JButton btnKaydet = new JButton("Kaydet");
		
		btnKaydet.setBounds(170, 333, 117, 29);
		contentPane.add(btnKaydet);
		
		JLabel lblNewLabel_2 = new JLabel("Çalışan Bilgileri");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(110, 43, 250, 16);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(110, 53, 250, 12);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefon");
		lblNewLabel_1_2.setBounds(110, 267, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
	
		
		
		MaskFormatter mf=new MaskFormatter("(0###) ### - ## - ##");
		JFormattedTextField formattedTextField = new JFormattedTextField(mf);//
		formattedTextField.setBounds(110, 284, 250, 26);
		contentPane.add(formattedTextField);
		
		
		
		
		Image img=new ImageIcon(getClass().getResource("/duz.jpeg")).getImage();
		
		MaskFormatter mf2=new MaskFormatter("##/##/####");
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(-3, 0, 68, 29);
		contentPane.add(btnNewButton);
		JLabel lblArkaPlan = new JLabel("");
		lblArkaPlan.setBounds(-3, -17, 522, 444);
		contentPane.add(lblArkaPlan);
		lblArkaPlan.setIcon(new ImageIcon(img));
		
		
		setVisible(true);
		
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim = textIsim.getText();
	            soyad = textSoyad.getText();
	            calısmaAlani = textCalısmaAlanı.getText();
	            telefon=formattedTextField.getText();
	            if (isim.equals("") || soyad.equals("") || calısmaAlani.equals("")) {
	            		JOptionPane.showMessageDialog(null, "Boş Alan Bulunmaktadır", "Calışan Ekle", JOptionPane.WARNING_MESSAGE);
	            } else {
	            	String calisan=isim+";"+soyad+";"+calısmaAlani+";"+telefon;
	            	try {
								
	            		File file=new File("CalısanListesi.txt");
						if(!file.exists()) {
							file.createNewFile();
						}
								
						FileWriter fWriter =new FileWriter(file,true);
						BufferedWriter bWriter=new BufferedWriter(fWriter);
						bWriter.write(calisan);bWriter.newLine();
						bWriter.close();
						JOptionPane.showMessageDialog(null,isim+" "+soyad+" calışan listesine eklendi","Çalışan Ekle",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						} catch (Exception e2) {
							e2.printStackTrace();
						}

	                    	
	                    	
	            }     
	                
	        }
			
		});
		setVisible(true);
	}
}
