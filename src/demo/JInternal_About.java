package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Employee;
import models.EmployeeModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JInternal_About extends JInternalFrame {

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
					JInternal_About frame = new JInternal_About();
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
	public JInternal_About() {
		getContentPane().setBackground(new Color(118, 90, 61));
		setBounds(100, 100, 993, 681);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JInternal_About.class.getResource("/resource/load.png")));
		label.setBackground(Color.BLACK);
		label.setBounds(346, 133, 200, 200);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Group Code Medium,  was borned anywhere ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(346, 362, 376, 44);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact:  hongson16420@gmail.com");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(346, 470, 300, 37);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" and were died any challenge.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(346, 418, 361, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblAbout = new JLabel("ABOUT");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblAbout.setBounds(346, 44, 240, 93);
		getContentPane().add(lblAbout);

		EmployeeModel employeeModel = new EmployeeModel();
		loadData(employeeModel.findAll());
	}

	private void loadData(List<Employee> employees) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Adress");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Department");
		for (Employee employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhone(), employee.getDepartment() });
		}
	}
}
