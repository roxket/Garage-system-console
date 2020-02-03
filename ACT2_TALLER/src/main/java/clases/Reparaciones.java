
package clases;

import java.util.ArrayList;

public abstract class Reparaciones extends Trabajo{
	private ArrayList<Pieza> listadoPiezas = new ArrayList<>();
	private double calcularPrecioTotal;
	
	public Reparaciones(int ID, String descripcion, int horasAcumuladas, int fase, ArrayList<Pieza> listadoPiezas) {
		super(ID, descripcion, horasAcumuladas, fase);
		this.listadoPiezas = listadoPiezas;
	}
	
	public ArrayList<Pieza> getListadoPiezas() {
		return listadoPiezas;
	}

	public void setListadoPiezas(ArrayList<Pieza> listadoPiezas) {
		this.listadoPiezas = listadoPiezas;
	}
	
	public void verListadoPiezas(ArrayList<Pieza> listadoPiezas) {
		for(Pieza pieza : listadoPiezas){
			System.out.println(pieza);
		}
	}
	
	public double costeTotalPiezas(ArrayList<Pieza> listadoPiezas) {
		double total = 0;
		for (Pieza pieza : listadoPiezas) {
			total =+ pieza.getPrecio();
		}
		return total;
	}

	public double calcularPrecioTotal(ArrayList<Pieza> listadoPiezas) {
		return calcularPrecioTotal;
	}
	
}
