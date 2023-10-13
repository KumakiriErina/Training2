package training2;

public class GoodBlessing extends Omikuji {
	//吉
	@Override
	public void setUnsei(String unsei) {
		this.unsei = unsei;
	}
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}
	public String getUnsei() {
		return this.unsei;
	}
	public String getNegaigoto() {
		return this.negaigoto;
	}
	public String getAkinai() {
		return this.akinai;
	}
	public String getGakumon() {
		return this.gakumon;
	}
}
