package application;

public class Sarkilar {
	
  String sarkiAdi;
  String sanatciAdi;
  float sure;
  String turu;

    public Sarkilar(String sarkiAdi, String sanatciAdi, float sure, String turu) {
	  super();
	  
	  this.sarkiAdi= sarkiAdi;
	  this.sanatciAdi= sanatciAdi;
	  this.sure= sure;
	  this.turu= turu;
     }

	public String getSarkiAdi() {
		return sarkiAdi;
	}

	public void setSarkiAdi(String sarkiAdi) {
		this.sarkiAdi =sarkiAdi;
	}
	


	public String getSanatciAdi() {
		return sanatciAdi;
	}

	public void setSanatciAdi(String sanatciAdi) {
		this.sanatciAdi = sanatciAdi;
	}


	
	public float getSure() {
		return sure;
	}

	public void sure(float sure) {
		this.sure = sure;
	}


	public String getTuru() {
		return turu;
	}

	public void setTuru(String turu) {
		this.turu = turu;
	}
     

}
