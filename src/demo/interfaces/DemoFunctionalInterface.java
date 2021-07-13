package demo.interfaces;

@FunctionalInterface
public interface DemoFunctionalInterface<T> {

	String serialize(T t);
	
	default boolean supported(Class<T> c) {
		return String.class.equals(c);
	}
	
	static String version() {
		return "1.1";
	}
	
}
