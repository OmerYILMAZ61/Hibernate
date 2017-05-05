package com.ss.telefone.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ss.telefone.dao.DAO;
import com.ss.telefone.entity.Person;
import com.ss.telefone.enums.EGorusmeTipleri;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Kayit extends JFrame {

	private JPanel contentPane;
	private JTextField adSoyadTextF;
	private JTextField telefonTextF;
	private JTextArea mesajText;
	
	
	/**
	 * Create the frame.
	 * @param dao 
	 */
	public Kayit(DAO dao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdSoyad = new JLabel("Ad\u0131 Soyad\u0131");
		
		JLabel lblT = new JLabel("Telefon");
		
		adSoyadTextF = new JTextField();
		adSoyadTextF.setColumns(10);
		
		telefonTextF = new JTextField();
		telefonTextF.setColumns(10);
		
		ButtonGroup bG = new ButtonGroup();
		
		JRadioButton telefonRD = new JRadioButton("Telefon");
		telefonRD.setSelected(true);
		
		JRadioButton yuzyuzeRD = new JRadioButton("Y\u00FCzy\u00FCze");
		
		bG.add(telefonRD);
		bG.add(yuzyuzeRD);
		
		mesajText = new JTextArea();
		
		JLabel lblMesaj = new JLabel("Mesaj");
		
		JButton ekleButton = new JButton("Kay\u0131t Ekle");
		ekleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = new Person();
				
				person.setAdSoyad(adSoyadTextF.getText());
				
				person.setTelefon(telefonTextF.getText());
				
				if(telefonRD.isSelected()){
				person.setGorusmeTipi(EGorusmeTipleri.TELEFON.getTip());	
				}else if(yuzyuzeRD.isSelected()){
				person.setGorusmeTipi(EGorusmeTipleri.YUZYUZE.getTip());	
				}
				
				person.setGorusmeZamani(Calendar.getInstance().getTime());
				
				person.setMesaj(mesajText.getText());
				
				
				dao.add(person);
				
				setVisible(false);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdSoyad)
								.addComponent(lblT)
								.addComponent(telefonRD))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(yuzyuzeRD)
								.addComponent(telefonTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(adSoyadTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(ekleButton)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMesaj)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(mesajText, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdSoyad)
						.addComponent(adSoyadTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblT)
						.addComponent(telefonTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(telefonRD)
						.addComponent(yuzyuzeRD))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(mesajText, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMesaj))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(ekleButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
