import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Exercise (Chapter 4: GUIs with Swing) — matching a layout. */
public class RegistrationForm {

  /**
   * Builds the registration form with two stacked fields and a row of buttons.
   *
   * @return the form's root panel
   */
  public static JPanel buildForm() {
    JPanel panel = new JPanel(new BorderLayout(0, 8));
    JPanel fields = new JPanel(new GridLayout(2, 1, 0, 4));

    JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTextField firstName = new JTextField(12);
    firstRow.add(new JLabel("First name:"));
    firstRow.add(firstName);
    fields.add(firstRow);

    JPanel lastRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTextField lastName = new JTextField(12);
    lastRow.add(new JLabel("Last name:"));
    lastRow.add(lastName);
    fields.add(lastRow);

    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(event -> {
      firstName.setText("");
      lastName.setText("");
    });
    buttons.add(submit);
    buttons.add(cancel);

    panel.add(fields, BorderLayout.CENTER);
    panel.add(buttons, BorderLayout.SOUTH);
    return panel;
  }

  /** Shows the form in a window so you can compare it with the target picture. */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          JFrame frame = new JFrame("Registration");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setContentPane(buildForm());
          frame.pack();
          frame.setVisible(true);
        });
  }
}
