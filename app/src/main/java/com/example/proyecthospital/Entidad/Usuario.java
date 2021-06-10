package com.example.proyecthospital.Entidad;

public class Usuario {
    int cod;
    String nombre,apellidos,correo,usuario,password,dni,telefono;

    public Usuario(){

    }
    public boolean isNull(){
        if(nombre.equals("")&&apellidos.equals("")&&usuario.equals("")&&password.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString(){
        return "Usuario{"+
                "Cod=" + cod+
                ",Nombre='" + nombre + '\'' +
                ",Apellidos='" + apellidos + '\'' +
                ",Usuario='" + usuario + '\'' +
                ",Password='" + password + '\'' +
                ",Telefono='" + telefono + '\'' +
                ",Correo='" + correo + '\'' +
                ",Dni='" + dni + '\'' +
                '}';
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
