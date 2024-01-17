import java.io.Serializable;



public class Ogrenciler implements Serializable{
	private String isim,soyad,okul,bolum,telefon,dogum,kullaniciAdi,sifre;
	private static final long serialVersionUID=1l;
	
	Ogrenciler(String isim,String soyad,String okul,String bolum,String telefon,String dogum,String kullaniciAdi,String sifre) {
		setIsim(isim);
		setSoyad(soyad);
		setOkul(okul);
		setBolum(bolum);
		setTelefon(telefon);
		setDogum(dogum);
		setKullaniciAdi(kullaniciAdi);
		setSifre(sifre);
		

	}
	Ogrenciler(String isim,String soyad){
		setIsim(isim);
		setSoyad(soyad);
	}
	Ogrenciler(){
		
	}
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
	

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getOkul() {
		return okul;
	}

	public void setOkul(String okul) {
		this.okul = okul;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public String getDogum() {
		return dogum;
	}

	public void setDogum(String dogum) {
		this.dogum = dogum;
	}
	
	@Override
	public String toString() {
		return  isim+";"+soyad+";"+okul+";"+bolum+";"+telefon+";"+dogum+";"+kullaniciAdi+";"+sifre;
	}
	
	

}









