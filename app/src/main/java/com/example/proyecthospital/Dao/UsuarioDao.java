package com.example.proyecthospital.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyecthospital.Data.SqlOpenHelper;
import com.example.proyecthospital.Entidad.Usuario;

import java.util.ArrayList;

public class UsuarioDao {
    //atributo de la clase SqlOpenHelper
    Context c;
    ArrayList<Usuario> lista;
    Usuario u;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists tb_usuario(cod integer primary key autoincrement,usuario text,pass text,nombre text,apellido text,tlf text,corr text,dni int)";

    public UsuarioDao(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new Usuario();
    }

    public boolean insertarUsuario(Usuario u){
        if(buscar(u.getUsuario())==0){
            ContentValues cv= new ContentValues();
            cv.put("usuario",u.getUsuario());
            cv.put("pass",u.getPassword());
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellidos());
            cv.put("tlf",u.getTelefono());
            cv.put("corr",u.getCorreo());
            cv.put("dni",u.getDni());
            return (sql.insert("tb_usuario",null,cv)>0);
        }else{
            return  false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista= selectUsuario();
        for(Usuario us:lista){
            if(us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario(){
        lista= new ArrayList<Usuario>();
        lista.clear();
        Cursor cr= sql.rawQuery("select * from tb_usuario",null);
        if(cr!= null && cr.moveToFirst()){
            do{
                Usuario u = new Usuario();
                u.setCod(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
                u.setTelefono(cr.getString(5));
                u.setCorreo(cr.getString(6));
                u.setDni(cr.getString(7));
                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }
    public int login(String u , String p){
        int a=0;
        Cursor cr= sql.rawQuery("select * from tb_usuario",null);
        if(cr!= null && cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());
        }
        return a;
    }

    public Usuario getUsuario(String u,String p){
        lista=selectUsuario();
        for(Usuario us:lista){
            if(us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int cod){
        lista=selectUsuario();
        for(Usuario us:lista){
            if(us.getCod()==cod){
                return us;
            }
        }
        return null;
    }
}
