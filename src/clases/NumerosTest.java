package clases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumerosTest {

	static Numeros num = new Numeros(0);

	@ParameterizedTest
	@MethodSource("capicua")
	void testEsCapicua(int numero, boolean expected) {
		num.numero = numero;
		assertEquals(num.esCapicua(), expected);
	}

	private static Stream<Arguments> capicua() {
		return Stream.of(Arguments.of(100, false), Arguments.of(101, true));
	}
	
	@ParameterizedTest
	@MethodSource("primo")
	void testEsPrimo(int numero, boolean expected) {
		num.numero = numero;
		assertEquals(num.esPrimo(), expected);
	}

	private static Stream<Arguments> primo() {
		return Stream.of(Arguments.of(1, false), Arguments.of(4, false), Arguments.of(5, true), Arguments.of(23, true));
	}

}
