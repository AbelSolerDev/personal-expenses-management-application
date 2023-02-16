/* Clase Abstracta (sin métodos abstractos) con sus getters 
 * y setters que solo crearemos para que hereden las clases
 * Gasto e Ingreso. Al ser abstracta no podremos crear instancias
 * de la misma.
 */
public abstract class Dinero {

	//Propiedades
	
		protected double dinero;
		protected String descripcion;
		
		public double getDinero() {
			return dinero;
		}
		public void setDinero(double dinero) {
			this.dinero = dinero;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		
}
