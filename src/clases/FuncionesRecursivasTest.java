package clases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FuncionesRecursivasTest {

	@ParameterizedTest
	@MethodSource("sumatorio")
	void testSumatorio(int numero, int resultado) {
		assertEquals(resultado, FuncionesRecursivas.sumatorio(numero));
	}

	private static Stream<Arguments> sumatorio() {
		return Stream.of(Arguments.of(5, 15));
	}

	@ParameterizedTest
	@MethodSource("potencia")
	void testPotencia(double resultado, double a, int n) {
		assertEquals(resultado, FuncionesRecursivas.potencia(a, n));
	}
	
	private static Stream<Arguments> potencia() {
		return Stream.of(Arguments.of(4, 2, 2));
	}

	@ParameterizedTest
	@MethodSource("fibonacci")
	void testFibonacci(int numero, int resultado) {
		assertEquals(resultado, FuncionesRecursivas.fibonacci(numero));
	}
	
	private static Stream<Arguments> fibonacci() {
		return Stream.of(Arguments.of(5, 5));
	}

}
