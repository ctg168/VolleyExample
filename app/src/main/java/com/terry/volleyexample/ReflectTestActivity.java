package com.terry.volleyexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.terry.biz.Apple;

public class ReflectTestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect_test);

//        Apple apple = new Apple();
//        FruitInfoUtil.getFruitInfo(apple);
//        String dName = apple.displayName();
//        Toast.makeText(getApplicationContext(), dName, Toast.LENGTH_SHORT).show();

        try {
            Class c = Class.forName("com.terry.biz.Apple");
            Object classObj = c.newInstance();
            if (classObj instanceof Apple) {
                Apple apple = (Apple) classObj;
                FruitInfoUtil.getFruitInfo(apple);
                String dName = apple.displayName();
                Toast.makeText(getApplicationContext(), dName, Toast.LENGTH_SHORT).show();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reflect_test, menu);
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
