package hust.soict.hedspi.aims;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		
		DigitalVideoDisc dvd0 = new DigitalVideoDisc("Co vo dam dang");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Co y ta tan tuy voi cong viec cham soc benh nhan");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Anh tho cai win den dui gap co chu nha kho tinh");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Co thu ki va tinh yeu danh cho dong nghiep");
		// test search method
		Order order0 = new Order();
		
		ArrayList<Order> listOrder = new ArrayList<>();
		listOrder.add(order0);
		
		order0.addMedia((Media)dvd0);
		order0.addMedia((Media)dvd1);
		order0.addMedia((Media)dvd2);
		order0.addMedia((Media)dvd3);
		
		listOrder.get(order0.getNbOrders()).printOrder();
		
		order0 = new Order();
		order0.addMedia((Media)dvd0);
		order0.addMedia((Media)dvd1);
		listOrder.get(order0.getNbOrders()).printOrder();
	}

}
