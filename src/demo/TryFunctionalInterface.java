package demo;

import java.util.function.Predicate;

import demo.interfaces.DemoFunctionalInterface;

public class TryFunctionalInterface {

	public static void main(String[] args) {
		
		tryInterfacePredicate();

		tryInterfaceCustom();
		
	}
	
	
	private static void tryInterfacePredicate() {
		Predicate<String> predicate = String::isEmpty;
		tryInterfacePredicateTest(predicate, "");
		tryInterfacePredicateTest(String::isBlank, "n");
	}

	private static void tryInterfacePredicateTest(Predicate<String> predicate, String target) {
		System.out.println(predicate.test(target));
	}
	
	private static void tryInterfaceCustom() {
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
