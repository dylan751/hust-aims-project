package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;
//import hust.soict.hedspi.aims.utils.*;
//import java.util.ArrayList;
import java.util.Scanner;
public class Aims {
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("==============================");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("==============================");
		System.out.println("Plesea choose a number: 0-1-2-3-4");
	}

    public static Media getItemType(Scanner sc, int id) throws Exception {
        int type;
        Media item = null;
        System.out.println("Choose a type of media: ");
        System.out.println("1.Book");
        System.out.println("2.CompactDisc");
        System.out.println("3.DigitalVideoDisc");
        type = sc.nextInt();
        switch (type) {
             
            case 1 :
                item = new Book();
                item.setId(id);
                sc.nextLine();
                System.out.println("The Book title: "); try {
					item.setTitle(sc.nextLine());
				} catch (Exception e1) {					
					e1.printStackTrace();
				}
                System.out.println("The Book Category: "); try {
                    item.setCategory(sc.nextLine());
				} catch (Exception e1) {					
                    e1.printStackTrace();
				}
                System.out.println("The Cost: "); try {
					item.setCost(sc.nextFloat());
				} catch (Exception e1) {			
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("The Book Authors:  ");
                for (var author : sc.nextLine().split(" ")) {
                    try {
						((Book)item).addAuthor(author);
					} catch (Exception e1) {						
						e1.printStackTrace();
					}
                }
                break;
            case 2 :
            	item = new CompactDisc();
            	item.setId(id);
            	sc.nextLine();
                System.out.println("The CD Title: "); try {
					item.setTitle(sc.nextLine());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
                System.out.println("The Category of CD: "); try {
					item.setCategory(sc.nextLine());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
                System.out.println("The  Cost: "); try {
					item.setCost(sc.nextFloat());
				} catch (Exception e2) {
					e2.printStackTrace();
				} sc.nextLine();
                System.out.println("The CD director: "); ((CompactDisc)item).setDirector(sc.nextLine());
                System.out.println("The CD artist: "); try {
					((CompactDisc)item).setArtist(sc.nextLine());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
                String select;
                do {
                    System.out.println("Do you want to add track? Y/N");
                    select = sc.nextLine();
                    if (select.equals("Y"))  {
                        Track track = new Track();
                        System.out.println("The track title: "); track.setTitle(sc.nextLine());
                        System.out.println("The track length: "); track.setLength(sc.nextInt()); sc.nextLine();
                        ((CompactDisc)item).addTrack(track);
                    }
                } while (!select.endsWith("N"));
                break;
            case 3 : 
                item = new DigitalVideoDisc();
                item.setId(id);
                sc.nextLine();
                System.out.println("The DVD Title: "); try {
					item.setTitle(sc.nextLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
                System.out.println("The DVD Category: "); try {
					item.setCategory(sc.nextLine());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
                System.out.println("The  Cost: "); try {
					item.setCost(sc.nextFloat());
				} catch (Exception e) {
					e.printStackTrace();
				} sc.nextLine();
                System.out.println("The DVD Director: "); ((DigitalVideoDisc)item).setDirector(sc.nextLine());
                System.out.println("The DVD Length: "); ((DigitalVideoDisc)item).setLength(sc.nextInt()); sc.nextLine();

                System.out.println("Do you want to play DVD? Y/N");
                String select1 = sc.nextLine();
                if (select1.equals("Y") )
                    ((DigitalVideoDisc)item).play();    
                break;
            default: {
            	System.out.println("Invalid type item choice!");
            }
        }
        return item;
    }
		
    public static void main(String[] args) throws Exception {
    	
    	Order newOrder = null;
    	Scanner sc = new Scanner(System.in);
    	int choice, id = 1;
    	do {
    		showMenu();
    		choice = sc.nextInt();
    		switch (choice) {
    		case 0: 
    			System.out.println("Exit!");
    			break;
			case 1:
				newOrder = new Order();
				break;
			case 2:
			{
				try {
					Media newMedia = getItemType(sc, id);
					if(newMedia != null) {
						newOrder.addMedia(newMedia);
						id++;
					} else {
						System.out.println("Invalid!");
					}
				} catch(NullPointerException e) {
					System.out.println("Order does not exist.");
				}
			}
				break;
			case 3:
				try {
					System.out.println("Enter item's ID to delete: ");
					int idToDel = sc.nextInt();
					newOrder.removeMedia(idToDel);
					System.out.println("Delete successfully!");
				} catch(NullPointerException e) {
					System.out.println("Order does not exist.");
				}
				break;
			case 4:
				try {
					newOrder.printOrder();
				} catch(NullPointerException e) {
					System.out.println("Order does not exist.");
				}
				break;
			default:
				System.out.println("Invalid choice!");
			}
    		System.out.println("");
		} while (choice != 0);
    	sc.close();
    }	
}
