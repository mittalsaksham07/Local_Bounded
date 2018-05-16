package com.example.apoorva.local_bounded;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService s;
    ServiceConnection sc= new My();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(this,MyService.class);
        bindService(i,sc, Context.BIND_AUTO_CREATE);
    }
    public void click(View v)
    {
        String str=s.display();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public class My implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder m=(MyService.MyBinder)iBinder;
            s=m.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            s=null;
        }
    }
}
