package prozori;

import java.awt.Component;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class SefStaniceProzor extends JFrame {
	
	public SefStaniceProzor() {
		initUI();
	}
	
	private void initUI() {
		
		JTabbedPane tabs = new JTabbedPane();
		
		tabs.addTab("Pravljenje izvestaja", panelPravljenjeIzvestaja());
		tabs.addTab("Izmena cene naplate", panelIzmenaCena());
		tabs.addTab("Pregled kvarova", panelPregledKvarova());
		
		createLayout(tabs);
		
		setTitle("Sef stanice");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private Component panelPravljenjeIzvestaja() {
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		// Kalendar
		JLabel lab1 = new JLabel("Datum pocetka");
		JLabel lab2 = new JLabel("Datum kraja");
		
		UtilDateModel model1 = new UtilDateModel();
		UtilDateModel model2 = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new AbstractFormatter() {
			
			private String datePattern = "dd-MM-yyyy";
		    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		    @Override
		    public Object stringToValue(String text) throws ParseException {
		        return dateFormatter.parseObject(text);
		    }

		    @Override
		    public String valueToString(Object value) throws ParseException {
		        if (value != null) {
		            Calendar cal = (Calendar) value;
		            return dateFormatter.format(cal.getTime());
		        }

		        return "";
		    }
		});
		
		datePicker1.setSize(100, 10);
		
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new AbstractFormatter() {
			
			private String datePattern = "dd-MM-yyyy";
		    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		    @Override
		    public Object stringToValue(String text) throws ParseException {
		        return dateFormatter.parseObject(text);
		    }

		    @Override
		    public String valueToString(Object value) throws ParseException {
		        if (value != null) {
		            Calendar cal = (Calendar) value;
		            return dateFormatter.format(cal.getTime());
		        }

		        return "";
		    }
		});
		
		datePicker2.setSize(100, 10);
		
		// Vrsta izvestaja

		ButtonGroup group = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Izvestaj o zaradi", true);
		JRadioButton rb2 = new JRadioButton("Izvestaj o prolaznosti");
		JRadioButton rb3 = new JRadioButton("Detaljan izvestaj");
		
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		
		// Prikaz izvestaja
		JTextPane area = new JTextPane();
        JScrollPane spane = new JScrollPane(area);
        
        area.setEditable(false);
		
		JButton potvrdiBtn = new JButton("Potvrdi");

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
					.addComponent(lab1)
					.addComponent(datePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(lab2)
					.addComponent(datePicker2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(rb1)
					.addComponent(rb2)
					.addComponent(rb3)
					.addComponent(potvrdiBtn)).addGap(30)
				.addGroup(layout.createParallelGroup()
					.addComponent(spane))
			);
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(lab1)
					.addComponent(datePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(lab2)
					.addComponent(datePicker2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE).addGap(30)
					.addComponent(rb1)
					.addComponent(rb2)
					.addComponent(rb3).addGap(30)
					.addComponent(potvrdiBtn))
				.addGroup(layout.createSequentialGroup()
					.addComponent(spane))
			);
		pack();
		
		return panel;
		
	}
	
	private Component panelIzmenaCena() {
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		String[] deonice = new String[] {"deonice"}; // ucitati deonice
		JComboBox<String> list = new JComboBox<>(deonice);
		
		JLabel lab1 = new JLabel("Valuta");
		JRadioButton rb1 = new JRadioButton("RSD");
		JRadioButton rb2 = new JRadioButton("EUR");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		
		JLabel lab2 = new JLabel("Nove cene");
		JLabel kat1 = new JLabel("Motorno vozilo");
		JLabel kat2 = new JLabel("Putnicko vozilo");
		JLabel kat3 = new JLabel("Kamion");
		JLabel kat4 = new JLabel("Teretni kamion");
		JLabel kat5 = new JLabel("Putnicko vozilo - prkolica");
		
		JTextField cena1 = new JTextField();
		JTextField cena2 = new JTextField();
		JTextField cena3 = new JTextField();
		JTextField cena4 = new JTextField();
		JTextField cena5 = new JTextField();
		
		JButton btn1 = new JButton("Izmeni");
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(list, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(lab1)
						.addComponent(rb1)
						.addComponent(rb2)
						.addComponent(btn1)).addGap(30)
				.addGroup(layout.createParallelGroup()
						.addComponent(lab2)
						.addGroup(layout.createSequentialGroup()
								.addComponent(kat1)
								.addComponent(cena1))
						.addGroup(layout.createSequentialGroup()
								.addComponent(kat2)
								.addComponent(cena2))
						.addGroup(layout.createSequentialGroup()
								.addComponent(kat3)
								.addComponent(cena3))
						.addGroup(layout.createSequentialGroup()
								.addComponent(kat4)
								.addComponent(cena4))
						.addGroup(layout.createSequentialGroup()
								.addComponent(kat5)
								.addComponent(cena5)))
					);
		
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addComponent(list, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE).addGap(20)
						.addComponent(lab1)
						.addComponent(rb1)
						.addComponent(rb2).addGap(30)
						.addComponent(btn1))
				.addGroup(layout.createSequentialGroup()
						.addComponent(lab2)
						.addGroup(layout.createParallelGroup()
								.addComponent(kat1)
								.addComponent(cena1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup()
								.addComponent(kat2)
								.addComponent(cena2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup()
								.addComponent(kat3)
								.addComponent(cena3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup()
								.addComponent(kat4)
								.addComponent(cena4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup()
								.addComponent(kat5)
								.addComponent(cena5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE)))
					);
		pack();
		
		
		return panel;
	}
	
	private Component panelPregledKvarova() {
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		JButton btn1 = new JButton("Pregled izvestaja o kvarovima");
		JButton btn2 = new JButton("Pozovi servis");
		
		// Prikaz izvestaja
		JTextPane area = new JTextPane();
        JScrollPane spane = new JScrollPane(area);
        
        area.setEditable(false);
		
		JButton potvrdiBtn = new JButton("Potvrdi");

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.CENTER)
					.addComponent(btn1)
					.addComponent(btn2)).addGap(30)
				.addGroup(layout.createParallelGroup()
					.addComponent(spane))
			);
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addComponent(btn1).addGap(50)
						.addComponent(btn2))
				.addGroup(layout.createSequentialGroup()
					.addComponent(spane))
			);
		pack();
		
		return panel;
		
	}
	
	private void createLayout(JTabbedPane tabs) {
		Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(tabs)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(tabs)
        );

        pack();
		
	}
}
