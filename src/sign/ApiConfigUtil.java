package sign;

import java.util.ResourceBundle;

public class ApiConfigUtil {
    private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("AppConfig");

    /**
     * ͨ������ȡֵ
     * 
     * @param key
     * @return
     */
    public static final String get(String key) {
        return bundle.getString(key);
    }

}
