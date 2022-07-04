package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<DigitalVideoDisc> {

	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title) {
		super(title);
		this.category = "";
		this.director ="";
		this.length = 0;
		this.cost = 0.0f;
	}
	
	 public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
	        super(title);
	        this.category = category;
	        this.director = directory;
	        this.length = length;
	        this.cost = cost;
	    }
	
	public void printInfo(){
        System.out.println("\n-----DVD Info-----");
        System.out.println("Title: " + this.title);
        System.out.println("Category: " + this.category);
        System.out.println("Director: " + this.director);
        System.out.println("Length: " + this.length);
        System.out.println("Cost: " + this.cost);
    }
    
	
	public void play() throws PlayerException {
		if(this.getLength() <= 0) {
			System.out.println("ERROR: DVD length is 0");
			throw (new PlayerException());
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override 
	public int compareTo(DigitalVideoDisc obj) {
		return this.getTitle().compareTo(obj.title);
	}
}
