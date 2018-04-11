package controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        ControllerModule.getInstance().startApplication();
    }
}
