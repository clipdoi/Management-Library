package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Category;
import models.CategoryModel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class JInternal_Category extends JInternalFrame {
	private JTextField txtAddCate;
	private JTextField txtUpdateCate;
	private JRadioButton rdbtnAddingCategory;
	private JRadioButton rdbtnUpdateCategory;
	private JButton btnSave;
	private JButton btnDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tableCate;

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
					JInternal_Category frame = new JInternal_Category();
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
	public JInternal_Category() {
		getContentPane().setBackground(new Color(118,90,61));
		setClosable(true);
		setBounds(100, 100, 995, 622);
		getContentPane().setLayout(null);

		rdbtnAddingCategory = new JRadioButton("Adding Category");
		rdbtnAddingCategory.setFont(new Font("SansSerif", Font.BOLD, 12));
		buttonGroup.add(rdbtnAddingCategory);
		rdbtnAddingCategory.setBounds(90, 105, 122, 18);
		getContentPane().add(rdbtnAddingCategory);

		rdbtnUpdateCategory = new JRadioButton("Update Category");
		rdbtnUpdateCategory.setFont(new Font("SansSerif", Font.BOLD, 12));
		buttonGroup.add(rdbtnUpdateCategory);
		rdbtnUpdateCategory.setBounds(646, 105, 115, 18);
		getContentPane().add(rdbtnUpdateCategory);

		txtAddCate = new JTextField();
		txtAddCate.setBounds(90, 140, 122, 28);
		getContentPane().add(txtAddCate);
		txtAddCate.setColumns(10);

		txtUpdateCate = new JTextField();
		txtUpdateCate.setBounds(646, 140, 122, 28);
		getContentPane().add(txtUpdateCate);
		txtUpdateCate.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0, 0, 139));
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCate_actionPerformed(e);
			}
		});
		btnSave.setBounds(646, 196, 90, 28);
		getContentPane().add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dropcate_actionPerformed(e);
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(646, 235, 90, 28);
		getContentPane().add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 106, 364, 267);
		getContentPane().add(scrollPane);

		tableCate = new JTable();
		tableCate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableCate_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(tableCate);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 139));
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_actionPerformed(e);
			}
		});
		btnAdd.setBounds(122, 196, 90, 28);
		getContentPane().add(btnAdd);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblCategory.setBounds(232, 11, 223, 38);
		getContentPane().add(lblCategory);
		CategoryModel model = new CategoryModel();
		load(model.readCate());

	}

	public void load(List<Category> categories) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Types");
		for (Category category : categories) {
			model.addRow(new Object[] { category.getId(), category.getName() });
		}
		tableCate.setModel(model);
		tableCate.getTableHeader().setReorderingAllowed(false);
	}

	public void Dropcate_actionPerformed(ActionEvent e) {
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure", "Yes", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int selectedIndex = tableCate.getSelectedRow();
				CategoryModel cateModel = new CategoryModel();
				String cate = tableCate.getValueAt(selectedIndex, 0).toString();
				if (cateModel.drop(cate)) {
					JOptionPane.showMessageDialog(null, "Drop Cate done!");
					load(cateModel.readCate());
				} else {
					JOptionPane.showMessageDialog(null, "Drop Cate failed!");
				}
			}
		} catch (Exception e2) {
			System.err.println("Drop cate fail" + e2.getMessage());
		}
	}

	public void Add_actionPerformed(ActionEvent e) {
		CategoryModel categoryModel = new CategoryModel();
		Category category = new Category();
		category.setName(txtAddCate.getText());
		if (categoryModel.insert(category)) {
			JOptionPane.showMessageDialog(null, "Insert Done");
			load(categoryModel.readCate());
		} else {
			JOptionPane.showMessageDialog(null, "Insert Failed");
		}
	}

	public void TableCate_mouseClicked(MouseEvent e) {
		try {
			int selectedRow = tableCate.getSelectedRow();
			CategoryModel model = new CategoryModel();
			Category category = model.findCate(tableCate.getValueAt(selectedRow, 0).toString());
			txtUpdateCate.setText(category.getName());
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
		}
	}

	public void UpdateCate_actionPerformed(ActionEvent e) {
		try {
			int selectedRow = tableCate.getSelectedRow();
			CategoryModel cateModel = new CategoryModel();
			int id = Integer.parseInt(tableCate.getValueAt(selectedRow, 0).toString());
			Category cate = new Category();
			cate.setName(txtUpdateCate.getText());
			cate.setId(id);
			if (cateModel.update(cate)) {
				JOptionPane.showMessageDialog(null, "Update Done");
				load(cateModel.readCate());
			} else {
				JOptionPane.showMessageDialog(null, "Update Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Cannot update cate");
			System.err.println("Cannot update cate" + e2.getMessage());
		}
	}
}
