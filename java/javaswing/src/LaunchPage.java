import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener { // Implements interface to make the button work

    JFrame frame = new JFrame();
    JButton myButton = new JButton("Open new window");

    LaunchPage() {
        myButton.setBounds(100, 160, 200, 40); // Your usual button setup
        myButton.setFocusable(false);
        myButton.addActionListener(this); // ActionListener for button action

        frame.add(myButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame setup
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton) {
            frame.dispose(); // dispose the first window when the button is clicked
            NewWindow.window();
        }
    }
}
