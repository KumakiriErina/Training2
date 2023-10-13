package training2;

public abstract class Omikuji implements Fortune {
	protected String unsei;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;

	public abstract void setUnsei(String unsei);
	public abstract void setNegaigoto(String negaigoro);
	public abstract void setAkinai(String akinai);
	public abstract void setGakumon(String gakumon);
	
	public abstract String getUnsei();
	public abstract String getNegaigoto();
	public abstract String getAkinai();
	public abstract String getGakumon();

	public String disp() {
		String str = String.format(DISP_STR, this.unsei) + "\n" +"願い事:" +getNegaigoto() + "\n" + "商い:" + getAkinai() + "\n" + "学問:" + getGakumon();
		System.out.println(str);
		return str;
	}

}
