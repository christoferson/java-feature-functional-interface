package demo;

import java.util.function.Predicate;

public class TryFunctionalInterface {

	public static void main(String[] args) {
		
		tryInterfacePredicate();

	}
	
	
	private static void tryInterfacePredicate() {
		Predicate<String> predicate = String::isEmpty;
		tryInterfacePredicateTest(predicate, "");
		tryInterfacePredicateTest(predicate, "n");
	}

	private static void tryInterfacePredicateTest(Predicate<String> predicate, String target) {
		System.out.println(predicate.test(target));
	}
}
