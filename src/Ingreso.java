/* Clase Ingreso que hereda de clase Dinero sus atributos (ya que son protected) y métodos. En el constructor
 * asignamos la cantidad del ingreso y la descripción. También disponemos de un método toString para informar 
 * de dicha operación.
 */
public class Ingreso extends Dinero{

	public Ingreso (double ingreso, String descripcion) {
		
		dinero = ingreso;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Ingreso: " + descripcion + ", cantidad:" + String.format("%.2f", dinero) + "€";
	}
}