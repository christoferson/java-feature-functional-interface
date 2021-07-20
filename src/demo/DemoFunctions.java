package demo;

import java.util.function.Function;
import java.util.function.Predicate;

public class DemoFunctions {

	public static void predicate(Predicate<String> predicate, String target) {
		System.out.println(predicate.test(target));
	}
	

	public static void functions(Function<Integer, String> function, Integer in) {
		System.out.println(function.apply(in));
	}
}
