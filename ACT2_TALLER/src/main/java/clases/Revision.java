
package clases;

import java.util.ArrayList;

public class Revision extends Trabajo {

	public Revision(int ID, String descripcion, int horasAcumuladas, int fase) {
		super(ID, descripcion, horasAcumuladas, fase);
	}
	
	public double calcularPrecioTotal(){
		//(precioHora * horasAcumuladas) + (20)
		double extra = 20.0;
		return ((super.precioHora * this.getHorasAcumuladas()) + extra);
	}
	
}
