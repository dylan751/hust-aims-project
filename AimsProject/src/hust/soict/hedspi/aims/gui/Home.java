package hust.soict.hedspi.aims.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Home extends JFrame {
	protected JButton createButton = new JButton("Create new Order");
	protected JButton addButton = new JButton("Add item to the order");
	protected JButton removeButton = new JButton("Remove item by id");
	protected JButton displayButton =  new JButton("Display the items of list order ");
	protected JButton exitButton = new JButton("Exit");
	private static ArrayList<Order> listOrder = new ArrayList<Order>();
	
	public Home() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false); 	
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 800))/2; 
		int y = (int) ((dimension.getHeight() - 600))/2; 
		setLocation(x, y); 
		setVisible(true);   
		setTitle("Menu Order");
		
		createButtonSetting();
		
		addButtonSetting();
		
		removeButtonSetting();
		
		displayButtonSetting();
		
		exitButtonSetting();
	}
	
	private void exitButtonSetting() {
		exitButton.setSize(60,40);
		exitButton.setLocation(370, 450);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		add(exitButton);
	}
	
	private void displayButtonSetting() {
		displayButton.setSize(300, 40);
		displayButton.setLocation(250, 320);
		displayButton.setFocusPainted(false);
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				if(listOrder.size() == 0) {
					JOptionPane.showMessageDialog(null, "Danh sach Order hien dang trong", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					Dialogs displayDialog = new Dialogs(null);
					displayDialog.setTitle("Display Order");
					String column_names[]= {"ID","Type","Title","Category","Cost"};
					DefaultTableModel model = new DefaultTableModel(null,column_names); 
					JTable table = new JTable(model);
					int numberOrder = 1;
					
					for(Order order : listOrder) {
						if(order.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Order hien dang trong", "Warning", JOptionPane.WARNING_MESSAGE);
							return;
						}
						else {
							
							List<Media> items = new ArrayList<Media>();
							Media luckyItem = null;
							try {
								luckyItem = order.getALuckyItem();
							} catch (Exception lucky) {
								JOptionPane.showMessageDialog(null, lucky.getMessage(), "Lucky Item Infor", JOptionPane.INFORMATION_MESSAGE);
							}
							items = order.getItemsOrdered();
							model.addRow(new Object[] {"","","                              Order "+numberOrder,"",""});
							for(Media media: items) {
								String typeString ;
								if(media instanceof Book)
									typeString = "Book"; 
								else if (media instanceof DigitalVideoDisc) {
									typeString = "DVD"; 
								}
								else {
									typeString = "CD";
								}
								
								model.addRow(new Object[]{media.getId(),typeString,
										media.getTitle(),media.getCategory(),media.getCost()});							
							}
							if(luckyItem != null) {
								model.addRow(new Object[] {"","","Lucky Item id: "+ luckyItem.getId(),"Lucky Item cost ",luckyItem.getCost()});
								model.addRow(new Object[] {"","","","Total: ",order.totalCost()-luckyItem.getCost()});
							}
							else {
								model.addRow(new Object[] {"","","Lucky Item id: 0" ,"Lucky Item cost","0"});
								model.addRow(new Object[] {"","","","Total: ",order.totalCost()});
							}
							
							table.setSize(500, 300);
							table.setLocation(50,30);
							displayDialog.setLayout(new BorderLayout());
							displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
							displayDialog.add(table, BorderLayout.CENTER);					
							TableColumn column = null;
							for (int i = 0; i < 5; i++) {
							    column = table.getColumnModel().getColumn(i);
							    if (i == 0) {
							        column.setPreferredWidth(50); 
							    } 
							    if (i == 1) {
							        column.setPreferredWidth(50); 
							    }
							    if (i == 2) {
							        column.setPreferredWidth(200); 
							    }
							    if (i == 3) {
							        column.setPreferredWidth(150); 
							    }
							    if (i == 4) {
							        column.setPreferredWidth(50); 
							    }
							    
							}
							numberOrder = numberOrder + 1;
						}
						
					}
					displayDialog.setVisible(true);
				}
			}
		});
		add(displayButton);
	}
	
	private void removeButtonSetting() {
		removeButton.setSize(300, 40);
		removeButton.setLocation(250, 230);
		removeButton.setFocusPainted(false);
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				if(listOrder.size() == 0) {
					JOptionPane.showMessageDialog(null, "Danh sach Order hien dang trong", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					Dialogs rmDialog = new Dialogs(null, "Remove by id media");
					rmDialog.removeDialog(listOrder);
				}
			}
		});
		add(removeButton);
	}

	private void addButtonSetting() {
		addButton.setSize(300, 40);
		addButton.setLocation(250,140);
		addButton.setFocusPainted(false);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Dialogs mediaDialog = new Dialogs(null,"Media Order");
				if (listOrder.size() != 0) {
					int locationOrder = listOrder.size() - 1;
					
			// setup book option
					JButton bookButton = new JButton("Book");
					bookButton.setSize(200,40);
					bookButton.setLocation(200,50);
					bookButton.setFocusPainted(false);
					bookButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							Dialogs book = new Dialogs(null,"Book Order");
							book.bookDialog(book, listOrder.get(locationOrder));
							book.setVisible(false);
						}
					});				
					mediaDialog.add(bookButton);
					
			// setup CD option
					JButton cdButton = new JButton("Compact Disc");
					cdButton.setSize(200,40);
					cdButton.setLocation(200,150);
					cdButton.setFocusPainted(false);
					cdButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Dialogs cd = new Dialogs(null,"CD Order");
							cd.cdDialog(cd, listOrder.get(locationOrder));
//							listOrder.get(locationOrder).setTotalCost();
							cd.setVisible(false);
						}
					});
					mediaDialog.add(cdButton);
					
			// setup DVD option
					JButton dvdButton = new JButton("Digital Video Disc");
					dvdButton.setSize(200,40);
					dvdButton.setLocation(200,250);
					dvdButton.setFocusPainted(false);
					dvdButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Dialogs dvd = new Dialogs(null,"CD Order");
							dvd.dvdDialog(dvd, listOrder.get(locationOrder));
							dvd.setVisible(false);
						}
					});
					mediaDialog.add(dvdButton);
					
			//setup OK button
					JButton okJButton = new JButton("OK");
					okJButton.setSize(80,30);
					okJButton.setLocation(260, 320);
					okJButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							mediaDialog.setVisible(false);	
						}
					});
					okJButton.setFocusPainted(false);
					okJButton.setVisible(true);
					mediaDialog.add(okJButton);
					
					mediaDialog.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Chua tao order");
					return;
				}
				
			}	
		});
		add(addButton);
	}

	private void createButtonSetting() {
		createButton.setSize(300, 40);
		createButton.setLocation(250,50);
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Order order = new Order();
				listOrder.add(order);
				JOptionPane.showMessageDialog(null, "Khoi tao order thanh cong", "Order", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		createButton.setFocusPainted(false);
		add(createButton);
	}
	
}
					
