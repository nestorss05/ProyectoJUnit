package clases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CadenasTest {

	@ParameterizedTest
	@MethodSource("espacios")
	void testCuentaEspacios(String cadena, int espacios) {

		Cadenas cad = new Cadenas(cadena);
		assertEquals(espacios, cad.cuentaEspacios());

	}

	private static Stream<Arguments> espacios() {
		return Stream.of(Arguments.of("Fokin", 0), Arguments.of("Fokin RENFE Cercanias", 2));
	}
	
	@ParameterizedTest
	@MethodSource("reves")
	void testDelReves(String cadena, String reves) {

		Cadenas cad = new Cadenas(cadena);
		assertEquals(reves, cad.delReves());

	}

	private static Stream<Arguments> reves() {
		return Stream.of(Arguments.of("Fokin", "nikoF"));
	}
	
	@ParameterizedTest
	@MethodSource("contador")
	void testDelReves(String cadena, String palabraBuscada, int npalabras) {

		Cadenas cad = new Cadenas(cadena);
		assertEquals(npalabras, cad.contarPalabra(palabraBuscada));

	}

	private static Stream<Arguments> contador() {
		return Stream.of(Arguments.of("El servicio de RENFE es una tremenda basura", "RENFE", 1));
	}


}
