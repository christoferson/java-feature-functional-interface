package demo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

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

}
