package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.IssueStatus;
import entities.ReturnStatus;
import models.IssueModel;
import models.ReturnModel;

public class JInternal_Static extends JInternalFrame {
	private JTable jtableIssue;
	private JTable jtableReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternal_Static frame = new JInternal_Static();
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
	public JInternal_Static() {
		getContentPane().setBackground(new Color(118,90,61));
		setBounds(100, 100, 993, 623);
		getContentPane().setLayout(null);
		
		JLabel lblIssue = new JLabel("ISSUE");
		lblIssue.setForeground(new Color(255, 255, 255));
		lblIssue.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblIssue.setBounds(452, 21, 223, 38);
		getContentPane().add(lblIssue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 91, 654, 199);
		getContentPane().add(scrollPane);
		
		jtableIssue = new JTable();
		scrollPane.setViewportView(jtableIssue);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(165, 383, 654, 199);
		getContentPane().add(scrollPane_1);
		
		jtableReturn = new JTable();
		scrollPane_1.setViewportView(jtableReturn);
		
		JLabel lblReturn = new JLabel("RETURN");
		lblReturn.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblReturn.setBounds(452, 312, 223, 38);
		getContentPane().add(lblReturn);

		loadIssue();
		loadReturn();
	}
	private void loadIssue() {
		IssueModel issueModel = new IssueModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID_User");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Title_book");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Issue_date");
		defaultTableModel.addColumn("Due_date");
		for(IssueStatus i:issueModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				i.getUser_issue(),i.getName(),i.getBook_name(),
				i.getIsbn_book(),i.getIssue_date(),i.getDue_date()
			});
		}
		jtableIssue.setModel(defaultTableModel);
	}
	private void loadReturn() {
		ReturnModel returnModel = new ReturnModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID_User");
		defaultTableModel.addColumn("Title_book");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Return_date");
		defaultTableModel.addColumn("Fees_End");
		for(ReturnStatus r:returnModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				r.getUser_return(),r.getName_book(),
				r.getIsbn_book(),r.getReturn_date(),r.getFees()
			});
		}
		jtableReturn.setModel(defaultTableModel);
	}
}
