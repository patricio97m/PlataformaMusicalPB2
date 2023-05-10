package plataformaMusical;

import static org.junit.Assert.*;

import java.util.Set;

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
	  
	  @Test
	  public void AgregarCancionesAUnaPlaylist() {
	    Usuario usuario = plataforma.registrarUsuario("patricio", "password");
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 2);
	    Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario);
	    assertTrue(playlist.agregarCancion(cancion));
	    assertTrue(playlist.getCanciones().contains(cancion));
	  }
	  
	  @Test
	  public void EliminarCancionesDeUnaPlaylist() {
		Usuario usuario = plataforma.registrarUsuario("patricio", "password");
		Artista artista = plataforma.crearArtista("Queen", "Rock");
		Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
		Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 2);
		Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario);
	    playlist.agregarCancion(cancion);
	    assertTrue(playlist.eliminarCancion(cancion));
	    assertFalse(playlist.getCanciones().contains(cancion));
	  }
	  
	  @Test
	  public void ObtenerListaDeTodosLosArtistasDeLaPlataforma() {
	    Artista artista1 = plataforma.crearArtista("Queen", "Rock");
	    Artista artista2 = plataforma.crearArtista("David Bowie", "Rock");
	    Set<Artista> artistas = plataforma.getTodosLosArtistas();
	    assertEquals(2, artistas.size());
	    assertTrue(artistas.contains(artista1));
	    assertTrue(artistas.contains(artista2));
	  }
	  
	  @Test
	  public void ObtenerListaDeTodosLosAlbumnesDeLaPlataforma() {
	    Artista artista1 = plataforma.crearArtista("Queen", "Rock");
	    Artista artista2 = plataforma.crearArtista("David Bowie", "Rock");
	    Album album1 = plataforma.crearAlbum("Sheer Heart Attack", artista1, 1980);
	    Album album2 = plataforma.crearAlbum("Space Oddity", artista2, 1978);
	    Set<Album> albumes = plataforma.getTodosLosAlbumes();
	    assertEquals(2, albumes.size());
	    assertTrue(albumes.contains(album1));
	    assertTrue(albumes.contains(album2));
	  }
	  
	  @Test
	  public void ObtenerListaDeTodasLasCancionesDeLaPlataforma() {
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion1 = plataforma.crearCancion("Misfire", artista, album, 2);
	    Cancion cancion2 = plataforma.crearCancion("Stone Cold Crazy", artista, album, 2);
	    Set<Cancion> canciones = plataforma.getTodasLasCanciones();
	    assertEquals(2, canciones.size());
	    assertTrue(canciones.contains(cancion1));
	    assertTrue(canciones.contains(cancion2));
	  }
	 
	  
	  @Test
	  public void ObtenerPlaylistPorNombre() {
	    Usuario usuario = plataforma.registrarUsuario("Patricio", "password");
	    Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario);
	    Playlist playlistObtenida = plataforma.getPlaylistPorNombre("Mi playlist");
	    assertEquals(playlist, playlistObtenida);
	  }

}
