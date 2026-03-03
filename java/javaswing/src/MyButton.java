import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyButton extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MyButton() {

        ImageIcon icon = new ImageIcon("java/javaswing/SensationalIcon.png");
        ImageIcon icon2 = new ImageIcon("java/javaswing/SensationalIcon2.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false); // Set to false first so that when you clicked the button the it will become set to true and become visible

        button = new JButton();
        button.setBounds(140, 100, 190, 150); // button sizing
        button.addActionListener(this); // for click respond
        button.setText("");
        button.setFocusable(false);
        button.setIcon(icon);
        // button.setHorizontalTextPosition(JButtong.CENTER) - for horizontal text position in the button
        // button.setVerticalTextPosition(JButtong.CENTER) - for vertical text position in the button
        // button.setFont(new Font("Comic Sans", Font.BOLD, 25)); - for font formatting
        // button.setIconTextGap(-12); - adjust distance between the button icon and the button text
        // button.setForeGround(Color.cyan); - for font color 
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());
        // button.setEnabled(false); - Disable the button

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Sensational");
        // button.setEnabled(false); - Disable the button after you click it once
            label.setVisible(true); // When we click the button the label that we add will appear.
        }
    }
}
