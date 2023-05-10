package plataformaMusical;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PruebaPlataformaMusical {

private Plataforma plataforma;
	
	@Before
	  public void setUp() {
	    plataforma = new Plataforma();
	  }

	@Test
	public void AutenticarUsuario() {
		Usuario usuario = plataforma.registrarUsuario("patricio", "password");
	    assertNotNull(usuario);
	    assertEquals("patricio", usuario.getUsuario());
	    assertTrue(usuario.checkearContraseña("password"));
	}
	
	@Test
	  public void CrearUnArtistaEnLaPlataforma() {
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    assertNotNull(artista);
	    assertEquals("Queen", artista.getNombre());
	    assertEquals("Rock", artista.getGenero());
	  }
	
	@Test
	  public void CrearUnAlbumEnLaPlataforma() {
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    assertNotNull(album);
	    assertEquals("Sheer Heart Attack", album.getTitulo());
	    assertEquals(artista, album.getArtista());
	  }
	
	  @Test
	  public void CrearUnaCancionEnLaPlataforma() {
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 2);
	    assertNotNull(cancion);
	    assertEquals("Misfire", cancion.getTitulo());
	    assertEquals(artista, cancion.getArtista());
	    assertEquals(album, cancion.getAlbum());
	  }

}
