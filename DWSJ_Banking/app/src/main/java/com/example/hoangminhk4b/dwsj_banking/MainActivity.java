package com.example.hoangminhk4b.dwsj_banking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hoangminhk4b.dwsj_banking.fragment.InitMain;
import com.example.hoangminhk4b.dwsj_banking.fragment.transfer.Transfer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new InitMain()).commit();
    }
}
