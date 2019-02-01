
public class Originator {

	private String article;
	
	public void set(String newArticle)
	{
		System.out.println("From originator: current version of article\n" + newArticle + "\n");
	
		this.article = newArticle;
	}
	
	public Memento storeInMemento()
	{
		System.out.println("From originator: saving to memento\n");
		return new Memento(article);
	}
	
	public String restoreFromMemento(Memento memento) {
		System.out.println("From originator: previous article saved in Memento\n" + article + "\n");
		
		return article;
	}
}
