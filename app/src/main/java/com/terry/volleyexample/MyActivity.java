package com.terry.volleyexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //LoadData(getApplicationContext());

        startActivity(new Intent(MyActivity.this,ReflectTestActivity.class));

    }

    private void LoadData(Context context) {
        RequestQueue mQueue = Volley.newRequestQueue(context);

        //不带参数的网络请求
        StringRequest stringRequest = new StringRequest("http://yuedu.baidu.com/vip/index",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("TAG", volleyError.getMessage(), volleyError);
                    }
                }
        ) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String str = null;
                try {
                    str = new String(response.data, "gb2312");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        /* 带参数的网络访问
       String url = "http://223.4.209.79:8700/view/product/MainView.cshtml";//?navid=1
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("TAG", volleyError.getMessage(), volleyError);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> paras = new HashMap<String, String>();
                paras.put("navid", "1");
                return paras;
            }
        };*/


        mQueue.add(stringRequest);
        //mQueue.add(stringRequest1);
        mQueue.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
