package front;

import clases.Pieza;
import clases.Revision;
import clases.Trabajo;
import clases.repCarroceria;
import clases.repMecanica;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Inicio del ArrayList del taller
		ArrayList<Trabajo> listaTrabajos = new ArrayList<Trabajo>();

		//Lanzar menu
		System.out.println("Bienvenido a JD GARAGE");
		Scanner lector = new Scanner(System.in);
		int select = 0;
		while (select != 7) {
			imprimirMenu();
			select = lector.nextInt();
			menu(select, listaTrabajos);
		}
	}

	//Metodo para imprimir el menu
	public static void imprimirMenu() {
		System.out.println("============================");
		System.out.println("Seleccionar una opcion del menu:");
		System.out.println("1. Registrar un nuevo trabajo");
		System.out.println("2. Incrementar horas mano de obra de un trabajo");
		System.out.println("3. Incrementar listado piezas para un trabajo");
		System.out.println("4. Cambiar estado de un trabajo");
		System.out.println("5. Finalizar estado de un trabajo");
		System.out.println("6. Mostrar detalles del trabajo por ID");
		System.out.println("7. Salir del sistema.");
		System.out.println("============================");
	}

	//Metodo de seleccion del menu
	public static void menu(int select, ArrayList<Trabajo> listaTrabajos) {
		switch (select) {
			case 1:
				registrarTrabajo(listaTrabajos);
				break;
			case 2:
				incrementarHoras(listaTrabajos);
				break;
			case 3:
				añadirPiezas(listaTrabajos);
				break;
			case 4:
				cambiarOrden(listaTrabajos);
				break;
			case 5:
				finalizarOrden(listaTrabajos);
				break;
			case 6:
				mostrarTrabajo(listaTrabajos);
				break;
			case 7:
				salirSistema(select);
				break;
		}
	}

	private static void registrarTrabajo(ArrayList<Trabajo> listaTrabajos) {
		Trabajo trabajo = null;
		//Seleccionar tipo de trabajo
		System.out.println("Seleccionar trabajo a realizar:");
		System.out.println("1. Reparación Mecánica");
		System.out.println("2. Reparación Carrocería");
		System.out.println("3. Revisión");
		Scanner lector = new Scanner(System.in);
		int select = lector.nextInt();
		switch (select) {
			case 1:
				//Introducir datos del trabajo
				//ID autoincremental
				int id = listaTrabajos.size() + 1;
				//limpiamos el buffer del scanner
				lector.nextLine();
				//Descripcion
				System.out.println("Descripcion del trabajo:");
				String notas = lector.nextLine();
				//Horas acumuladas
				int horasAcumuladas = 0;
				//Fase del trabajo
				int fase = 0;
				//Listado de piezas
				ArrayList<Pieza> listadoPiezas = new ArrayList<>();
				trabajo = new repMecanica(id, notas, horasAcumuladas, fase, listadoPiezas);
				System.out.println("Trabajo añadido correctamente.");
				System.out.println("ID asignado: " + trabajo.getID());
				System.out.println("Descripción: " + trabajo.getDescripcion());
				System.out.println("============================");
				break;
			case 2:
				//Introducir datos del trabajo
				//ID autoincremental
				id = listaTrabajos.size() + 1;
				//Descripcion
				System.out.println("Descripcion del trabajo");
				notas = lector.nextLine();
				lector.nextLine();
				//Horas acumuladas
				horasAcumuladas = 0;
				//Fase del trabajo
				fase = 0;
				//Listado de piezas
				listadoPiezas = new ArrayList<>();
				trabajo = new repCarroceria(id, notas, horasAcumuladas, fase, listadoPiezas);
				System.out.println("Trabajo añadido correctamente.");
				System.out.println("ID asignado: " + trabajo.getID());
				System.out.println("Descripción: " + trabajo.getDescripcion());
				System.out.println("============================");
				break;
			case 3:
				//Introducir datos del trabajo
				//ID autoincremental
				id = listaTrabajos.size() + 1;
				//Descripcion
				System.out.println("Descripcion del trabajo");
				notas = lector.nextLine();
				lector.nextLine();
				//Horas acumuladas
				horasAcumuladas = 0;
				//Fase del trabajo
				fase = 0;
				trabajo = new Revision(id, notas, horasAcumuladas, fase);
				System.out.println("Trabajo añadido correctamente.");
				System.out.println("ID asignado: " + trabajo.getID());
				System.out.println("Descripción: " + trabajo.getDescripcion());
				System.out.println("============================");
				break;
			default:
				System.out.println("Seleccion erronea.");
				System.out.println("============================");
				break;
		}
		//Añadir al ArrayList
		listaTrabajos.add(trabajo);
	}

	private static void incrementarHoras(ArrayList<Trabajo> listaTrabajos) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Seleccionar ID de Trabajo:");
		boolean checkID = false;
		//Filtro para el tipo de entrada por consola
		while (!lector.hasNextInt()) {
			String input = lector.next();
			System.out.print("Error al introducir el ID");
		}
		int IDlector = lector.nextInt();

		//Revisar si existe el ID
		for (Trabajo trabajo : listaTrabajos) {
			//Confirmar
			if (trabajo.getID() == IDlector) {
				checkID = true;
				break;
			}
		}
		//ejecutar si ID Correcto
		if (checkID) {
			IDlector = IDlector - 1;
			//Revisar estado del trabajo
			if (listaTrabajos.get(IDlector).getFase() != 2) {
				int getHoras = listaTrabajos.get(IDlector).getHorasAcumuladas();
				System.out.println("Horas actuales: " + getHoras);
				System.out.println("Introducir horas de trabajo realizadas por el operario(se sumarán al total): ");
				int horasLector = lector.nextInt();
				int acum = getHoras + horasLector;
				listaTrabajos.get(IDlector).setHorasAcumuladas(acum);
				System.out.println("Nuevo total de horas acumuladas: " + listaTrabajos.get(IDlector).getHorasAcumuladas());
			} else {
				System.out.println("Trabajo terminado. Opción no disponible.");
			}
		} else {
			System.out.println("ID itroducido erroneo.");
		}
	}

	private static void añadirPiezas(ArrayList<Trabajo> listaTrabajos) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Seleccionar ID de Trabajo:");
		boolean checkID = false;
		//Filtro para el tipo de entrada por consola
		while (!lector.hasNextInt()) {
			String input = lector.next();
			System.out.print("Error al introducir el ID");
		}
		int IDlector = lector.nextInt();
		//Revisar si existe el ID
		for (Trabajo trabajo : listaTrabajos) {
			//Confirmar
			if (trabajo.getID() == IDlector) {
				checkID = true;
				break;
			}
		}
		//ejecutar si ID Correcto
		if (checkID) {
			IDlector = IDlector - 1;
			//Revisar estado del trabajo
			if (listaTrabajos.get(IDlector).getFase() != 2) {
				//Revisamos tipo de instancia del trabajo
				//Instancia repMecanica
				if (listaTrabajos.get(IDlector) instanceof repMecanica) {
					repMecanica trabajo = (repMecanica) listaTrabajos.get(IDlector);
					//Obtenemos el listado de piezas
					ArrayList<Pieza> listadoPiezas = trabajo.getListadoPiezas();
					//Mostramos las piezas acumuladas
					System.out.println("Este Trabajo acumula las siguientes piezas: ");
					System.out.println("============================");

					for (Pieza pieza : listadoPiezas) {
						System.out.println(pieza);
						System.out.println("--------");
					}
					//Solicitamos nueva pieza
					//limpiamos el buffer del scanner
					lector.nextLine();
					System.out.println("============================");
					System.out.println("Introducir más piezas --- ");
					System.out.println("Nombre: ");
					String nombrePieza = lector.nextLine();
					//limpiamos el buffer del scanner
					//lector.nextLine();
					System.out.println("Descripcion: ");
					String descPieza = lector.nextLine();
					System.out.println("Precio:");
					Double precPieza = lector.nextDouble();
					//Creamos y añadimos la nueva pieza al arraylist
					Pieza newPieza = new Pieza(nombrePieza, descPieza, precPieza);
					listadoPiezas.add(newPieza);
					trabajo.setListadoPiezas(listadoPiezas);
					System.out.println("Pieza añadida correctamente: " + newPieza);
					//Instancia repCarroceria
				} else if (listaTrabajos.get(IDlector) instanceof repCarroceria) {
					repCarroceria trabajo = (repCarroceria) listaTrabajos.get(IDlector);
					//Obtenemos el listado de piezas
					ArrayList<Pieza> listadoPiezas = trabajo.getListadoPiezas();
					//Mostramos las piezas acumuladas
					System.out.println("Este Trabajo acumula las siguientes piezas: ");
					System.out.println("============================");

					for (Pieza pieza : listadoPiezas) {
						System.out.println(pieza);
						System.out.println("--------");
					}
					//Solicitamos nueva pieza
					System.out.println("============================");
					System.out.println("Introducir piezas --- ");
					System.out.println("Nombre: ");
					String nombrePieza = lector.nextLine();
					lector.nextLine();
					System.out.println("Descripcion: ");
					String descPieza = lector.nextLine();
					System.out.println("Precio:");
					Double precPieza = lector.nextDouble();
					//Creamos y añadimos la nueva pieza al arraylist
					Pieza newPieza = new Pieza(nombrePieza, descPieza, precPieza);
					listadoPiezas.add(newPieza);
					trabajo.setListadoPiezas(listadoPiezas);
					System.out.println("Pieza añadida correctamente: " + newPieza);
					//Instancia Revision
				} else if (listaTrabajos.get(IDlector) instanceof Revision) {
					System.out.println("Este trabajo no requiere piezas.");
				}
			} else {
				System.out.println("Trabajo terminado. Opción no disponible.");
			}

		} else {
			System.out.println("ID itroducido erroneo.");
		}
	}

	private static void cambiarOrden(ArrayList<Trabajo> listaTrabajos) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Seleccionar ID de Trabajo:");
		boolean checkID = false;
		//Filtro para el tipo de entrada por consola
		while (!lector.hasNextInt()) {
			String input = lector.next();
			System.out.print("Error al introducir el ID");
		}
		int IDlector = lector.nextInt();
		//Revisar si existe el ID
		for (Trabajo trabajo : listaTrabajos) {
			//Confirmar
			if (trabajo.getID() == IDlector) {
				checkID = true;
				break;
			}
		}
		//ejecutar si ID Correcto
		if (checkID) {
			IDlector = IDlector - 1;
			int getFase = listaTrabajos.get(IDlector).getFase();
			System.out.println("Este Trabajo se encuentra en la siguiente fase: ");
			System.out.println("============================");
			switch (getFase) {
				case 0:
					System.out.println("Trabajo iniciado.");
					break;
				case 1:
					System.out.println("Trabajo en ejecucion.");
					break;
				case 2:
					System.out.println("Trabajo finalizado.");
					break;
			}
			System.out.println("============================");
			System.out.println("Cambiar fase del trabajo ( 0 - 1 - 2): ");
			int faseLector = lector.nextInt();
			listaTrabajos.get(IDlector).setFase(faseLector);
			System.out.println("Nuevo estado del trabajo: " + listaTrabajos.get(IDlector).getFase());

		} else {
			System.out.println("ID introducido erroneo.");
		}
	}

	private static void mostrarTrabajo(ArrayList<Trabajo> listaTrabajos) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Seleccionar ID de Trabajo:");
		boolean checkID = false;
		//Filtro para el tipo de entrada por consola
		while (!lector.hasNextInt()) {
			String input = lector.next();
			System.out.print("Error al introducir el ID");
		}
		int IDlector = lector.nextInt();
		//Revisar si existe el ID
		for (Trabajo trabajo : listaTrabajos) {
			//Confirmar
			if (trabajo.getID() == IDlector) {
				checkID = true;
				break;
			}
		}
		//ejecutar si ID Correcto
		if (checkID) {
			IDlector = IDlector - 1;
			//Revisamos tipo de instancia del trabajo
			//Instancia repMecanica
			if (listaTrabajos.get(IDlector) instanceof repMecanica) {
				repMecanica trabajo = (repMecanica) listaTrabajos.get(IDlector);
				//Obtenemos los datos de esta instancia
				int idTrabajo = trabajo.getID();
				String descTrabajo = trabajo.getDescripcion();
				int horasAcumTrabajo = trabajo.getHorasAcumuladas();
				int faseTrabajo = trabajo.getFase();
				ArrayList<Pieza> listadoPiezas = trabajo.getListadoPiezas();
				Double preTotalTrabajo = trabajo.calcularPrecioTotal(listadoPiezas);

				//Mostramos las piezas acumuladas
				System.out.println("Datos de este trabajo: ");
				System.out.println("============================");
				System.out.println("ID: " + idTrabajo);
				System.out.println("Descripcion: " + descTrabajo);
				System.out.println("Horas Acumuladas: " + horasAcumTrabajo);
				switch (faseTrabajo) {
					case 0:
						System.out.println("Fase: Trabajo iniciado.");
						break;
					case 1:
						System.out.println("Fase: Trabajo en ejecucion.");
						break;
					case 2:
						System.out.println("Fase: Trabajo finalizado.");
						break;
				}
				System.out.println("---");
				System.out.println("Listado de piezas: ");
				System.out.println(listadoPiezas);
				System.out.println("---");
				System.out.println("Precio total: " + preTotalTrabajo);
				System.out.println("============================");
				//Instancia repCarroceria
			} else if (listaTrabajos.get(IDlector) instanceof repCarroceria) {
				repCarroceria trabajo = (repCarroceria) listaTrabajos.get(IDlector);
				//Obtenemos los datos de esta instancia
				int idTrabajo = trabajo.getID();
				String descTrabajo = trabajo.getDescripcion();
				int horasAcumTrabajo = trabajo.getHorasAcumuladas();
				int faseTrabajo = trabajo.getFase();
				ArrayList<Pieza> listadoPiezas = trabajo.getListadoPiezas();
				Double preTotalTrabajo = trabajo.calcularPrecioTotal(listadoPiezas);

				//Mostramos las piezas acumuladas
				System.out.println("Datos de este trabajo: ");
				System.out.println("============================");
				System.out.println("ID: " + idTrabajo);
				System.out.println("Descripcion: " + descTrabajo);
				System.out.println("Horas Acumuladas: " + horasAcumTrabajo);
				switch (faseTrabajo) {
					case 0:
						System.out.println("Fase: Trabajo iniciado.");
						break;
					case 1:
						System.out.println("Fase: Trabajo en ejecucion.");
						break;
					case 2:
						System.out.println("Fase: Trabajo finalizado.");
						break;
				}
				System.out.println("---");
				System.out.println("Listado de piezas: ");
				System.out.println(listadoPiezas);
				System.out.println("---");
				System.out.println("Precio total: " + preTotalTrabajo);
				System.out.println("============================");
				//Instancia Revision
			} else if (listaTrabajos.get(IDlector) instanceof Revision) {
				Revision trabajo = (Revision) listaTrabajos.get(IDlector);
				//Obtenemos los datos de esta instancia
				int idTrabajo = trabajo.getID();
				String descTrabajo = trabajo.getDescripcion();
				int horasAcumTrabajo = trabajo.getHorasAcumuladas();
				int faseTrabajo = trabajo.getFase();
				Double preTotalTrabajo = trabajo.calcularPrecioTotal();
				//Mostramos las piezas acumuladas
				System.out.println("Datos de este trabajo: ");
				System.out.println("============================");
				System.out.println("ID: " + idTrabajo);
				System.out.println("Descripcion: " + descTrabajo);
				switch (faseTrabajo) {
					case 0:
						System.out.println("Fase: Trabajo iniciado.");
						break;
					case 1:
						System.out.println("Fase: Trabajo en ejecucion.");
						break;
					case 2:
						System.out.println("Fase: Trabajo finalizado.");
						break;
				}
				System.out.println("Horas Acumuladas: " + horasAcumTrabajo);
				System.out.println("Precio total: " + preTotalTrabajo);
				System.out.println("============================");
			}
		} else {
			System.out.println("ID itroducido erroneo.");
		}
	}

	private static void salirSistema(int select) {
		System.out.println("Hasta luego");
		select = 7;
	}

	private static void finalizarOrden(ArrayList<Trabajo> listaTrabajos) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Seleccionar ID de Trabajo:");
		boolean checkID = false;
		//Filtro para el tipo de entrada por consola
		while (!lector.hasNextInt()) {
			String input = lector.next();
			System.out.print("Error al introducir el ID");
		}
		int IDlector = lector.nextInt();
		//Revisar si existe el ID
		for (Trabajo trabajo : listaTrabajos) {
			//Confirmar
			if (trabajo.getID() == IDlector) {
				checkID = true;
				break;
			}
		}
		//ejecutar si ID Correcto
		if (checkID) {
			IDlector = IDlector - 1;
			//Revisar estado del trabajo
			if (listaTrabajos.get(IDlector).getFase() != 2) {
				int getFase = listaTrabajos.get(IDlector).getFase();
				System.out.println("Este Trabajo se encuentra en la siguiente fase: ");
				System.out.println("============================");
				switch (getFase) {
					case 0:
						System.out.println("Trabajo iniciado.");
						break;
					case 1:
						System.out.println("Trabajo en ejecucion.");
						break;
					case 2:
						System.out.println("Trabajo finalizado.");
						break;
				}
				System.out.println("============================");
				int faseLector = 2;
				listaTrabajos.get(IDlector).setFase(faseLector);
				System.out.println("Trabajo cambiado a FINALIZADO.");
			} else {
				System.out.println("Trabajo en estado FINALIZADO.");
			}

		} else {
			System.out.println("ID itroducido erroneo.");
		}
	}
}
