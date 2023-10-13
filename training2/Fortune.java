package training2;

import java.util.ResourceBundle;

public interface Fortune {
	//プロパティファイルの読み込み、値の取得（定数）
	String DISP_STR = ResourceBundle.getBundle("fortune").getString("disp_str");

	//運勢結果の表示
	String disp();
}
