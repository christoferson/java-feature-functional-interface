package demo;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import demo.interfaces.DemoFunctionalInterface;
import demo.model.DemoClass;

public class TryFunctionalInterface {

	public static void main(String[] args) {
		
		tryInterfacePredicate(); // Predicate<T> | boolean test(T t);
		
		tryInterfaceFunction(); // Function<T, R> | R apply(T t);
		
		tryInterfaceIntFunction(); // IntFunction<R> | R apply(int value);
		
		tryInterfaceToIntFunction(); // ToIntFunction<T> | int applyAsInt(T value);

		tryInterfaceBiFunction(); // BiFunction<T, U, R> | R apply(T t, U u);
		
		tryInterfaceToIntBiFunction();
		
		tryInterfaceUnaryOperator();
		
		tryInterfaceBinaryOperator(); // BinaryOperator<T> extends BiFunction<T,T,T> | T apply(T t, T u);
		
		tryInterfaceSupplier(); // Supplier<T> | T get();
		
		tryInterfaceSupplierPrimitives();
		
		tryInterfaceConsumer(); // Consumer<T> | void accept(T t);
		
		tryInterfaceBiConsumer(); // BiConsumer<T, U> | void accept(T t, U u);
		
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
		
		System.out.println("******* TryInterfaceFunction *******");
		
		Function<Integer, String> function = num -> String.format("[%s]", num);
		function = function.andThen(str -> { return String.format("(%s)", str);} );
		function = function.andThen(str -> { return String.format("{%s}", str);} );
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

	private static void tryInterfaceBiFunction() {
		
		System.out.println("******* TryInterfaceBiFunction *******");
		
		BiFunction<Integer, Integer, Long> function = (in1, in2) ->  Long.valueOf(in1 * in2);
		DemoFunctions.functions(function, 21, 17);
	}

	private static void tryInterfaceToIntBiFunction() {
		
		System.out.println("******* TryInterfaceToIntBiFunction *******");
		
		ToIntBiFunction<Integer, Integer> function = (in1, in2) ->  Integer.valueOf(in1 * in2);
		DemoFunctions.functions(function, 78, 12);
	}
	
	
	private static void tryInterfaceUnaryOperator() {
		
		System.out.println("******* TryInterfaceUnaryOperator *******");

		UnaryOperator<BigDecimal> operator = (dec) ->  dec.add(BigDecimal.valueOf(3));
		DemoFunctions.operator(operator, BigDecimal.valueOf(82));
	}
	
	private static void tryInterfaceBinaryOperator() {
		
		System.out.println("******* TryInterfaceBinaryOperator *******");

		BinaryOperator<BigDecimal> operator = (dec1, dec2) ->  dec1.add(dec2);
		DemoFunctions.operator(operator, BigDecimal.valueOf(82), BigDecimal.valueOf(71));
	}
	
	private static void tryInterfaceSupplier() {
		
		System.out.println("******* TryInterfaceSupplier *******");

		Supplier<BigDecimal> supplier = () ->  BigDecimal.valueOf(276);
		DemoFunctions.supplier(supplier);

		Supplier<DemoClass> classSupplier = DemoClass::new;
		System.out.println(classSupplier.get());
	}
	
	private static void tryInterfaceSupplierPrimitives() {
		
		System.out.println("******* TryInterfaceSupplierPrimitives *******");

		IntSupplier isupplier = () ->  817; // int getAsInt();
		System.out.println("IntSupplier: " + isupplier.getAsInt());
		
		LongSupplier lsupplier = () ->  854953; // int getAsInt();
		System.out.println("LongSupplier: " + lsupplier.getAsLong());
		
		DoubleSupplier dsupplier = () ->  78.223; // int getAsInt();
		System.out.println("DoubleSupplier: " + dsupplier.getAsDouble());
		
		BooleanSupplier bsupplier = () ->  false; // int getAsInt();
		System.out.println("BooleanSupplier: " + bsupplier.getAsBoolean());

	}
	
	private static void tryInterfaceConsumer() {
		
		System.out.println("******* TryInterfaceConsumer *******");

		Consumer<String> consumer = (val) -> System.out.print(val);
		consumer = consumer.andThen((val) -> System.out.println(val.toUpperCase()));
		DemoFunctions.consumer(consumer, "xyz");
	}
	
	private static void tryInterfaceBiConsumer() {
		
		System.out.println("******* TryInterfaceBiConsumer *******");

		BiConsumer<String, Double> consumer = (str, num) -> System.out.print(str + (num + 5.7));
		consumer = consumer.andThen((str, num) -> System.out.println(str.toUpperCase() + num));
		DemoFunctions.consumer(consumer, "abc", 716d);
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
