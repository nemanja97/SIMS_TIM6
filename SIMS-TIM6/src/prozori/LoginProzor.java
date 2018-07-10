package prozori;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modeli.Centrala;
import modeli.korisnici.Admin;
import modeli.korisnici.Korisnik;
import modeli.korisnici.SefStanice;
import modeli.korisnici.ZaposleniNaNaplatnomMestu;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;

import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class LoginProzor extends JFrame {
	
	private JTextField loginField;
	private JPasswordField passField;

	public LoginProzor() {

		initUI();
	}

	private void initUI() {

		JLabel loginLabel = new JLabel("Login");
		JLabel passwordLabel = new JLabel("Password");

		loginField = new JTextField(15);
		passField = new JPasswordField(15);
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitAction(this));

		createLayout(loginLabel, loginField, passwordLabel, passField, submitButton);

		setTitle("Login");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private class SubmitAction extends AbstractAction {
		
		private LoginProzor lp;
		
		public SubmitAction(LoginProzor lp) {
			this.lp = lp;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			doSubmitAction();
		}

		private void doSubmitAction() {
			String login = loginField.getText();
            char[] passwd = passField.getPassword();
            
            if (!login.isEmpty() && passwd.length != 0) {
            	for (Korisnik k : Centrala.getInstance().getSviKorisnici()) {
            		if (k.getUsername().equals(login) && k.getPassword().equals(String.valueOf(passwd))) {
            			JFrame frame;
            			if (k.getClass() == Admin.class) {
            				frame = new AdminProzor();
            			} else if (k.getClass() == SefStanice.class) {
            				frame = new SefStaniceProzor();
            			} else if (k.getClass() == ZaposleniNaNaplatnomMestu.class) {
            				frame = new ZaposleniNaNaplatnomMestuProzor();
            			} else {
            				frame = new ZaposleniUCentraliProzor();
            			}
            			frame.setVisible(true);
            			this.lp.dispose();
            		}
            	}
            }
		}
	}

	private void createLayout(Component... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGap(50)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])
						.addComponent(arg[1])
						.addComponent(arg[2])
						.addComponent(arg[3])
						.addComponent(arg[4]))
				.addGap(50)
				);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGap(50)
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[0])
						.addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[2])
						.addComponent(arg[3], GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(UNRELATED)
						.addComponent(arg[4]))
				.addGap(50)
				);

		pack();
	}

}
