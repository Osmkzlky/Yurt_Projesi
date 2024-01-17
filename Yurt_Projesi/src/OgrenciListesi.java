import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class OgrenciListesi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciListesi frame = new OgrenciListesi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public OgrenciListesi() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Object[][] veriler = new Object[15][8];
		try {
			FileReader fileReader=new FileReader("OgrenciListesi.txt");
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line;
			int i=0;
			while((line=bufferedReader.readLine())!=null) {
				String[] ogrenciler=line.split(";");
				
				for (int j = 0; j < 8; j++) {
					veriler[i][j] = ogrenciler[j];
            
				}
				i++;	
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        

        
        String[] sutunBasliklari = {"İsim", "Soyad", "Okul", "Bölüm", "Telefon","Doğum Tarihi","Kullanıcı Adı","Sifre"};
        
        DefaultTableModel model = new DefaultTableModel(veriler, sutunBasliklari);
		
		table = new JTable(model);
		table.setBounds(38, 28, 102, 180);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 722, 279);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(294, 289, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(240, 248, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(-15, -14, 749, 350);
		contentPane.add(lblNewLabel);
		setVisible(true);
		
	}
}
