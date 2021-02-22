package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.History;

import models.HistoryModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import org.freixas.jcalendar.JCalendarCombo;
import java.awt.Color;
import javax.swing.ImageIcon;


public class JInternal_History extends JInternalFrame {
	private JTable jtableHistory;
	private JTextField jtextField;
	private JTable jtableSearch;

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
					JInternal_History frame = new JInternal_History();
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
	public JInternal_History() {
		getContentPane().setBackground(new Color(118,90,61));
		setBounds(100, 100, 993, 621);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 177, 730, 232);
		getContentPane().add(scrollPane);
		
		jtableHistory = new JTable();
		scrollPane.setViewportView(jtableHistory);
		
		JButton jbtnSearch = new JButton(" Search");
		jbtnSearch.setIcon(new ImageIcon(JInternal_History.class.getResource("/resource/search.png")));
		jbtnSearch.setForeground(new Color(0, 0, 139));
		jbtnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearch_actionPerformed(arg0);
			}
		});
		jbtnSearch.setBounds(745, 113, 100, 28);
		getContentPane().add(jbtnSearch);
		
		jtextField = new JTextField();
		jtextField.setBounds(439, 113, 238, 28);
		getContentPane().add(jtextField);
		jtextField.setColumns(10);
		
		JLabel lblHistory = new JLabel("HISTORY");
		lblHistory.setForeground(new Color(255, 255, 255));
		lblHistory.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblHistory.setBounds(370, 11, 223, 38);
		getContentPane().add(lblHistory);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(115, 445, 730, 92);
		getContentPane().add(scrollPane_1);
		
		jtableSearch = new JTable();
		scrollPane_1.setViewportView(jtableSearch);
		
		loadData();
	}
	private void loadData() {
		HistoryModel historyModel = new HistoryModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Id_user");
		defaultTableModel.addColumn("Name_user");
		defaultTableModel.addColumn("Name_book");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Due_date");
		defaultTableModel.addColumn("Issue_date");
		defaultTableModel.addColumn("Return_date");
		defaultTableModel.addColumn("Fees");
		for(History h:historyModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				h.getUser_issue(),
				h.getName_user(),
				h.getBook_name(),
				h.getIsbn(),
				h.getDue_date(),
				h.getIssue_date(),
				h.getReturn_date(),
				h.getFees()
			});
		}
		jtableHistory.setModel(defaultTableModel);
	}
	public void jbtnSearch_actionPerformed(ActionEvent arg0) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String d = jtextField.getText();
			Date date = simpleDateFormat.parse(d);
			
			HistoryModel historyModel = new HistoryModel();
			
			DefaultTableModel defaultTableModel = new DefaultTableModel();
			defaultTableModel.addColumn("Id_user");
			defaultTableModel.addColumn("Name_user");
			defaultTableModel.addColumn("Name_book");
			defaultTableModel.addColumn("ISBN");
			defaultTableModel.addColumn("Due_date");
			defaultTableModel.addColumn("Issue_date");
			defaultTableModel.addColumn("Return_date");
			defaultTableModel.addColumn("Fees");
			
			for(History h:historyModel.searchDate(date)) {
				defaultTableModel.addRow(new Object[] {
					h.getUser_issue(),
					h.getName_user(),
					h.getBook_name(),
					h.getIsbn(),
					h.getDue_date(),
					h.getIssue_date(),
					h.getReturn_date(),
					h.getFees()
				});
			}
			jtableSearch.setModel(defaultTableModel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not at all");
		}
	}
}
