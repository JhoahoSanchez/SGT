package org.example;

public class CuentaEntity {
    private String direccionCorreo;
    private String contrasena;

    public CuentaEntity(){}

    public CuentaEntity(String direccionCorreo, String contrasena) {
        this.direccionCorreo = direccionCorreo;
        this.contrasena = contrasena;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentaEntity that = (CuentaEntity) o;

        if (direccionCorreo != null ? !direccionCorreo.equals(that.direccionCorreo) : that.direccionCorreo != null)
            return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = direccionCorreo != null ? direccionCorreo.hashCode() : 0;
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CuentaEntity{" +
                "direccionCorreo='" + direccionCorreo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
