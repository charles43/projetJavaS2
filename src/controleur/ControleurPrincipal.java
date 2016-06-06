package controleur;
import modele.Joueur;
import modele.Grille;
import modele.Jeu;
import vue.Vue;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class ControleurPrincipal {
	
	public static boolean jouer(Joueur leJoueur,Grille g,Joueur adversaire)
	{
		char couleurDemandee;
		ArrayList<Character> colors=new ArrayList<>();
		colors.add('R');
		colors.add('O');
		colors.add('J');
		colors.add('V');
		colors.add('B');
		colors.add('I');
		boolean couleurLibre=true, charValable=true;
		Vue.afficherGrille(g);
		do
		{
			if(!charValable)
				System.out.println("Attention ! Il faut entrer l'initiale de la couleur demandée en majuscule.");
			if(!couleurLibre)
				System.out.println("Attention ! La couleur doit être libre et différente de ta couleur actuelle et de celle de ton adversaire.");
			Scanner sca = new Scanner(System.in);
			System.out.println(leJoueur.getNom()+" à toi de jouer. Ta couleur actuelle est "+leJoueur.getPossessions().get(0).getEtat());
			System.out.println("Tu contrôles actuellement "+leJoueur.nbControlees()+" cases. "+adversaire.getNom()+" en possède "+adversaire.nbControlees()+".");
			System.out.println("Donne l'initiale en majuscule de la couleur que tu veux demander.");
			String strCouleur=sca.nextLine();
			if(strCouleur.length()==1)
			{
				couleurDemandee=strCouleur.charAt(0);
				charValable=colors.contains(couleurDemandee);
				couleurLibre = (couleurDemandee!=leJoueur.getCouleur() && couleurDemandee!=adversaire.getCouleur());
			}
			else
			{
				charValable=false;
				couleurDemandee='a';
			}
		}while(!couleurLibre || !charValable);
		leJoueur.posseder(couleurDemandee, g);
		boolean fin = leJoueur.nbControlees()>Grille.nbCases()/2 || adversaire.nbControlees()>Grille.nbCases()/2 || g.toutesControlees();
		return fin;
	}
	
	public static boolean jouerIArnd(Joueur leJoueur,Grille g,Joueur adversaire)
	{
		char couleurDemandee;
		ArrayList<Character> colors=new ArrayList<>();
		colors.add('R');
		colors.add('O');
		colors.add('J');
		colors.add('V');
		colors.add('B');
		colors.add('I');
		boolean couleurLibre=true;
		Vue.afficherGrille(g);
		int alea;
		do
		{
			Random rand = new Random();
		    alea = rand.nextInt(6);
		    couleurDemandee = (char) colors.get(alea);
			couleurLibre = (couleurDemandee!=leJoueur.getCouleur() && couleurDemandee!=adversaire.getCouleur());
		}while(!couleurLibre);
		leJoueur.posseder(couleurDemandee, g);
		System.out.println(leJoueur.getNom()+" a demandé la couleur "+couleurDemandee+".");
		boolean fin = leJoueur.nbControlees()>Grille.nbCases()/2 || adversaire.nbControlees()>Grille.nbCases()/2 || g.toutesControlees();
		return fin;
	}
	
	public static boolean jouerIA2(Joueur leJoueur,Grille g,Joueur adversaire)
	{
		char couleurDemandee;
		ArrayList<Character> colors=new ArrayList<>();
		colors.add('R');
		colors.add('O');
		colors.add('J');
		colors.add('V');
		colors.add('B');
		colors.add('I');
		boolean couleurLibre;
		Vue.afficherGrille(g);
		int i,max=0,iMax=0,nb;
		i=0;
		for(Object col : colors)
		{
			char couleur = (char) col;
			couleurLibre = (couleur!=leJoueur.getCouleur() && couleur!=adversaire.getCouleur());
			if(couleurLibre)
			{
				nb=leJoueur.nbGagnees(couleur,g);
				if(nb>max)
				{
					max=nb;
					iMax=i;
				}
			}
			i++;
		}
	    couleurDemandee = (char) colors.get(iMax);
		leJoueur.posseder(couleurDemandee, g);
		System.out.println(leJoueur.getNom()+" a demandé la couleur "+couleurDemandee+".");
		boolean fin = leJoueur.nbControlees()>Grille.nbCases()/2 || adversaire.nbControlees()>Grille.nbCases()/2 || g.toutesControlees();
		return fin;
	}
	
	public static boolean jouerIA3(Joueur leJoueur,Grille g,Joueur adversaire)
	{
		char couleurDemandee;
		ArrayList<Character> colors=new ArrayList<>();
		colors.add('R');
		colors.add('O');
		colors.add('J');
		colors.add('V');
		colors.add('B');
		colors.add('I');

		boolean couleurLibre;
		Vue.afficherGrille(g);
		int i,max=0,iMax=0,nb;
		i=0;
		for(Object col : colors)
		{
			char couleur = (char) col;
			couleurLibre = (couleur!=leJoueur.getCouleur() && couleur!=adversaire.getCouleur());
			if(couleurLibre)
			{
				nb=adversaire.nbGagnees(couleur,g);
				if(nb>max)
				{
					max=nb;
					iMax=i;
				}
			}
			i++;
		}
	    couleurDemandee = (char) colors.get(iMax);
		leJoueur.posseder(couleurDemandee, g);
		System.out.println(leJoueur.getNom()+" a demandé la couleur "+couleurDemandee+".");
		boolean fin = leJoueur.nbControlees()>Grille.nbCases()/2 || adversaire.nbControlees()>Grille.nbCases()/2 || g.toutesControlees();
		return fin;
	}
	
	public static void fin(Joueur j1, Joueur j2)
	{
		if(j1.nbControlees()>j2.nbControlees())
		{
			System.out.println("\nVictoire de "+j1.getNom());
		}
		else
		{
			System.out.println("\nVictoire de "+j2.getNom());
		}
	}
	
	
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("À combien de joueurs voulez-vous jouer (1 ou 2) ?");
		int nbJoueurs=sc.nextInt();
		Jeu j;
		
		System.out.println("Nom du joueur 1 :");
		String nomJ1=sc.next();
		
		System.out.println("Nom du joueur 2 :");
		String nomJ2=sc.next();
		
		j= new Jeu(nomJ1,nomJ2,nbJoueurs==1);
		
		boolean fin=false;
		int joueurPrecedent = 2;
		while(fin==false)
		{
			if(joueurPrecedent==1)
			{
				if(j.ia())
					fin=jouerIA2(j.getJ2(),j.getGrille(),j.getJ1());
				else
					fin=jouer(j.getJ2(),j.getGrille(),j.getJ1());
				joueurPrecedent = 2;
			}
			else
			{
				fin=jouer(j.getJ1(),j.getGrille(),j.getJ2());
				joueurPrecedent=1;
			}
		}
		fin(j.getJ1(),j.getJ2());
		sc.close();
	}
}
