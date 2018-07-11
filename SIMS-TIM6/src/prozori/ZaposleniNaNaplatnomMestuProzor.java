package prozori;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ZaposleniNaNaplatnomMestuProzor extends JFrame {
	
	public ZaposleniNaNaplatnomMestuProzor() {
		initUI();
	}
	
	private void initUI() {
		
		
		JButton katBtn1 = new JButton("<html>MOTOR</html>");
		JButton katBtn2 = new JButton("<html>PUTNICKO<br/>VOZILO</html>");
		JButton katBtn3 = new JButton("<html>PUTNICKO<br/>VOZILO<br/>PRIKOLICA</html>");
		JButton katBtn4 = new JButton("<html>KAMION</html>");
		JButton katBtn5 = new JButton("<html>TERETNI<br/>KAMION</html>");
		
		katBtn1.setPreferredSize(new Dimension(250, 180));
		katBtn2.setPreferredSize(new Dimension(250, 180));
		katBtn3.setPreferredSize(new Dimension(250, 180));
		katBtn4.setPreferredSize(new Dimension(250, 180));
		katBtn5.setPreferredSize(new Dimension(250, 180));
		
		katBtn1.setFont(new Font("Arial", Font.PLAIN, 40));
		katBtn2.setFont(new Font("Arial", Font.PLAIN, 40));
		katBtn3.setFont(new Font("Arial", Font.PLAIN, 40));
		katBtn4.setFont(new Font("Arial", Font.PLAIN, 40));
		katBtn5.setFont(new Font("Arial", Font.PLAIN, 40));
		
		
		JButton rsdBtn = new JButton("RSD");
		JButton eurBtn = new JButton("EUR");
		
		rsdBtn.setPreferredSize(new Dimension(250, 150));
		eurBtn.setPreferredSize(new Dimension(250, 150));
		
		rsdBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		eurBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JLabel lblList = new JLabel("LISTA IDE OVDE");
		lblList.setFont(new Font("Arial", Font.PLAIN, 40));
		lblList.setPreferredSize(new Dimension(450, 721));
		lblList.setBackground(Color.decode("#ffd27f"));
		lblList.setOpaque(true);
		
		JLabel lblCtrl = new JLabel("KONTROLER OVDE");
		lblCtrl.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCtrl.setPreferredSize(new Dimension(480, 300));
		lblCtrl.setBackground(Color.decode("#e6b3ff"));
		lblCtrl.setOpaque(true);
		
		JButton upBtn = new JButton("<html>PODIGNI<br/>RAMPU</html>");
		JButton dwBtn = new JButton("<html>SPUSTI<br/>RAMPU</html>");
		
		upBtn.setPreferredSize(new Dimension(230, 150));
		dwBtn.setPreferredSize(new Dimension(230, 150));
		
		upBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		dwBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JLabel priceLbl = new JLabel("ZA NAPLATU:");
		priceLbl.setPreferredSize(new Dimension(230, 70));
		priceLbl.setFont(new Font("Arial", Font.PLAIN, 34));
		
		JTextField priceTxt = new JTextField();
		priceTxt.setPreferredSize(new Dimension(230, 80));
		priceTxt.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton payBtn = new JButton("NAPLATI");
		payBtn.setPreferredSize(new Dimension(230, 155));
		payBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		
		
		createLayout(katBtn1, katBtn2, katBtn3, katBtn4, katBtn5, rsdBtn, eurBtn, lblList, lblCtrl, upBtn, dwBtn, priceLbl, priceTxt, payBtn );
		
		setTitle("Naplata");
		setSize(1600, 800);
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
				.addGap(20)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(arg[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE))
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(206)
						.addComponent(arg[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE))
				.addGap(50)
				.addComponent(arg[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				          GroupLayout.PREFERRED_SIZE)
				.addGap(50)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(110)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(arg[10], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(gl.createSequentialGroup()
								.addGroup(gl.createParallelGroup()
										.addComponent(arg[11], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(arg[12], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										)
								.addGap(20)
								.addComponent(arg[13], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						)
				);

		gl.setVerticalGroup(gl.createParallelGroup()
				.addGap(20)
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(arg[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE))
				
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(206)
						.addComponent(arg[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE))
				.addGap(50)
				.addComponent(arg[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				          GroupLayout.PREFERRED_SIZE)
				.addGap(50)
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addGap(110)
						.addGroup(gl.createParallelGroup()
								.addComponent(arg[9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(arg[10], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(gl.createParallelGroup()
								.addGroup(gl.createSequentialGroup()
										.addComponent(arg[11], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(arg[12], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										)
								.addGap(20)
								.addComponent(arg[13], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE)))
				);

		pack();
	}

}
