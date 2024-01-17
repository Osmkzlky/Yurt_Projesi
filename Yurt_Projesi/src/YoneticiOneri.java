import java.awt.EventQueue;
import java.io.BufferedReader;
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

public class YoneticiOneri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	Object[][] veriler;
	private JButton btnNewButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiOneri frame = new YoneticiOneri();
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
	public YoneticiOneri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 588, 265);
		contentPane.add(scrollPane);
		
try {
			
			FileReader fileReader=new FileReader("OneriSikayetTalep.txt");
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line;
			int i=0;
			veriler=new Object[15][2];
			while((line=bufferedReader.readLine())!=null){
				String[] oneri=line.split(";");
				for (int j = 0; j < 2; j++) {
					veriler[i][j] = oneri[j];
            
				}
				i++;
				
				
				

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String[] sutunBasliklari = {"Öneri/Şikayet/Talep", "İsim Soyad"};	
		model = new DefaultTableModel(veriler,sutunBasliklari);
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        btnNewButton = new JButton("Geri");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(237, 273, 117, 29);
        contentPane.add(btnNewButton);
        setVisible(true);
	}
}
