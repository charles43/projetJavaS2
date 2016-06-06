package modele;

public class Jeu {
	private Grille laGrille;
	private Joueur j1;
	private Joueur j2;
	private boolean ia;
	public Jeu(String nomJ1,String nomJ2, boolean ia)
	{
		//génération de la grille
		laGrille = new Grille();
		//définition des joueurs
		j1 = new Joueur(nomJ1,laGrille.getTab()[0][0]);
		j2 = new Joueur(nomJ2,laGrille.getTab()[Grille.cote-1][Grille.cote-1]);
		this.ia=ia;
	}
	public Joueur getJ1()
	{
		return j1;
	}
	public Joueur getJ2()
	{
		return j2;
	}
	public Grille getGrille()
	{
		return laGrille;
	}
	
	public boolean ia()
	{
		return ia;
	}
}
