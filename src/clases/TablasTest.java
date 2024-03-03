package clases;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TablasTest {

	@ParameterizedTest
	@MethodSource("esmagica")
	void testEsMagica(int tabla[][]) {
		assertTrue(Tablas.esMagica(tabla));
	}
	
	private static Stream<Arguments> esmagica() {
		return Stream.of(Arguments.of(new int[][] {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}));
	}
	
	@ParameterizedTest
	@MethodSource("esmagicant")
	void testEsMagicant(int tabla[][]) {
		assertFalse(Tablas.esMagica(tabla));
	}
	
	private static Stream<Arguments> esmagicant() {
		return Stream.of(Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
	
	@ParameterizedTest
	@MethodSource("esinvalida")
	void testEsInvalida(int tabla[][]) {
		assertFalse(Tablas.esMagica(tabla));
	}
	
	private static Stream<Arguments> esinvalida() {
		return Stream.of(Arguments.of(new int[][] {{1, 2}, {3, 4, 5}}, new int[][] {}));
	}

	@ParameterizedTest
	@MethodSource("gira90")
	void testGira90(int tabla[][], int tablaFinal[][]) {
		assertArrayEquals(tablaFinal, Tablas.gira90(tabla));
	}
	
	private static Stream<Arguments> gira90() {
		return Stream.of(Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));
	}
	
	@ParameterizedTest
	@MethodSource("gira90nt")
	void testGira90nt(int tablaInicio[][]) {
		assertNull(Tablas.gira90(tablaInicio));
	}
	
	private static Stream<Arguments> gira90nt() {
		return Stream.of(Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}}, new int[][]{{7, 4, 1}, {8, 5, 6}, {9}}, new int[][] {null}));
	}

}
