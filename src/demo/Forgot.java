package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import org.freixas.jcalendar.JCalendarCombo;

import entities.Librarian;
import helpers.BCrypt;
import models.LibrarianModel;


import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldUsername;
	private JTextField jtextFieldName;
	private JTextField jtextFieldSecQ;
	private JTextField jtextFieldAnswer;
	private JTextField jtextFieldPassword;
	private JButton jbtnRetrieve;
	private JTextField jtextFieldId;

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
					Forgot frame = new Forgot();
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
	public Forgot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(33, 44, 80, 23);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", lblNewLabel_2.getFont().getStyle(), 15));
		lblNewLabel_2.setBounds(33, 202, 110, 25);
		contentPane.add(lblNewLabel_2);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(230, 42, 161, 28);
		contentPane.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		jtextFieldPassword = new JTextField();
		jtextFieldPassword.setBounds(230, 201, 161, 28);
		contentPane.add(jtextFieldPassword);
		jtextFieldPassword.setColumns(10);
		
		JButton jbtnSearch = new JButton(" Search");
		jbtnSearch.setForeground(new Color(128, 0, 0));
		jbtnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnSearch.setBackground(new Color(255, 248, 220));
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearch_actionPerformed(arg0);
			}
		});
		jbtnSearch.setIcon(new ImageIcon(Forgot.class.getResource("/resource/search.png")));
		jbtnSearch.setBounds(403, 42, 102, 28);
		contentPane.add(jbtnSearch);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Retrieve Password", TitledBorder.LEFT, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(12, 16, 500, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton jbtnBack = new JButton(" Back");
		jbtnBack.setBackground(new Color(255, 250, 240));
		jbtnBack.setForeground(new Color(128, 0, 0));
		jbtnBack.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBack_actionPerformed(e);
			}
		});
		jbtnBack.setBounds(219, 260, 80, 28);
		panel.add(jbtnBack);
		jbtnBack.setIcon(new ImageIcon(Forgot.class.getResource("/resource/back.png")));
		
		jtextFieldAnswer = new JTextField();
		jtextFieldAnswer.setBounds(219, 144, 161, 28);
		panel.add(jtextFieldAnswer);
		jtextFieldAnswer.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(21, 145, 55, 25);
		panel.add(lblAnswer);
		lblAnswer.setFont(new Font("Tahoma", lblAnswer.getFont().getStyle(), 15));
		
		jbtnRetrieve = new JButton(" Retrieve");
		jbtnRetrieve.setForeground(new Color(255, 140, 0));
		jbtnRetrieve.setBackground(new Color(192, 192, 192));
		jbtnRetrieve.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnRetrieve_actionPerformed(arg0);
			}
		});
		jbtnRetrieve.setBounds(392, 144, 102, 28);
		panel.add(jbtnRetrieve);
		jbtnRetrieve.setIcon(new ImageIcon(Forgot.class.getResource("/resource/retrieve.png")));
		jbtnRetrieve.setEnabled(false);
		
		JButton jbtnChange = new JButton(" Change");
		jbtnChange.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnChange.setBackground(new Color(255, 250, 240));
		jbtnChange.setForeground(new Color(128, 0, 0));
		jbtnChange.setIcon(new ImageIcon(Forgot.class.getResource("/resource/iconfinder_round-trip-return-repeat_2075799 (1).png")));
		jbtnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnChange_actionPerformed(arg0);
			}
		});
		jbtnChange.setBounds(392, 184, 102, 28);
		panel.add(jbtnChange);
		
		jtextFieldId = new JTextField();
		jtextFieldId.setBounds(220, 223, 160, 28);
		panel.add(jtextFieldId);
		jtextFieldId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 229, 55, 16);
		panel.add(lblId);
		
		jtextFieldSecQ = new JTextField();
		jtextFieldSecQ.setBounds(219, 104, 161, 28);
		panel.add(jtextFieldSecQ);
		jtextFieldSecQ.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Your Security Question");
		lblNewLabel_1.setBounds(21, 104, 161, 26);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", lblNewLabel_1.getFont().getStyle(), 15));
		
		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(219, 64, 161, 28);
		panel.add(jtextFieldName);
		jtextFieldName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 66, 55, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", lblNewLabel.getFont().getStyle(), 15));
	}
	public void jbtnSearch_actionPerformed(ActionEvent arg0) {
		try {
			String username = jtextFieldUsername.getText();
			LibrarianModel librarianModel = new LibrarianModel();
			int r = librarianModel.search(username).getUsername().compareTo(username);
			if(r == 0) {
				jtextFieldUsername.setText(librarianModel.search(username).getUsername());
				jtextFieldName.setText(librarianModel.search(username).getName());
				jtextFieldSecQ.setText(librarianModel.search(username).getSec_q());
				jbtnRetrieve.setEnabled(true);
			} else if (librarianModel.search(username).getUsername() == null ){
				JOptionPane.showMessageDialog(null, "Not all, please sign up");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not all, please sign up");
			System.out.println(e.getMessage());
		}
	}
	public void jbtnRetrieve_actionPerformed(ActionEvent arg0) {	
		String username = jtextFieldUsername.getText();
		LibrarianModel librarianModel = new LibrarianModel();
		int r = librarianModel.search(username).getAnswer().compareTo(jtextFieldAnswer.getText());
		if(r == 0) {
			jtextFieldPassword.setText(librarianModel.search(username).getPassword());
			jtextFieldId.setText(String.valueOf(librarianModel.search(username).getId()));
		} else {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}
	}
	public void jbtnChange_actionPerformed(ActionEvent arg0) {
		try {
			Librarian l = new Librarian();
			l.setUsername(jtextFieldUsername.getText());
			l.setName(jtextFieldName.getText());
			l.setSec_q(jtextFieldSecQ.getText());
			l.setAnswer(jtextFieldAnswer.getText());
			l.setPassword(jtextFieldPassword.getText());
			l.setId(Integer.parseInt(jtextFieldId.getText()));
			LibrarianModel librarianModel = new LibrarianModel();
			if(librarianModel.update(l)) {
				JOptionPane.showMessageDialog(null, "Done");
			} else {
				JOptionPane.showMessageDialog(null, "Fail");
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
