import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OgrenciYemekTakibi extends JFrame {

	 private static final long serialVersionUID = 1L;
	 private JPanel contentPane;
	 private JTable table;
	 private String[] sabah;
	 private String[] aksam;
	 private int konum;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciYemekTakibi frame = new OgrenciYemekTakibi();
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
	public OgrenciYemekTakibi() {
		setTitle("Ögrenci Yemek Listesi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 730, 561);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(21, 6, 689, 242);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblGün = new JLabel("Gün");
        lblGün.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblGün.setBounds(6, 18, 677, 25);
        panel.add(lblGün);

        JLabel lblNewLabel_1 = new JLabel("Sabah");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(46, 46, 230, 16);
        panel.add(lblNewLabel_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(46, 76, 230, 127);
        panel.add(scrollPane_1);

        JTextArea txtSabah = new JTextArea();
        txtSabah.setToolTipText("5 satır olmalı");
        scrollPane_1.setViewportView(txtSabah);

        JLabel lblNewLabel_1_2 = new JLabel("Akşam");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setBounds(406, 46, 230, 16);
        panel.add(lblNewLabel_1_2);  
        

        JScrollPane scrollPane_1_2 = new JScrollPane();
        scrollPane_1_2.setBounds(406, 76, 230, 127);
        panel.add(scrollPane_1_2);

        JTextArea txtAksam = new JTextArea();
        txtAksam.setToolTipText("5 satır olmalı");
        scrollPane_1_2.setViewportView(txtAksam);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(46, 62, 230, 12);
        panel.add(separator_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(406, 62, 230, 12);
        panel.add(separator_1_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(21, 265, 689, 223);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        try {
            FileReader fileReader = new FileReader("YemekListesiSabah.txt");
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                sabah = new String[7];
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    sabah[i] = line;
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader2 = new FileReader("YemekListesiAksam.txt");
            try (BufferedReader bufferedReader2 = new BufferedReader(fileReader2)) {
                String line2;
                aksam = new String[7];
                int i = 0;
                while ((line2 = bufferedReader2.readLine()) != null) {
                    aksam[i] = line2;
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] veriler = new Object[7][3];
        String[] gun = { "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar" };

        for (int i = 0; i < 7; i++) {
            veriler[i][0] = gun[i];
            veriler[i][1] = sabah[i];
            veriler[i][2] = aksam[i];
        }

        String[] sutunBasliklari = { "Günler", "Sabah", "Akşam" };

        DefaultTableModel model = new DefaultTableModel(veriler, sutunBasliklari);

        table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtSabah.setText("");
        		txtAksam.setText("");
        		
        		
        		DefaultTableModel model=(DefaultTableModel) table.getModel();
        		int satır=table.getSelectedRow();
        		konum=table.getSelectedRow();
        		String sabah1=model.getValueAt(satır, 1).toString();
        		String aksam1=model.getValueAt(satır, 2).toString();
        		String[] sabahYeni=sabah1.split(",");
        		String[] aksamYeni=aksam1.split(",");
        		
        		String gunString=model.getValueAt(satır, 0).toString();
        		lblGün.setText(gunString);
        		
        		for(int i=0;i<sabahYeni.length;i++) {
        			txtSabah.append(sabahYeni[i]+"\n");
        			txtAksam.append(aksamYeni[i]+"\n");
        			
        		}
        		
        		
        		
        	}
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 35, 677, 168);
        panel_1.add(scrollPane);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Yemek Listesi");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(6, 7, 184, 16);
        panel_1.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 23, 155, 12);
        panel_1.add(separator);
        
        JButton btnNewButton = new JButton("Geri");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(298, 487, 117, 29);
        contentPane.add(btnNewButton);
        setVisible(true);
	}
}
