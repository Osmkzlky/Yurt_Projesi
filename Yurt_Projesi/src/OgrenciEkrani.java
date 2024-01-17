import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.sound.midi.Soundbank;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;

public class OgrenciEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JOptionPane optionPaneTalep;
	OneriSikayetTalep oneriSikayetTalep;
	private String isim,soyad;
	private int flag;
	private String[] mesaj;
	private String[] metin;
	
	
	


	public OgrenciEkrani(String isim,String soyad) {
		setTitle(isim+" "+soyad);
		this.isim=isim;
		this.soyad=soyad;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Yurt İşlemleri");
		lblNewLabel.setForeground(new Color(56, 56, 56));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(129, 38, 180, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnIzin = new JButton("İzin Alma");
		btnIzin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnIzin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzinAlma izinAlma=new IzinAlma(isim,soyad);
			}
		});
		
		btnIzin.setBounds(118, 80, 201, 29);
		contentPane.add(btnIzin);
		
		JButton btnNakil = new JButton("Nakil Talebi");
		btnNakil.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNakil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NakilTalebi nakilTalebi=new NakilTalebi();
				
			}
		});
		btnNakil.setBounds(118, 117, 201, 29);
		contentPane.add(btnNakil);
		
		JButton btnSilme = new JButton("Kayıt Silme Talebi");
		btnSilme.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cevap = JOptionPane.showConfirmDialog(null,"Kaydını silmek istiyor musun?","Kayıt Silme",JOptionPane.YES_NO_OPTION);
				if (cevap == JOptionPane.YES_OPTION) {
		            
		            try {
						FileReader fileReader=new FileReader("OgrenciListesi.txt");
						BufferedReader bufferedReader=new BufferedReader(fileReader);
						String line,line2;
						File file=new File("OgrenciListesi.txt");
						if(!file.exists()) {
							file.exists();
						}
						boolean flag=true;
						
						
						while((line=bufferedReader.readLine())!=null) {
							metin=line.split(";");
							if(flag) {
								FileWriter fileWriter=new FileWriter(file,false);
								flag=false;
							}
							
							FileWriter fileWriter=new FileWriter(file,true);
							BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
							if(metin[0].equals(isim)&&metin[1].equals(soyad)) {
								continue;
							}
							else {
								
								bufferedWriter.write(line);
								bufferedWriter.newLine();
								bufferedWriter.close();
						}
						
						}			
						
						
						JOptionPane.showMessageDialog(null, "İşlem onaylandı.Sistem Kapanıyor...","Kayıt Silme",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					} catch (Exception e2) {
						// TODO: handle exception
					}
		        } else {
		            JOptionPane.showMessageDialog(null, "İşlem iptal edildi.","Kayıt Silme",JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});
		btnSilme.setBounds(118, 154, 201, 29);
		contentPane.add(btnSilme);
		
		JButton btnEtkinlikler = new JButton("Etkinlikler");
		btnEtkinlikler.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		btnEtkinlikler.setBounds(118, 192, 201, 29);
		contentPane.add(btnEtkinlikler);
		
		JButton btnYemek = new JButton("Yemek Takibi");
		btnYemek.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnYemek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciYemekTakibi ogrenciYemekTakibi=new OgrenciYemekTakibi();
			}
		});
		btnYemek.setBounds(118, 233, 201, 29);
		contentPane.add(btnYemek);
		
		JButton btnTalep = new JButton("Öneri/Şikayet/Talep");
		btnTalep.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		btnTalep.setBounds(118, 274, 201, 29);
		contentPane.add(btnTalep);
		
		JButton btnMesaj = new JButton("Gelen Kutusu");
		btnMesaj.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMesaj.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnMesaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fileReader=new FileReader("Mesaj.txt");
					BufferedReader bufferedReader=new BufferedReader(fileReader);
					String line;
					flag=0;
					mesaj=new String[10];
					while((line=bufferedReader.readLine())!=null) {
						mesaj[flag]=line;
						flag++;
						
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,flag+" tane mesajın var","Gelen Kutusu",JOptionPane.INFORMATION_MESSAGE);
				for(int i=0;i<flag;i++){
					JOptionPane.showMessageDialog(null,mesaj[i],"Gelen Kutusu",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnMesaj.setToolTipText("");
		

		Image img=new ImageIcon(this.getClass().getResource("/mesajIcon.png")).getImage();
		btnMesaj.setIcon(new ImageIcon(img));
		btnMesaj.setVerticalTextPosition(SwingConstants.TOP);
		setVisible(true);
		
		
			
		btnMesaj.setBackground(new Color(238, 237, 238));
		btnMesaj.setBounds(118, 315, 201, 32);
		contentPane.add(btnMesaj);
		
		Image img2=new ImageIcon(getClass().getResource("/ArkaPlanOgrenci5.png")).getImage();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(128, 62, 180, 12);
		contentPane.add(separator);
		JLabel lblArka = new JLabel("");
		lblArka.setBounds(-24, -37, 523, 497);
		lblArka.setIcon(new ImageIcon(img2));
		contentPane.add(lblArka);
		
		
		btnEtkinlikler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtkinlikGoster etkinlikGoster=new EtkinlikGoster();
			}
		});
		
		btnTalep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oneriSikayetTalep=new OneriSikayetTalep(isim,soyad);
				
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
