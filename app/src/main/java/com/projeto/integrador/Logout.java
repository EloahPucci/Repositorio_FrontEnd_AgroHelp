package com.projeto.integrador;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projeto.integrador.application.AgroHelpApplication;
import com.projeto.integrador.domain.Usuario;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AgroHelpApplication.getInstance().setUsuario(null);
    }
}
