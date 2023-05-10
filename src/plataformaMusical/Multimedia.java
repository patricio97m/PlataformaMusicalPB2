package plataformaMusical;

public class Multimedia {
	//Multimedia es una clase abstracta que sirve para representar los elementos en com�n que tienen "Album" y "Cancion"
	private String titulo;
	private Artista artista;
	private int a�o;

	public Multimedia(String titulo, Artista artista, int a�o) {
	    this.titulo 	= titulo;
	    this.artista 	= artista;
	    this.a�o 		= a�o;
	}

	public String getTitulo() {
	    return titulo;
	}

	public void setTitulo(String titulo) {
	    this.titulo = titulo;
	}

	public Artista getArtista() {
	   return artista;
	}

	public void setArtista(Artista artista) {
	    this.artista = artista;
	}

	public int getA�o() {
	    return a�o;
	}

	public void setA�o(int a�o) {
	   this.a�o = a�o;
	}
}
