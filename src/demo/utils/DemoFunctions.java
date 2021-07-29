package demo.utils;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public class DemoFunctions {

	public static void predicate(Predicate<String> predicate, String target) {
		System.out.println(predicate.test(target));
	}
	 
	public static <U, V> void bipredicate(BiPredicate<U, V> predicate, U v1, V v2) {
		System.out.println(predicate.test(v1, v2));
	}
	
	public static void functions(Function<Integer, String> function, Integer in) {
		System.out.println(function.apply(in));
	}

	public static void functions(IntFunction<String> function, int in) {
		System.out.println(function.apply(in));
	}
	
	public static void functions(IntToLongFunction function, int in) {
		System.out.println(function.applyAsLong(in));
	}
	
	public static void functions(IntToDoubleFunction function, int in) {
		System.out.println(function.applyAsDouble(in));
	}
	
	public static void functions(ToIntFunction<String> function, String in) {
		System.out.println(function.applyAsInt(in));
	}
	
	public static void functions(LongFunction<String> function, long in) {
		System.out.println(function.apply(in));
	}

	public static void functions(LongToIntFunction function, long in) {
		System.out.println(function.applyAsInt(in));
	}
	
	public static void functions(LongToDoubleFunction function, long in) {
		System.out.println(function.applyAsDouble(in));
	}
	
	public static void functions(DoubleFunction<String> function, double in) {
		System.out.println(function.apply(in));
	}
	
	public static void functions(DoubleToIntFunction function, double in) {
		System.out.println(function.applyAsInt(in));
	}
	
	public static void functions(DoubleToLongFunction function, double in) {
		System.out.println(function.applyAsLong(in));
	}
	
	public static void functions(ToLongFunction<String> function, String in) {
		System.out.println(function.applyAsLong(in));
	}

	public static void functions(ToDoubleFunction<String> function, String in) {
		System.out.println(function.applyAsDouble(in));
	}	
	
	public static void functions(BiFunction<Integer, Integer, Long> function, Integer in1, Integer in2) {
		System.out.println(function.apply(in1, in2));
	}

	public static void functions(ToIntBiFunction<Integer, Integer> function, Integer in1, Integer in2) {
		System.out.println(function.applyAsInt(in1, in2));
	}
	
	public static void bifunctions(ToLongBiFunction<Integer, Integer> function, Integer in1, Integer in2) {
		System.out.println(function.applyAsLong(in1, in2));
	}
	
	public static void bifunctions(ToDoubleBiFunction<Integer, Integer> function, Integer in1, Integer in2) {
		System.out.println(function.applyAsDouble(in1, in2));
	}

	public static <T> void operator(UnaryOperator<T> operator, T num) {
		T result = operator.apply(num);
		System.out.println(result);
	}
	
	public static void operator(IntUnaryOperator operator, int num) {
		System.out.println(operator.applyAsInt(num));
	}

	public static void operator(LongUnaryOperator operator, long num) {
		System.out.println(operator.applyAsLong(num));
	}
	
	public static void operator(DoubleUnaryOperator operator, double num) {
		System.out.println(operator.applyAsDouble(num));
	}
	
	public static <T> void BinaryOperator(BinaryOperator<T> operator, T num1, T num2) {
		T result = operator.apply(num1, num2);
		System.out.println(result);
	}

	public static <T> void BinaryOperator(IntBinaryOperator operator, int num1, int num2) {
		int result = operator.applyAsInt(num1, num2);
		System.out.println(result);
	}
	
	public static <T> void BinaryOperator(LongBinaryOperator operator, long num1, long num2) {
		long result = operator.applyAsLong(num1, num2);
		System.out.println(result);
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
