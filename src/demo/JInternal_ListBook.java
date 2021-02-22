package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.Category;
import entities.IssueStatus;
import helpers.FileHelper;
import models.BookModel;
import models.CategoryModel;
import models.IssueModel;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import javax.swing.UIManager;

public class JInternal_ListBook extends JInternalFrame {
	private JTextField jtextFieldCallNum;
	private JTextField jtextFieldISBN;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldAuthor;
	private JTextField jtextFieldRent;
	private JTextField jtextFieldUserID;
	private JTextField jtextFieldUserName;
	private JTextField jtextFieldIssueDate;
	private JTextField jtextFieldDueDate;
	private JTextField jtextFieldSearch;
	private JTable jtableListBook;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton jradioButtonStatus;
	private JButton jbtnDelete;
	private JButton jbuttonUpdate;
	private JButton btnSetPhoto;
	private JRadioButton jradioButtonCallNumber;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JButton jbuttonSearch;
	private JPanel panel_checkout;
	private JComboBox jcomboBoxType;
	private JLabel jlblPhoto;
	private File selectedFile;
	private JButton btnCategory;

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
					JInternal_ListBook frame = new JInternal_ListBook();
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
	public JInternal_ListBook() {
		getContentPane().setBackground(new Color(118, 90, 61));
		setBackground(new Color(118, 90, 61));
		setBounds(100, 100, 993, 681);
		getContentPane().setLayout(null);

		JLabel lblCallNumber = new JLabel("Call Number");
		lblCallNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCallNumber.setBounds(10, 92, 102, 16);
		getContentPane().add(lblCallNumber);

		JLabel lblListBook = new JLabel("LIST BOOK");
		lblListBook.setForeground(new Color(255, 255, 255));
		lblListBook.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblListBook.setBounds(349, 18, 183, 33);
		getContentPane().add(lblListBook);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 174, 102, 16);
		getContentPane().add(lblTitle);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthor.setBounds(10, 215, 102, 16);
		getContentPane().add(lblAuthor);

		JLabel lblRentPrice = new JLabel("Rent Price");
		lblRentPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRentPrice.setBounds(10, 256, 102, 16);
		getContentPane().add(lblRentPrice);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(10, 296, 102, 16);
		getContentPane().add(lblType);

		jtextFieldCallNum = new JTextField();
		jtextFieldCallNum.setColumns(10);
		jtextFieldCallNum.setBounds(122, 87, 217, 30);
		getContentPane().add(jtextFieldCallNum);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setColumns(10);
		jtextFieldISBN.setBounds(122, 128, 217, 30);
		getContentPane().add(jtextFieldISBN);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(122, 169, 217, 30);
		getContentPane().add(jtextFieldTitle);

		jtextFieldAuthor = new JTextField();
		jtextFieldAuthor.setColumns(10);
		jtextFieldAuthor.setBounds(122, 210, 217, 30);
		getContentPane().add(jtextFieldAuthor);

		jtextFieldRent = new JTextField();
		jtextFieldRent.setColumns(10);
		jtextFieldRent.setBounds(122, 251, 217, 30);
		getContentPane().add(jtextFieldRent);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIsbn.setBounds(10, 133, 102, 16);
		getContentPane().add(lblIsbn);

		jcomboBoxType = new JComboBox();
		jcomboBoxType.setBounds(122, 292, 218, 27);
		getContentPane().add(jcomboBoxType);

		panel_checkout = new JPanel();
		panel_checkout
				.setBorder(new TitledBorder(null, "Check - out", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_checkout.setBounds(87, 415, 280, 225);
		getContentPane().add(panel_checkout);
		panel_checkout.setLayout(null);

		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setBounds(10, 38, 84, 16);
		panel_checkout.add(lblUserId);

		jtextFieldUserID = new JTextField();
		jtextFieldUserID.setEditable(false);
		jtextFieldUserID.setColumns(10);
		jtextFieldUserID.setBounds(97, 32, 173, 30);
		panel_checkout.add(jtextFieldUserID);

		jtextFieldUserName = new JTextField();
		jtextFieldUserName.setEditable(false);
		jtextFieldUserName.setColumns(10);
		jtextFieldUserName.setBounds(97, 83, 173, 30);
		panel_checkout.add(jtextFieldUserName);

		jtextFieldIssueDate = new JTextField();
		jtextFieldIssueDate.setEditable(false);
		jtextFieldIssueDate.setColumns(10);
		jtextFieldIssueDate.setBounds(97, 138, 173, 30);
		panel_checkout.add(jtextFieldIssueDate);

		jtextFieldDueDate = new JTextField();
		jtextFieldDueDate.setEditable(false);
		jtextFieldDueDate.setColumns(10);
		jtextFieldDueDate.setBounds(97, 184, 173, 30);
		panel_checkout.add(jtextFieldDueDate);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 89, 84, 16);
		panel_checkout.add(lblName);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(10, 144, 84, 16);
		panel_checkout.add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(10, 192, 84, 16);
		panel_checkout.add(lblTo);

		jlblPhoto = new JLabel("");
		jlblPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlblPhoto.setBounds(349, 92, 171, 155);
		getContentPane().add(jlblPhoto);

		btnSetPhoto = new JButton("Set Photo");
		btnSetPhoto.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSetPhoto.setForeground(new Color(0, 0, 139));
		btnSetPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				UpdateIMG_actionPerformed(e);
			}
		});
		btnSetPhoto.setBounds(387, 251, 102, 28);
		getContentPane().add(btnSetPhoto);

		jtextFieldSearch = new JTextField();
		jtextFieldSearch.setColumns(10);
		jtextFieldSearch.setBounds(537, 80, 328, 28);
		getContentPane().add(jtextFieldSearch);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.setIcon(new ImageIcon(JInternal_ListBook.class.getResource("/resource/search.png")));
		jbuttonSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonSearch.setForeground(new Color(0, 0, 139));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_actionPerformed(e);
			}
		});
		jbuttonSearch.setBounds(877, 80, 90, 28);
		getContentPane().add(jbuttonSearch);

		jradioButtonCallNumber = new JRadioButton("Call Number");
		buttonGroup.add(jradioButtonCallNumber);
		jradioButtonCallNumber.setBounds(537, 121, 96, 18);
		getContentPane().add(jradioButtonCallNumber);

		radioButton_1 = new JRadioButton("ISBN");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(645, 121, 75, 18);
		getContentPane().add(radioButton_1);

		radioButton_2 = new JRadioButton("Title");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(732, 121, 60, 18);
		getContentPane().add(radioButton_2);

		radioButton_3 = new JRadioButton("Author's name");
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(822, 121, 102, 18);
		getContentPane().add(radioButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(537, 151, 430, 489);
		getContentPane().add(scrollPane);

		jtableListBook = new JTable();
		jtableListBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableListBook);

		jradioButtonStatus = new JRadioButton("In library");
		jradioButtonStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		jradioButtonStatus.setBounds(144, 332, 90, 18);
		getContentPane().add(jradioButtonStatus);

		jbuttonUpdate = new JButton("Update");
		jbuttonUpdate.setForeground(new Color(0, 0, 139));
		jbuttonUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_actionPerformed(e);
			}
		});
		jbuttonUpdate.setBounds(133, 376, 90, 28);
		getContentPane().add(jbuttonUpdate);

		jbtnDelete = new JButton("Delete");
		jbtnDelete.setForeground(new Color(0, 0, 139));
		jbtnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drop_actionPerformed(e);
			}
		});
		jbtnDelete.setBounds(233, 376, 90, 28);
		getContentPane().add(jbtnDelete);

		JButton jbuttonAddBook = new JButton("ADD");
		jbuttonAddBook.setForeground(new Color(0, 0, 139));
		jbuttonAddBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddBook_actionPerformed(e);
			}
		});
		jbuttonAddBook.setBounds(0, 0, 89, 23);
		getContentPane().add(jbuttonAddBook);

		btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCategory.setForeground(new Color(0, 0, 139));
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Category_actionPerformed(arg0);
			}
		});
		btnCategory.setBounds(108, 0, 89, 23);
		getContentPane().add(btnCategory);
		BookModel model = new BookModel();
		load(model.read());
		loadData();
		loadCate();
//		status();

	}

	// user check-out form
//	private boolean status() {
//		if (jradioButtonStatus.isSelected()) {
//			panel_checkout.setVisible(false);
//		} else {
//			panel_checkout.setVisible(true);
//		}
//		return false;
//	}

	public void loadData() {
		BookModel bookModel = new BookModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		for (Book b : bookModel.read()) {
			defaultTableModel.addRow(new Object[] { b.getCallnumber(), b.getIsbn(),
					b.getTitle(), b.getAuthor() });
		}
		jtableListBook.setModel(defaultTableModel);
		jtableListBook.getTableHeader().setReorderingAllowed(false);
	}

	public void load(List<Book> book) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Call Number");
		model.addColumn("ISBN");
		model.addColumn("Title");
		model.addColumn("Author");
		for (Book books : book) {
			model.addRow(new Object[] { books.getCallnumber(), books.getIsbn(),
					books.getTitle(), books.getAuthor() });
		}
		jtableListBook.setModel(model);
		jtableListBook.getTableHeader().setReorderingAllowed(false);
	}
	public void loadCate() {
		CategoryModel cateModel = new CategoryModel();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (Category cate : cateModel.readCate()) {
			model.addElement(cate.getName());
		}
		jcomboBoxType.setModel(model);
	}

	public void table_mouseClicked(MouseEvent e) {
		try {
			int selectedRow = jtableListBook.getSelectedRow();
			BookModel model = new BookModel();		
			Book book = model.find(jtableListBook.getValueAt(selectedRow, 0).toString());
			jtextFieldCallNum.setText(book.getCallnumber());
			jtextFieldISBN.setText(String.valueOf(book.getIsbn()));
			jtextFieldTitle.setText(book.getTitle());
			jtextFieldAuthor.setText(book.getAuthor());
			jtextFieldRent.setText(String.valueOf(book.getRentprice()));
			jradioButtonStatus.setSelected(book.isStatus());
			jcomboBoxType.setSelectedItem(book.getC().getName());
			jlblPhoto.setIcon(new ImageIcon(book.getPhoto()));
			if (book.isStatus() == true) {
				jtextFieldUserID.setText("UserID");
				jtextFieldUserName.setText("Name");
				jtextFieldIssueDate.setText("Issue Date");
				jtextFieldDueDate.setText("Due Date");
			} else {
				IssueModel returnModel = new IssueModel();
				IssueStatus issueStatus = returnModel.findIssueId(jtableListBook.getValueAt(selectedRow, 1).toString());	
				jtextFieldUserID.setText(String.valueOf(issueStatus.getUser_issue()));
				jtextFieldUserName.setText(returnModel.findIssueId(jtableListBook.getValueAt(selectedRow, 1).toString()).getName());
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("E,  MMMM-dd-yyyy");
				jtextFieldIssueDate.setText(dateFormat.format(issueStatus.getIssue_date()));
				jtextFieldDueDate.setText(dateFormat.format(issueStatus.getDue_date()));

			}

		} catch (Exception e2) {
			System.err.println(e2.getMessage());
			JOptionPane.showMessageDialog(null, "Error has occur: " + e2.getMessage());
		}
	}

	public void update_actionPerformed(ActionEvent e) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			int selectIndex = jcomboBoxType.getSelectedIndex();
			Category category = categoryModel.readCate().get(selectIndex);
			
			byte[] photo = FileHelper.convertFileToBytes(selectedFile);
			int selectedRow = jtableListBook.getSelectedRow();
			String call = jtableListBook.getValueAt(selectedRow, 0).toString();

			BookModel model = new BookModel();
			Book book = new Book();
			book.setIsbn(jtextFieldISBN.getText());
			book.setAuthor(jtextFieldAuthor.getText());
			book.setC(category);
			book.setRentprice(Double.parseDouble(jtextFieldRent.getText()));
			book.setStatus(jradioButtonStatus.isSelected());
			book.setTitle(jtextFieldTitle.getText());
			book.setCallnumber(call);
			book.setPhoto(photo);
			// update comboboxType
			book.setC(category);
			// --------------------------------
			
			if (model.update(book)) {
				JOptionPane.showMessageDialog(null, "Update Done");
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Update Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Cannot update Book");
			System.err.println("Cannot update Book" + e2.getMessage());
		}
	}

	public void drop_actionPerformed(ActionEvent e) {
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure to drop the book ?", "Yes",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int selectedRow = jtableListBook.getSelectedRow();
				String call = jtableListBook.getValueAt(selectedRow, 0).toString();
				BookModel model = new BookModel();
				if (model.drop(call)) {
					JOptionPane.showMessageDialog(null, "Drop done!");
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "Drop Failed!");
				}
			}
			jbtnDelete.setEnabled(false);
		} catch (Exception e2) {
			System.err.println("Drop fail" + e2.getMessage());
		}
	}

	public void Search_actionPerformed(ActionEvent e) {
		try {
			String keyword = jtextFieldSearch.getText().trim();
			int limit = 20;
			BookModel model = new BookModel();
			String type = getSearchType();
			if (type.contentEquals("Call Number")) {
				load(model.searchCallNumber(keyword.toLowerCase(), limit));
			} else if (type.contentEquals("ISBN")) {
				load(model.searchISBN(keyword, limit));
			} else if (type.contentEquals("Title")) {
				load(model.searchTitle(keyword, limit));
			} else if (type.contentEquals("Author's name")) {
				load(model.searchAuthor(keyword, limit));
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Invalid Search");
			e1.printStackTrace();
		}

	}

	private String getSearchType() {
		Enumeration<AbstractButton> radios = buttonGroup.getElements();
		while (radios.hasMoreElements()) {
			JRadioButton radioButton = (JRadioButton) radios.nextElement();
			if (radioButton.isSelected()) {
				return radioButton.getText();
			}
		}
		return null;
	}

//	public void Check_out_actionPerformed(ActionEvent e) {
//		if (jradioButtonStatus.isSelected()) {
//			panel_checkout.setVisible(false);
//		} else {
//			panel_checkout.setVisible(true);
//		}
//	}

	public void UpdateIMG_actionPerformed(ActionEvent e) {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select a photo");
			chooser.setMultiSelectionEnabled(false);
			chooser.setFileFilter(new FileTypeFilter(".gif", "GIF(*.gif)"));
			chooser.setFileFilter(new FileTypeFilter(".png", "PNG(*.png)"));
			chooser.setFileFilter(new FileTypeFilter(".jpg", "JPG(*.jpg)"));
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				selectedFile = chooser.getSelectedFile();
				jlblPhoto.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, " No Photo Found " + e2.getMessage());
		}
	}

	public void jbuttonAddBook_actionPerformed(ActionEvent e) {
		JDesktopPane desktopPane = getDesktopPane();
		desktopPane.removeAll();
		desktopPane.updateUI();
		JInternal_AddBook internalFrameAddBook = new JInternal_AddBook();
		internalFrameAddBook.setVisible(true);
		desktopPane.add(internalFrameAddBook);
		try {
			internalFrameAddBook.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

	}

	public void Category_actionPerformed(ActionEvent arg0) {
		JDesktopPane desktopPane = getDesktopPane();
		desktopPane.removeAll();
		desktopPane.updateUI();
		JInternal_Category interCategory = new JInternal_Category();
		interCategory.setVisible(true);
		desktopPane.add(interCategory);
		try {
			interCategory.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
}
