import static org.junit.Assert.*;
import org.junit.*;

import classes.Aluno;

public class AlunoTest {
	Aluno a1;
	Aluno a2;
	Aluno a3;
	
	@Before
	
	public void iniciar() {
		a2 = new Aluno("Mateus", "1", "cc");
		a3 = new Aluno("Mateus", "1", "cc");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarNomeNulo() {
		a1 = new Aluno(null, "200","CC");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarMatriculaNula() {
		a1 = new Aluno("Mateus Lima", null,"CC");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarCursoNulo() {
		a1 = new Aluno("Mateus Lima", "200", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarNomeVazio() {
		a1 = new Aluno("", "200","CC");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarMatriculaVazio() {
		a1 = new Aluno("Mateus Lima", "","CC");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarCursoVazio() {
		a1 = new Aluno("Mateus Lima", "200", "");
	}
	
	@Test
	public void equals() {
		assertEquals(a2,a3);
	}
	
	@Test
	public void diferentes() {
		assertNotEquals(a2,a1);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("1 - Mateus - cc\n", a2.toString());
	}

}
