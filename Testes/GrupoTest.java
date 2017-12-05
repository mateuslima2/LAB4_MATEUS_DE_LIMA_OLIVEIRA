import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import classes.Aluno;
import classes.Grupo;

public class GrupoTest {
	Grupo g1;
	Grupo g2;
	Grupo g3;
	Aluno a1;
	
	@Before
	public void iniciar() {
		g1 = new Grupo("DISCRETA");
		g2 = new Grupo("AA");
		g3 = new Grupo("AA");
		a1 = new Aluno("mateus lima","1","cc");
	}
	

	@Test(expected = NullPointerException.class)
	public void criarNomeNulo() {
		g1 = new Grupo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criarNomeVazio() {
		g1 = new Grupo("");
	}
	
	@Test
	public void alocarTest() {
		g1.alocar(a1);;
	}
	
	@Test
	public void testEquals() {
		assertEquals(g2,g3);
	}
	
	@Test
	public void testDiferenteEquals() {
		assertNotEquals(g1,g3);
	}
	
	@Test
	public void TesteImprimir() {
		g1.alocar(a1);
		assertEquals("* 1 - mateus lima - cc\n", g1.imprimir());
	}
}
