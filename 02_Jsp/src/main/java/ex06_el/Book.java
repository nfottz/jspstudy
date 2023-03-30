package ex06_el;

public class Book {
	
	private String author;
	private String title;
	private int price;
	
	public Book() {
		
	}

	public Book(String author, String title, int price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	

}
