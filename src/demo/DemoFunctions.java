package demo;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class DemoFunctions {

	public static void predicate(Predicate<String> predicate, String target) {
		System.out.println(predicate.test(target));
	}

	public static void functions(Function<Integer, String> function, Integer in) {
		System.out.println(function.apply(in));
	}

	public static void functions(IntFunction<String> function, int in) {
		System.out.println(function.apply(in));
	}

	public static void functions(ToIntFunction<String> function, String in) {
		System.out.println(function.applyAsInt(in));
	}

	public static void functions(BiFunction<Integer, Integer, Long> function, Integer in1, Integer in2) {
		System.out.println(function.apply(in1, in2));
	}

	public static void functions(ToIntBiFunction<Integer, Integer> function, Integer in1, Integer in2) {
		System.out.println(function.applyAsInt(in1, in2));
	}


	public static void operator(UnaryOperator<BigDecimal> operator, BigDecimal num) {
		System.out.println(operator.apply(num));
	}

	public static void operator(BinaryOperator<BigDecimal> operator, BigDecimal num1, BigDecimal num2) {
		System.out.println(operator.apply(num1, num2));
	}
	
	public static void supplier(Supplier<BigDecimal> supplier) {
		System.out.println(supplier.get());
	}
	
	public static void consumer(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}
	
	public static void consumer(BiConsumer<String, Double> consumer, String str, Double num) {
		consumer.accept(str, num);
	}
}
