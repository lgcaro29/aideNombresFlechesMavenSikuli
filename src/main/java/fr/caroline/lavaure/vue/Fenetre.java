package fr.caroline.lavaure.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private Dimension size;

	private JPanel contentPanel = new JPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem quitter  = new JMenuItem("Quitter");

	NombresFlechesPanel nombresFlechesPanel; 
	
	public Fenetre() {
		this.setTitle("Aide Nombres Fléchés");
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
				
		initMenu();
		
		JLabel titre = new JLabel("Aide Nombres Fléchés");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(new Font("Arial", 14, 40));
		contentPanel.add(titre, BorderLayout.NORTH);
		
		this.size = new Dimension(this.getWidth(), (this.getHeight()));
		contentPanel.add(new NombresFlechesPanel(this.size).getPanel());
		
		this.setJMenuBar(menuBar);

		this.setContentPane(contentPanel);
		this.setVisible(true);

	}
	
	private void initMenu() {
		// ajout d'un écouteur sur quitter
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		
		fichier.add(quitter);
		this.menuBar.add(fichier);
	}
	
	

}




