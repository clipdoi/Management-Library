package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.Employee;
import entities.IssueStatus;
import models.BookModel;
import models.EmployeeModel;
import models.IssueModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import org.freixas.jcalendar.JCalendarCombo;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class JInternal_Issue extends JInternalFrame {
	private JTextField txtToday;
	private JTable tableUser;
	private JTable tableBook;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JRadioButton rdbtnEmployeesName;
	private JRadioButton rdbtnCall;
	private JRadioButton rdbtnAuthor;
	private JRadioButton rdbtnTitle;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnIssueBook;
	private JTextField txtName;
	private JTextField txtTitle;
	private JTextField txtTo;

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
					JInternal_Issue frame = new JInternal_Issue();
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
	public JInternal_Issue() {
		getContentPane().setBackground(new Color(118, 90, 61));
		setClosable(true);
		setBounds(100, 100, 993, 660);
		getContentPane().setLayout(null);

		txtToday = new JTextField();
		txtToday.setEditable(false);
		txtToday.setText("Today");
		txtToday.setBounds(73, 128, 154, 28);
		getContentPane().add(txtToday);
		txtToday.setColumns(10);

		JScrollPane scrollPaneUser = new JScrollPane();

		scrollPaneUser.setBounds(73, 249, 397, 263);
		getContentPane().add(scrollPaneUser);

		tableUser = new JTable();
		tableUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserTable_mouseClicked(e);
			}
		});
		scrollPaneUser.setViewportView(tableUser);

		JScrollPane scrollPaneBook = new JScrollPane();
		scrollPaneBook.setBounds(515, 249, 397, 263);
		getContentPane().add(scrollPaneBook);

		tableBook = new JTable();
		tableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookTable_mouseClicked(e);
			}
		});
		scrollPaneBook.setViewportView(tableBook);

		txtSearch = new JTextField();
		txtSearch.setBounds(515, 128, 391, 28);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		rdbtnEmployeesName = new JRadioButton("Employee's Name");
		rdbtnEmployeesName.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnEmployeesName);
		rdbtnEmployeesName.setBounds(515, 163, 130, 23);
		getContentPane().add(rdbtnEmployeesName);

		rdbtnCall = new JRadioButton("Call Number");
		rdbtnCall.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnCall);
		rdbtnCall.setBounds(657, 163, 98, 23);
		getContentPane().add(rdbtnCall);

		rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnAuthor);
		rdbtnAuthor.setBounds(767, 163, 64, 23);
		getContentPane().add(rdbtnAuthor);

		rdbtnTitle = new JRadioButton("Title");
		rdbtnTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnTitle);
		rdbtnTitle.setBounds(854, 163, 52, 23);
		getContentPane().add(rdbtnTitle);

		btnSearch = new JButton(" Search");
		btnSearch.setIcon(new ImageIcon(JInternal_Issue.class.getResource("/resource/search.png")));
		btnSearch.setForeground(new Color(0, 0, 139));
		btnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_actionPerformed(e);
			}
		});
		btnSearch.setBounds(808, 208, 98, 30);
		getContentPane().add(btnSearch);

		btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setForeground(new Color(0, 0, 139));
		btnIssueBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBook_actionPerformed(e);
			}
		});
		btnIssueBook.setBounds(438, 566, 109, 36);
		getContentPane().add(btnIssueBook);

		txtName = new JTextField();
		txtName.setBounds(348, 128, 122, 28);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(348, 181, 122, 28);
		getContentPane().add(txtTitle);

		txtTo = new JTextField();
		txtTo.setEditable(false);
		txtTo.setColumns(10);
		txtTo.setBounds(73, 181, 154, 28);
		getContentPane().add(txtTo);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom.setBounds(20, 125, 52, 30);
		getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(20, 178, 52, 30);
		getContentPane().add(lblTo);

		JLabel lblIssuedBook = new JLabel("ISSUED BOOK");
		lblIssuedBook.setForeground(new Color(255, 255, 255));
		lblIssuedBook.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblIssuedBook.setBounds(370, 11, 223, 38);
		getContentPane().add(lblIssuedBook);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(258, 125, 52, 30);
		getContentPane().add(lblUser);

		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookName.setBounds(258, 179, 89, 30);
		getContentPane().add(lblBookName);
		EmployeeModel employeeModel = new EmployeeModel();
		loadUser(employeeModel.findAll());
		BookModel bookModel = new BookModel();
		loadBook(bookModel.read());
		loadDate();
	}

	// 1.tables load user and book
	private void loadUser(List<Employee> list) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		for (Employee employee : list) {
			model.addRow(new Object[] { employee.getId(), employee.getName() });
		}
		tableUser.setModel(model);
	}

	private void loadBook(List<Book> books) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CallNumber");
		model.addColumn("Title");
		model.addColumn("Author");
		for (Book book : books) {
			model.addRow(new Object[] { book.getCallnumber(), book.getTitle(), book.getAuthor() });
		}
		tableBook.setModel(model);
	}

//end of 1

	public void loadDate() {
		SimpleDateFormat format = new SimpleDateFormat("E, MMMM-dd-yyyy");
		txtToday.setText(format.format(new Date()));
		Calendar c = Calendar.getInstance();
		duedate(c);
		txtTo.setText(format.format(c.getTime()));
	}

	// Search
	public void Search_actionPerformed(ActionEvent e) {
		try {

			String keyword = txtSearch.getText().trim();
			BookModel bookModel = new BookModel();
			EmployeeModel employeeModel = new EmployeeModel();
			int limit = 20;
			String type = getSearchType();
			if (type.contentEquals("Call Number")) {
				loadBook(bookModel.searchCallNumber(keyword.toLowerCase(), limit));
			} else if (type.contentEquals("ISBN")) {
				loadBook(bookModel.searchISBN(keyword.trim(), limit));
			} else if (type.contentEquals("Title")) {
				loadBook(bookModel.searchTitle(keyword.toLowerCase(), limit));
			} else if (type.contentEquals("Author's name")) {
				loadBook(bookModel.searchAuthor(keyword.toLowerCase(), limit));
			} else if (type.contentEquals("Employee's Name")) {
				loadUser(employeeModel.search(keyword.toLowerCase()));
			}
		} catch (Exception e2) {
			System.err.println("Can't search Issue: " + e2.getMessage());
		}
	}

	private String getSearchType() {
		Enumeration<AbstractButton> radios = buttonGroup.getElements();
		while (radios.hasMoreElements()) {
			JRadioButton radioButton = (JRadioButton) radios.nextElement();
			if (radioButton.isSelected()) {
				EmployeeModel employeeModel = new EmployeeModel();
				loadUser(employeeModel.findAll());
				BookModel bookModel = new BookModel();
				loadBook(bookModel.read());
				return radioButton.getText();
			}
		}
		return null;
	}
	// end of search......................................

	// Issuebook button action submit
	public void IssueBook_actionPerformed(ActionEvent e) {

		int selectedUserRow = tableUser.getSelectedRow();
		int selectedBookRow = tableBook.getSelectedRow();
		int IDuser = Integer.parseInt(tableUser.getValueAt(selectedUserRow, 0).toString());

		String callBook = tableBook.getValueAt(selectedBookRow, 0).toString();
		IssueModel model = new IssueModel();
		IssueStatus issue = new IssueStatus();

		BookModel bookModel = new BookModel();
		Book book = bookModel.find(callBook);
		issue.setBook_name(book.getTitle());
		issue.setIsbn_book(book.getIsbn());
		book.setStatus(false);

		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = employeeModel.find(IDuser);
		issue.setUser_issue(IDuser);

		Calendar c = Calendar.getInstance();
		duedate(c);
		issue.setDue_date(c.getTime());

		if (model.createIssue(issue)) {
			JOptionPane.showMessageDialog(null, "Action done!");
		} else {
			JOptionPane.showMessageDialog(null, "Action Failed!");
		}
	}

	public Calendar duedate(Calendar c) {
		c.setTime(new Date());
		c.add(Calendar.DATE, 5);
		return c;
	}

	// Table mouselickshow
	public void UserTable_mouseClicked(MouseEvent e) {
		try {
			int selectedRow = tableUser.getSelectedRow();
			EmployeeModel model = new EmployeeModel();
			Employee employee = model.find(Integer.parseInt(tableUser.getValueAt(selectedRow, 0).toString()));
			txtName.setText(employee.getName());
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void BookTable_mouseClicked(MouseEvent e) {
		try {
			int selectedRow = tableBook.getSelectedRow();
			BookModel model = new BookModel();
		    Book book = model.find(tableBook.getValueAt(selectedRow, 0).toString());
			txtTitle.setText(book.getTitle());
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}
