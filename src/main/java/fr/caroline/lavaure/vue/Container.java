package fr.caroline.lavaure.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import fr.caroline.lavaure.services.Somme;

public abstract class Container {

	protected JPanel panel = new JPanel();

	protected Font arial20 = new Font("Arial", 14, 20);
	protected Font arial30 = new Font("Arial", 14, 30);
	protected Font arial40 = new Font("Arial", 14, 40);

	public Container(Dimension dim){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
	}

	public Container(Dimension dim, Somme somme){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
	}

	protected JPanel getPanel(){
		return this.panel;
	}

	protected abstract void initPanel(Dimension dim);	

}
