package plataformaMusical;

public class Usuario {
	private String usuario;
	private String contrase�a;

	public Usuario(String usuario, String contrase�a) {
	  this.usuario 		= usuario;
	  this.contrase�a 	= contrase�a;
	}

	public String getUsuario() {
	  return usuario;
	}

	public boolean checkearContrase�a(String contrase�a) {
	  return this.contrase�a.equals(contrase�a);
	}
}
