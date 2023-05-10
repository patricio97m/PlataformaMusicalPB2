package plataformaMusical;

public class Usuario {
	private String usuario;
	private String contraseņa;

	public Usuario(String usuario, String contraseņa) {
	  this.usuario 		= usuario;
	  this.contraseņa 	= contraseņa;
	}

	public String getUsuario() {
	  return usuario;
	}

	public boolean checkearContraseņa(String contraseņa) {
	  return this.contraseņa.equals(contraseņa);
	}
}
