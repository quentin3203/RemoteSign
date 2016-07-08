package com.zw.interceptors;

import java.util.MissingResourceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zw.utils.ApiConfigUtil;
import com.zw.utils.AppConfigUtil;
import com.zw.utils.AppData;
import com.zw.utils.SystemCodeUtil;
import com.zw.utils.encrypt.DesEncrypt;
import com.zw.utils.encrypt.Encrypt;
import com.zw.utils.encrypt.EncryptFactory;

/**
 * 
 * �����ƣ�IOSHandlerInterceptor.java ��������
 * 
 * @author HY ���ߵ�λ�� ��ϵ��ʽ�� ����ʱ�䣺2015��1��1��
 * @version 1.6
 */
public class WebHandlerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = Logger.getLogger(WebHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String[] version = (String[]) request.getParameterMap().get("version");
		String path = request.getServletPath();
		path = path.replace("/web", "");
		AppData data = new AppData();
		try {
			if (StringUtils.isEmpty(version)) {
				data.setCode(SystemCodeUtil.get("MSG_PARAMS_ERROR"));
				data.setMsg(data.getMsg() + ",versionû�д���");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(JSON.toJSONString(data).toString());
				return false;
			}
			if (AppConfigUtil.get("is_checked").equals("0")) {
				// У��appKey�Ƿ�ƥ��
				try {
					String param = ApiConfigUtil.get(path);
					if (!StringUtils.isEmpty(param)) {
						String[] params = param.split(",");
						String s = "";
						String[] checkValue = (String[]) request.getParameterMap().get("checkValue");
						if (StringUtils.isEmpty(checkValue)) {
							data.setCode(SystemCodeUtil.get("MSG_PARAMS_ERROR"));
							data.setMsg(data.getMsg() + ",checkValueû�д���");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write(JSON.toJSONString(data).toString());
							return false;
						}
						for (String p : params) {
							String[] ps = (String[]) request.getParameterMap().get(p);
							if (ps.length > 0)
								s += ps[0];
						}
						Encrypt e = EncryptFactory.createEncrypt("des", DesEncrypt.TYPE_3DES_CBC, AppConfigUtil.get("appkey_web"), AppConfigUtil.get("appsecret_web"));
						String serverCheckValue = e.encrypt(s).trim();
						String clientCheckValue = checkValue[0].trim();
						if (!serverCheckValue.equals(clientCheckValue)) {
							LOGGER.info("��ǩʧ�ܣ�");
							LOGGER.info("serverCheckValue=" + serverCheckValue + " length=" + serverCheckValue.length());
							LOGGER.info("clientCheckValue=" + checkValue[0] + " length=" + checkValue[0].length());
							data.setCode(SystemCodeUtil.get("MSG_SECRET_ERROR"));
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write(JSONObject.toJSONString(data));
							return false;
						}

					}
				} catch (MissingResourceException e) {
				}
			}
		} catch (MissingResourceException e) {
			return true;
		} catch (Exception e) {
			LOGGER.error("������������Ŷ������", e);
			data.setCode(SystemCodeUtil.get("MSG_PARAMS_ERROR"));
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.toJSONString(data).toString());
			return false;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
