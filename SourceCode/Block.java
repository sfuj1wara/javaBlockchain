package blockchain;

import java.util.Date;

// ブロックを生成するクラス
public class Block {

		// データ格納
		// Bitcoinなら取引データ
		private String data;

		// ハッシュを格納
		public String hash;

		// 1つ前のブロックのハッシュ
		public String previousHash;

		//ブロックができた時間のタイムスタンプ
		private long timeStamp;

		// マイニングの難易度
		// 格納されている値はハッシュ先頭の0の数
		public static int difficulty = 5;

		// 正解のハッシュを求めるための変数
		// カウントアップして条件に当てはまるハッシュを見つける
		private int answer;


		// コンストラクタ
		  public Block(String data, String previousHash ) {
		    this.data = data;

		    this.previousHash = previousHash;

		    this.timeStamp = new Date().getTime();

		    this.hash = Hash();

		    mineBlock(difficulty);
		  }

		  // ハッシュを生成する関数
		  public String Hash() {
			  //answer をhashに含みます。
			  //マイナーさんは正しいanswerを計算する必要があります。
			  String hash = Sha256Algorithm.sha256( previousHash + data + Long.toString(timeStamp) + Integer.toString(answer));

			  return hash;
		  }

		  // マイニングをする関数
		  public void mineBlock(int difficulty) {
		        String targetedHash = new String(new char[difficulty]).replace('\0', '0');

		        // difficultyの条件にあてはまるまでハッシュを生成
		        while(!hash.substring( 0, difficulty).equals(targetedHash)) {
		            answer ++;
		            hash = Hash();
		        }

		        System.out.println("ブロックHash : " + hash);
		  }

}
