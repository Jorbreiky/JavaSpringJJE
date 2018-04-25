package mvc1.models;

public class Alumno {
	private int alumnoId;
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Alumno(){}
	
	public Alumno(int alumnoId, String nombre, String apellidos, int edad) {
		this.alumnoId = alumnoId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public int getAlumnoId() {return alumnoId;}
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public int getEdad() {return edad;}
	
	public int setAlumnoId(int alumnoId) {return this.alumnoId = alumnoId;}
	public String setNombre(String nombre) {return this.nombre = nombre;}
	public String setApellidos(String apellidos) {return this.apellidos = apellidos;}
	public int setEdad(int edad) {return this.edad = edad;}
	
	public String toString() {
		return "ID: "+getAlumnoId()+" - Nombre:"+getNombre()+" - Apellidos:"+getApellidos()+" - Edad:"+getEdad();
	}
	
	
	
}
