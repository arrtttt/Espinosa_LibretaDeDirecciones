public class DatosDeRegistro {

    private String nombre;
    private String apellido;
    private String calle;
    private String ciudad;
    private String estado;
    private int codigoPostal;
    private String correoElec;
    private int telefono;

    public DatosDeRegistro() {
    }

    public DatosDeRegistro(String nombre, String apellido, String calle, String ciudad, String estado, int codigoPostal,
            String correoElec, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.correoElec = correoElec;
        this.telefono = telefono;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return nombre + "," + apellido + "," + calle + ","
                + ciudad + "," + estado + "," + codigoPostal + "," + correoElec
                + "," + telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}