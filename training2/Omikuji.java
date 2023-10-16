package training2;
/**
 * おみくじ抽象クラス
 * @author e_kumakiri
 */
public abstract class Omikuji implements Fortune {
	/** 運勢を表す */
	protected String unsei;
	/** 願い事を表す */
	protected String negaigoto;
	/** 商いを表す */
	protected String akinai;
	/** 学問を表す */
	protected String gakumon;

	/** 各運勢クラスで運勢をsetする */
	public abstract void setUnsei();
	/**
	 * @param negaigoto  願い事をsetする
	 */
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	/**
	 * @param akinai 商いをsetする
	 */
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	/**
	 * @param gakumon 学問をsetする
	 */
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}
	/**
	 * @return 運勢
	 */
	public String getUnsei() {
		return this.unsei;
	}
	/**
	 * @return 願い事
	 */
	public String getNegaigoto() {
		return this.negaigoto;
	}
	/**
	 * @return 商い
	 */
	public String getAkinai() {
		return this.akinai;
	}
	/**
	 * @return 学問
	 */
	public String getGakumon() {
		return this.gakumon;
	}

	/**
	 * @return 運勢の表示
	 */
	public String disp() {
		String str = String.format(DISP_STR, this.unsei) + "\n" +"願い事:" +getNegaigoto() + "\n" + "商い:" + getAkinai() + "\n" + "学問:" + getGakumon();
		return str;
	}
}
