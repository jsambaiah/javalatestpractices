/**
 * 
 */
package com.learning.corejava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learning.company.dtos.Employee;

/**
 * @author ACJW8ZZ
 *
 */
public class BasicStreams {
	private static Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0), new Employee(3, "Mark Zuckerberg", 300000.0) };

	public static void definingStreams() {
		// Defining from arrays
		Stream.of(arrayOfEmps);

		// Defining with single object
		Stream.of(arrayOfEmps[0]);

		// Defining with multiple objects
		Stream.of(arrayOfEmps[0], arrayOfEmps[1]);

		// Defining from Array List
		Arrays.asList(arrayOfEmps).stream();
	}

	/**
	 * forEach is a terminal operation and it is simplest and most common operation;
	 * it loops over the stream elements, calling the supplied function on each
	 * element. Once operation is performed, the stream pipeline is considered
	 * consumed and can no longer be used.
	 * 
	 */
	public static void validateForEach() {
		Stream.of(arrayOfEmps).forEach(e -> e.salaryIncrement(1000.0));
		System.out.println("Icremented salaries " + Arrays.asList(arrayOfEmps));
	}

	/**
	 * map method of stream produces a new stream after applying a function to each
	 * element of the original stream. The new stream could be of different type.
	 */
	public static void validateMap() {
		ArrayList<List<Employee>> listOfListOfEmployees = new ArrayList<List<Employee>>();
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps));
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps).stream()
				.sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList()));
		List<Employee> employess = listOfListOfEmployees.stream().map(elements -> elements.stream().findAny().get())
				.collect(Collectors.toList());
		System.out.println("List of employees mapped " + employess);
	}

	/**
	 * A stream can hold complex data structures like Stream<List<String>>. In cases
	 * like this, flatMap() helps us to flatten the data structure to simplify
	 * further operations.
	 */
	public static void validateFlatMap() {
		ArrayList<List<Employee>> listOfListOfEmployees = new ArrayList<List<Employee>>();
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps));
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps).stream()
				.sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList()));
		List<Employee> employess = listOfListOfEmployees.stream().flatMap(elements -> elements.stream())
				.collect(Collectors.toList());
		System.out.println("List of employees mapped " + employess);
	}

	/**
	 * forEach is a terminal operation. But sometimes we need to perform multiple
	 * operations on each element of the stream before any terminal operation is
	 * applied.
	 */
	public static void validatePeek() {
		ArrayList<List<Employee>> listOfListOfEmployees = new ArrayList<List<Employee>>();
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps));
		listOfListOfEmployees.add(Arrays.asList(arrayOfEmps).stream()
				.sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList()));

		listOfListOfEmployees.stream().flatMap(elements -> elements.stream()).peek(e -> e.salaryIncrement(10.0))
				.peek(System.out::println).collect(Collectors.toList());
	}

	/**
	 * filter produces a new stream that contains elements of the original stream
	 * that pass a given test (specified by a Predicate).
	 * 
	 */
	public static void validateFilter() {
		System.out.println("Filtered list "
				+ Stream.of(arrayOfEmps).filter(e -> e.getSalary() > 200000).collect(Collectors.toList()));
	}

	public void whenFindFirst_thenGetFirstEmployeeInStream() {
		Employee employee = Arrays.asList(arrayOfEmps).stream().map(e -> e).filter(e -> e != null)
				.filter(e -> e.getSalary() > 100000).findFirst().orElse(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// BasicStreams.validatePeek();
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2); // 2, 4, 8, 16, 32, 64
		List<Integer> collect = infiniteStream.skip(3).limit(5).collect(Collectors.toList());
		System.out.println(collect);
	}

}
