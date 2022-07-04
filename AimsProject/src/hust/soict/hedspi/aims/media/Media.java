package hust.soict.hedspi.aims.media;

public abstract class Media {
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public Media() {
		
	}
	public Media(String title) {
		this.title = title;
	}
	
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		if(cost > 0)
			this.cost = cost;
		else this.cost = 0.0f;
	}
	
	public void printMedia() {
		System.out.println("Id: "+ this.id + "\n" +
						   "Title: " + this.title + "\n"+
						   "Category: " + this.category +"\n"+
						   "Cost: " + this.cost +"\n\n");
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Media) obj).getId() == this.id;
	}
}
