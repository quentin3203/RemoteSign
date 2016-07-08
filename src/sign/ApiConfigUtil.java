package sign;

import java.util.ResourceBundle;

public class ApiConfigUtil {
    private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("AppConfig");

    /**
     * 通过键获取值
     * 
     * @param key
     * @return
     */
    public static final String get(String key) {
        return bundle.getString(key);
    }

}
