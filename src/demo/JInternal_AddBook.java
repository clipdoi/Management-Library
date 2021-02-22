package demo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entities.Book;
import entities.Category;
import helpers.FileHelper;
import models.BookModel;
import models.CategoryModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class JInternal_AddBook extends JInternalFrame {
	private JTextField jtextFieldTitleWords;
	private JTextField jtextFieldAuthorWords;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldAuthor;
	private JButton jbuttonBrowse;
	private JComboBox jcomboboxType;
	private File selectFile;
	private JLabel jlabelPhoto;
	private JTextField jtextFieldRentalPrice;
	private JButton btnCategory;
	private JTextField jtextField3;
	private JTextField jtextFieldNumber;
	private JTextField jtextField4;

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
					JInternal_AddBook frame = new JInternal_AddBook();
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
	public JInternal_AddBook() {
		setClosable(true);
		getContentPane().setBackground(new Color(118, 90, 61));
		setBackground(new Color(118, 90, 61));
		setBounds(100, 100, 993, 621);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("ADD BOOK");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		label.setBounds(370, 11, 195, 38);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Call Number");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(49, 122, 108, 30);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Title");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(49, 260, 108, 30);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Type");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(49, 326, 108, 30);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Author");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(49, 389, 108, 30);
		getContentPane().add(label_4);

		jtextFieldTitleWords = new JTextField();
		jtextFieldTitleWords.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (jtextFieldTitleWords.getText().length() >= 2) {
					e.consume();
				}
			}
		});
		jtextFieldTitleWords.setColumns(10);
		jtextFieldTitleWords.setBounds(186, 124, 82, 30);
		getContentPane().add(jtextFieldTitleWords);

		JLabel label_5 = new JLabel("First 2 Title words");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(186, 82, 146, 30);
		getContentPane().add(label_5);

		JLabel label_6 = new JLabel("First 2 Author words");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(408, 82, 166, 30);
		getContentPane().add(label_6);

		jtextFieldAuthorWords = new JTextField();
		jtextFieldAuthorWords.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (jtextFieldAuthorWords.getText().length() >= 2) {
					e.consume();
				}
			}
		});
		jtextFieldAuthorWords.setColumns(10);
		jtextFieldAuthorWords.setBounds(408, 123, 90, 30);
		getContentPane().add(jtextFieldAuthorWords);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(186, 261, 221, 30);
		getContentPane().add(jtextFieldTitle);

		jlabelPhoto = new JLabel("");
		jlabelPhoto
				.setBorder(new TitledBorder(null, "Upload Photo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jlabelPhoto.setBounds(630, 182, 221, 196);
		getContentPane().add(jlabelPhoto);

		jbuttonBrowse = new JButton("Browse");
		jbuttonBrowse.setForeground(new Color(128, 0, 0));
		jbuttonBrowse.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbuttonBrowse_actionPerformed(arg0);
			}
		});
		jbuttonBrowse.setBounds(760, 390, 90, 30);
		getContentPane().add(jbuttonBrowse);

		jtextFieldAuthor = new JTextField();
		jtextFieldAuthor.setColumns(10);
		jtextFieldAuthor.setBounds(186, 390, 221, 30);
		getContentPane().add(jtextFieldAuthor);

		jcomboboxType = new JComboBox();
		jcomboboxType.setBackground(new Color(30, 144, 255));
		jcomboboxType.setForeground(new Color(0, 0, 0));
		jcomboboxType.setBounds(186, 327, 221, 38);
		getContentPane().add(jcomboboxType);

		JButton jbuttonSave = new JButton("SAVE");
		jbuttonSave.setForeground(new Color(0, 0, 139));
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setFont(new Font("Segoe Print", Font.BOLD, 16));
		jbuttonSave.setBounds(396, 509, 146, 38);
		getContentPane().add(jbuttonSave);

		JLabel lblRentalPricee = new JLabel("Rental Pricee");
		lblRentalPricee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRentalPricee.setBounds(49, 453, 108, 30);
		getContentPane().add(lblRentalPricee);

		jtextFieldRentalPrice = new JTextField();
		jtextFieldRentalPrice.setColumns(10);
		jtextFieldRentalPrice.setBounds(186, 454, 221, 30);
		getContentPane().add(jtextFieldRentalPrice);

		JButton jbuttonListBook = new JButton("LIST");
		jbuttonListBook.setFont(new Font("SansSerif", Font.BOLD, 12));
		jbuttonListBook.setForeground(new Color(0, 0, 139));
		jbuttonListBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonListBook_actionPerformed(e);
			}
		});
		jbuttonListBook.setBounds(6, 0, 89, 23);
		getContentPane().add(jbuttonListBook);

		btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCategory.setForeground(new Color(0, 0, 139));
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category_actionPerformed(e);
			}
		});
		btnCategory.setBounds(107, 0, 90, 23);
		getContentPane().add(btnCategory);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(49, 214, 58, 16);
		getContentPane().add(lblNewLabel);
		
		jtextField3 = new JTextField();
		jtextField3.setBounds(186, 209, 82, 28);
		getContentPane().add(jtextField3);
		jtextField3.setColumns(10);
		
		jtextFieldNumber = new JTextField();
		jtextFieldNumber.setBounds(615, 124, 97, 28);
		getContentPane().add(jtextFieldNumber);
		jtextFieldNumber.setColumns(10);
		
		JLabel lblFirstNumber = new JLabel("First 3 number of ID");
		lblFirstNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstNumber.setBounds(616, 90, 166, 16);
		getContentPane().add(lblFirstNumber);
		
		jtextField4 = new JTextField();
		jtextField4.setBounds(408, 209, 97, 28);
		getContentPane().add(jtextField4);
		jtextField4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First 3");
		lblNewLabel_1.setBounds(197, 182, 58, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First 4");
		lblNewLabel_2.setBounds(426, 182, 58, 16);
		getContentPane().add(lblNewLabel_2);
		loadData();

	}

	public void loadData() {
		CategoryModel categoryModel = new CategoryModel();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Category c : categoryModel.readCate()) {
			defaultComboBoxModel.addElement(c.getName());
		}
		jcomboboxType.setModel(defaultComboBoxModel);
	}

	public void jbuttonBrowse_actionPerformed(ActionEvent arg0) {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select a photo");
			chooser.setMultiSelectionEnabled(false);
			chooser.setFileFilter(new FileTypeFilter(".gif", "GIF(*.gif)"));
			chooser.setFileFilter(new FileTypeFilter(".png", "PNG(*.png)"));
			chooser.setFileFilter(new FileTypeFilter(".jpg", "JPG(*.jpg)"));
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				selectFile = chooser.getSelectedFile();
				jlabelPhoto.setIcon(new ImageIcon(selectFile.getAbsolutePath()));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, " No Photo Found " + e2.getMessage());
		}
	}

	public void jbuttonListBook_actionPerformed(ActionEvent e) {
		JDesktopPane desktopPane = getDesktopPane();
		desktopPane.removeAll();
		desktopPane.updateUI();
		JInternal_ListBook jInternalFrameListBook = new JInternal_ListBook();
		jInternalFrameListBook.setVisible(true);
		desktopPane.add(jInternalFrameListBook);
		try {
			jInternalFrameListBook.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

	}

	public void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			// if there is an empty blank
			boolean input = jtextFieldTitleWords.getText().isEmpty() || jtextFieldAuthorWords.getText().isEmpty()
					|| jtextFieldAuthor.getText().isEmpty() || jtextFieldTitle.getText().isEmpty()
					|| jtextFieldRentalPrice.getText().isEmpty();
			if (input == true) {
				JOptionPane.showMessageDialog(null, "Input Blanks can not be empty!");
			} else {
				CategoryModel categoryModel = new CategoryModel();
				int selectIndex = jcomboboxType.getSelectedIndex();
				Category category = categoryModel.readCate().get(selectIndex);
						
				
				byte[] photo = FileHelper.convertFileToBytes(selectFile);
				// modify book's info
				Book book = new Book();
				book.setC(category);	
				book.setCallnumber((jtextFieldTitleWords.getText() + "-" + jtextFieldAuthorWords.getText() + "-" + jtextFieldNumber.getText())
						.trim());
				book.setIsbn(jtextField3.getText().trim()+"-"+jtextField4.getText().trim());
				book.setAuthor(jtextFieldAuthor.getText());
				book.setRentprice(Double.parseDouble(jtextFieldRentalPrice.getText()));
				book.setStatus(true);
				book.setTitle(jtextFieldTitle.getText());
				book.setPhoto(photo);
				// update type
				BookModel model = new BookModel();
				if (model.insert(book)) {
					JOptionPane.showMessageDialog(null, "Insert Done");
				} else {
					JOptionPane.showMessageDialog(null, "Insert Failed");
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	public void Category_actionPerformed(ActionEvent e) {
		try {
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
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
	}
}
