import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NakilTalebi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JOptionPane optionPane;
	JFrame frame=new JFrame();
	String yeniYurt;
	int indeks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NakilTalebi frame = new NakilTalebi();
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
	public NakilTalebi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboYurtListesi = new JComboBox();
		comboYurtListesi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				yeniYurt=comboYurtListesi.getItemAt(comboYurtListesi.getSelectedIndex()).toString();
				indeks=comboYurtListesi.getSelectedIndex();
				
			}
		});
		comboYurtListesi.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz...", "Cerrah Mehmet Paşa Erkek Öğrenci Yurdu", "Mehterçeşme Erkek Öğrenci Yurdu", "Fatih Erkek Öğrenci Yurdu", "Mimar Sinan Erkek Öğrenci Yurdu"}));
		comboYurtListesi.setBounds(82, 80, 258, 27);
		contentPane.add(comboYurtListesi);
		
		JLabel lblNewLabel = new JLabel("Nakil Olmak İstediğiniz Yurdu Seçiniz:");
		lblNewLabel.setBounds(82, 53, 278, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(indeks!=0) {
					JOptionPane.showMessageDialog(frame,yeniYurt +" na nakil işleminiz başarılı bir şekilde yapılmıştır","Nakil İşleme",optionPane.INFORMATION_MESSAGE);
					btnKaydet.setEnabled(true);
				}
				btnKaydet.setEnabled(false);
				
				
			}
		});
		btnKaydet.setBounds(92, 120, 117, 29);
		contentPane.add(btnKaydet);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(223, 119, 117, 29);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
}
