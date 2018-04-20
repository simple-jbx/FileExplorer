package utils;

import java.security.MessageDigest;

public class MD5Utils {

	/***
	 * MD5鍔犲瘑 鐢熸垚32浣峬d5鐮�
	 * 
	 * @param 寰呭姞瀵嗗瓧绗︿覆
	 * @return 杩斿洖32浣峬d5鐮�
	 */
	public static String md5Encode(String str) throws Exception {
		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}

		byte[] byteArray = str.getBytes("UTF-8");
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	public static void main(String[] args) throws Exception {
		System.out.println(md5Encode("123456"));

	}

}
