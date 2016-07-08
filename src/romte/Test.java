package romte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import view.Answer;
import view.Question;
import view.QuestionnaireList;
import view.Result;
import view.Risk;


public class Test {
	public static <T> void main(String[] args) throws IOException {
//		String strURL = "http://112.124.6.26:8001/web/questionnaire/answerDetail?version=2.0&userId=5320";
		String strURL="http://112.124.6.26:8001/web/questionnaire/questionnaireScore?userId=5321&version=2.0";
        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection)
        url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.connect();
            
        BufferedReader reader = new BufferedReader(new InputStreamReader(
        httpConn.getInputStream(),"utf-8"));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
        buffer.append(line);
        }
        reader.close();
        httpConn.disconnect();
        JSONObject jSONObject=JSONObject.parseObject(buffer.toString());
//        Result<T> result=jSONObject.toJavaObject(jSONObject, Result.class);
//        JSONObject jSONObject1=JSONObject.parseObject(result.getData().toString());
//        Risk risk=jSONObject1.toJavaObject(jSONObject1, Risk.class);
//        System.out.println(result);
//        
//        List<Question> list=risk.getQuestions();
//        for(Question qus:list){
//        	System.out.println(qus.getDescription());
//        	System.out.println(qus.getZwOptions());
//        }
//        System.out.println(risk);
        
        Result<T> result=jSONObject.toJavaObject(jSONObject, Result.class);
        JSONObject jSONObject1=JSONObject.parseObject(result.getData().toString());
        QuestionnaireList qlist=jSONObject1.toJavaObject(jSONObject1, QuestionnaireList.class);
        System.out.println(result.getData());
        System.out.println(qlist.getQuestionnaireList().get(0));
        System.out.println(result);
     
        System.out.println(buffer.toString());
	}

}
