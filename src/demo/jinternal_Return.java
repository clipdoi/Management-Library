package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import org.freixas.jcalendar.JCalendarCombo;

import entities.Book;
import entities.IssueStatus;
import entities.ReturnStatus;
import models.BookModel;
import models.ReturnModel;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jinternal_Return extends JInternalFrame {
	private JTextField jtextFieldId;
	private JTextField jtextFieldIsbn;
	private JTextField jtextFieldNameBook;
	private JTextField jtextFieldFees;
	private JCalendarCombo jcalendarComboReturn;
	private JTextField jtextFieldDueDate;
	private JCheckBox jchckbxStatusBook;

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
					jinternal_Return frame = new jinternal_Return();
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
	public jinternal_Return() {
		getContentPane().setBackground(new Color(118,90,61));
		setClosable(true);
		setBounds(100, 100, 993, 621);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Return Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(166, 124, 669, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdUser = new JLabel("ID user");
		lblIdUser.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblIdUser.setBounds(21, 38, 55, 16);
		panel.add(lblIdUser);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 74, 55, 16);
		panel.add(lblNewLabel);
		
		jtextFieldId = new JTextField();
		jtextFieldId.setBounds(196, 32, 206, 28);
		panel.add(jtextFieldId);
		jtextFieldId.setColumns(10);
		
		JButton jbtnSearch = new JButton("Search");
		jbtnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnSearch.setForeground(new Color(0, 0, 139));
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearch_actionPerformed(arg0);
			}
		});
		jbtnSearch.setIcon(new ImageIcon(jinternal_Return.class.getResource("/resource/search.png")));
		jbtnSearch.setBounds(414, 32, 90, 28);
		panel.add(jbtnSearch);
		
		jtextFieldIsbn = new JTextField();
		jtextFieldIsbn.setBounds(196, 68, 206, 28);
		panel.add(jtextFieldIsbn);
		jtextFieldIsbn.setColumns(10);
		
		JLabel lblNameBook = new JLabel("Name book");
		lblNameBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNameBook.setBounds(21, 114, 73, 16);
		panel.add(lblNameBook);
		
		jtextFieldNameBook = new JTextField();
		jtextFieldNameBook.setBounds(197, 108, 205, 28);
		panel.add(jtextFieldNameBook);
		jtextFieldNameBook.setColumns(10);
		
		JLabel lblIssuedate = new JLabel("Due_date");
		lblIssuedate.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblIssuedate.setBounds(21, 155, 73, 16);
		panel.add(lblIssuedate);
		
		JLabel lblReturndate = new JLabel("Return_date");
		lblReturndate.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblReturndate.setBounds(21, 202, 73, 16);
		panel.add(lblReturndate);
		
		jcalendarComboReturn = new JCalendarCombo();
		jcalendarComboReturn.setBackground(new Color(30, 144, 255));
		jcalendarComboReturn.setForeground(new Color(255, 255, 255));
		jcalendarComboReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		jcalendarComboReturn.setBounds(196, 192, 299, 37);
		panel.add(jcalendarComboReturn);
		
		JLabel lblFees = new JLabel("Fees over limit");
		lblFees.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblFees.setBounds(21, 252, 89, 16);
		panel.add(lblFees);
		
		jtextFieldFees = new JTextField();
		jtextFieldFees.setBounds(196, 246, 122, 28);
		panel.add(jtextFieldFees);
		jtextFieldFees.setColumns(10);
		
		JButton jbtnReturn = new JButton("Return");
		jbtnReturn.setForeground(new Color(128, 0, 0));
		jbtnReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnReturn_actionPerformed(arg0);
			}
		});
		jbtnReturn.setBounds(283, 319, 90, 28);
		panel.add(jbtnReturn);
		
		jchckbxStatusBook = new JCheckBox("Available");
		jchckbxStatusBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		jchckbxStatusBook.setBounds(196, 286, 104, 18);
		panel.add(jchckbxStatusBook);
		
		JButton jbtnCalculator = new JButton("Calculator");
		jbtnCalculator.setForeground(new Color(0, 0, 139));
		jbtnCalculator.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnCalculator_actionPerformed(e);
			}
		});
		jbtnCalculator.setBounds(414, 246, 90, 28);
		panel.add(jbtnCalculator);
		
		jtextFieldDueDate = new JTextField();
		jtextFieldDueDate.setBounds(196, 148, 206, 28);
		panel.add(jtextFieldDueDate);
		jtextFieldDueDate.setColumns(10);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setForeground(new Color(255, 255, 255));
		lblReturnBook.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblReturnBook.setBounds(382, 23, 223, 38);
		getContentPane().add(lblReturnBook);

	}
	public void jbtnSearch_actionPerformed(ActionEvent arg0) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			int id = Integer.parseInt(jtextFieldId.getText());
			String isbn = jtextFieldIsbn.getText();
			ReturnModel returnModel = new ReturnModel();
			int s = returnModel.search(id, isbn).getIsbn_book().compareTo(isbn);
			IssueStatus r = returnModel.search(id, isbn);
			if (returnModel.search(id, isbn).getUser_issue() == id && s == 0) {
				jtextFieldNameBook.setText(r.getBook_name());
				jtextFieldDueDate.setText(simpleDateFormat.format(r.getDue_date()));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not at all");
			System.out.println(e.getMessage());
		}
	}
	public void jbtnReturn_actionPerformed(ActionEvent arg0) {
		try {
			ReturnStatus r = new ReturnStatus();
			r.setUser_return(Integer.parseInt(jtextFieldId.getText()));
			r.setName_book(jtextFieldNameBook.getText());
			r.setIsbn_book(jtextFieldIsbn.getText());
			r.setFees(Double.parseDouble(jtextFieldFees.getText()));
			r.setReturn_date(jcalendarComboReturn.getDate());
			Book b = new Book();
			b.setStatus(true);
			ReturnModel returnModel = new ReturnModel();
			BookModel bookModel = new BookModel();
			if (returnModel.create(r) && bookModel.update(b, r)) {
				JOptionPane.showMessageDialog(null, "Done");
			} else {
				JOptionPane.showMessageDialog(null, "Failed");	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void jbtnCalculator_actionPerformed(ActionEvent e) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String d = jtextFieldDueDate.getText();
			Date r = jcalendarComboReturn.getDate();
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(simpleDateFormat.parse(d));
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(r);
			int d_due = calendar1.get(Calendar.DAY_OF_YEAR);
			int d_return = calendar2.get(Calendar.DAY_OF_YEAR);
			jtextFieldFees.setText(String.valueOf((d_return-d_due)*10));
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
	}
}
