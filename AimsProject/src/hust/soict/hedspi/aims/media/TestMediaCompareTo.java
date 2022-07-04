package hust.soict.hedspi.aims.media;

import java.util.Collection;
import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;

public class TestMediaCompareTo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int choice;
        int n = 0;
        int orderId;
        int itemId = 0;
        Scanner keyboard = new Scanner(System.in);
        Order[] orderList = new Order[Order.MAX_LIMITTED_ORDERS];
		
        
        DigitalVideoDisc dvd0 = new DigitalVideoDisc();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        
        dvd1.setCost(19.95f);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Kawasemi", "Animation", "John Musker", 90, 18.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Midori", "Animation", "John Musker", 90, 30f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Take no hana", "Animation", "John Musker", 90, 20f);
        
//        dvd3.printInfo();
        
        java.util.Collection<DigitalVideoDisc> collection = new java.util.ArrayList<DigitalVideoDisc>();
        
        collection.add(dvd5);
        collection.add(dvd4);
        collection.add(dvd3);
        collection.add(dvd2);
        
        java.util.Iterator<DigitalVideoDisc> iterator = collection.iterator();
        
        System.out.println("------------------------------");
        System.out.println("The DVDS curently in the order are: ");
        
        while (iterator.hasNext()){
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        
        java.util.Collections.sort((java.util.List<DigitalVideoDisc>) collection);
        iterator = collection.iterator();
        System.out.println("---------------------------");
        System.out.println("The DVDs in sorted order are: ");
        while(iterator.hasNext()){
        System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        System.out.println("----------------------------------");
        
	}
	
}
