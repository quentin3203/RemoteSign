package sign;

public class Sign {
	public static void main(String[] args) throws Exception {
		String url="http://112.124.6.26:8001/web/questionnaire/questionnaireScore?version=2.0&userId=5320";
		String[] u=url.split("=");
		for(String s:u){
			System.out.println(s);
		}
		String s="2.0"+"5320";
		System.out.println("checkvalue:"+Signs(s));

	}

	public static String Signs(String url) throws Exception {
		Encrypt e = EncryptFactory.createEncrypt("des",
				DesEncrypt.TYPE_3DES_CBC, "5D99AAFADE61223B47EC3EEA",
				"47EC3EEA");
		String sign = e.encrypt(url).trim();
		return sign;
	}

}
