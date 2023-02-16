/* Clase GastoException que heredara de Exception (podía usarse también RuntimeException)
 * que invoca en su constructor al constructor de la clase de la que hereda con super(), 
 * y le pasa el mensaje de la excepción no comprobada que queremos que se muestre.
 */
public class GastoException extends Exception{

	public GastoException() {
		super("No se pudo realizar la operación. Saldo en cuenta insuficiente");
	}
}
