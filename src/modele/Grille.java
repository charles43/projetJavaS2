package modele;

import java.util.Random;

public class Grille {
	private Case tab[][];
	private int nbPossedes;
	public static final int cote=13;  
	
	public static int nbCases()
	{
		return cote*cote;
	}
	
	public Grille()
	{
		tab = new Case[cote][cote];
		char colors[]={'r','o','j','v','b','i'};
		int nbUtilColors[]={0,0,0,0,0,0};
		int alea,i,j;
		for(i=0;i<cote;i++)
		{
			for(j=0;j<cote;j++)
			{	
				do
				{
					Random rand = new Random();
				    alea = rand.nextInt(6);
				}while(nbUtilColors[alea]>cote*cote/6);
				nbUtilColors[alea]++;
				tab[i][j]=new Case(colors[alea],i,j);
			}
		}
		//on vérifie que la case en haut à gauche et la case en bas à droite sont bien de couleur différente
		if(tab[0][0].getEtat()==tab[cote-1][cote-1].getEtat())
		{
			do
			{
				Random rand = new Random();
			    alea = rand.nextInt(6);
			}while(colors[alea]==tab[0][0].getEtat());
			tab[cote-1][cote-1].setEtat(colors[alea]);
		}
		nbPossedes=2;
	}
	
	public Case [][] getTab()
	{
		return tab;
	}
	
	public void ajouterPossession()
	{
		nbPossedes++;
	}
	
	public boolean toutesControlees()
	{
		return (nbPossedes == (nbCases()));
	}
}
