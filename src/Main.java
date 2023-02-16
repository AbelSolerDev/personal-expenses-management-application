import java.util.ArrayList;
import java.util.Scanner;


//Este será la clase principal donde arrancará el programa.
public class Main {

	public static void main(String[] args) {
		
			
			//Objeto de la clase Scanner para lecturas con teclado desde C.
			Scanner lector = new Scanner(System.in);
			
			//instancio un usuario de la clase Usuario.
			Usuario nuevoUsuario = new Usuario();
			
			//Se pide el nombre del usuario para almacenar
			System.out.println("Introduce el Nombre: ");
			nuevoUsuario.setNombre(lector.nextLine());
			
			//Se pide la edad del usuario para almacenar
			System.out.println("Introduce la edad: ");
			nuevoUsuario.setEdad(lector.nextInt());
			lector.nextLine(); //Para limpiar el Buffer.
			
			/* Pedimos el DNI del usuario hasta que la función setDNI 
			 * nos devuelva que el DNI introducido cumple con el formato
			 * requerido por el ejercicio.
			 */
			boolean esValido = true;
			do {
					/* si es la primera vez que pedimos el DNI se mostrará una
					 * frase, las veces que se pida a posteriori el DNI mostrará
					 * otra frase distinta.
					 */
					if (esValido) {
						System.out.println("Introduce el DNI: ");
					}else {
						System.out.println("introduce el DNI válido: ");
					}
					
					String dniUsuario = lector.nextLine();
					
					esValido = nuevoUsuario.setDNI(dniUsuario);
					if (!esValido) {
						System.out.println("DNI introducido incorrecto.");
					}
			}while (!esValido);
			
			/* Llegados a este punto, ya tenemos los tres atributos del Usuario
			 * creados correctamente y almacenados en él, informo de ello
			 * por pantalla y creamos la cuenta de ese usuario.
			 */
			System.out.println("Usuario creado correctamente.");
			
			Cuenta nuevaCuenta = new Cuenta(nuevoUsuario);
			
			/* Muestro el menú inicial que se ira repitiendo hasta que se
			 * pulse la opción cero.
			 */
			
			int opcionMenu;		
			do {
		
					System.out.println("Realizar una acción\n" + 
										"1. Introduce un nuevo gasto\n" +
										"2. Introduce un nuevo ingreso\n" +
										"3. Mostrar gastos\n" +
										"4. Mostrar ingresos\n" +
										"5. Mostrar saldo\n" +
										"0. Salir");
			
					opcionMenu = lector.nextInt();
					lector.nextLine();
					
					/* Voy a realizar cada acción del menú en métodos aparte para
					 * no hacerlo en el mismo case. Por simplicidad de las mismas,
					 * solo hare en el case las opciones 5 y 0. Los argumentos pasados
					 * a los métodos serán siempre la nuevaCuenta y el objeto lector de la
					 * clase Scanner para trabajar siempre con el mismo y no tener que
					 * estar creándolo nuevo localmente en cada método.
					 */
					switch (opcionMenu) {
					case 1:
						introduceGasto(nuevaCuenta, lector);
						break;
					case 2:
						introduceIngreso(nuevaCuenta, lector);
						break;
					case 3:
						mostrarGastos(nuevaCuenta, lector);
						break;
					case 4:
						mostrarIngreso(nuevaCuenta, lector);
						break;
					/* Nota: En el video de ejemplo, al pulsar la opción 5 solo se
					 * muestra el mensaje en pantalla del valor del saldo (usar
					 * nuevaCuenta.getSaldo()). El profesor ha dado a entender 
					 * en las tutorías que los mensajes no han de ser totalmente 
					 * exactos a los de ese video, y que podríamos usar el 
					 * nuevaCuenta.toString() donde mostramos el nombre del titular
					 * de la cuenta y el saldo (ambos datos y no solo el saldo de 
					 * la misma). Así pues, he tomado la decisión final de usar 
					 * dicho método toString().
					 */
					case 5:
						System.out.println(nuevaCuenta.toString());
						break;
					// En caso de pulsar cero, salimos y mostramos un mensaje de despedida.
					case 0:
						System.out.println("Fin del programa.\n"
								+ "Gracias por utilizar la aplicación.");
						break;
					// Si se pulsa cualquier otra opción que no contempla el menú, lo informamos.
					default :
						System.out.println("Opción incorrecta. Introduce un numero válido");
						break;
				}
				
			}while (opcionMenu != 0);
			
			lector.close();
		}
	
	
			/* Método para introducir un gasto. Se pedirá la descripción del gasto y la cuantía del
			 * mismo. Se controlará una excepción que definiremos en otra clase en la que si la 
			 * cuantía del gasto supera el saldo de la cuenta, se lanzará un mensaje para informar 
			 * por pantalla que la operación no se llevará a cabo ya que no hay saldo en la cuenta,
			 * pero el programa no caerá.
			 */
		
		private static void introduceGasto(Cuenta nuevaCuenta, Scanner lector) {
			
			System.out.println("Introduce la descripción del nuevo gasto: ");
			String descripcion = lector.nextLine();
			
			System.out.println("Introduce la cantidad");
			double cantidad = lector.nextDouble();
			lector.nextLine();
			
			try {
				//Como aquí es donde hago la llamada a addGastos, aquí controlo la excepción.
				double saldo = nuevaCuenta.addGastos(descripcion, cantidad);
				System.out.println(nuevaCuenta.toString());
				
			} catch (GastoException e) {
				// Si ocurre la excepción hago saltar el mensaje que puse en la clase con super();
				System.out.println(e.getMessage());
			}		
		}	
		
		//Método para introducir un ingreso. Se pedirá la descripción del ingreso y la cuantía del mismo.
		private static void introduceIngreso(Cuenta nuevaCuenta, Scanner lector) {
			
			
			System.out.println("Introduce la descripción del nuevo ingreso: ");
			String descripcion = lector.nextLine();
			
			System.out.println("Introduce la cantidad");
			double cantidad = lector.nextDouble();
			lector.nextLine();
			
			nuevaCuenta.addIngresos(descripcion, cantidad);
			System.out.println(nuevaCuenta.toString());
			
					
		}
		
					
		/*Método que muestra todos los gastos almacenados en el ArrayList gastos que primero extraigo. 
		 * He usado un bucle ”for each” de java en vez de optar por usar Iterator, pero se podría 
		 * haber hecho así también.
		 */
		private static void mostrarGastos (Cuenta nuevaCuenta, Scanner lector){
			
			ArrayList<Gasto> gastos = new ArrayList<>();
			gastos = (ArrayList<Gasto>) nuevaCuenta.getGastos();
			
			for (Gasto g: gastos) {
				System.out.println(g.toString());
			}
			
		}
		
		/*Método que muestra todos los ingresos almacenados en el ArrayList ingresos que primero extraigo. 
		 * He usado un bucle ”for each” de java en vez de optar por usar Iterator, pero se podría 
		 * haber hecho así también.
		 */
		private static void mostrarIngreso (Cuenta nuevaCuenta, Scanner sc){
			
			ArrayList<Ingreso> ingresos = new ArrayList<>();
			ingresos = (ArrayList<Ingreso>) nuevaCuenta.getIngresos();
			
			for (Ingreso i: ingresos) {
				System.out.println(i.toString());
			}
			
		}
	}