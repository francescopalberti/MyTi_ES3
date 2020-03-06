package it.myti.test;

import java.time.LocalDate;
import java.time.Period;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Questa classe descrive un oggetto Student con specifiche proprietà
 * @author Francesco Palberti
 */

public class Student {
	private static final String lineSeparator = "\n";
	private String firstname;	//nome
	private String lastname;	//cognome
	private String birthdate;	//compleanno
	private String grades;	//voti
	 
	public Student(String firstname, String lastname, String birthdate, String grades) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.grades = grades;
	}
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Questo metodo calcola l'età dello studente
	 * @return età dello student
	 */
	public int calculateAge() {
		//Data corrente
		LocalDate currentDate = LocalDate.now();
		//Converte una data stringa in formato AAAA-MM-GG in LocalDate
		LocalDate birthDate = LocalDate.parse(birthdate);
        return Period.between(birthDate, currentDate).getYears();
    }
	
	/**
	 * Questo metodo calcola le votazioni medie dello studente
	 * @return votazione media
	 */
	public int calculateAvgGrade() {
		int totale=0;
		String [ ] voti = new String [grades.length()-1];
		voti=grades.split("-");
		for (int i = 0; i < voti.length; i++) {
			totale=totale+ Integer.valueOf(voti[i]);
		}
		return totale/voti.length;
    }


	/**
	 * Questo metodo costruice la carta d'identità dello studente
	 * @return string rappresentativa dello studente
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Nome: "+ firstname);
		s.append(lineSeparator);
		s.append("Cognome: "+ lastname);
		s.append(lineSeparator);
		s.append("Età: "+ calculateAge());
		s.append(lineSeparator);
		s.append("Media Voti: "+ calculateAvgGrade());
		return s.toString();
	}


	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}


	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	/**
	 * @return the grades
	 */
	public String getGrades() {
		return grades;
	}


	/**
	 * @param grades the grades to set
	 */
	public void setGrades(String grades) {
		this.grades = grades;
	}


	/**
	 * @return the lineseparator
	 */
	public static String getLineseparator() {
		return lineSeparator;
	}
	
	
	
}
