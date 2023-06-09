import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

	private TestDemo testDemo;
	
	@BeforeEach
	public void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	public void assertThatTwoPosistiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
		
		static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
					arguments(3, 4, 7, false),
					arguments(-1, 5, 0, true),
					arguments(4, -2, 0, true),
					arguments(1, 1, 2, false)
					);
		}


		@Test
		void assertThatNumberSquaredIsCorrect() {
			TestDemo testDemo = new TestDemo();
			TestDemo MockDemo = spy(testDemo);
			doReturn(5).when(MockDemo).getRandomInt();
			
			int fiveSquared = MockDemo.randomNumberSquared();
			
			assertThat(fiveSquared).isEqualTo(25);
		}

	

}
