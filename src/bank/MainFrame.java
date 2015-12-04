package bank;



import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {

	private JTextField _txtPNr;
	private JTextField _txtId;
	private JTextField _txtName;
	private JTextField _txtAmount;
	private JTextArea _taOutput;
	private JButton _btnOk;
	private JComboBox<KeyValue> _cbCommand;
	private Border _bDefaultBorder;
	
	/**
	 * Konstruktor för Mainframe klassen
	 */
	public MainFrame(String title) {
		setTitle(title);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

		_cbCommand = new JComboBox<>();
		_cbCommand.addItem(new KeyValue("cmdAddCustomer", "Lägg till ny kund"));
		_cbCommand.addItem(new KeyValue("cmdShowCustomerList", "Visa kund lista"));
		_cbCommand.addItem(new KeyValue("cmdShowCustomerInfo", "Visa kund info"));
		_cbCommand.addItem(new KeyValue("cmdChangeCustomerName", "Ändra kundens namn"));
		_cbCommand.addItem(new KeyValue("cmdRemoveCustomer", "Ta bort kund"));
		_cbCommand.addItem(new KeyValue("cmdDisableController", "-------------------------------"));
		_cbCommand.addItem(new KeyValue("cmdFindAccount", "Sök konto"));
		_cbCommand.addItem(new KeyValue("cmdFindTransaction", "Sök transaktion"));
		_cbCommand.addItem(new KeyValue("cmdAddSavingsAccount", "Lägg till sparkonto"));
		_cbCommand.addItem(new KeyValue("cmdAddCreditAccount", "Lägg till kreditkonto"));
		_cbCommand.addItem(new KeyValue("cmdRemoveAccount", "Ta bort konto"));
		_cbCommand.addItem(new KeyValue("cmdDisableController", "--------------------------------"));
		_cbCommand.addItem(new KeyValue("cmdDeposit", "Insättning"));
		_cbCommand.addItem(new KeyValue("cmdWithdraw", "Uttag"));
		_cbCommand.addItem(new KeyValue("cmdDisableController", "----------------------------------"));
		_cbCommand.addItem(new KeyValue("cmdSaveCustomerList", "Expotera kundlistan till fil"));
		_cbCommand.addItem(new KeyValue("cmdSaveCustomerInfo", "Expotera kundinfo till fil"));

		_cbCommand.addActionListener(this);

		_txtPNr = new JTextField(10);
		_txtId = new JTextField(5);
		_txtName = new JTextField(10);
		_txtAmount = new JTextField(6);
		
		JPanel _pnlInput = new JPanel(new FlowLayout());
		_pnlInput.add(new JLabel("Personnr: "));
		_pnlInput.add(_txtPNr);
		_pnlInput.add(new JLabel("Kontonr: "));
		_pnlInput.add(_txtId);
		_pnlInput.add(new JLabel("Namn: "));
		_pnlInput.add(_txtName);
		_pnlInput.add(new JLabel("Belopp: "));
		_pnlInput.add(_txtAmount);
		
		_taOutput = new JTextArea();
		_taOutput.setEditable(true);
		JScrollPane _scOutput = new JScrollPane(_taOutput);
		_scOutput.setPreferredSize(new Dimension(500, 250));
		
		JPanel _pnlCenter = new JPanel(new BorderLayout());
		_pnlCenter.add(_pnlInput, BorderLayout.PAGE_START);
		_pnlCenter.add(_scOutput, BorderLayout.CENTER);
		
		_btnOk = new JButton("OK");
		_btnOk.setPreferredSize(new Dimension(50, 50));
		_btnOk.addActionListener(this);
		
		add(_cbCommand, BorderLayout.PAGE_START);
		add(_pnlCenter, BorderLayout.CENTER);
		add(_btnOk, BorderLayout.PAGE_END);

		pack();
		
		_bDefaultBorder = _txtPNr.getBorder();
		_cbCommand.setSelectedIndex(0);
		Helper.isValidName("Cam Huynh");
	}
	
	/**
	 * Händelse hanterare för både Combobox och OK knappen
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {

		if ( ev.getSource() == _cbCommand) {	// hantera combobox 
			
			String _command = ((KeyValue) _cbCommand.getSelectedItem()).getKey();
			switch (_command) {
				case "cmdAddCustomer": 
					enableComponent(true, false, true, false, true);				
					break;
				case "cmdChangeCustomerName": 
					enableComponent(true, false, true, false, true);
					break;
				case "cmdAddSavingsAccount":
					enableComponent(true, false, false, false, true);
					break;
				case "cmdAddCreditAccount":
					enableComponent(true, false, false, false, true);
					break;
				case "cmdRemoveCustomer":
					enableComponent(true, false, false, false, true);
					break;
				case "cmdFindAccount":
					enableComponent(true, false, false, false, true);
					break;
				case "cmdFindTransaction":
					enableComponent(false, true, false, false, true);
					break;
				case "cmdRemoveAccount": 
					enableComponent(true, true, false, false, true);
					break;
				case "cmdDeposit": 
					enableComponent(true, true, false, true, true);
					break;
				case "cmdWithDraw": 
					enableComponent(true, true, false, true, true);
					break;
				case "cmdShowCustomerList":
					enableComponent(false, false, false, false, true);
					break;
				case "cmdShowCustomerInfo":
					enableComponent(true, false, false, false, true);
					break;
				case "cmdSaveCustomerList":
					enableComponent(false, false, false, false, true);
					break;
				case "cmdSaveCustomerInfo":
					enableComponent(false, false, false, false, true);
					break;
				case "cmdDisableController":
					enableComponent(false, false, false, false, true);
			}
			
			_btnOk.setActionCommand(_command);
			
		} else if ( ev.getSource() == _btnOk) {	// hantera ok knapp
			String data;
			Path path;

			if (!validateInput())	return;

			switch (_btnOk.getActionCommand()) {
				case "cmdAddCustomer": 
					System.out.print(_btnOk.getActionCommand());
					
					break;
				case "cmdChangeCustomerName": 
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdAddSavingsAccount":
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdAddCreditAccounr":
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdRemoveCustomer":
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdRemoveAccount": 
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdDeposit": 
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdWithDraw": 
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdShowCustomerList":
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdShowCustomerInfo":
					// här skall koden lägga in för att utföra uppgiften i databas
					
					break;
				case "cmdSaveCustomerList":
					// här skall koden lägga in för att utföra uppgiften i databas
					data = "anna\\cam\\hanpus\\hamid\\åsa";

					path = getPath();
					if (path != null)	
						Helper.saveToFile(path, data);
					
					break;
				case "cmdSaveCustomerInfo":
					// här skall koden lägga in för att utföra uppgiften i databas
					data = "Kund Anna\\n1001: SPARKONTO\\nSaldo: 5000.80\\n1002: KREDITKONTO\\nSaldo: 5000.80";

					path = getPath();
					if (path != null)	
						Helper.saveToFile(path, data);

					break;
			}
		}
	}

	/**
	 * @return sökväg efter användare har valt en fil i FileChoose dialog
	 */
	private Path getPath() {
		JFileChooser _fc = new JFileChooser();

		_fc.setDialogTitle("Spara som");
		if ( _fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

			return Paths.get(_fc.getSelectedFile().getAbsolutePath());
		}
		else
			return null;
	}

	/**
	 * @return Validera att alla aktiva textbox värde är giltig
	 */
	private boolean validateInput() {
		boolean isOk = true;
		
		if (_txtPNr.isEnabled() && !Helper.isValidPNr(_txtPNr.getText())) {
			_txtPNr.setBackground(Color.red);
			isOk = false;
		} else
			_txtPNr.setBackground(Color.white);
			
		if (_txtId.isEnabled() && !Helper.isValidAccountId(_txtId.getText())) {
			_txtId.setBackground(Color.red);
			isOk = false;
		} else
			_txtId.setBackground(Color.white);

		if (_txtName.isEnabled() && !Helper.isValidName(_txtName.getText())) {
			_txtName.setBackground(Color.red);
			isOk = false;
		} else
			_txtName.setBackground(Color.white);

		if (_txtAmount.isEnabled() && !Helper.isValidNr(_txtAmount.getText())) {
			_txtAmount.setBackground(Color.red);
			isOk = false;
		} else
			_txtAmount.setBackground(Color.white);

		return isOk;
	}

	/**
	 * Aktivera eller avaktivera textbox
	 */
	private void enableComponent(boolean selPNr, boolean selId, boolean selName, boolean selAmount, boolean selOkButt) {
		_txtPNr.setEnabled(selPNr);
		_txtId.setEnabled(selId);
		_txtName.setEnabled(selName);
		_txtAmount.setEnabled(selAmount);
		_btnOk.setEnabled(selOkButt);

		if(selPNr) {
			_txtPNr.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
			_txtPNr.setText("");
			_txtPNr.setBorder(_bDefaultBorder);
		}
			
		if(selId) {
			_txtId.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
			_txtId.setText("");
			_txtId.setBorder(_bDefaultBorder);
		}

		if(selName) {
			_txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
			_txtName.setText("");
			_txtName.setBorder(_bDefaultBorder);
		}
		
		if(selAmount) {
			_txtAmount.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
			_txtAmount.setText("");
			_txtAmount.setBorder(_bDefaultBorder);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				MainFrame _frame = new MainFrame("Newton Bank");
				_frame.setVisible(true);
			}
		});
	}
}

/**
 * Denna klassen använd till Combobox Key/Value 
 */
class KeyValue {
   private String _key;
   private String _value;
 
   public KeyValue(String key, String value) {
      _key = key;
	  _value = value;
   }
 
   public String getKey() {
      return _key;
   }

   public String getValue() {
      return _value;
   }

   public String toString() {
      return _value;
   }
}