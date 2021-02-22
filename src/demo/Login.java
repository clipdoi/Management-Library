package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import helpers.BCrypt;
import models.LibrarianModel;

import java.awt.Color;
import java.awt.Event;

import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordField;
	private JLabel jlblTroubleLogin;

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
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\Library\\src\\resources\\library.png"));
		setFont(new Font("Times New Roman", Font.BOLD, 16));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.setBackground(Color.ORANGE);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 250, 205)), "LOGIN", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panel.setBounds(6, 14, 396, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(162, 37, 169, 28);
		panel.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		JButton jbtnForgotPassword = new JButton(" Forgot  Password");
		jbtnForgotPassword.setForeground(new Color(139, 0, 0));
		jbtnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnForgotPassword_actionPerformed(arg0);
			}
		});
		jbtnForgotPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnForgotPassword.setIcon(new ImageIcon(Login.class.getResource("/resource/forgotpw.png")));
		jbtnForgotPassword.setBounds(162, 182, 158, 31);
		panel.add(jbtnForgotPassword);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setBounds(162, 90, 169, 28);
		panel.add(jpasswordField);
		
		JButton jbtnLogin = new JButton(" Login");
		jbtnLogin.setForeground(new Color(128, 0, 0));
		jbtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnLogin_actionPerformed(e);
			}
		});
		jbtnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jbtnLogin.setBackground(Color.CYAN);
		jbtnLogin.setIcon(new ImageIcon(Login.class.getResource("/resource/login.png")));
		jbtnLogin.setBounds(162, 139, 91, 31);
		panel.add(jbtnLogin);
		
		JButton jbtnSignUp = new JButton(" Sign up");
		jbtnSignUp.setForeground(new Color(128, 0, 0));
		jbtnSignUp.setBackground(Color.CYAN);
		jbtnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSignUp_actionPerformed(arg0);
			}
		});
		jbtnSignUp.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnSignUp.setIcon(new ImageIcon(Login.class.getResource("/resource/signup.png")));
		jbtnSignUp.setBounds(271, 139, 98, 31);
		panel.add(jbtnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Library\\src\\resources\\lock.png"));
		lblNewLabel.setBounds(353, 37, 16, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Library\\src\\resources\\key.png"));
		lblNewLabel_1.setBounds(353, 87, 16, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(22, 97, 81, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(22, 44, 81, 14);
		panel.add(lblUsername);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		jlblTroubleLogin = new JLabel("Trouble login !");
		jlblTroubleLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		jlblTroubleLogin.setForeground(new Color(255, 0, 0));
		jlblTroubleLogin.setBounds(22, 162, 128, 16);
		panel.add(jlblTroubleLogin);
	}
	public void jbtnLogin_actionPerformed(ActionEvent e) {
		try {
			String username = jtextFieldUsername.getText();
			String pw = String.valueOf(jpasswordField.getPassword());
			LibrarianModel librarianModel = new LibrarianModel();
			if(username.equals(librarianModel.search(username).getUsername()) && BCrypt.checkpw(pw, librarianModel.search(username).getPassword())) {
				this.setVisible(false);
				Home h = new Home();
				h.setVisible(true);
				h.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			}
		} catch (Exception e2) {
			jlblTroubleLogin.setText(e2.getMessage());
			System.out.println(e2.getMessage());
		}
	}
	public void jbtnSignUp_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		Sign_up s = new Sign_up();
		s.setVisible(true);
		s.setLocationRelativeTo(null);
	}
	public void jbtnForgotPassword_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		Forgot f = new Forgot();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}
}
