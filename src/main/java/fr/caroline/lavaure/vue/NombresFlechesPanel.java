package fr.caroline.lavaure.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.caroline.lavaure.services.Somme;

public class NombresFlechesPanel extends Container {

	private JFormattedTextField nombreFTextField;
	private JComboBox<Integer> nombreCombo;

	private JPanel conteneur = new JPanel();

	private Dimension size;

	public NombresFlechesPanel(Dimension _dim) {
		super(_dim);
		this.size = _dim;
		this.initPanel(this.size);
	}

	@Override
	protected void initPanel(Dimension _dim) {

		JLabel videLabel = new JLabel(" ");
		videLabel.setPreferredSize(new Dimension(900, 50));
		JLabel nombreDeChiffresLabel = new JLabel("Nombre de chiffres (2 à 9)");
		nombreDeChiffresLabel.setFont(arial20);
		Integer[] tab = {2,3,4,5,6,7,8,9};
		this.nombreCombo = new JComboBox<Integer>(tab);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.add(videLabel);
		panel1.add(nombreDeChiffresLabel);
		panel1.add(this.nombreCombo);

		JLabel NombreLabel = new JLabel("Nombre dont on veut les sommes (3 à 45)");
		NombreLabel.setFont(arial20);
		this.nombreFTextField = new JFormattedTextField(NumberFormat.getInstance());
		this.nombreFTextField.setPreferredSize(new Dimension(50, 30));
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.add(NombreLabel);
		panel2.add(this.nombreFTextField);

		JButton boutonOk = new JButton("OK");
		boutonOk.addActionListener(new BoutonListener());

		JPanel panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(_dim.width, _dim.height/3));
		panelCentre.add(panel1);
		panelCentre.add(panel2);
		panelCentre.add(boutonOk);
		panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.PAGE_AXIS)); // positionnement en colonne 

		this.panel.add(panelCentre, BorderLayout.CENTER);

	}

	class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int nombre;

			// On vérifie que le nombre soit conforme
			String strg = nombreFTextField.getText();
			if (strg.matches("^[0-9]+$")){
				nombre = Integer.parseInt(nombreFTextField.getText());
			}
			else
			{
				nombre = 3;
				nombreFTextField.setText("3");
			}

			int nombreDeChiffres = (Integer) nombreCombo.getSelectedItem();
			Somme newSomme = new Somme(nombreDeChiffres, nombre);

			JLabel titre = new JLabel("RESULTAT");
			titre.setFont(arial30);

			JPanel panel1 = new JPanel();
			panel1.add(titre);
			panel1.setBackground(Color.WHITE);

			String resultatString = "";

			for (String str : newSomme.getListSommes()) {
				resultatString += str + "\n";
			}
			JTextArea texte = new JTextArea(resultatString);
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.white);
			panel2.add(texte);

			JPanel panelSud = new JPanel();
			panelSud.setPreferredSize(new Dimension(size.width, size.height/3));
			panelSud.add(panel1);
			panelSud.add(panel2);
			panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.PAGE_AXIS));

			conteneur.removeAll();
			conteneur.add(panelSud);
			conteneur.setBackground(Color.WHITE);

			panel.add(conteneur, BorderLayout.SOUTH);
			panel.revalidate();

		}
	}


}
