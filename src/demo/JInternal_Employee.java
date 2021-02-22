package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import entities.Employee;
import models.EmployeeModel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class JInternal_Employee extends JInternalFrame{
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldDepartment;
	private JTextField jtextFieldId;
	private JTable jtableEmployee;
	private JButton jbtnUpdate;
	private JButton jbtnDelete;
	private JTextField jtextFieldSearch;

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
					JInternal_Employee frame = new JInternal_Employee();
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
	public JInternal_Employee() {
		getContentPane().setBackground(new Color(118, 90, 61));
		setBounds(100, 100, 983, 653);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(25, 210, 52, 30);
		getContentPane().add(lblName);
		
		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(137, 211, 253, 30);
		getContentPane().add(jtextFieldName);
		jtextFieldName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(25, 289, 78, 14);
		getContentPane().add(lblAddress);
		
		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(137, 282, 253, 30);
		getContentPane().add(jtextFieldAddress);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(137, 356, 253, 30);
		getContentPane().add(jtextFieldPhone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(25, 363, 78, 14);
		getContentPane().add(lblPhone);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDepartment.setBounds(25, 438, 93, 14);
		getContentPane().add(lblDepartment);
		
		jtextFieldDepartment = new JTextField();
		jtextFieldDepartment.setColumns(10);
		jtextFieldDepartment.setBounds(137, 431, 253, 30);
		getContentPane().add(jtextFieldDepartment);
		
		JButton jbuttonSave = new JButton("SAVE");
		jbuttonSave.setForeground(new Color(0, 0, 139));
		jbuttonSave.setFont(new Font("Segoe Print", Font.BOLD, 16));
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbuttonSave_actionPerformed(arg0);
			}
		});
		jbuttonSave.setBounds(137, 507, 146, 38);
		getContentPane().add(jbuttonSave);
		
		JLabel lblNewLabel = new JLabel("ADD USER");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel.setBounds(137, 30, 195, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(25, 148, 55, 16);
		getContentPane().add(lblId);
		
		jtextFieldId = new JTextField();
		jtextFieldId.setBounds(137, 143, 253, 28);
		getContentPane().add(jtextFieldId);
		jtextFieldId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(438, 141, 495, 374);
		getContentPane().add(scrollPane);
		
		jtableEmployee = new JTable();
		jtableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jtableEmployee_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(jtableEmployee);
		
		jbtnDelete = new JButton("Delete");
		jbtnDelete.setForeground(new Color(0, 0, 139));
		jbtnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnDelete_actionPerformed(e);
			}
		});
		jbtnDelete.setBounds(843, 527, 90, 28);
		getContentPane().add(jbtnDelete);
		
		jbtnUpdate = new JButton("Update");
		jbtnUpdate.setForeground(new Color(0, 0, 139));
		jbtnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnUpdate_actionPerformed(e);
			}
		});
		jbtnUpdate.setBounds(510, 527, 90, 28);
		getContentPane().add(jbtnUpdate);
		
		jtextFieldSearch = new JTextField();
		jtextFieldSearch.setBounds(438, 101, 272, 28);
		getContentPane().add(jtextFieldSearch);
		jtextFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(JInternal_Employee.class.getResource("/resource/search.png")));
		btnSearch.setForeground(new Color(0, 0, 139));
		btnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(754, 101, 90, 28);
		getContentPane().add(btnSearch);
		loadData();
	}	
	
	public void jbtnSearch_actionPerformed(ActionEvent e) {
		try {
			String s = jtextFieldSearch.getText().trim();
			EmployeeModel employeeModel = new EmployeeModel();
			DefaultTableModel defaultTableModel = new DefaultTableModel();
			defaultTableModel.addColumn("Id");
			defaultTableModel.addColumn("Name");
			defaultTableModel.addColumn("Address");
			defaultTableModel.addColumn("Phone");
			defaultTableModel.addColumn("Department");
			for(Employee p:employeeModel.search(s)) {
				defaultTableModel.addRow(new Object[] {
					p.getId(),
					p.getName(),
					p.getAddress(),
					p.getPhone(),
					p.getDepartment()
				});
			}
			jtableEmployee.setModel(defaultTableModel);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	public void jbuttonSave_actionPerformed(ActionEvent arg0) {
		try {
			Employee e = new Employee();
			e.setId(Integer.parseInt(jtextFieldId.getText()));
			e.setName(jtextFieldName.getText().trim());
			e.setAddress(jtextFieldAddress.getText().trim());
			e.setPhone(jtextFieldPhone.getText().trim());
			e.setDepartment(jtextFieldDepartment.getText().trim());
			
			EmployeeModel employeeModel = new EmployeeModel();
			if (employeeModel.create(e)) {
				JOptionPane.showMessageDialog(null, "Done");
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void jtableEmployee_mouseClicked(MouseEvent arg0) {
		try {
			jbtnDelete.setEnabled(true);
			jbtnUpdate.setEnabled(true);
			int selectedRow = jtableEmployee.getSelectedRow();
			int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
			EmployeeModel employeeModel = new EmployeeModel();
			Employee e = employeeModel.find(id);
			jtextFieldId.setText(String.valueOf(e.getId()));
			jtextFieldName.setText(e.getName());
			jtextFieldPhone.setText(e.getPhone());
			jtextFieldAddress.setText(e.getAddress());
			jtextFieldDepartment.setText(e.getDepartment());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void jbtnUpdate_actionPerformed(ActionEvent e) {
		try {
			int selectedRow = jtableEmployee.getSelectedRow();
			int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(jtextFieldId.getText()));
			employee.setName(jtextFieldName.getText());
			employee.setAddress(jtextFieldAddress.getText());
			employee.setPhone(jtextFieldPhone.getText());
			employee.setDepartment(jtextFieldDepartment.getText());
			//employee.setId(id);
			EmployeeModel employeeModel = new EmployeeModel();
			if (employeeModel.update(employee, id)) {
				JOptionPane.showMessageDialog(null, "Done");
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	public void jbtnDelete_actionPerformed(ActionEvent e) {
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int selectedRow = jtableEmployee.getSelectedRow();
				int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
				EmployeeModel employeeModel = new EmployeeModel();
				if (employeeModel.delete(id)) {
					JOptionPane.showMessageDialog(null, "Done");
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
			jbtnDelete.setEnabled(false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	private void loadData() {
		EmployeeModel employeeModel = new EmployeeModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Department");
		for(Employee p:employeeModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				p.getId(),
				p.getName(),
				p.getAddress(),
				p.getPhone(),
				p.getDepartment()
			});
		}
		jtableEmployee.setModel(defaultTableModel);
	}
}
