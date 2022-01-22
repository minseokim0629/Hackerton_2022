package com.example.qna;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "http://10.0.2.2/login.php";
    private Map<String,String> map;

    public LoginRequest(String login_id, int password, Response.Listener<String> listener) {
        super(Method.POST,URL,listener,null);
        try {
            map = new HashMap<>();

            map.put("login_id", login_id);
            map.put("id", password+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
