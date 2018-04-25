package mvc1.models;

import java.util.List;

public interface AlumnoDao {
	public List<Alumno> getAll();
	public Alumno findByAlumnoId(int alumnoId);
	public String insert(Alumno alumno);
	public String update(Alumno alumno);
	public String delete(int alumnoId);	
}