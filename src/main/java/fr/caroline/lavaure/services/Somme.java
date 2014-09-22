package fr.caroline.lavaure.services;

import java.util.ArrayList;
import java.util.List;

public class Somme {
	private int nombreDeChiffres, nombre;
	private List<String> listSommes;
	private String uneSomme;

	public Somme(int _nombreDeChiffres, int _nombre) {
		super();
		this.nombreDeChiffres = _nombreDeChiffres;
		this.nombre = _nombre;
		this.listSommes = new ArrayList<String>();
	}

	// Recherche de toutes les sommes pour le nombre saisi et le nombre de chiffres sélectionné
	public List<String> getListSommes()  {

		int i = 0;
		int somme = 0;
		int iFinMax = calculFinBoucle(this.nombreDeChiffres, 1);
		int jFinMax = calculFinBoucle(this.nombreDeChiffres, 2);

		// premier chiffre de la somme
		for (i = 1; i <= iFinMax ; i++) {

			int cpt = 1;
			somme += i ;
			this.uneSomme = i  + "" ;
			int k = i+1;

			// deuxieme chiffre de la somme
			for (int j = k; j<=jFinMax; j++){

				cpt = 2;
				somme = i + j ;

				if (cpt == this.nombreDeChiffres) {
					if (somme == nombre) {
						this.uneSomme = i + "+" + j ;
						addListSommes(uneSomme);
						somme = 0;
						this.uneSomme = "" ;
					}

				} // somme avec plus de 2 chiffres
				else if (cpt < this.nombreDeChiffres) {
					int index = j + 1;
					this.uneSomme = i + "+" + j;
					boucleFor(index, somme, cpt);
				}
			}
		}

		return this.listSommes;
	}

	private void addListSommes(String _uneSomme) {
		this.listSommes.add(_uneSomme);
	}

	// Boucle récursive appelée pour les sommes de plus de 2 chiffres
	private void boucleFor(int _index, int _somme, int _cpt) {
		int somme = 0;
		
		String strSav = uneSomme, str1;
		int cpt = _cpt + 1;

		int zFinMax = calculFinBoucle(nombreDeChiffres, cpt);

		for (int z = _index; z<=zFinMax; z++){
			somme = _somme + z;
			if (cpt == nombreDeChiffres) {
				if (somme == nombre) {
					str1 = uneSomme +  "+" + z   ;
					addListSommes(str1);
					somme = 0;
					str1 = "" ;
				}
			} else if (cpt < nombreDeChiffres) {
				int index = z + 1;
				uneSomme = uneSomme + "+" + z;
				boucleFor(index, somme, cpt);
				uneSomme = strSav;
			}
		}
	}
	
	private int calculFinBoucle(int _chiffre, int _cpt) {
	return (9 - (_chiffre - _cpt));
}

	@Override
	public String toString() {
		return "Somme [nombreDeChiffres=" + nombreDeChiffres + ", nombre="
				+ nombre + "]";
	}

}
