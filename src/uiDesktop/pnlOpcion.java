package uiDesktop;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlOpcion extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public pnlOpcion() {
		setLayout(null);

		JButton btnPartida = new JButton("Partida");
		btnPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partida();
			}
		});
		btnPartida.setBounds(178, 104, 94, 23);
		add(btnPartida);
		
		JButton btnEditor = new JButton("Editor");
		btnEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editor();
			}
		});
		btnEditor.setBounds(178, 152, 94, 23);
		add(btnEditor);

	}

	
	public void partida(){
		frmPrincipal.showPanel(frmPrincipal.PANEL_SELECCION);
	}
	
	public void editor(){
		frmPrincipal.showPanel(frmPrincipal.PANEL_EDITOR);
	}
}
