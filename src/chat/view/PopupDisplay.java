package chat.view;
import javax.swing.*;

public class PopupDisplay 
{
	private ImageIcon icon;
	private ImageIcon icon2;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("Images/switch.gif"));
		//icon2 = new ImageIcon(getClass().getResource("Images/bobby.gif"));
		windowTitle = "3dgyM3ME";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
	
	
}
