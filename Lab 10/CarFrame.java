/*
 * Created by Jasque Saydyk and Austin Collins
 * Lab 10 - ControlPanel
 * CS 136L Section 3801
 * 30 April 2017
 * Description - This class creates the window for the cars to be shown
 * The entire class never extends anything so that it is forced to use
 * Composition techniques to get the job done
*/
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class CarFrame{
	
	private JFrame window;
	
	public CarFrame(){
		window = new JFrame();
		
		CarComponent content = new CarComponent();
		
		content.addCar(0, 0, 40, 10, 10);
		
		content.setLayout(new FlowLayout());
		window.setContentPane(content);
        
        // Custom JFrame settings
        window.setTitle("Custom Car Drawing");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
}
