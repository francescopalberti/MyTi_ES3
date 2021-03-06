package it.myti.test;

/**
 * Classe mock che simula un DAO
 * @author Francesco Palberti
 */

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private static List<Student> data = new ArrayList<>();
	private static StudentDAO instance;
	
	static {
		data.add(new Student("Luca", "Rossi", "1997-11-03", "8-4-10"));
		data.add(new Student("Mario", "Pino", "1995-13-04", "8-10-10"));
	}

	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return lista degli studenti
	 */
	public List<Student> listAll(){
		return new ArrayList<Student>(data);
	}
	
	/**
	 * 
	 * @return l'indice dello studente inserito
	 */
	public int addStudent(Student aStudent){
		int newId = data.size() + 1;
        data.add(aStudent); 
        return newId;
	}
}
