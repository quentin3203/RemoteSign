package sign;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DesEncrypt extends Encrypt {
	public static final String TYPE_3DES_ECB = "3des_ecb";
	public static final String TYPE_3DES_CBC = "3des_cbc";
	public static final String TYPE_DES_ECB = "des_ecb";
	public static final String TYPE_DES_CBC = "des_cbc";

	private byte[] key = null;
	private byte[] vi = null;
	private String type = null;

	public DesEncrypt(String type, String key, String vi) {
		super();
		this.key = key.getBytes();
		this.vi = vi.getBytes();
		this.type = type;
	}

	@Override
	public String encrypt(String str) throws Exception {
		String result = "";
		byte[] plainText = str.getBytes();
		SecretKey secretKey;
		Cipher cipher = null;
		IvParameterSpec iv;
		switch (type) {
		case TYPE_3DES_ECB:
			secretKey = new SecretKeySpec(key, "DESede");
			cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			break;
		case TYPE_3DES_CBC:
			iv = new IvParameterSpec(vi);
			secretKey = new SecretKeySpec(key, "DESede");
			cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			break;
		case TYPE_DES_ECB:
			secretKey = new SecretKeySpec(key, "DES");
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			break;
		case TYPE_DES_CBC:
			iv = new IvParameterSpec(vi); 
			secretKey = new SecretKeySpec(key, "DES");
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			break;
		}
		byte[] encryptedData = cipher.doFinal(plainText);
		result = Hex.encodeHexStr(encryptedData);
		return result;
	}

	@Override
	public String decrypt(String str) throws Exception {
		String result = "";
		byte[] encryptedData = str.getBytes();
		Cipher cipher = null;
		IvParameterSpec iv;
		switch (type) {
		case TYPE_3DES_ECB:
			SecretKey secretKey = new SecretKeySpec(key, "DESede");
			cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			break;
		case TYPE_3DES_CBC:
			iv = new IvParameterSpec(vi);
			secretKey = new SecretKeySpec(key, "DESede");
			cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			break;
		case TYPE_DES_ECB:
			secretKey = new SecretKeySpec(key, "DES");
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
			break;
		case TYPE_DES_CBC:
			iv = new IvParameterSpec(vi); 
			secretKey = new SecretKeySpec(key, "DES");
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			break;
		}
		byte[] decryptPlainText = cipher.doFinal(encryptedData);
		result = new String(decryptPlainText);
		return result;
	}

}
