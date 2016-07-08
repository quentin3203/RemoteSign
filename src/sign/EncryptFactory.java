package sign;

public class EncryptFactory {
	public static Encrypt createEncrypt(String key, String... params) {
		Encrypt e = null;
		switch (key) {
		case "sha1":
			e = new Sha1Encrypt();
			break;
		case "des":
			e = new DesEncrypt(params[0], params[1], params[2]);
			break;
		}

		return e;
	}

}
