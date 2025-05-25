package Modelo;

public class Paciente {

    private String numPaciente;

    private String nombre;

    private String apePat;

    private String apeMat;

    private String calleNumero;

    private String colonia;

    private String cp;

    private String estado;

    private String telefono;

    private String fechaNac;

    private String sexo;

    private String estadoCivil;

    private String fechaIngreso;

    public Paciente(String numPaciente, String nombre, String apePat, String apeMat, String calleNumero, String colonia, String cp, String estado, String telefono, String fechaNac, String sexo, String estadoCivil, String fechaIngreso) {
        this.numPaciente = numPaciente;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.cp = cp;
        this.estado = estado;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumPaciente() {
        return numPaciente;
    }

    public void setNumPaciente(String numPaciente) {
        this.numPaciente = numPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "numPaciente='" + numPaciente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apePat='" + apePat + '\'' +
                ", apeMat='" + apeMat + '\'' +
                ", calleNumero='" + calleNumero + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp='" + cp + '\'' +
                ", estado='" + estado + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", sexo='" + sexo + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}
