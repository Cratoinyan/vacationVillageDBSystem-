package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class PageDeleteActivity extends Page{
	private JButton currentActivitiesButton = new JButton("Activities");
	private JTextField activityIdToDeleteTextField = new JTextField("Activity ID");
	private JButton deleteActivityButton = new JButton("Delete");
	private JButton returnToEntryPageButton = new JButton("Return");

	//Links
	public PageEntry entryPage = null;
	public PageActivityList activityListPage = null;
	
	@Override
	public void startup()
	{
		currentActivitiesButton.setBounds(350,107,100,50);
		activityIdToDeleteTextField.setBounds(250,194,300,50);
		deleteActivityButton.setBounds(450,275,100,50);
		returnToEntryPageButton.setBounds(250,275,100,50);
		
		currentActivitiesButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){  
				 Print.info("Current Activities button is clicked.");
				 activityListPage.setCaller(1);
				 frame.clear();
				 frame.display(activityListPage);
		    }  
		});
		
		deleteActivityButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){  
				 Print.info("Delete button is clicked.");
		    }  
		});
		
		returnToEntryPageButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){  
				 Print.info("Return to entry page button is clicked.");
				 frame.clear();
				 frame.display(entryPage);
		    }  
		});
		
		components.add(currentActivitiesButton);
		components.add(activityIdToDeleteTextField);
		components.add(deleteActivityButton);
		components.add(returnToEntryPageButton);
	}
}
