package prozori;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import modeli.Centrala;
import modeli.Deonica;
import modeli.NaplatnaStanica;

public class ZaposleniUCentraliProzor extends JFrame {
	
	public ZaposleniUCentraliProzor() {
		initUI();
	}
	
	private void initUI() {
		
		
		JLabel datPocetakLab = new JLabel("Datum pocetka");
		JLabel datKrajLab = new JLabel("Datum kraja");
		
		UtilDateModel pocetakDateMod = new UtilDateModel();
		UtilDateModel krajDateMod = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(pocetakDateMod, p);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(datePanel1, new AbstractFormatter() {
			
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
		
		startDatePicker.setSize(100, 10);
		
		JDatePanelImpl datePanel2 = new JDatePanelImpl(krajDateMod, p);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(datePanel2, new AbstractFormatter() {
			
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
		
		endDatePicker.setSize(100, 10);
		
		JLabel naplatneStaniceLab = new JLabel("Naplatne stanice");
		DefaultListModel naplatneStaniceModel = new DefaultListModel();
		for (NaplatnaStanica stanica : Centrala.getInstance().getNaplatneStanice()) {
			naplatneStaniceModel.addElement(stanica.getNaziv());
		}
		
		JList staniceList = new JList(naplatneStaniceModel);
		staniceList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		staniceList.setMinimumSize(new Dimension(100, 100));
		staniceList.setMinimumSize (new Dimension (200,300));
		staniceList.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		staniceList.setVisibleRowCount(10);
		
		
		JRadioButton rb1 = new JRadioButton("Izvestaj o zaradi", true);
		JRadioButton rb2 = new JRadioButton("Izvestaj o prolaznosti");
		JRadioButton rb3 = new JRadioButton("Detaljan izvestaj");
		
		JTextPane areaTextPane = new JTextPane();
        JScrollPane scroll = new JScrollPane(areaTextPane);
        
        areaTextPane.setEditable(false);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		
		createLayout(datPocetakLab,datKrajLab,startDatePicker,endDatePicker,naplatneStaniceLab,staniceList,rb1,rb2,rb3,potvrdiBtn,scroll);
		setTitle("Centrala");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createLayout(Component... arg) {
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);
		
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
					.addComponent(arg[0])
					.addComponent(arg[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(arg[1])
					.addComponent(arg[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(arg[4])
					.addComponent(arg[5])
					.addComponent(arg[6])
					.addComponent(arg[7])
					.addComponent(arg[8])
					.addComponent(arg[9])).addGap(150)
				.addGroup(gl.createParallelGroup()
					.addComponent(arg[10])));
		gl.setVerticalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
					.addComponent(arg[0])
					.addComponent(arg[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE)
					.addComponent(arg[1])
					.addComponent(arg[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					          GroupLayout.PREFERRED_SIZE).addGap(30)
					.addComponent(arg[4])
					.addComponent(arg[5]).addGap(30)
					.addComponent(arg[6])
					.addComponent(arg[7])
					.addComponent(arg[8]).addGap(30)
					.addComponent(arg[9]))
				.addGroup(gl.createSequentialGroup()
					.addComponent(arg[10]))
			);
		pack();
	}
	

}
