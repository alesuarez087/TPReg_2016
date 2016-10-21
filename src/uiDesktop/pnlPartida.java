package uiDesktop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import entities.Personaje;
import logic.ControladorPartida;
import utils.ApplicationException;

public class pnlPartida extends JPanel {

	private static final long serialVersionUID = 1L;

	protected ControladorPartida ctrl;
	
	protected Personaje p1;
	protected Personaje p2;
	public void setP1(Personaje p1) {
		this.p1 = p1;
	}
	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	private JTextField txtVida_1;
	private JTextField txtVida_2;
	private JLabel lblPersonaje_1;
	private JLabel lblPersonaje_2;
	private JTextField txtEnergia_1;
	private JTextField txtDefensa_1;
	private JLabel lblAtaque_1;
	private JLabel lblEnergia_1;
	private JLabel lblDefensa_1;
	private JLabel lblAtaque_2;
	private JLabel lblEnergia_2;
	private JLabel lblDefensa_2;
	private JSpinner spnAtaque_2;
	private JTextField txtEnergia_2;
	private JTextField txtDefensa_2;
	private JButton btnFinalDePartida;
	private JButton btnAtaque;
	private JButton btnDefensa;
	private JSpinner spnAtaque_1;
	private JLabel lblPersonajeTurno;
	private JLabel lblAtaqueBloqueado;

	/**
	 * Create the panel.
	 */
	public pnlPartida() {
		setLayout(null);

		ctrl = new ControladorPartida();
		
		lblPersonaje_1 = new JLabel("New label");
		lblPersonaje_1.setText("");
		lblPersonaje_1.setBounds(85, 14, 46, 14);
		add(lblPersonaje_1);
		
		lblAtaque_1 = new JLabel("Ataque");
		lblAtaque_1.setBounds(37, 63, 58, 14);
		add(lblAtaque_1);
		
		lblEnergia_1 = new JLabel("Energ\u00EDa");
		lblEnergia_1.setBounds(37, 93, 58, 14);
		add(lblEnergia_1);
		
		lblDefensa_1 = new JLabel("Defensa");
		lblDefensa_1.setBounds(37, 124, 58, 14);
		add(lblDefensa_1);
		
		lblPersonaje_2 = new JLabel("Personaje_2");
		lblPersonaje_2.setText("");
		lblPersonaje_2.setBounds(311, 14, 46, 14);
		add(lblPersonaje_2);
		
		lblAtaque_2 = new JLabel("Ataque");
		lblAtaque_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtaque_2.setBounds(362, 63, 46, 14);
		add(lblAtaque_2);
		
		lblEnergia_2 = new JLabel("Energ\u00EDa");
		lblEnergia_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergia_2.setBounds(362, 93, 46, 14);
		add(lblEnergia_2);
		
		lblDefensa_2 = new JLabel("Defensa");
		lblDefensa_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefensa_2.setBounds(350, 124, 58, 14);
		add(lblDefensa_2);
		
		txtVida_1 = new JTextField();
		txtVida_1.setEditable(false);
		txtVida_1.setEnabled(false);
		txtVida_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida_1.setBounds(155, 11, 45, 20);
		add(txtVida_1);
		txtVida_1.setColumns(10);
		//150
		
		spnAtaque_1 = new JSpinner();
		spnAtaque_1.setEnabled(false);
		spnAtaque_1.setBounds(105, 60, 45, 20);
		add(spnAtaque_1);
		
		txtEnergia_1 = new JTextField();
		txtEnergia_1.setEditable(false);
		txtEnergia_1.setEnabled(false);
		txtEnergia_1.setBounds(105, 90, 45, 20);
		add(txtEnergia_1);
		txtEnergia_1.setColumns(10);
		
		txtDefensa_1 = new JTextField();
		txtDefensa_1.setEnabled(false);
		txtDefensa_1.setEditable(false);
		txtDefensa_1.setBounds(105, 121, 46, 20);
		add(txtDefensa_1);
		txtDefensa_1.setColumns(10);
		
		txtVida_2 = new JTextField();
		txtVida_2.setEditable(false);
		txtVida_2.setEnabled(false);
		txtVida_2.setBounds(250, 11, 45, 20);
		add(txtVida_2);
		txtVida_2.setColumns(10);
		
		spnAtaque_2 = new JSpinner();
		spnAtaque_2.setEnabled(false);
		spnAtaque_2.setBounds(295, 60, 45, 20);
		add(spnAtaque_2);
		
		txtEnergia_2 = new JTextField();
		txtEnergia_2.setEditable(false);
		txtEnergia_2.setEnabled(false);
		txtEnergia_2.setBounds(295, 90, 45, 20);
		add(txtEnergia_2);
		txtEnergia_2.setColumns(10);
		
		txtDefensa_2 = new JTextField();
		txtDefensa_2.setEnabled(false);
		txtDefensa_2.setEditable(false);
		txtDefensa_2.setBounds(295, 120, 45, 20);
		add(txtDefensa_2);
		txtDefensa_2.setColumns(10);
		
		btnAtaque = new JButton("Ataque");
		btnAtaque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				atacar();
			}
		});
		
		btnAtaque.setBounds(112, 208, 89, 23);
		add(btnAtaque);
		
		btnDefensa = new JButton("Defensa");
		btnDefensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				defender();
			}
		});
		btnDefensa.setBounds(251, 208, 89, 23);
		add(btnDefensa);
		
		btnFinalDePartida = new JButton("Final de Partida");
		btnFinalDePartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cierre();
			}
		});
		btnFinalDePartida.setEnabled(false);
		btnFinalDePartida.setBounds(169, 242, 113, 23);
		add(btnFinalDePartida);
		
		JLabel lblElTurnoCorresponde = new JLabel("El turno corresponde a:");
		lblElTurnoCorresponde.setBounds(87, 152, 208, 14);
		add(lblElTurnoCorresponde);
		
		lblPersonajeTurno = new JLabel("New label");
//		lblPersonajeTurno.setText(ctrl.getAtaca().toString());
		lblPersonajeTurno.setBounds(225, 152, 46, 14);
		add(lblPersonajeTurno);
		
		lblAtaqueBloqueado = new JLabel("Debido a que no posee energ\u00EDa, el personaje no puede atacar");
		lblAtaqueBloqueado.setVerticalAlignment(SwingConstants.TOP);
		lblAtaqueBloqueado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaqueBloqueado.setBounds(37, 183, 371, 14);
		add(lblAtaqueBloqueado);
		
		lblAtaqueBloqueado.setVisible(false);
		
	}

	private void atacar(){
		int pto;
		if((ctrl.getJugador_1()).equals(ctrl.getTurno())){
			pto = (int)this.spnAtaque_1.getValue();
		} else{
			pto = (int)this.spnAtaque_2.getValue();
		}
		try {
			ctrl.atacar(pto);
			actualizarPartida();
			if(ctrl.getFin()){
				JOptionPane.showMessageDialog(this, ctrl.getTurno().getNombre() + " ha ganado la partida");
				finalPartida();
			}
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	private void finalPartida(){
		btnAtaque.setEnabled(false);
		btnDefensa.setEnabled(false);
		spnAtaque_1.setEnabled(false);
		spnAtaque_2.setEnabled(false);
		btnFinalDePartida.setEnabled(true);
	}
	
	private void actualizarPartida(){
		Personaje p1 = ctrl.getJugador_1();
		this.lblPersonaje_1.setText(p1.getNombre());
		this.txtVida_1.setText(Integer.toString(p1.getVidaRestante()));
		this.txtEnergia_1.setText(Integer.toString(p1.getEnergiaRestante()));
		this.txtDefensa_1.setText(Integer.toString(p1.getDefensa()));
		
		Personaje p2 = ctrl.getJugador_2();
		this.lblPersonaje_2.setText(p2.getNombre());
		this.txtVida_2.setText(Integer.toString(p2.getVidaRestante()));
		this.txtEnergia_2.setText(Integer.toString(p2.getEnergiaRestante()));
		this.txtDefensa_2.setText(Integer.toString(p2.getDefensa()));
		
		this.lblPersonajeTurno.setText(ctrl.getTurno().getNombre());
		
		if((ctrl.getJugador_1()).equals(ctrl.getTurno())){
			this.spnAtaque_2.setEnabled(false);
			if(Integer.parseInt(txtEnergia_1.getText())==0){
				this.btnAtaque.setEnabled(false);
				lblAtaqueBloqueado.setVisible(true);
			} else{
				lblAtaqueBloqueado.setVisible(false);
				this.spnAtaque_1.setEnabled(true);
				this.btnAtaque.setEnabled(true);
			}
		} else{
			this.spnAtaque_1.setEnabled(false);
			if(Integer.parseInt(txtEnergia_2.getText())==0){
				this.btnAtaque.setEnabled(false);
				lblAtaqueBloqueado.setVisible(true);
			} else{
				lblAtaqueBloqueado.setVisible(false);
				this.spnAtaque_2.setEnabled(true);
				this.btnAtaque.setEnabled(true);
			}
		}
		
		int max1 = ctrl.getJugador_1().getEnergiaRestante();
		int max2 = ctrl.getJugador_2().getEnergiaRestante();
		
		this.spnAtaque_1.setModel(new SpinnerNumberModel(0, 0, max1, 1));
		this.spnAtaque_2.setModel(new SpinnerNumberModel(0, 0, max2, 1));
	}
	
	private void defender(){
		try {
			ctrl.defender();
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		actualizarPartida();
	}
	
	public void iniciaPartida(Personaje p1, Personaje p2){
		ctrl.inicioPartida(p1, p2);
		this.actualizarPartida();
	}
	
	 private void cierre(){
		frmPrincipal.showPanel(frmPrincipal.PANEL_OPCION);
	 }
}
