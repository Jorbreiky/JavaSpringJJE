package mvc1.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import mvc1.models.Alumno;
import mvc1.models.AlumnoDao;

public class AlumnoImpl implements AlumnoDao {
	
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			String sql = "SELECT * FROM Alumno";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getInt("alumnoId"),rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("edad")));
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			cerrarCession();
		}
		return alumnos;
	}
	
	@Override
	public Alumno findByAlumnoId(int alumnoId) {
		try {
			String sql = "SELECT * FROM Alumno WHERE alumnoId = ?";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, alumnoId);
			Alumno alumno = null;
			rs = ps.executeQuery();
			if (rs.next()) {
				alumno = new Alumno(rs.getInt("alumnoId"),rs.getString("nombre"), rs.getString("apellidos"),rs.getInt("edad"));
			}
			rs.close();
			ps.close();
			return alumno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			cerrarCession();
		}
	}

	@Override
	public String insert(Alumno alumno) {
		try {
			String sql = "INSERT INTO Alumno (alumnoId, nombre, apellidos, edad) VALUES (null, ?, ?, ?)";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellidos());
			ps.setInt(3, alumno.getEdad());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			cerrarCession();
		}
		return "success";
	}

	@Override
	public String update(Alumno alumno) {
		try {
			String sql = "UPDATE Alumno SET nombre=?, apellidos=?, edad=? WHERE alumnoId="+alumno.getAlumnoId();
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellidos());
			ps.setInt(3, alumno.getEdad());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			cerrarCession();
		}
		
		return "success";
	}

	@Override
	public String delete(int alumnoId) {
		try {
			String sql = "DELETE FROM Alumno WHERE alumnoId="+alumnoId;
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			cerrarCession();
		}
		return "success";
	}	
	
	public void cerrarCession() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
}
