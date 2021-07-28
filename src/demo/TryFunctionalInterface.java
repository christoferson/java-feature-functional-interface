package demo;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

import demo.interfaces.DemoFunctionalInterface;
import demo.model.DemoClass;
import demo.utils.DemoFunctions;

public class TryFunctionalInterface {

	public static void main(String[] args) {
		
		tryInterfacePredicate(); // Predicate<T> | boolean test(T t);
		
		tryInterfacePredicateOthers();
		
		tryInterfaceBiPredicate();
		
		tryInterfaceFunction(); // Function<T, R> | R apply(T t);
		
		tryInterfaceIntFunction(); // IntFunction<R> | R apply(int value);
		
		tryInterfaceToIntFunction(); // ToIntFunction<T> | int applyAsInt(T value);

		tryInterfaceToFunctionOthers();
		
		tryInterfaceLongFunction();
		
		tryInterfaceDoubleFunction();
		
		tryInterfaceBiFunction(); // BiFunction<T, U, R> | R apply(T t, U u);
		
		tryInterfaceToIntBiFunction();
		
		tryInterfaceToLongBiFunction();
		
		tryInterfaceToDoubleBiFunction();
		
		tryInterfaceUnaryOperator();
		
		tryInterfaceBinaryOperator(); // BinaryOperator<T> extends BiFunction<T,T,T> | T apply(T t, T u);
		
		tryInterfaceSupplier(); // Supplier<T> | T get();
		
		tryInterfaceSupplierOthers();
		
		tryInterfaceConsumer(); // Consumer<T> | void accept(T t);
		
		tryInterfaceConsumerOthers();
		
		tryInterfaceBiConsumer(); // BiConsumer<T, U> | void accept(T t, U u);
		
		tryInterfaceBiConsumerOthers();
		
		tryInterfaceCustom();

	}
	
	
	private static void tryInterfacePredicate() {
		
		System.out.println("******* TryInterfacePredicate *******");
		
		// Predicate<T> | boolean test(T t);
		Predicate<String> predicate = String::isEmpty;
		DemoFunctions.predicate(predicate, "");
		DemoFunctions.predicate(String::isBlank, "n");
		DemoFunctions.predicate(str -> str == null || str.isBlank(), "");

	}
	
	private static void tryInterfacePredicateOthers() {
		
		System.out.println("******* TryInterfacePredicateOthers *******");
		
		// boolean test(int value);
		IntPredicate ipredicate = (num) -> num > 5;
		System.out.println("IntPredicate: " + ipredicate.test(10));

		// boolean test(long value);
		LongPredicate lpredicate = (num) -> num >= 50;
		System.out.println("LongPredicate: " + lpredicate.test(32));
	
		// boolean test(double value);
		DoublePredicate dpredicate = (num) -> num > 5.5;
		System.out.println("DoublePredicate: " + dpredicate.test(5.2));
		
		System.out.println();

	}
	
	private static void tryInterfaceBiPredicate() {
		
		System.out.println("******* TryInterfaceBiPredicate *******");
		
		// BiPredicate<T, U> | boolean test(T t, U u);
		BiPredicate<String, Integer> bipredicate = (str, num) -> Integer.valueOf(str) > num;
		System.out.println("BiPredicate: " + bipredicate.test("28", 27));

		DemoFunctions.bipredicate((n1, n2) -> n1 >= n2, 57, 98);
		
	}
	
	private static void tryInterfaceFunction() {
		
		System.out.println("******* TryInterfaceFunction *******");
		
		// Function<T, R> | R apply(T t);
		Function<Integer, String> function = num -> String.format("[%s]", num);
		function = function.andThen(str -> { return String.format("(%s)", str);} );
		function = function.andThen(str -> { return String.format("{%s}", str);} );
		DemoFunctions.functions(function, 78);

	}
	
	
	private static void tryInterfaceIntFunction() {
		
		System.out.println("******* TryInterfaceIntFunction *******");
		
		// int to Object  IntFunction<R> | R apply(int value);
		IntFunction<String> function = num -> String.format("[%s]", num);
		DemoFunctions.functions(function, 78);
		
		// int to long
		IntToLongFunction i2lfunction = num -> Long.valueOf(num);
		DemoFunctions.functions(i2lfunction, 56);
		
		// int to double
		IntToDoubleFunction i2dfunction = num -> Double.valueOf(num+0.75);
		DemoFunctions.functions(i2dfunction, 56);
	}
	
	private static void tryInterfaceLongFunction() {
		
		System.out.println("******* TryInterfaceLongFunction *******");
		
		// long to Object
		LongFunction<String> function = num -> String.format("[%s]", num);
		DemoFunctions.functions(function, 373902);
		
		// long to int
		LongToIntFunction l2ifunction = num -> Long.valueOf(num).intValue();
		DemoFunctions.functions(l2ifunction, 535l);
		
		// long to double
		LongToDoubleFunction l2dfunction = num -> Double.valueOf(num+0.75);
		DemoFunctions.functions(l2dfunction, 793l);

	}
	
	private static void tryInterfaceDoubleFunction() {
		
		System.out.println("******* TryInterfaceDoubleFunction *******");
		
		// double to Object
		DoubleFunction<String> function = num -> String.format("[%s]", num);
		DemoFunctions.functions(function, 1028d);
		
		// double to int
		DoubleToIntFunction d2ifunction = num -> Double.valueOf(num).intValue();
		DemoFunctions.functions(d2ifunction, 735.78);
		
		// double to long
		DoubleToLongFunction d2lfunction = num -> Double.valueOf(num).longValue();
		DemoFunctions.functions(d2lfunction, 9287.289);

	}
	
	private static void tryInterfaceToIntFunction() {
		
		System.out.println("******* TryInterfaceToIntFunction *******");
		
		ToIntFunction<String> function = str -> Integer.valueOf(str) + 2;
		DemoFunctions.functions(function, "78");
	}
	
	private static void tryInterfaceToFunctionOthers() {
		
		System.out.println("******* TryInterfaceToFunctionOthers *******");
		
		ToLongFunction<String> lfunction = num -> Long.valueOf(num);
		DemoFunctions.functions(lfunction, "78");
		
		ToDoubleFunction<String> dfunction = num -> Double.valueOf(num);
		DemoFunctions.functions(dfunction, "78.56");
		
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
	
	private static void tryInterfaceToLongBiFunction() {
		
		System.out.println("******* TryInterfaceToLongBiFunction *******");
		
		ToLongBiFunction<Integer, Integer> function = (in1, in2) ->  Long.valueOf(in1 + in2);
		DemoFunctions.bifunctions(function, 78, 12);
	}

	private static void tryInterfaceToDoubleBiFunction() {
		
		System.out.println("******* tryInterfaceToDoubleBiFunction *******");
		
		ToDoubleBiFunction<Integer, Integer> function = (in1, in2) ->  Double.valueOf(in1 + in2);
		DemoFunctions.bifunctions(function, 78, 12);
	}
	
	private static void tryInterfaceUnaryOperator() {
		
		System.out.println("******* TryInterfaceUnaryOperator *******");

		UnaryOperator<BigDecimal> operator = (dec) ->  dec.add(BigDecimal.valueOf(3));
		DemoFunctions.operator(operator, BigDecimal.valueOf(82));
		
		//IntUnaryOperator // int applyAsInt(int operand);
		IntUnaryOperator ioperator = i -> i + 1;
		DemoFunctions.operator(ioperator, 76);
		
		//LongUnaryOperator
		//DoubleUnaryOperator
		
	}
	
	private static void tryInterfaceBinaryOperator() {
		
		System.out.println("******* TryInterfaceBinaryOperator *******");

		BinaryOperator<BigDecimal> operator = (dec1, dec2) ->  dec1.add(dec2);
		DemoFunctions.operator(operator, BigDecimal.valueOf(82), BigDecimal.valueOf(71));
	
		//IntBinaryOperator
		//LongBinaryOperator
		//DoubleBinaryOperator
		
	}
	
	private static void tryInterfaceSupplier() {
		
		System.out.println("******* TryInterfaceSupplier *******");

		Supplier<BigDecimal> supplier = () ->  BigDecimal.valueOf(276);
		DemoFunctions.supplier(supplier);

		Supplier<DemoClass> classSupplier = DemoClass::new;
		System.out.println(classSupplier.get());
	}
	
	private static void tryInterfaceSupplierOthers() {
		
		System.out.println("******* TryInterfaceSupplierOthers *******");

		IntSupplier isupplier = () ->  817; // int getAsInt();
		System.out.println("IntSupplier: " + isupplier.getAsInt());
		
		LongSupplier lsupplier = () ->  854953; // long getAsLong();
		System.out.println("LongSupplier: " + lsupplier.getAsLong());
		
		DoubleSupplier dsupplier = () ->  78.223; // double getAsDouble();
		System.out.println("DoubleSupplier: " + dsupplier.getAsDouble());
		
		BooleanSupplier bsupplier = () ->  false; // boolean getAsBoolean();
		System.out.println("BooleanSupplier: " + bsupplier.getAsBoolean());

	}
	
	private static void tryInterfaceConsumer() {
		
		System.out.println("******* TryInterfaceConsumer *******");

		Consumer<String> consumer = (val) -> System.out.print(val);
		consumer = consumer.andThen((val) -> System.out.println(val.toUpperCase()));
		DemoFunctions.consumer(consumer, "xyz");
	}
	
	private static void tryInterfaceConsumerOthers() {
		
		System.out.println("******* TryInterfaceConsumerOthers *******");

		IntConsumer iconsumer = (val) -> System.out.println(val + (val+1));
		iconsumer.accept(398);

		LongConsumer lconsumer = (val) -> System.out.println(val + (val+2));
		lconsumer.accept(398);
		
		DoubleConsumer dconsumer = (val) -> System.out.println(val + (val+0.5));
		dconsumer.accept(398);
		
		System.out.println("");
	}
	
	private static void tryInterfaceBiConsumer() {
		
		System.out.println("******* TryInterfaceBiConsumer *******");

		BiConsumer<String, Double> consumer = (str, num) -> System.out.print(str + (num + 5.7));
		consumer = consumer.andThen((str, num) -> System.out.println(str.toUpperCase() + num));
		DemoFunctions.consumer(consumer, "abc", 716d);
	}
	
	private static void tryInterfaceBiConsumerOthers() {
		
		System.out.println("******* TryInterfaceBiConsumerOthers *******");

		ObjIntConsumer<String> oiconsumer = (str, num) -> System.out.println(String.format("Object=%s int=%s", str, num)); // void accept(T t, int value);
		oiconsumer.accept("stringobject", 928);
		
		ObjLongConsumer<String> olconsumer = (str, num) -> System.out.println(String.format("Object=%s long=%s", str, num)); // void accept(T t, long value);
		olconsumer.accept("stringobject", 87363);
		
		ObjDoubleConsumer<String> odconsumer = (str, num) -> System.out.println(String.format("Object=%s double=%s", str, num)); // void accept(T t, double value);
		odconsumer.accept("stringobject", 837.23);
		
		System.out.println();

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
