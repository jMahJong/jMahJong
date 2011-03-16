package Gioco;

public class Partita {
	Giocatore[] arrayGiocatori;
	private Turno t;
	private int nGiri;
	public Partita(String[]nomi){
		nGiri=0;
		arrayGiocatori = new Giocatore[4];
		for (int i=0;i<4;i++)
			arrayGiocatori[i]=new Giocatore(nomi[i]);
		t=new Turno(nGiri,arrayGiocatori);
	}
	public Turno getTurno(){
		return t;
	}
	public int getNGiri(){
		return nGiri;
	}
	public String toString(){
		return t.toString();
	}
	public void newTurno(){
		nGiri++;
		t=new Turno(nGiri,arrayGiocatori);
	}
	public void endTurno(int indexMahjong){
		t.paga(indexMahjong);
	}
	public Giocatore getGiocatoreAtIndex(int index){
		if (index<4)
			return arrayGiocatori[index];
		else return null;
	}
}