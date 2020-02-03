package clases;

import java.util.ArrayList;

public class repCarroceria extends Reparaciones {
	
	public repCarroceria(int ID, String descripcion, int horasAcumuladas, int fase, ArrayList<Pieza> listadoPiezas) {
		super(ID, descripcion, horasAcumuladas, fase, listadoPiezas);
	}

	@Override
		public ArrayList<Pieza> getListadoPiezas() {
		return super.getListadoPiezas();
	}

	@Override
	public void setListadoPiezas(ArrayList<Pieza> listadoPiezas) {
		super.setListadoPiezas(listadoPiezas);
	}

	@Override
	public void verListadoPiezas(ArrayList<Pieza> listadoPiezas) {
		for (Pieza pieza : listadoPiezas) {
			System.out.println(pieza);
		}
	}

	@Override
	public double costeTotalPiezas(ArrayList<Pieza> listadoPiezas) {
		double total = 0;
		for (Pieza pieza : listadoPiezas) {
			total = +pieza.getPrecio();
		}
		return total;
	}
	
	@Override
	public double calcularPrecioTotal(ArrayList<Pieza> listadoPiezas){
		//(precioHora * horasAcumuladas) + (costePiezas  * 1.3)
		double margen = 1.3;
		return ((super.precioHora * this.getHorasAcumuladas()) + (this.costeTotalPiezas(listadoPiezas) * margen));
	}

}
