package demo;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import demo.interfaces.DemoFunctionalInterface;

public class TryFunctionalInterface {

	public static void main(String[] args) {
		
		tryInterfacePredicate();
		
		tryInterfaceFunction();
		
		tryInterfaceIntFunction();
		
		tryInterfaceToIntFunction();

		tryInterfaceCustom();

	}
	
	
	private static void tryInterfacePredicate() {
		
		System.out.println("******* TryInterfacePredicate *******");
		
		Predicate<String> predicate = String::isEmpty;
		DemoFunctions.predicate(predicate, "");
		DemoFunctions.predicate(String::isBlank, "n");
		DemoFunctions.predicate(str -> str == null || str.isBlank(), "");

	}
	
	private static void tryInterfaceFunction() {
		
		System.out.println("******* TryInterfacePredicate *******");
		
		Function<Integer, String> function = num -> String.format("[%s]", num);
		DemoFunctions.functions(function, 78);
	}
	
	private static void tryInterfaceIntFunction() {
		
		System.out.println("******* TryInterfaceIntFunction *******");
		
		IntFunction<String> function = num -> String.format("[%s]", num);
		DemoFunctions.functions(function, 78);
	}
	
	private static void tryInterfaceToIntFunction() {
		
		System.out.println("******* TryInterfaceToIntFunction *******");
		
		ToIntFunction<String> function = str -> Integer.valueOf(str) + 2;
		DemoFunctions.functions(function, "78");
	}
	
	private static void tryInterfaceCustom() {
		
		System.out.println("******* TryInterfaceCustom *******");
		
		DemoFunctionalInterface<String> predicate = (v) -> {
			return "Data: " + String.valueOf(v);
		};
		tryInterfaceCustomTest(predicate, "094824934");
		tryInterfaceCustomTest((v) -> { return "IData: " + String.valueOf(v); }, 92873L);
	}

	private static <T> void tryInterfaceCustomTest(DemoFunctionalInterface<T> predicate, T target) {
		System.out.println(predicate.serialize(target));
	}
}
