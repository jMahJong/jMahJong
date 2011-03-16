package Gioco;
public class Main {
	public static void main(String[] args) {
		Partita p = new Partita (args);
		p.endTurno(0);
		System.out.println(p.toString());
		System.out.println();
		for (int i=0;i<4;i++)
			System.out.println(p.getGiocatoreAtIndex(i).calcolaPunteggio(0));
	}
}
