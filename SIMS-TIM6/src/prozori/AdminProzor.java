package prozori;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.TRAILING;

import modeli.Centrala;
import modeli.Mesto;
import modeli.Cenovnik;
import modeli.Kategorija;
import modeli.korisnici.Admin;
import modeli.korisnici.Korisnik;
import modeli.korisnici.SefStanice;
import modeli.korisnici.TipKorisnika;
import modeli.korisnici.ZaposleniNaNaplatnomMestu;

public class AdminProzor extends JFrame {
	
	private JLabel statusbar;
	private Container pane;
	
	private JLabel userNameLbl = new JLabel("User name:");
	private JLabel passwordLbl = new JLabel("Password:");
	private JLabel userTypeLbl = new JLabel("Tip korisnika:");

	private JTextField field1 = new JTextField(15);
	private JTextField field2 = new JTextField(15);
	private JComboBox<String> box;
	
	private JLabel mesto1 = new JLabel("Mesto 1");
	private JLabel mesto1_naziv = new JLabel("Naziv:");
	private JLabel mesto1_ptt = new JLabel("Ptt broj:");
	private JTextField m1_field1 = new JTextField(15);
	private JTextField m1_field2 = new JTextField(15);
    
	private JLabel mesto2 = new JLabel("Mesto 2");
	private JLabel mesto2_naziv = new JLabel("Naziv:");
	private JLabel mesto2_ptt = new JLabel("Ptt broj:");
	private JTextField m2_field1 = new JTextField(15);
	private JTextField m2_field2 = new JTextField(15);
    
	private JLabel cenovnikRSD = new JLabel("Cenovnik RSD");
	private JLabel cenovnikEUR = new JLabel("Cenovnik EUR");
    
	private JLabel k1_RSD = new JLabel("Kategorija 1");
	private JTextField k1RSD_field = new JTextField(15);
	private JLabel k2_RSD = new JLabel("Kategorija 2");
	private JTextField k2RSD_field = new JTextField(15);
	private JLabel k3_RSD = new JLabel("Kategorija 3");
	private JTextField k3RSD_field = new JTextField(15);
	private JLabel k4_RSD = new JLabel("Kategorija 4");
    private JTextField k4RSD_field = new JTextField(15);
    private JLabel k5_RSD = new JLabel("Kategorija 5");
    private JTextField k5RSD_field = new JTextField(15);
    
    private JLabel k1_EUR = new JLabel("Kategorija 1");
    private JTextField k1EUR_field = new JTextField(15);
    private JLabel k2_EUR = new JLabel("Kategorija 2");
    private JTextField k2EUR_field = new JTextField(15);
    private JLabel k3_EUR = new JLabel("Kategorija 3");
    private JTextField k3EUR_field = new JTextField(15);
    private JLabel k4_EUR = new JLabel("Kategorija 4");
    private JTextField k4EUR_field = new JTextField(15);
    private JLabel k5_EUR = new JLabel("Kategorija 5");
    private JTextField k5EUR_field = new JTextField(15);
	
	public AdminProzor() {
		initUI();
		pane = getContentPane();
	}
	
	private void applyPositioning() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
	
	private void createStatusBar() {
        statusbar = new JLabel("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername());
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.SOUTH);
        //statusbar.setVisible(true);
    }
	
	private void add_menuRegistracija(JMenuBar menubar) {
		JMenu registracijaMeni = new JMenu("Registracija");
        registracijaMeni.setMnemonic(KeyEvent.VK_R);
        JMenuItem r_k = new JMenuItem(new MenuItemAction("Registracija korisnika", KeyEvent.VK_1, ActionType.REG_KORISNIKA));
        JMenuItem r_d = new JMenuItem(new MenuItemAction("Registracija deonica", KeyEvent.VK_2, ActionType.REG_DEONICA));
        JMenuItem r_s = new JMenuItem(new MenuItemAction("Registracija stanica", KeyEvent.VK_3, ActionType.REG_STANICA));
        registracijaMeni.add(r_k);
        registracijaMeni.add(r_d);
        registracijaMeni.add(r_s);
        
        menubar.add(registracijaMeni);
	}
	
	private void add_menuIzmena(JMenuBar menubar) {
		JMenu registracijaMeni = new JMenu("Izmena");
        registracijaMeni.setMnemonic(KeyEvent.VK_I);
        JMenuItem i_k = new JMenuItem(new MenuItemAction("Izmena korisnika", KeyEvent.VK_1, ActionType.IZM_KORISNIKA));
        JMenuItem i_d = new JMenuItem(new MenuItemAction("Izmena deonica", KeyEvent.VK_2, ActionType.IZM_DEONICA));
        JMenuItem i_s = new JMenuItem(new MenuItemAction("Izmena stanica", KeyEvent.VK_3, ActionType.IZM_STANICA));
        registracijaMeni.add(i_k);
        registracijaMeni.add(i_d);
        registracijaMeni.add(i_s);
        
        menubar.add(registracijaMeni);
	}
	
	private void add_menuBrisanje(JMenuBar menubar) {
		JMenu registracijaMeni = new JMenu("Brisanje");
        registracijaMeni.setMnemonic(KeyEvent.VK_B);
        JMenuItem b_k = new JMenuItem(new MenuItemAction("Brisanje korisnika", KeyEvent.VK_1, ActionType.BRI_KORISNIKA));
        JMenuItem b_d = new JMenuItem(new MenuItemAction("Brisanje deonica", KeyEvent.VK_2, ActionType.BRI_DEONICA));
        JMenuItem b_s = new JMenuItem(new MenuItemAction("Brisanje stanica", KeyEvent.VK_3, ActionType.BRI_STANICA));
        registracijaMeni.add(b_k);
        registracijaMeni.add(b_d);
        registracijaMeni.add(b_s);
        
        menubar.add(registracijaMeni);
	}
	
	private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem exitMI = new JMenuItem(new MenuItemAction("Exit", KeyEvent.VK_E, null));
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                InputEvent.CTRL_MASK));
        exitMI.setToolTipText("Exit application");
        exitMI.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        fileMenu.add(exitMI);

        menubar.add(fileMenu);
        add_menuRegistracija(menubar);
        add_menuIzmena(menubar);
        add_menuBrisanje(menubar);
        setJMenuBar(menubar);
    }
	
	private enum ActionType {
		
		REG_KORISNIKA,
		REG_DEONICA,
		REG_STANICA,
		BRI_KORISNIKA,
		BRI_DEONICA,
		BRI_STANICA,
		IZM_KORISNIKA,
		IZM_DEONICA,
		IZM_STANICA;
		
	}
	
	private class MenuItemAction extends AbstractAction {
		
		private ActionType type;

        public MenuItemAction(String text, Integer mnemonic, ActionType type) {
            super(text);
            this.type = type;
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pane.removeAll();
            pane.add(statusbar);
        	switch (type) {
        	case REG_KORISNIKA: {
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Registracija korisnika");
                
                GroupLayout gl = new GroupLayout(pane);
                pane.setLayout(gl);

                String[] userTypes = {"Admin", "Zaposleni u centrali", "Sef stanice", "Zaposleni na naplatnom mestu"};
                box = new JComboBox<>(userTypes);
                
                JButton submitButton = new JButton("Submit");
                submitButton.setMinimumSize(new Dimension((int) pane.getWidth() - 110, JButton.HEIGHT));
        		submitButton.addActionListener(new registrujKorisnikaAction());
                
                gl.setAutoCreateGaps(true);
                gl.setAutoCreateContainerGaps(true);

                gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(TRAILING)
                                .addComponent(userNameLbl)
                                .addComponent(passwordLbl)
                        		.addComponent(userTypeLbl))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(field1)
                                .addComponent(field2)
                                .addComponent(box)
                        		.addComponent(submitButton))
                );

                gl.setVerticalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(BASELINE)
                                .addComponent(userNameLbl, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(field1, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(passwordLbl, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(field2, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(userTypeLbl, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(box, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(submitButton, GroupLayout.PREFERRED_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
        	}
        		break;
        	case REG_DEONICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Registracija deonica");

                GroupLayout gl = new GroupLayout(pane);
                pane.setLayout(gl);

                JButton submitButton = new JButton("Submit");
                submitButton.setMinimumSize(new Dimension((int) pane.getWidth() - 110, JButton.HEIGHT));
        		submitButton.addActionListener(new registrujDeonicuAction());
                
                gl.setAutoCreateGaps(true);
                gl.setAutoCreateContainerGaps(true);

                gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(TRAILING)
                        		.addComponent(mesto1)
                        		.addComponent(mesto1_naziv)
                        		.addComponent(mesto1_ptt)
                        		.addComponent(mesto2)
                        		.addComponent(mesto2_naziv)
                        		.addComponent(mesto2_ptt)
                        		.addComponent(cenovnikRSD)
                        		.addComponent(k1_RSD)
                        		.addComponent(k2_RSD)
                        		.addComponent(k3_RSD)
                        		.addComponent(k4_RSD)
                        		.addComponent(k5_RSD)
                        		)
                        .addGroup(gl.createParallelGroup()
                				.addComponent(m1_field1)
                        		.addComponent(m1_field2)
                        		.addComponent(m2_field1)
                        		.addComponent(m2_field2)
                        		.addGroup(gl.createSequentialGroup()
                        				.addGroup(gl.createParallelGroup(TRAILING)
                                        		.addComponent(k1RSD_field)
                                        		.addComponent(k2RSD_field)
                                        		.addComponent(k3RSD_field)
                                        		.addComponent(k4RSD_field)
                                        		.addComponent(k5RSD_field)
                                				)
                                		.addGroup(gl.createParallelGroup()
        	                        		.addGroup(gl.createParallelGroup(TRAILING)
        	                                		.addComponent(cenovnikEUR)
        	                                		.addComponent(k1_EUR)
        	                                		.addComponent(k2_EUR)
        	                                		.addComponent(k3_EUR)
        	                                		.addComponent(k4_EUR)
        	                                		.addComponent(k5_EUR))
        	                        		.addGroup(gl.createParallelGroup()
        	                                		.addComponent(k1EUR_field)
        	                                		.addComponent(k2EUR_field)
        	                                		.addComponent(k3EUR_field)
        	                                		.addComponent(k4EUR_field)
        	                                		.addComponent(k5EUR_field))))
                        		.addComponent(submitButton)
                        		));

                gl.setVerticalGroup(gl.createSequentialGroup()
                		.addComponent(mesto1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl.createParallelGroup(BASELINE)                        		
                                .addComponent(mesto1_naziv, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(m1_field1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(mesto1_ptt, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(m1_field2, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(mesto2, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(mesto2_naziv, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(m2_field1, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                        		.addComponent(mesto2_ptt, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        		.addComponent(m2_field2, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)                        		
                                .addComponent(cenovnikRSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cenovnikEUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)                        		
                                .addComponent(k1_RSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k1RSD_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k1_EUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k1EUR_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                                .addComponent(k2_RSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k2RSD_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k2_EUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k2EUR_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                                .addComponent(k3_RSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k3RSD_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k3_EUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k3EUR_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                                .addComponent(k4_RSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k4RSD_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k4_EUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k4EUR_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(BASELINE)
                                .addComponent(k5_RSD, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k5RSD_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k5_EUR, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(k5EUR_field, GroupLayout.DEFAULT_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(submitButton)
                        
                );
        		
        		break;
        	case REG_STANICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Registracija stanica");
        		break;
        	case BRI_KORISNIKA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Brisanje korisnika");
        		break;
        	case BRI_DEONICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Brisanje deonica");
        		break;
        	case BRI_STANICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Brisanje stanica");
        		break;
        	case IZM_KORISNIKA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Izmena korisnika");
        		break;
        	case IZM_DEONICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Izmena deonica");
        		break;
        	case IZM_STANICA:
        		statusbar.setText("Korisnik :: " + Centrala.getInstance().getTrenutnoUlogovani().getUsername() + " - Izmena stanica");
        		break;
        	}
        }
    }
	
	private class registrujKorisnikaAction extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			doSubmitAction();
		}

		private void doSubmitAction() {
			TipKorisnika tip;
			
			switch (box.getSelectedIndex()) {
			case 0:
				tip = TipKorisnika.ADMIN;
				break;
			case 1:
				tip = TipKorisnika.ZAPOSLENI_U_CENTRALI;
				break;
			case 2:
				tip = TipKorisnika.SEF_STANICE;
				break;
			case 3:
				tip = TipKorisnika.ZAPOSLENI_NA_NAPLATNOM_MESTU;
				break;
			default:
				tip = null;
				break;
			}
			if (Centrala.getInstance().registracijaKorisnika(field1.getText(), field2.getText(), tip))
				Centrala.getInstance().snimanjePodataka();
			else
				System.out.println("Los unos");
		}
	}
	
	private class registrujDeonicuAction extends AbstractAction {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doSubmitAction();
			}
	
			private void doSubmitAction() {
				Mesto m1 = new Mesto(m1_field1.getText(), Integer.parseInt(m1_field2.getText()));
				Mesto m2 = new Mesto(m2_field1.getText(), Integer.parseInt(m2_field2.getText()));
				ArrayList<Cenovnik> c = new ArrayList<Cenovnik>();
				c.add(new Cenovnik(Kategorija.MOTOR, new Date(), Double.parseDouble(k1RSD_field.getText()), Double.parseDouble(k1EUR_field.getText())));
				c.add(new Cenovnik(Kategorija.PUTNICKO_VOZILO, new Date(), Double.parseDouble(k2RSD_field.getText()), Double.parseDouble(k2EUR_field.getText())));
				c.add(new Cenovnik(Kategorija.PUTNICKO_VOZILO_SA_PRIKOLICOM, new Date(), Double.parseDouble(k3RSD_field.getText()), Double.parseDouble(k3EUR_field.getText())));
				c.add(new Cenovnik(Kategorija.KAMION, new Date(), Double.parseDouble(k4RSD_field.getText()), Double.parseDouble(k4EUR_field.getText())));
				c.add(new Cenovnik(Kategorija.TESKI_TERETNI_KAMION, new Date(), Double.parseDouble(k5RSD_field.getText()), Double.parseDouble(k5EUR_field.getText())));
				
				if (Centrala.getInstance().registracijaDeonice(m1, m2, c))
					Centrala.getInstance().snimanjePodataka();
				else
					System.out.println("Los unos");
			}
		}
	
	private class registrujStanicuAction extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			doSubmitAction();
		}
	
		private void doSubmitAction() {
			System.out.println("Pritisnuto");
		}
	}
	
	private void initUI() {
		setTitle("Admin prozor");
		applyPositioning();
		createMenuBar();
		createStatusBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
