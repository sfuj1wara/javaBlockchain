package blockchain;

import java.security.MessageDigest;

// SHA256アルゴリズム
public class Sha256Algorithm {

	//String型のInput値を入力して、ハッシュ値を返す
	public static String sha256(String input){

		try { //メッセージ・ダイジェストは、任意サイズのデータを取得して固定長のハッシュ値を出力する安全な一方向のハッシュ機能です。
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(input.getBytes("UTF-8"));

			// 16進数としてハッシュ値を持つ
			StringBuffer hexStr = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexStr.append('0');
				hexStr.append(hex);
			}

			return hexStr.toString();
		}

		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
