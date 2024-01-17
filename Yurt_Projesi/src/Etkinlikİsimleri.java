

import java.io.Serializable;

public class Etkinlikİsimleri implements Serializable{
	private String eIsim,eGun,eSaat,eAdres,eFirma,eIletisim,eNot;
	
	
	public Etkinlikİsimleri(String eIsim,String eGun,String eSaat,String eAdres,String eFirma,String eIletisim,String eNot) {
		seteIsim(eIsim);
		seteGun(eGun);
		seteSaat(eSaat);
		seteAdres(eAdres);
		seteFirma(eFirma);
		seteIletisim(eIletisim);
		seteNot(eNot);
	}


	public String geteIsim() {
		return eIsim;
	}


	public void seteIsim(String eIsim) {
		this.eIsim = eIsim;
	}


	public String geteGun() {
		return eGun;
	}


	public void seteGun(String eGun) {
		this.eGun = eGun;
	}


	public String geteSaat() {
		return eSaat;
	}


	public void seteSaat(String eSaat) {
		this.eSaat = eSaat;
	}


	public String geteAdres() {
		return eAdres;
	}


	public void seteAdres(String eAdres) {
		this.eAdres = eAdres;
	}


	public String geteFirma() {
		return eFirma;
	}


	public void seteFirma(String eFirma) {
		this.eFirma = eFirma;
	}


	public String geteIletisim() {
		return eIletisim;
	}


	public void seteIletisim(String eIletisim) {
		this.eIletisim = eIletisim;
	}


	public String geteNot() {
		return eNot;
	}


	public void seteNot(String eNot) {
		this.eNot = eNot;
	}
	
	public String toString() {
		return eIsim+"/"+eGun+"/"+eSaat+"/"+eAdres+"/"+eFirma+"/"+eIletisim+"/"+eNot;
	}
}
