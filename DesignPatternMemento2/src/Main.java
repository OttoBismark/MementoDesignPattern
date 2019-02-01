import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton savedButton, undoButton, redoButton;
	
	private JTextArea theArticle = new JTextArea(40,60);
	
	CareTaker caretaker = new CareTaker();
	
	Originator originator = new Originator();
	
	private int saveFiles = 0, currentArticle = 0;
	
	public static void main(String[] args) {

		new Main();
	}
	
	public Main()
	{
		this.setSize(750, 780);
		this.setTitle("Memento Design Pattern");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		
		panel1.add(new JLabel("Article"));
		
		panel1.add(theArticle);
		
		ButtonListener save = new ButtonListener();
		ButtonListener undo = new ButtonListener();
		ButtonListener redo = new ButtonListener();

		savedButton = new JButton("Save");
		savedButton.addActionListener(save);
		
		undoButton = new JButton("Undo");
		undoButton.addActionListener(undo);
		
		redoButton = new JButton("Redo");
		redoButton.addActionListener(redo);
		
		panel1.add(savedButton);
		panel1.add(undoButton);
		panel1.add(redoButton);
		
		this.add(panel1);
		
		this.setVisible(true);
		
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == savedButton)
			{
				String textInArea = theArticle.getText();
				
				originator.set(textInArea);
				
				caretaker.addMemento(originator.storeInMemento());
				
				saveFiles++;
				currentArticle++;
				
				System.out.println("Save files" + saveFiles);
				
				undoButton.setEnabled(true);
			}
			else if(e.getSource() == undoButton)
			{

				if(currentArticle >= 1)
				{
					currentArticle--;
						
					String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
					
					theArticle.setText(textBoxString);
						
					redoButton.setEnabled(true);
				}
				else
				{
					undoButton.setEnabled(false);
				}
			}
			else if(e.getSource() == redoButton)
			{
				if((saveFiles - 1) > currentArticle)
				{
					currentArticle++;
					
					String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
					
					theArticle.setText(textBoxString);
					
					undoButton.setEnabled(true);
				}
				else
				{
					redoButton.setEnabled(false);
				}
			}
		}
		
	}

}
