package entity;


//public record Motivation(Integer id,String motivation,String author,String color ) {
//
//}

public class Motivation {
	
	
	private Long id;
	private String motivation;
	private String author;
	private String color;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivation() {
		return motivation;
	}
	
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Motivation() {
		
	}
	
	public Motivation(Long id, String motivation, String author, String color) {
		super();
		this.id = id;
		this.motivation = motivation;
		this.author = author;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Motivations [id=" + id + ", motivation=" + motivation + ", author=" + author + ", color=" + color + "]";
	}
	
}
