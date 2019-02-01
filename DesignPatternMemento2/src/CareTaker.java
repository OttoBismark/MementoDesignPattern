import java.util.ArrayList;

public class CareTaker {

	private ArrayList<Memento> savedArticles = new ArrayList<Memento>();
	
	public void addMemento(Memento memento)
	{
		savedArticles.add(memento);
	}
	
	public Memento getMemento(int index)
	{
		return savedArticles.get(index);
	}
}
