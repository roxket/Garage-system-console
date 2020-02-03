
package clases;

import java.util.ArrayList;

public abstract class Trabajo {
	private int ID;
	private String descripcion;
	public final double precioHora = 30.0;
	private int horasAcumuladas;
	private int fase; // fase 0: inicio - fase 1: en ejecucion - fase 2: terminado

	public Trabajo(int ID, String descripcion, int horasAcumuladas, int fase) {
		this.ID = ID;
		this.descripcion = descripcion;
		this.horasAcumuladas = horasAcumuladas;
		this.fase = fase;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		//this.ID = numTrabajos; //autoincremental en el mismo SET
		//numTrabajos++;
		this.ID = ID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHorasAcumuladas() {
		return horasAcumuladas;
	}

	public void setHorasAcumuladas(int horasAcumuladas) {
		this.horasAcumuladas = horasAcumuladas;
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}
}
