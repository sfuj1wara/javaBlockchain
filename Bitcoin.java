package blockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class Bitcoin {
	// ブロック型の配列作成
	public static ArrayList<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) {

		// ジェネシスブロック
		// 最初のブロックなので、ハッシュは0
		blockchain.add(new Block("取引データ1", "0"));

		// 2番目のブロック
		blockchain.add(new Block("取引データ2",blockchain.get(blockchain.size()-1).hash));
		System.out.println(isValidBlockchain());

		// 3番目のブロック
		blockchain.add(new Block("取引データ3",blockchain.get(blockchain.size()-1).hash));
		System.out.println(isValidBlockchain());

		//JSON形式に出力
		String blockchainToJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainToJson);

	}

	// ブロックチェーンが有効かどうかを判定する関数
	public static Boolean isValidBlockchain() {
		// 今現在のブロック
		Block currentBlock = null;

		// 1つ前のブロック
		Block previousBlock;

		String targetHash = new String(new char[Block.difficulty]).replace('\0', '0');

		for(int i=1; i < blockchain.size(); i++) {
			//今現在のブロック
			currentBlock = blockchain.get(i);

			//１つ前のブロック
			previousBlock = blockchain.get(i-1);

		    //今現在のブロックのHashが計算結果と合わない場合は無効と返す
		    if(!currentBlock.hash.equals(currentBlock.Hash()) ){
		        return false;
		    }

		    //１つ前のブロックのHashが計算結果と合わない場合は無効と返す
		    if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
		    	return false;
		    }
		}

        //マイニングされたかどうかをチェック
		if(!currentBlock.hash.substring( 0, Block.difficulty).equals(targetHash)) {
			return false;
		}

		System.out.println("正常にマイニングされました");
		return true;
	}

}
