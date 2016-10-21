package uiDesktop;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import entities.Personaje;
import logic.ControladorEditor;
import utils.ApplicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class pnlEditor extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private ControladorEditor ctrl;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPuntosTotales;
	private JTextField txtPuntosRestantes;
	private JSpinner spnVida;
	private JSpinner spnEvasion;
	private JSpinner spnDefensa;
	private JSpinner spnEnergia;
	

	/**
	 * Create the panel.
	 */
	public pnlEditor() {
		setLayout(null);
		
		ctrl = new ControladorEditor();
		
			
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 36, 46, 14);
		add(lblId);
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 46, 14);
		add(lblNombre);
	
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(25, 92, 46, 14);
		add(lblVida);
	
		JLabel lblEnergia = new JLabel("Energ\u00EDa");
		lblEnergia.setBounds(25, 120, 46, 14);
		add(lblEnergia);
	
		JLabel lblEvasion = new JLabel("Evasi\u00F3n");
		lblEvasion.setBounds(25, 148, 46, 14);
		add(lblEvasion);
	
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(25, 176, 46, 14);
		add(lblDefensa);
	
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntosTotales.setBounds(25, 204, 103, 14);
		add(lblPuntosTotales);
	
		JLabel lblPuntosRestantes = new JLabel("Puntos Restantes");
		lblPuntosRestantes.setBounds(25, 232, 117, 14);
		add(lblPuntosRestantes);
	
		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setText("0");
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(60, 33, 86, 20);
		add(txtId);
		txtId.setColumns(10);
	
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(60, 61, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
	
		ChangeListener cl = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0){
				actualizarRestante();
			}
		};
	
		spnVida = new JSpinner();
		spnVida.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnVida.addChangeListener(cl);
		spnVida.setBounds(135, 89, 46, 20);
		add(spnVida);
	
		spnEnergia = new JSpinner();
		spnEnergia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnEnergia.addChangeListener(cl);
		spnEnergia.setBounds(135, 117, 46, 20);
		add(spnEnergia);
	
		spnEvasion = new JSpinner();
		spnEvasion.setModel(new SpinnerNumberModel(0, 0, Personaje.MAX_EVASION, 1));
		spnEvasion.addChangeListener(cl);
		spnEvasion.setBounds(135, 145, 46, 20);
		add(spnEvasion);
	
		spnDefensa = new JSpinner();
		spnDefensa.setModel(new SpinnerNumberModel(0, 0, Personaje.MAX_DEFENSA, 1));
		spnDefensa.addChangeListener(cl);
		spnDefensa.setBounds(135, 173, 46, 20);
		add(spnDefensa);
	
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosTotales.setText("200");
		txtPuntosTotales.setEnabled(false);
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setBounds(135, 201, 46, 20);
		add(txtPuntosTotales);
		txtPuntosTotales.setColumns(10);
	
		txtPuntosRestantes = new JTextField();
		txtPuntosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosRestantes.setText("200");
		txtPuntosRestantes.setEditable(false);
		txtPuntosRestantes.setEnabled(false);
		txtPuntosRestantes.setBounds(135, 229, 46, 20);
		add(txtPuntosRestantes);
		txtPuntosRestantes.setColumns(10);
	
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(7, 260, 86, 23);
		add(btnAgregar);
	
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificar();
			}
		});
		
		btnModificar.setBounds(116, 260, 86, 23);
		add(btnModificar);
	
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(7, 293, 86, 23);
		add(btnEliminar);
	
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atras();
			}
		});
		btnAtras.setBounds(116, 293, 86, 23);
		add(btnAtras);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(201, 59, 86, 23);
		add(btnBuscar);
	}
	
	private void actualizarRestante(){
		int spinner = (int)spnDefensa.getValue() + (int)spnEvasion.getValue() + (int)spnEnergia.getValue() + (int)spnVida.getValue();
		int total = Integer.parseInt(txtPuntosTotales.getText());
		txtPuntosRestantes.setText(Integer.toString(total-spinner));
	}

	private void mapearAFormulario(Personaje p){
		this.txtId.setText(Integer.toString(p.getId()));
		this.txtNombre.setText(p.getNombre());
		this.txtPuntosTotales.setText((Integer.toString(p.getPuntosTotales())));
		this.spnDefensa.setValue(p.getDefensa());
		this.spnEnergia.setValue(p.getEnergia());
		this.spnEvasion.setValue(p.getEvasion());
		this.spnVida.setValue(p.getVida());
	}
	
	private Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(this.txtId.getText()));
		p.setNombre(this.txtNombre.getText());
		p.setPuntosTotales(Integer.parseInt(this.txtPuntosTotales.getText()));
		p.setDefensa((int)this.spnDefensa.getValue());
		p.setEnergia((int)this.spnEnergia.getValue());
		p.setEvasion((int)this.spnEvasion.getValue());
		p.setVida((int)this.spnVida.getValue());
		return p;
	}

	private void agregar(){
		if(ctrl.agregar(mapearDeFormulario())){
			limpiarCampos();
		}
	}
	
	private void modificar(){
		if(ctrl.modificar(mapearDeFormulario())){
			limpiarCampos();
		}
	}

	private void limpiarCampos(){
		this.txtId.setText("0");
		this.txtNombre.setText("");
		this.spnDefensa.setValue(0);
		this.spnEnergia.setValue(0);
		this.spnEvasion.setValue(0);
		this.spnVida.setValue(0);
		txtPuntosTotales.setText(Integer.toString(Personaje.PUNTOS_INICIO));
		txtId.setText("0");
		this.actualizarRestante();
	}

	private void buscar(){
		Personaje p = ctrl.getPersonaje(mapearDeFormulario().getNombre());
		if(p!=null){
			mapearAFormulario(p);
		} else{
			JOptionPane.showMessageDialog(null, "No existe ese personaje");
			limpiarCampos();
		}
	}
	
	private void eliminar(){
		try {
			int c = JOptionPane.showConfirmDialog(null, "Atencíon, desde eliminar el contenido ?");
			if(JOptionPane.OK_OPTION == c){
				ctrl.delete(mapearDeFormulario());
			}
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(this, e);
		} catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error Inesperado");
		}
	}

	private void atras(){
		frmPrincipal.showPanel(frmPrincipal.PANEL_OPCION);
	}
}
