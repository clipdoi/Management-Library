package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import org.freixas.jcalendar.JCalendarCombo;

import entities.Librarian;
import helpers.BCrypt;
import helpers.FileHelper;
import models.LibrarianModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldName;
	private JTextField jtextFieldUsername;
	private JTextField jtextFieldAswer;
	private JPasswordField jpasswordField;
	private JComboBox jcomboBoxSecQ;
	private JCalendarCombo jcalendarComboCreate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up frame = new Sign_up();
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
	public Sign_up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "NEW  Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(75, 0, 130)));
		panel.setBounds(10, 11, 364, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 34, 46, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 73, 83, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(21, 116, 83, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Security Question");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(21, 152, 127, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Answer");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(21, 193, 66, 22);
		panel.add(lblNewLabel_4);
		
		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(161, 34, 185, 27);
		panel.add(jtextFieldName);
		jtextFieldName.setColumns(10);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(161, 71, 185, 27);
		panel.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		jcomboBoxSecQ = new JComboBox();
		jcomboBoxSecQ.setBackground(new Color(139, 69, 19));
		jcomboBoxSecQ.setFont(new Font("SansSerif", Font.BOLD, 12));
		jcomboBoxSecQ.setModel(new DefaultComboBoxModel(new String[] {"How do you feel ?", "What is your favorite job ?", "What is your favorite animal ?"}));
		jcomboBoxSecQ.setBounds(161, 153, 185, 29);
		panel.add(jcomboBoxSecQ);
		
		jtextFieldAswer = new JTextField();
		jtextFieldAswer.setBounds(161, 191, 185, 27);
		panel.add(jtextFieldAswer);
		jtextFieldAswer.setColumns(10);
		
		JButton jbtnCreate = new JButton("Create");
		jbtnCreate.setBackground(new Color(255, 250, 205));
		jbtnCreate.setForeground(new Color(128, 0, 0));
		jbtnCreate.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				jbtnCreate_actionPerformed(arg0);
			}
		});
		jbtnCreate.setIcon(new ImageIcon(Sign_up.class.getResource("/resource/create.png")));
		jbtnCreate.setBounds(59, 278, 89, 31);
		panel.add(jbtnCreate);
		
		JButton jbtnBack = new JButton("Back");
		jbtnBack.setBackground(new Color(255, 250, 205));
		jbtnBack.setForeground(new Color(128, 0, 0));
		jbtnBack.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBack_actionPerformed(e);
			}
		});
		jbtnBack.setIcon(new ImageIcon(Sign_up.class.getResource("/resource/back.png")));
		jbtnBack.setBounds(257, 278, 89, 31);
		panel.add(jbtnBack);
		
		jcalendarComboCreate = new JCalendarCombo();
		jcalendarComboCreate.setForeground(new Color(255, 255, 255));
		jcalendarComboCreate.setFont(new Font("SansSerif", Font.BOLD, 12));
		jcalendarComboCreate.setBackground(new Color(100, 149, 237));
		jcalendarComboCreate.setBounds(97, 229, 249, 37);
		panel.add(jcalendarComboCreate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(21, 240, 55, 16);
		panel.add(lblDate);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setBounds(161, 114, 185, 28);
		panel.add(jpasswordField);
	}
	public void jbtnCreate_actionPerformed(ActionEvent arg0) {	
		try {
			Librarian librarian = new Librarian();
			librarian.setName(jtextFieldName.getText().trim());
			librarian.setUsername(jtextFieldUsername.getText().trim());
			String password = String.valueOf(jpasswordField.getPassword());
			librarian.setPassword(password);
			librarian.setSec_q(jcomboBoxSecQ.getSelectedItem().toString());
			librarian.setAnswer(jtextFieldAswer.getText().trim());
			librarian.setCreated(jcalendarComboCreate.getDate());
			LibrarianModel librarianModel = new LibrarianModel();
			if(jtextFieldUsername.getText().trim()
					.equals(librarianModel.search(jtextFieldUsername.getText().trim()).getUsername())) {
				JOptionPane.showMessageDialog(null, "Username exist!");
			} else {
				if (librarianModel.create(librarian)) {
					JOptionPane.showMessageDialog(null, "Done");
				} else {
					JOptionPane.showMessageDialog(null, "Failed");	
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void jbtnBack_actionPerformed(ActionEvent e) {	
		this.setVisible(false);
		Login l = new Login();
		l.setVisible(true);
		l.setLocationRelativeTo(null);
	}
}
