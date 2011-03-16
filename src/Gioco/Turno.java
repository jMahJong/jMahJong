package Gioco;

public class Turno {
	private Mazzo m;
	private int giocatoreCorrente;
	private  Giocatore[] arrayGiocatori;
	public Turno (int estIndex, Giocatore[] arrayGiocatori){//estIndex parte da 0
		int i;
		giocatoreCorrente=estIndex;
		this.arrayGiocatori=arrayGiocatori;
		for (i=0;i<4;i++){
			int k=i+estIndex;
			if (k>3) k-=4;
			this.arrayGiocatori[k].setVento(i+1);
		}
		m = new Mazzo();
		for (i=0;i<4;i++)
			this.arrayGiocatori[i].newMano();
		for (giocatoreCorrente=0;giocatoreCorrente<4;giocatoreCorrente++)
			for(int j=0;j<13;j++)
				pescata(m.getPedina());
		this.arrayGiocatori[estIndex].pesca(m.getPedina());
		giocatoreCorrente=estIndex;
	}
	public String toString(){
		String a="";
		for (int i=0;i<4;i++)
			a+=arrayGiocatori[i].toString();
		return a;
	}
	public Pedina passa(Pedina scartata){
		giocatoreCorrente++;
		if (giocatoreCorrente>3)
			giocatoreCorrente-=3;
		return scartata;
	}
	public void chiama (Pedina chiamata, int indexGiocatoreChiamante){
		giocatoreCorrente=indexGiocatoreChiamante;
		arrayGiocatori[giocatoreCorrente].pesca(chiamata);
		if (chiamata.isFiore()){
			arrayGiocatori[giocatoreCorrente].scopri(chiamata);
			pescata(m.getFiore());
		}
	}
	public void pescata(Pedina pesco){
		arrayGiocatori[giocatoreCorrente].pesca(pesco);
		if (pesco.isFiore()){
			arrayGiocatori[giocatoreCorrente].scopri(pesco);
			pescata(m.getFiore());
		}
	}
	public void end(int indexMahjong){
		for (int i=0;i<4;i++){
			System.out.println(arrayGiocatori[i].calcolaPunteggio(indexMahjong));
		}
	}
	public void paga(int indexMahjong){
		//si paga il mahjong
		 
		int guadagnoMahJong=0;
		if (arrayGiocatori[indexMahjong].getVento()==Costanti.EST)
			guadagnoMahJong=arrayGiocatori[indexMahjong].calcolaPunteggio(indexMahjong)*2;
		arrayGiocatori[indexMahjong].incPunteggio(guadagnoMahJong*3);
		for (int i=0;i<4;i++){
			if (i!=indexMahjong)
				arrayGiocatori[i].decPunteggio(guadagnoMahJong);
		}
		Giocatore[] nonPagato = new Giocatore[3];
		int iNonPagato=0;
		for (int i=0;i<4;i++)
			if (arrayGiocatori[i].getVento()!=indexMahjong+1)
				nonPagato[iNonPagato++]=arrayGiocatori[i];
		//Bene bene in nonPagato[] ho coloro che non hanno pagato!!!
		int n;
		for (int i=1;i<3;i++){
			n=nonPagato[0].calcolaPunteggio(indexMahjong)-nonPagato[i].calcolaPunteggio(indexMahjong);
			if (nonPagato[0].getVento()==Costanti.EST || nonPagato[i].getVento()==Costanti.EST){
				nonPagato[0].incPunteggio(n*2);
				nonPagato[i].decPunteggio(n*2);
			}
			else {
				nonPagato[0].incPunteggio(n);
				nonPagato[i].decPunteggio(n);
			}
		}
		n=nonPagato[1].calcolaPunteggio(indexMahjong)-nonPagato[2].calcolaPunteggio(indexMahjong);
		if (nonPagato[1].getVento()==Costanti.EST || nonPagato[2].getVento()==Costanti.EST){
			nonPagato[1].incPunteggio(n*2);
			nonPagato[2].decPunteggio(n*2);
		}
		else {
			nonPagato[1].incPunteggio(n);
			nonPagato[2].decPunteggio(n);
		}
	}
}
