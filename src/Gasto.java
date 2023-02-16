/* Clase Gasto que hereda de clase Dinero sus atributos (ya que son protected) y métodos. En el constructor
 * asignamos la cantidad del gasto y la descripción. También disponemos de un método toString para informar 
 * de dicha operación.
 */
public class Gasto extends Dinero{
	
	public Gasto (double gasto, String descripcion) {
		
		dinero = gasto;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Gasto: " + descripcion + ", cantidad:" + String.format("%.2f", dinero) + "€";
	}

}
