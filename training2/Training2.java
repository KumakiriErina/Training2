package training2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 * 実行クラス
 * @author e_kumakiri
 */
public class Training2 {
	public static void main(String[] args) {
		//事前準備
		//パスの取得
		Path path = Paths.get("/Users/e_kumakiri/Desktop/workspace/Training2/src/Fortune.csv");

		// FileWriterクラスを宣言
		FileWriter fw = null;

		try {
			//csvファイルの読み込み
			List<String> line = Files.readAllLines(path);
			//箱の宣言(List)
			List<Omikuji> list = new ArrayList<Omikuji>();

			//50回分する
			for (int i = 0; i < line.size(); i++) {
				//dataの,を取り除く
				String[] data = line.get(i).split(",");
				//おみくじオブジェクトの宣言
				Omikuji omikuji = null;

				//switch文(具象クラスの生成)
				switch (data[0]) {
				case "大吉":
					//それぞれのオブジェクトを生成
					omikuji = new GreatBlessing();
					break;

				case "中吉":
					omikuji = new MiddleBlassing();
					break;

				case "小吉":
					omikuji = new SmallBlessing();
					break;

				case "末吉":
					omikuji = new UncertinLuck();
					break;

				case "吉":
					omikuji = new GoodBlessing();
					break;

				case "凶":
					omikuji = new BadLuck();
					break;

				default:
					System.out.println("飛ばします");
					break;
				}
				//値をset
				omikuji.setUnsei();
				omikuji.setNegaigoto(data[1]);
				omikuji.setAkinai(data[2]);
				omikuji.setGakumon(data[3]);

				//おみくじオブジェクトをListに格納する
				list.add(omikuji);
			}
			//事前準備終了(おみくじの箱、おみくじの中身の用意が完了)

			//System.inからInputStreamReaderクラスのオブジェクト作成
			//BufferedReaderクラスのオブジェクト作成
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			//誕生日の入力
			System.out.println("誕生日を入力してください(例：20150809)");

			//日付入力のフォーマット（yyyyMMdd）
			DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			//入力された値が正しいかチェック
			simpleDateFormat.setLenient(false);
			//readLine()メソッドを使って1行データを読み込む
			String str = reader.readLine();
			//入力したデータをDate型に変換
			Date inputDate = simpleDateFormat.parse(str);
			//Date型（現在）の生成
			Date date = new Date();
			//Date型をString型に変換
			String now = new SimpleDateFormat("yyyyMMdd").format(date);

			//ランダムオブジェクトを生成する（本日と入力した値のString型をInteger型に変換）
			Random rand = new Random(Integer.parseInt(now) + Integer.parseInt(str));

			// FileWriterクラスのオブジェクトを生成する
			fw = new FileWriter("/Users/e_kumakiri/Desktop/workspace/Training2/src/data.txt", true);

			//ランダムにしたおみくじオブジェクトをリストから取得する
			Fortune fortune = list.get(rand.nextInt(list.size()));
			//コンソールに出力する
			System.out.println(fortune.disp());
			//ファイルに追記する
			fw.write(fortune.disp());

		} catch (IOException e) {
			//エラーになった時
			//CSVファイルの読み込みか、data.txtへの書き込みの失敗
			System.out.println("CSVファイルの読み込みに失敗しました。");
			e.printStackTrace();

		} catch (ParseException p) {
			//存在しない日付を入力した場合
			System.out.println("日付が存在しません");
			p.printStackTrace();

		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					//何もしない
					;
				}
			}
		}
	}
}
