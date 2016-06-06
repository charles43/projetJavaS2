package modele;

import java.util.ArrayList;

public class Joueur {
	
	private String nom;
	private ArrayList<Case> possessions;
	private char couleur;
	public Joueur(String nom, Case premiereCase)
	{
		this.nom=nom;
		possessions=new ArrayList<>();
		possessions.add(premiereCase);
		premiereCase.setEtat(Character.toUpperCase(premiereCase.getEtat()));
		couleur=premiereCase.getEtat();
	}
	
	
	public String getNom()
	{
		return nom;
	}
	
	public char getCouleur()
	{
		return couleur;
	}
	
	public void posseder(char nouvelleCouleur, Grille g)
	{
		couleur=nouvelleCouleur;
		ArrayList<Case> copiePosses=(ArrayList<Case>) possessions.clone();
		for(Case c : copiePosses)
		{
			c.setEtat(couleur);
			c.casesTouchees(g,Character.toLowerCase(couleur),this);
		}
	}
	
	public int nbGagnees(char nouvelleCouleur, Grille g)
	{
		int nbGagnees=0;
		for(Case c : possessions)
		{
			nbGagnees+=c.nbCasesTouchees(g,nouvelleCouleur,this);
		}
		return nbGagnees;
	}
	

	
	public void ajouterPossession(Case possession, Grille g)
	{
		possession.setEtat(couleur);
		g.ajouterPossession();
		possessions.add(possession);
	}
	
	public ArrayList<Case> getPossessions()
	{
		return possessions;
	}
	
	public int nbControlees()
	{
		return possessions.size();
	}
}
