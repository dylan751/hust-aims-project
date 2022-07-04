package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.exception.InputException;

public class Disc extends Media{
	protected int length;
	protected String director;
	
	public Disc() {
		super();
	}
	
	 public Disc(int length, String director, String title, String category) {
	        super(title, category);
	        this.length = length;
	        this.director = director;
	    }
	
	public Disc(String title) {
		super(title);
	}
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	public Disc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
	}

	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public String setDirector(String director) {
		this.director = director;
		return director;
	}
	
	public int setLength(int length) {
		this.length = length;
		return length;
	}
	public void setLength(String lengthStr) throws Exception{
		try {
			int length = Integer.parseInt(lengthStr);
			if(length <= 0) throw new InputException("Ban nhap sai. Length DVD phai la so duong");
			this.length = length;
		} catch (Exception e1){
			throw new InputException("Ban nhap sai dinh dang 'length DVD' (phai la so) ");
		}
	}
	
}
