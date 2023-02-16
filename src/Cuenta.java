import java.util.ArrayList;
import java.util.List;

/* En esta Clase Cuenta básicamente paso a código lo que pone en el diagrama de clases, añadiendo los 
 * getters y los setters de cada atributo privado y un método toString() que mostrara por pantalla el
 * nombre de usuario de la cuenta con el saldo. 
 */

public class Cuenta {

	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	public Cuenta(Usuario usuario) {
		this.usuario = usuario;
		saldo = 0;
		ingresos = new ArrayList<>();
		gastos = new ArrayList<>();
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/* Método con el que añadimos una cantidad al saldo. A la vez creamos un nuevo objeto
	 * de la clase Ingreso y lo añadimos al ArrayList de los ingresos.
	 */
	
	public double addIngresos(String descripcion, double cantidad) {
		this.saldo += cantidad;
		Ingreso nuevoIngreso = new Ingreso(cantidad, descripcion);
		ingresos.add(nuevoIngreso);
		return saldo;
	}
	
	/* Método con el que restamos una cantidad al saldo siempre y cuando el saldo sea superior
	 * o igual a la cantidad a restar. A la vez creamos un nuevo objeto de la clase Gasto y lo
	 * añadimos al ArrayList de los gastos. En la definición del método avisamos que el mismo 
	 * va a lanzar una excepción a la Clase GastoException cuando la cantidad del gasto sea mayor
	 * que el saldo.
	 */
	public double addGastos(String descripcion, double cantidad) throws GastoException {
		if (saldo >= cantidad) {
			this.saldo -= cantidad;
			Gasto nuevoGasto = new Gasto(cantidad, descripcion);
			gastos.add(nuevoGasto);
		}else {
			throw new GastoException();
		}
		return saldo;
	}	

	public List<Gasto> getGastos() {
		return gastos;
	}


	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	// Este método es el que usaré desde el Main siempre que quiera mostrar el saldo del usuario y su nombre. 
		@Override
		public String toString() {
			return "La cuenta del usuario " + getUsuario().getNombre() + " tiene un saldo de " + String.format("%.2f", saldo) + "€";
			
		}
	
}
