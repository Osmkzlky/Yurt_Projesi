import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class CalısanListesi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	Object[][] veriler ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalısanListesi frame = new CalısanListesi();
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
	public CalısanListesi() {
		setTitle("Çalışan Listesi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 23, 536, 338);
		contentPane.add(scrollPane);
		

		
		try {
			
			FileReader fileReader=new FileReader("CalısanListesi.txt");
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line;
			int i=0;
			int a=2;
			veriler=new Object[15][4];
			while((line=bufferedReader.readLine())!=null){
				String[] calisan=line.split(";");
				veriler[i][0]=calisan[0];
				veriler[i][1]=calisan[1];
				veriler[i][2]=calisan[2];
				veriler[i][3]=calisan[3];
				i++;
				
				
				

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String[] sutunBasliklari = { "İsim", "Soyad", "Çalışma Alanı", "Telefon" };	
		model = new DefaultTableModel(veriler,sutunBasliklari);
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Geri");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(241, 371, 117, 29);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(240, 248, 255));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBounds(0, 0, 600, 432);
        contentPane.add(lblNewLabel);
		setVisible(true);
        

        }
}
