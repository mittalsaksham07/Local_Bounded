package com.example.apoorva.local_bounded;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public class MyBinder extends Binder{
        public MyService getService()
        {
            return MyService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    public String display()
    {
        return "Saksham";
    }
}
