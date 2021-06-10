package com.example.proyecthospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecthospital.Dao.UsuarioDao;
import com.example.proyecthospital.Entidad.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnIngresar,btnRegistrar;
    EditText edtUser,edtPass;
    UsuarioDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //
        setContentView(R.layout.activity_main);
        edtUser = (EditText) findViewById(R.id.edtUsuario);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new UsuarioDao(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnIngresar:
            String u= edtUser.getText().toString();
            String p=edtPass.getText().toString();
            if(u.equals("")&&p.equals(""))
            {
                Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_SHORT).show();
            }else if(dao.login(u,p)==1){
                Usuario us=dao.getUsuario(u,p);
                Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                Intent i2= new Intent(MainActivity.this,MainInicio.class);
                i2.putExtra("cod",us.getCod());
                startActivity(i2);
            }break;
            case R.id.btnRegistrar:
                Intent i= new Intent(MainActivity.this,MainRegistro.class);
                startActivity(i);
                break;
    }
  }
}