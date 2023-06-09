package plataformaMusical;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.List;
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
	    Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 200);
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
	    Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 200);
	    Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario);
	    assertTrue(playlist.agregarCancion(cancion));
	    assertTrue(playlist.getCanciones().contains(cancion));
	  }
	  
	  @Test
	  public void EliminarCancionesDeUnaPlaylist() {
		Usuario usuario = plataforma.registrarUsuario("patricio", "password");
		Artista artista = plataforma.crearArtista("Queen", "Rock");
		Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
		Cancion cancion = plataforma.crearCancion("Misfire", artista, album, 200);
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
	    Cancion cancion1 = plataforma.crearCancion("Misfire", artista, album, 200);
	    Cancion cancion2 = plataforma.crearCancion("Stone Cold Crazy", artista, album, 200);
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
	  
	  @Test
	  public void ObtenerUsuarioPorNombre() {
	    Usuario usuario = plataforma.registrarUsuario("Patricio", "password");
	    Usuario usuarioObtenido = plataforma.getusuarioPorNombre("Patricio");
	    assertEquals(usuario, usuarioObtenido);
	  }
	  
	  @Test
	  public void ObtenerTodasLasPlaylistDeLaPlataforma() {
	    Usuario usuario1 = plataforma.registrarUsuario("Patricio", "password");
	    Usuario usuario2 = plataforma.registrarUsuario("Rocio", "password");
	    Playlist playlist1 = plataforma.crearPlaylist("Playlist de Patricio", usuario1);
	    Playlist playlist2 = plataforma.crearPlaylist("Playlist de Rocio", usuario2);
	    List<Playlist> playlists = plataforma.getTodasLasPlaylist();
	    assertEquals(2, playlists.size());
	    assertTrue(playlists.contains(playlist1));
	    assertTrue(playlists.contains(playlist2));
	  }
	  
	  @Test
	  public void QueNoSePuedaCrearCancionesDuplicadasEnLaPlaylist() {
		Usuario usuario1 = plataforma.registrarUsuario("Patricio", "password");
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion = plataforma.crearCancion("Mistify", artista, album, 200);
	    Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario1);
	    assertTrue(playlist.agregarCancion(cancion));
	    assertFalse(playlist.agregarCancion(cancion)); //La canción no debería agregarse dos veces
	    assertTrue(playlist.getCanciones().contains(cancion));
	    }
	  
	  @Test
	  public void ObtenerCancionesDeUnaPlaylist() {
	    Usuario usuario1 = plataforma.registrarUsuario("Patricio", "password");
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion1 = plataforma.crearCancion("Mistify", artista, album, 200);
	    Cancion cancion2 = plataforma.crearCancion("Sheer Heart Attack", artista, album, 200);
	    Playlist playlist = plataforma.crearPlaylist("Mi playlist", usuario1);
	    assertTrue(playlist.agregarCancion(cancion1));
	    assertTrue(playlist.agregarCancion(cancion2));
	      
	    Set<Cancion> cancionesEnPlaylist = playlist.getCanciones();
	    Set<Cancion> cancionesEsperadas = new LinkedHashSet<>();
	    cancionesEsperadas.add(cancion1);
	    cancionesEsperadas.add(cancion2);
	    assertEquals(cancionesEnPlaylist, cancionesEsperadas);
	  }
	  
	  @Test
	  public void ObtenerCancionesDeUnDisco() {
	    Artista artista = plataforma.crearArtista("Queen", "Rock");
	    Album album = plataforma.crearAlbum("Sheer Heart Attack", artista, 1980);
	    Cancion cancion1 = plataforma.crearCancion("Mistify", artista, album, 120);
	    Cancion cancion2 = plataforma.crearCancion("Sheer Heart Attack", artista, album, 130);
	    Cancion cancion3 = plataforma.crearCancion("Stone Cold Crazy", artista, album, 150);
	    album.agregarCancion(cancion1);
	    album.agregarCancion(cancion2);
	    album.agregarCancion(cancion3);
	      
	    Set<Cancion> cancionesEnElDisco = album.getCanciones();
	    Set<Cancion> cancionesEsperadas = new LinkedHashSet<>();
	    cancionesEsperadas.add(cancion1);
	    cancionesEsperadas.add(cancion2);
	    cancionesEsperadas.add(cancion3);
	    assertEquals(cancionesEnElDisco, cancionesEsperadas);
	  }
	  
	  public void ObtenerDuracionDeUnDisco() {
	    Artista artista = new Artista("Queen", "Rock");
	    Album album = new Album("Sheer Heart Attack", artista, 1980);
	    Cancion cancion1 = new Cancion("Sheer Heart Attack", artista, album, 120);
	    Cancion cancion2 = new Cancion("Mistify", artista, album, 180);
	    Cancion cancion3 = new Cancion("Stone Cold Crazy", artista, album, 240);
	        
	    album.agregarCancion(cancion1);
	    album.agregarCancion(cancion2);
	    album.agregarCancion(cancion3);
	        
	    int duracionEsperada = cancion1.getDuracion() + cancion2.getDuracion() + cancion3.getDuracion();
	    int duracionObtenida = album.obtenerDuracion();
	        
	    assertEquals(duracionEsperada, duracionObtenida);
	  }

}
