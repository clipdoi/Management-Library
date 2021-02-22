package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

//import sun.security.jgss.LoginConfigImpl;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMenu;
	private JButton jbuttonUser;
	private JButton jbuttonBook;
	private JButton jbuttonReturn;
	private JButton jbuttonIssued;
	private JPanel jpanelDestoppane;
	private JDesktopPane jdesktopPaneMain;
	private JPanel panellines;
	private JLabel lableMenu;
	private JPanel panellines2;
	private JLabel label_1;
	private JButton btnLogOut;
	private JButton btnNewButton;
	private JButton btnStatic;

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
					Home frame = new Home();
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
	public Home() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("LIBRARY MANAGEMENT MOHAN LTD.");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Home.class.getResource("/resource/iconfinder_book_285636.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpanelMenu = new JPanel();
		jpanelMenu.setBackground(new Color(118, 90, 61));
		jpanelMenu.setBounds(0, 0, 271, 681);
		contentPane.add(jpanelMenu);
		jpanelMenu.setLayout(null);

		jbuttonBook = new JButton("         BOOK");
		jbuttonBook.setForeground(new Color(0, 0, 139));
		jbuttonBook.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonBook.setIcon(new ImageIcon(Home.class.getResource("/resource/iconfinder_book_214658.png")));
		jbuttonBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBook_actionPerformed(e);
			}
		});
		jbuttonBook.setBounds(98, 98, 152, 43);
		jpanelMenu.add(jbuttonBook);

		jbuttonUser = new JButton("         USER");
		jbuttonUser.setForeground(new Color(0, 0, 139));
		jbuttonUser.setIcon(new ImageIcon(Home.class.getResource("/resource/iconfinder_user_male4_172628.png")));
		jbuttonUser.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonUser.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbuttonUser_actionPerformed(arg0);
			}
		});
		jbuttonUser.setBounds(98, 179, 152, 43);
		jpanelMenu.add(jbuttonUser);

		jbuttonIssued = new JButton("         ISSUED");
		jbuttonIssued.setForeground(new Color(0, 0, 139));
		jbuttonIssued.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonIssued.setIcon(new ImageIcon(
				Home.class.getResource("/resource/iconfinder_round-trip-return-repeat_2075799 (1).png")));
		jbuttonIssued.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonIssued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbuttonIssued_actionPerformed(arg0);
			}
		});
		jbuttonIssued.setBounds(98, 258, 152, 43);
		jpanelMenu.add(jbuttonIssued);

		jbuttonReturn = new JButton("        RETURN");
		jbuttonReturn.setForeground(new Color(0, 0, 139));
		jbuttonReturn.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonReturn.setIcon(new ImageIcon(Home.class.getResource("/resource/iconfinder_v-5_3162598.png")));
		jbuttonReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonReturnBook_actionPerformed(e);
			}
		});
		jbuttonReturn.setBounds(98, 339, 152, 43);
		jpanelMenu.add(jbuttonReturn);

		panellines = new JPanel();
		panellines.setBounds(58, 98, 1, 423);
		jpanelMenu.add(panellines);

		lableMenu = new JLabel("Menu");
		lableMenu.setForeground(new Color(0, 0, 0));
		lableMenu.setFont(new Font("Modern No. 20", Font.BOLD, 27));
		lableMenu.setBounds(117, 16, 80, 36);
		jpanelMenu.add(lableMenu);

		panellines2 = new JPanel();
		panellines2.setBounds(78, 64, 187, 1);
		jpanelMenu.add(panellines2);

		btnLogOut = new JButton(" Log Out");
		btnLogOut.setIcon(new ImageIcon(Home.class.getResource("/resource/back.png")));
		btnLogOut.setForeground(new Color(255, 0, 0));
		btnLogOut.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnLogout_actionPerformed(arg0);
			}
		});
		btnLogOut.setBounds(6, 640, 95, 36);
		jpanelMenu.add(btnLogOut);
		
		btnNewButton = new JButton("HISTORY");
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnHistory_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(98, 508, 152, 43);
		jpanelMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.setForeground(new Color(65, 105, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnAbout_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_1.setBounds(137, 602, 90, 31);
		jpanelMenu.add(btnNewButton_1);
		
		btnStatic = new JButton("STATIC");
		btnStatic.setForeground(new Color(0, 0, 139));
		btnStatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStatic_actionPerformed(e);
			}
		});
		btnStatic.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnStatic.setBounds(98, 424, 152, 43);
		jpanelMenu.add(btnStatic);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 271, 681);
		contentPane.add(label);
		label.setIcon(null);

		jpanelDestoppane = new JPanel();
		jpanelDestoppane.setBounds(271, 0, 993, 681);
		contentPane.add(jpanelDestoppane);
		jpanelDestoppane.setLayout(new BorderLayout(0, 0));

		jdesktopPaneMain = new JDesktopPane();
		jdesktopPaneMain.setBackground(Color.WHITE);
		jpanelDestoppane.add(jdesktopPaneMain, BorderLayout.CENTER);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/resource/background2.jpg")));
		label_1.setBounds(0, 0, 993, 681);
		jdesktopPaneMain.add(label_1);
	}
	public void btnStatic_actionPerformed(ActionEvent e) {
		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_Static jinternal_static = new JInternal_Static();
		jinternal_static.setVisible(true);
		jdesktopPaneMain.add(jinternal_static);
		try {
			jinternal_static.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
	}

	public void jbuttonBook_actionPerformed(ActionEvent e) {

		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_AddBook jInternalFrameAddBook = new JInternal_AddBook();
		jInternalFrameAddBook.setVisible(true);
		jdesktopPaneMain.add(jInternalFrameAddBook);
		try {
			jInternalFrameAddBook.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

	}

	public void jbuttonUser_actionPerformed(ActionEvent arg0) {

		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_Employee jInternalFrameAddEmployee = new JInternal_Employee();
		jInternalFrameAddEmployee.setVisible(true);
		jdesktopPaneMain.add(jInternalFrameAddEmployee);
		try {
			jInternalFrameAddEmployee.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

	}

	public void jbuttonIssued_actionPerformed(ActionEvent arg0) {
		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_Issue interIssue = new JInternal_Issue();
		interIssue.setVisible(true);
		jdesktopPaneMain.add(interIssue);
		try {
			interIssue.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}

	public void jbuttonReturnBook_actionPerformed(ActionEvent e) {
		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		jinternal_Return interReturn = new jinternal_Return();
		interReturn.setVisible(true);
		jdesktopPaneMain.add(interReturn);
		try {
			interReturn.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void jbtnHistory_actionPerformed(ActionEvent e) {
		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_History h = new JInternal_History();
		h.setVisible(true);
		jdesktopPaneMain.add(h);
		try {
			h.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
	public void jbtnLogout_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		Login l = new Login();
		l.setVisible(true);
		l.setLocationRelativeTo(null);
	}
	public void jbtnAbout_actionPerformed(ActionEvent arg0) {
		jdesktopPaneMain.removeAll();
		jdesktopPaneMain.updateUI();

		JInternal_About j = new JInternal_About();
		j.setVisible(true);
		jdesktopPaneMain.add(j);
		try {
			j.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
}
