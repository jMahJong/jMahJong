package Gioco;

import java.util.Comparator;


public class Pedina implements Comparator<Pedina>{
	private int valore;
	private int seme;
	private boolean pallaDiTesta;
	private boolean fiore;
	
	public Pedina(int val, int seme, boolean diTesta, boolean fiore){
		this.valore=val;
		this.seme=seme;
		this.pallaDiTesta=diTesta;
		this.fiore=fiore;
	}
	public int getValore(){
		return this.valore;
	}
	public int getSeme(){
		return this.seme;
	}
	public boolean isPallaDiTesta(){
		return this.pallaDiTesta;
	}
	public boolean isFiore(){
		return this.fiore;
	}
	public String toString(){
		String a = "";
		switch (seme){
		case Costanti.CANNE:{ 	
			a+="CANNE";
			break;
		}
		case Costanti.PALLE:{ 	
			a+="PALLE";
			break;
		}
		case Costanti.SCRITTI:{	
			a+="SCRITTI";
			break;
		}
		case Costanti.DRAGHI:{	
			a+="DRAGO";
			break;
		}
		case Costanti.STAGIONI:{
			a+="STAGIONE";
			break;
		}
		case Costanti.VENTI:{	
			a+="VENTO";
			break;
		}
		case Costanti.FIORI:{	
			a+="FIORE";
			break;
		}
		default: a+="unknown";
		}
		a+=" ";
		if (seme==Costanti.DRAGHI){
			switch (valore){
			case Costanti.ROSSO:{
				a+="ROSSO";
				break;
			}
			case Costanti.BIANCO:{
				a+="BIANCO";
				break;
			}
			case Costanti.VERDE:{
				a+="VERDE";
				break;
			}
			}
		}
		if (seme==Costanti.VENTI){
			switch (valore){
			case Costanti.EST:{
				a+="EST";
				break;
			}
			case Costanti.WEST:{
				a+="WEST";
				break;
			}
			case Costanti.NORD:{
				a+="NORD";
				break;
			}
			case Costanti.SUD:
				a+="SUD";
				break;
			}
		}
		if (seme!=Costanti.DRAGHI && seme!=Costanti.VENTI)
			a+=valore;
		return a;
	}
	@Override
	public int compare(Pedina arg0, Pedina arg1) {
		if (((Pedina) arg0).getSeme()==((Pedina) arg1).getSeme()){
			if (((Pedina) arg0).getValore()==((Pedina) arg1).getValore()){
				return 0;
			}
			else
				if (((Pedina) arg0).getValore()<((Pedina) arg1).getValore())
					return -1;
				else 
					return 1;
		}
			else 
				if (((Pedina) arg0).getSeme()<((Pedina) arg1).getSeme())
					return -1;
				else return 1;
	}
	public boolean equals(Pedina arg0){
		if (this.getSeme()==arg0.getSeme())
			if (this.getValore()==arg0.getValore())
				return true;
			else return false;
		else return false;
	}
	public boolean isDrago(){
		if (seme==Costanti.DRAGHI) return true;
		else return false;
	}
	public boolean isVento(){
		if (seme==Costanti.VENTI) return true;
		else return false;
	}
}