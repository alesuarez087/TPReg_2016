package uiDesktop;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class frmPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	final static String PANEL_OPCION = "Panel Opcion";
	final static String PANEL_EDITOR = "Panel Editor";
	final static String PANEL_SELECCION = "Panel Seleccion";
	final static String PANEL_PARTIDA = "Panel Partida";
	
	CardLayout card;
	pnlEditor panelEditor;
	pnlOpcion panelOpcion;
	pnlPartida panelPartida;
	pnlSeleccion panelSeleccion;
	
	private JFrame form;
	
	private static frmPrincipal window;

	public static void showPanel(String nombrePanel){
		Container cp = window.form.getContentPane();
		window.card.show(cp, nombrePanel);
	}
	
	public static pnlEditor getPanelEditor(){
		return window.panelEditor;
	}
	
	public static pnlOpcion getPanelOpcion(){
		return window.panelOpcion;
	}
	
	public static pnlPartida getPanelPartida(){
		return window.panelPartida;
	}
	
	public static pnlSeleccion getPanelSeleccion(){
		return window.panelSeleccion;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new frmPrincipal();
					window.form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		form = new JFrame();
		form.setTitle("TP Java 2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		card = new CardLayout(0, 0);
		form.getContentPane().setLayout(card);
		
		panelOpcion = new pnlOpcion();
		panelEditor = new pnlEditor();
		panelSeleccion = new pnlSeleccion();
		panelPartida = new pnlPartida();
		form.getContentPane().add(panelOpcion, PANEL_OPCION);
		form.getContentPane().add(panelEditor, PANEL_EDITOR);
		form.getContentPane().add(panelSeleccion, PANEL_SELECCION);
		form.getContentPane().add(panelPartida, PANEL_PARTIDA);
	}

}
