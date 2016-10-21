package uiDesktop;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import entities.Personaje;
import logic.ControladorPartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class pnlSeleccion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ControladorPartida ctrl;
	public static Personaje personaje_1;
	public static Personaje personaje_2;
	
	private JComboBox<Personaje> cmbSeleccion_1;
	private JComboBox<Personaje> cmbSeleccion_2;
	private JButton btnIniciarPartida;
	private JButton btnSeleccionar_1;
	private JButton btnSeleccionar_2;
	private JTextField txtVida_1;
	private JTextField txtEnergia_1;
	private JTextField txtDefensa_1;
	private JTextField txtVida_2;
	private JTextField txtEnergia_2;
	private JTextField txtDefensa_2;
	private JLabel lblVida_2;
	private JLabel lblEnergia_2;
	private JLabel lblDefensa_2;
	private JButton btnCancelar_1;
	private JButton btnCancelar_2;
	
	/**
	 * Create the panel.
	 */
	public pnlSeleccion() {
		setLayout(null);

		ctrl = new ControladorPartida();
		
		cmbSeleccion_1 = new JComboBox<Personaje>();
		cmbSeleccion_1.setBounds(33, 30, 113, 20);
		cmbSeleccion_2 = new JComboBox<Personaje>();
		cmbSeleccion_2.setBounds(216, 30, 113, 20);
		cargaCombo();
		cmbSeleccion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personaje per = (Personaje)cmbSeleccion_1.getSelectedItem();
				txtDefensa_1.setText(Integer.toString((per.getDefensa())));
				txtEnergia_1.setText(Integer.toString(per.getEnergia()));
				txtVida_1.setText(Integer.toString(per.getVida()));
			}
		});
		add(cmbSeleccion_1);
		
		cmbSeleccion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personaje per = (Personaje)cmbSeleccion_2.getSelectedItem();
				txtDefensa_2.setText(Integer.toString((per.getDefensa())));
				txtEnergia_2.setText(Integer.toString(per.getEnergia()));
				txtVida_2.setText(Integer.toString(per.getVida()));
			}
		});
		add(cmbSeleccion_2);
		
		btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.setBounds(216, 244, 113, 23);
		btnIniciarPartida.setEnabled(false);
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turnos();
			}
		});
		add(btnIniciarPartida);
		
		btnSeleccionar_1 = new JButton("Seleccionar");
		btnSeleccionar_1.setBounds(33, 150, 113, 23);
		btnSeleccionar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionar_1();
			}
		});
		add(btnSeleccionar_1);
		
		btnSeleccionar_2 = new JButton("Seleccionar");
		btnSeleccionar_2.setBounds(216, 150, 113, 23);
		btnSeleccionar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionar_2();
			}
		});
		add(btnSeleccionar_2);
		
		txtVida_1 = new JTextField();
		txtVida_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida_1.setBounds(122, 60, 34, 20);
		add(txtVida_1);
		txtVida_1.setColumns(10);
		
		txtEnergia_1 = new JTextField();
		txtEnergia_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia_1.setBounds(122, 85, 34, 20);
		add(txtEnergia_1);
		txtEnergia_1.setColumns(10);
		
		txtDefensa_1 = new JTextField();
		txtDefensa_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa_1.setBounds(122, 110, 34, 20);
		add(txtDefensa_1);
		txtDefensa_1.setColumns(10);
		
		txtVida_2 = new JTextField();
		txtVida_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida_2.setBounds(305, 60, 34, 20);
		add(txtVida_2);
		txtVida_2.setColumns(10);
		
		txtEnergia_2 = new JTextField();
		txtEnergia_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia_2.setBounds(305, 85, 34, 20);
		add(txtEnergia_2);
		txtEnergia_2.setColumns(10);
		
		txtDefensa_2 = new JTextField();
		txtDefensa_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa_2.setBounds(305, 110, 34, 20);
		add(txtDefensa_2);
		txtDefensa_2.setColumns(10);
		
		JLabel lblVida_1 = new JLabel("Vida");
		lblVida_1.setBounds(23, 63, 46, 14);
		add(lblVida_1);
		
		JLabel lblEnergia_1 = new JLabel("Energ\u00EDa");
		lblEnergia_1.setBounds(23, 88, 46, 14);
		add(lblEnergia_1);
		
		JLabel lblDefensa_1 = new JLabel("Defensa");
		lblDefensa_1.setBounds(23, 113, 69, 14);
		add(lblDefensa_1);
		
		lblVida_2 = new JLabel("Vida");
		lblVida_2.setBounds(206, 63, 46, 14);
		add(lblVida_2);
		
		lblEnergia_2 = new JLabel("Energ\u00EDa");
		lblEnergia_2.setBounds(206, 88, 46, 14);
		add(lblEnergia_2);
		
		lblDefensa_2 = new JLabel("Defensa");
		lblDefensa_2.setBounds(206, 113, 69, 14);
		add(lblDefensa_2);
		
		btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cancelarSeleccion_1();
			}
		});
		btnCancelar_1.setEnabled(false);
		btnCancelar_1.setBounds(33, 179, 113, 23);
		add(btnCancelar_1);
		
		btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelarSeleccion_2();
			}
		});
		btnCancelar_2.setEnabled(false);
		btnCancelar_2.setBounds(216, 179, 113, 23);
		add(btnCancelar_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atras();
			}
		});
		btnVolver.setBounds(33, 244, 113, 23);
		add(btnVolver);
	}
	
	public void cargaCombo(){
		ArrayList<Personaje> list = ctrl.getAll();
		int i = 0;
		Personaje p = null;
		for(i=0;i<list.size();i++){
			p = list.get(i);
			cmbSeleccion_1.addItem(p);
			cmbSeleccion_2.addItem(p);
		}
	}
	
	private void seleccionar_1(){
		personaje_1 = (Personaje)cmbSeleccion_1.getSelectedItem();
		btnSeleccionar_1.setEnabled(false);
		btnCancelar_1.setEnabled(true);
		cmbSeleccion_2.removeItem(personaje_1);
		iniciarPartida();
	}
	
	private void seleccionar_2(){
		personaje_2 = (Personaje)cmbSeleccion_2.getSelectedItem();
		btnSeleccionar_2.setEnabled(false);
		btnCancelar_2.setEnabled(true);
		cmbSeleccion_1.removeItem(personaje_2);
		iniciarPartida();
	}
	
	private void cancelarSeleccion_1(){
		cmbSeleccion_2.addItem(personaje_1);
		personaje_1 = null;
		btnSeleccionar_1.setEnabled(true);
		btnCancelar_1.setEnabled(false);
	}
	
	private void cancelarSeleccion_2(){
		cmbSeleccion_1.addItem(personaje_2);
		personaje_2 = null;
		btnSeleccionar_2.setEnabled(true);
		btnCancelar_2.setEnabled(false);
	}
	
	private void iniciarPartida(){
		if(personaje_1!=null && personaje_2!=null){
			btnIniciarPartida.setEnabled(true);
		}
	}
	
	private void turnos(){
		frmPrincipal.getPanelPartida().iniciaPartida(personaje_1, personaje_2);
		frmPrincipal.showPanel(frmPrincipal.PANEL_PARTIDA);
	}
	
	private void atras(){
		frmPrincipal.showPanel(frmPrincipal.PANEL_OPCION);
	}
}
