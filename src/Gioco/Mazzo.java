package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
	private ArrayList<Pedina> carte;
	private ArrayList<Pedina> arrayFiori;
	public Mazzo(){
		carte= new ArrayList<Pedina>();
		arrayFiori = new ArrayList<Pedina>();
		//Riempiamo Con le Palle
		for (int j=0;j<4;j++){
			for (int i=1;i<10;i++){
				if (i==1 || i==9)
					carte.add(new Pedina(i,Costanti.PALLE,true,false));
				else	
					carte.add(new Pedina(i,Costanti.PALLE,false,false));
			}
		}
		//Riempiamo Con le CANNE
		for (int j=0;j<4;j++){
			for (int i=1;i<10;i++){
				if (i==1 || i==9)
					carte.add(new Pedina(i,Costanti.CANNE,true,false));
				else	
					carte.add(new Pedina(i,Costanti.CANNE,false,false));
			}
		}
		//Riempiamo con gli SCRITTI
		for (int j=0;j<4;j++){
			for (int i=1;i<10;i++){
				if (i==1 || i==9)
					carte.add(new Pedina(i,Costanti.SCRITTI,true,false));
				else	
					carte.add(new Pedina(i,Costanti.SCRITTI,false,false));
			}
		}
		//Mettiamo gli EST
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.EST,Costanti.VENTI,true,false));
		//Mettiamo i SUD
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.SUD,Costanti.VENTI,true,false));
		//Mettiamo i NORD
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.NORD,Costanti.VENTI,true,false));
		//Mettiamo i WEST
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.WEST,Costanti.VENTI,true,false));
		//Mettiamo i ROSSI
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.ROSSO,Costanti.DRAGHI,true,false));
		//Mettiamo i Bianchi
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.BIANCO,Costanti.DRAGHI,true,false));
		//Mettiamo i Verdi
		for (int i=0;i<4;i++)
			carte.add(new Pedina(Costanti.VERDE,Costanti.DRAGHI,true,false));
		//Mettiamo i Fiori
		carte.add(new Pedina(Costanti.EST,Costanti.FIORI,false,true));
		carte.add(new Pedina(Costanti.SUD,Costanti.FIORI,false,true));
		carte.add(new Pedina(Costanti.WEST,Costanti.FIORI,false,true));
		carte.add(new Pedina(Costanti.NORD,Costanti.FIORI,false,true));
		//Mettiamo le stagioni
		carte.add(new Pedina(Costanti.EST,Costanti.STAGIONI,false,true));
		carte.add(new Pedina(Costanti.SUD,Costanti.STAGIONI,false,true));
		carte.add(new Pedina(Costanti.WEST,Costanti.STAGIONI,false,true));
		carte.add(new Pedina(Costanti.NORD,Costanti.STAGIONI,false,true));
		Collections.shuffle(carte);
		for (int i = 0;i<20;i++){
			arrayFiori.add(carte.get(0));
			carte.remove(0);
		}
	}
	public Pedina getPedina(){
		if (carte.size()!=0){
			Pedina buffer=carte.get(0);
			carte.remove(0);
			return buffer;
		}
		else return null;
	}
	public Pedina getFiore(){
		if (arrayFiori.size()!=0){
			Pedina buffer=arrayFiori.get(0);
			arrayFiori.remove(0);
			return buffer;
		}
		else return null;
	}
	public int carteRimaste(){
		return carte.size();
	}
}