
public class Usuario {

	private String nombre;
	private int edad;
	private String DNI;
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad=edad;
		
	}
	
	public String getDNI() {
		return DNI;
	}
	/* Método que comprueba si el DNI cumple un patron determinado en su formación. Devuelve true o false
	 * dependiendo de que este bien o mal formado.
	 */
	public boolean setDNI(String DNI) {
		int i = 0;
		boolean esCorrecto = true;
		char caracter;
		//Si el DNI se presenta sin guion tendrá 9 caracteres.
		if (DNI.length() == 9) {
			// Comprobamos que los 8 primeros son números.
			do {
				caracter = DNI.charAt(i);
				if (Character.isDigit(caracter) == false) {
					esCorrecto = false;
				}
			i++;
			}while ((i<8) && (esCorrecto == true));
			// Si los 8 primeros son numeros, comprobamos que el 9 es una letra.
			if (esCorrecto) {
				if ((Character.isLetter(DNI.charAt(8)))){
					this.DNI = DNI;
				}
			}
			return esCorrecto;
		}
		//Si el DNI se presenta con guion tendrá 10 caracteres.
		if (DNI.length() == 10) {
			do {
				// Comprobamos que los 8 primeros son números.
				caracter = DNI.charAt(i);
				if (Character.isDigit(caracter) == false) {
					esCorrecto = false;
				}
			i++;
			}while ((i<8) && (esCorrecto == true));
			// Si los 8 primeros son numeros, comprobamos que el 9 es un guión y el 10 una letra.
			if (esCorrecto) {
				if ((DNI.charAt(8) == '-') && (Character.isLetter(DNI.charAt(9)))){
					this.DNI = DNI;
					return esCorrecto;
				}
			}
						
		}
		//Si la longitud del DNI no es ni 8 ni 10, directamente esta mal y devolvemos false.
		return false;
		
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
	}	
}