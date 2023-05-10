package plataformaMusical;

public class Cancion extends Multimedia {
	private Album album;
	private int duracion;

	public Cancion(String titulo, Artista artista, Album album, int a�o) {
        super(titulo, artista, a�o);
        this.album = album;
    }

	public Album getAlbum() {
	  return album;
	}
	
	public int getDuracion() {
		return duracion;
	}
}
