package com.example.proyecthospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecthospital.Dao.UsuarioDao;
import com.example.proyecthospital.Entidad.Usuario;

public class MainRegistro extends AppCompatActivity implements View.OnClickListener{

    EditText usuario,pass,nom,ape,corr,dni,tlf;
    Button btnRegistrar,btnCancelar;

    UsuarioDao dao;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        usuario = (EditText) findViewById(R.id.edtUsuarioReg);
        pass = (EditText) findViewById(R.id.edtPassReg);
        nom = (EditText) findViewById(R.id.edtNomReg);
        ape = (EditText) findViewById(R.id.edtApeReg);
        tlf = (EditText) findViewById(R.id.edtTlfReg);
        dni = (EditText) findViewById(R.id.edtDniReg);
        corr = (EditText) findViewById(R.id.edtCorreoReg);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrarR);
        btnCancelar=(Button) findViewById(R.id.btnCancelarR);
        btnRegistrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        dao=new UsuarioDao(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnRegistrarR:
                Usuario u = new Usuario();
                u.setUsuario(usuario.getText().toString());
                u.setPassword(pass.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ape.getText().toString());
                u.setTelefono(tlf.getText().toString());
                u.setDni(dni.getText().toString());
                u.setCorreo(corr.getText().toString());
                if (!u.isNull()) {
                    Toast.makeText(this, "Registro erroneo", Toast.LENGTH_SHORT).show();
                } else if (dao.insertarUsuario(u)) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(MainRegistro.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancelarR:
                Intent i = new Intent(MainRegistro.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
