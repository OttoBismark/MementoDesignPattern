
public class Memento {

	private String article;
	
	public Memento(String articleSaved)
	{
		article = articleSaved;
	}
	
	public String getSavedArticle()
	{
		return article;
	}
}
