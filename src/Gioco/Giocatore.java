package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Giocatore {
	private String nome;
	private ArrayList<Pedina> mano;
	private ArrayList<Pedina> scoperte;
	private int punteggio;
	private int vento;
	
	public Giocatore(String nome){
		this.nome=nome;
		this.punteggio=2000;
		mano = new ArrayList<Pedina>();
		scoperte = new ArrayList<Pedina>();
	}
	public ArrayList<Pedina> getMano(){
		ArrayList<Pedina> arrayToReturn = new ArrayList<Pedina>();
		for (int i=0;i<mano.size();i++)
			arrayToReturn.set(i, new Pedina(mano.get(i).getValore(),mano.get(i).getSeme(),mano.get(i).isPallaDiTesta(),mano.get(i).isFiore()));
		return arrayToReturn;
	}
	public ArrayList<Pedina> getScoperte(){
		ArrayList<Pedina> arrayToReturn = new ArrayList<Pedina>();
		for (int i=0;i<scoperte.size();i++)
			arrayToReturn.set(i, new Pedina(scoperte.get(i).getValore(),scoperte.get(i).getSeme(),scoperte.get(i).isPallaDiTesta(),scoperte.get(i).isFiore()));
		return arrayToReturn;
	}
	public void setVento(int vento) {
		this.vento = vento;
	}
	public int getVento() {
		return vento;
	}
	public Pedina pesca(Pedina pescata){
		if (pescata!=null){
			mano.add(pescata);
			Collections.sort(mano, pescata);
			Collections.sort(scoperte, pescata);
			return pescata;
		}
		else
			return null;
	}
	public Pedina scarta(Pedina a){
		mano.remove(a);
		return a;
	}
	public void scopri(Pedina a){
		scoperte.add(a);
		mano.remove(a);
		Collections.sort(mano, a);
	}
	public int incPunteggio (int a){
		punteggio+=a;
		return punteggio;
	}
	public int decPunteggio (int a){
		punteggio-=a;
		return punteggio;
	}
	public int getPunteggio (){
		return punteggio;
	}
	public String toString (){
		String a="";
		a+=nome+" ";
		a+=vento;
		a+=" "+punteggio+"\n";
		a+="Mano ";
		a+=mano.size()+"\n";
		for (Pedina q:mano) a+=q.toString()+"\n";
		a+="Scoperte ";
		a+=scoperte.size()+"\n";
		for (Pedina q:scoperte) a+=q.toString()+"\n";
		return a;
	}
	public void newMano(){
		mano = new ArrayList<Pedina>();
		scoperte = new ArrayList<Pedina>();
	}
	public int calcolaPunteggio(int indexMahjong){
		int raddoppi=0;
		int punti=0;
		int nCoppie=0;
		int nTris=0;
		int nPoker=0;
		if (indexMahjong+1==this.vento) punti=20;
		//conto i punti calati
		for (int i=0;i<scoperte.size();i++){
			Pedina a=scoperte.get(i);
			if (a.isFiore()){
				if (a.getValore()==this.vento)
					raddoppi++;
				punti+=4;
			}
			else{
				boolean coppia=false;
				boolean tris=false;
				boolean poker=false;
				if (i+1<scoperte.size() && scoperte.get(i).equals(scoperte.get(i+1))){ // è una coppia?
					if (i+2<scoperte.size() && scoperte.get(i).equals(scoperte.get(i+2))){ //è un tris?
						if (i+3<scoperte.size() && scoperte.get(i).equals(scoperte.get(i+3))){ //è un poker?
							poker=true;
						}
						else tris=true;
					}
					else coppia=true;
				}
				//dopo aver determinato se si tratta di un poker un tris o una coppia
				if (coppia){
					if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
						punti+=2;
					i+=1;
					nCoppie++;
				}
				if (tris){
					if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
						raddoppi++;
					if (mano.get(i).isPallaDiTesta()) punti+=4;
					else punti+=2;
					i+=2;
					nTris++;
				}
				if (poker){
					if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
						raddoppi++;
					if (mano.get(i).isPallaDiTesta()) punti+=16;
					else punti+=8;
					i+=3;
					nPoker++;
				}
			}
		}
		//Conto i punti coperti
		for (int i=0;i<mano.size();i++){
			boolean coppia=false;
			boolean tris=false;
			boolean poker=false;
			if (i+1<mano.size() && mano.get(i).equals(mano.get(i+1))){ //è una coppia?
				if (i+2<mano.size() && mano.get(i).equals(mano.get(i+2))){ //è un tris?
					if (i+3<mano.size() && mano.get(i).equals(mano.get(i+3))){ //è un poker?
						poker=true;
					}
					else tris=true;
				}
				else coppia=true;
			}
			//dopo aver determinato se si tratta di un poker un tris o una coppia
			if (coppia){
				if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
					punti+=2;
				i+=1;
				nCoppie++;
			}
			if (tris){
				if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
					raddoppi++;
				if (mano.get(i).isPallaDiTesta()) punti+=8;
				else punti+=4;
				i+=2;
				nTris++;
			}
			if (poker){
				if (mano.get(i).isDrago() || (mano.get(i).isVento() && mano.get(i).getValore()==this.vento))
					raddoppi++;
				if (mano.get(i).isPallaDiTesta()) punti+=32;
				else punti+=16;
				i+=3;
				nPoker++;
			}
		}
		//Faccio i raddoppi (non quello dell'est)
		if (nPoker+nTris==4)
			raddoppi++;
		for (int i=0;i<raddoppi;i++){
			punti=punti*2;
		}
		if (nCoppie==7 || punti>300)
			return Costanti.MASSIMO;
		else return punti;
	}
}