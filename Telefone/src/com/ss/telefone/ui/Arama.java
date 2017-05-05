package com.ss.telefone.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import org.w3c.dom.stylesheets.LinkStyle;

import com.ss.telefone.dao.DAO;
import com.ss.telefone.entity.Person;
import com.ss.telefone.entity.SorgulaEnitity;
import com.ss.telefone.enums.EGorusmeTipleri;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Arama extends JFrame {

	private JPanel contentPane;
	private JTextField basTarText;
	private JTextField bitTarText;
	private JLabel lblAdSoyad;
	private JTextField adSoyadText;
	private JRadioButton TelefonRD;
	private JRadioButton yuzYuzeRD;
	private JButton SorgulaB;
	private JTable table;


	/**
	 * Create the frame.
	 * @param dao 
	 */
	public Arama(DAO dao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBaTarihi = new JLabel("Ba\u015F. Tarihi");
		
		basTarText = new JFormattedTextField(createFormat("##-##-####"));
		basTarText.setColumns(10);
		
		JLabel lblBitTarihi = new JLabel("Bit. Tarihi");
		
		bitTarText = new JFormattedTextField(createFormat("##-##-####"));
		bitTarText.setColumns(10);
		
		lblAdSoyad = new JLabel("Ad Soyad");
		
		adSoyadText = new JTextField();
		adSoyadText.setColumns(10);
		
		TelefonRD = new JRadioButton("Telefon");
		
		yuzYuzeRD = new JRadioButton("Y\u00FCzy\u00FCze");
		
		SorgulaB = new JButton("Sorgula");
		SorgulaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SorgulaEnitity sorgulaEnitity = new SorgulaEnitity();
				sorgulaEnitity.setAdSoyad(adSoyadText.getText());
				sorgulaEnitity.setBasTar(basTarText.getText());
				sorgulaEnitity.setBitTar(bitTarText.getText());
				if(TelefonRD.isSelected())
				sorgulaEnitity.setGorTip(EGorusmeTipleri.TELEFON.getTip());
					else if(yuzYuzeRD.isSelected())
						sorgulaEnitity.setGorTip(EGorusmeTipleri.YUZYUZE.getTip());
				List<Person> myList= dao.listele(sorgulaEnitity);
				String[] columns = {"id","isim Soyad","Mesaj","Telefon"};
				String[][] rows = new String[myList.size()][4];
				for (int i = 0; i < myList.size(); i++) {
					rows[i][0]= String.valueOf(myList.get(i).getId());
					rows[i][1]= myList.get(i).getAdSoyad();
					rows[i][2]= myList.get(i).getMesaj();
					rows[i][3]= myList.get(i).getTelefon();
				}
				
				TableModel dataModel = new DefaultTableModel(rows, columns);
				table.setModel(dataModel);
				
				
			}
		});
		
		table = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBaTarihi)
								.addComponent(lblAdSoyad)
								.addComponent(TelefonRD))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(adSoyadText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(basTarText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(yuzYuzeRD))
									.addGap(25)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(SorgulaB)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblBitTarihi)
											.addGap(18)
											.addComponent(bitTarText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBaTarihi)
						.addComponent(lblBitTarihi)
						.addComponent(bitTarText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(basTarText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdSoyad)
						.addComponent(adSoyadText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TelefonRD)
						.addComponent(yuzYuzeRD)
						.addComponent(SorgulaB))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private MaskFormatter createFormat(String value){
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}
}
