/**
 * 
 */
package com.learning.patterns;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueSetConceptNameFilter {

	private Pattern namePattern;
	private Matcher matcher;

	public ValueSetConceptNameFilter(String namePattern) {
		if (namePattern.startsWith(".*"))
			namePattern = namePattern.substring(2);
		if (namePattern.endsWith(".*"))
			namePattern = namePattern.substring(0, namePattern.length() - 2);
		this.namePattern = Pattern.compile(namePattern);
		this.matcher = this.namePattern.matcher("");
	}

	public boolean filterConcept(String concept) {
		try {
			return CompletableFuture.supplyAsync(() -> execute(concept)).get(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		} catch (TimeoutException e) {
			throw new RuntimeException(e);
		}
	}

	public Boolean execute(String concept) {
		return matcher.reset(concept).find();
	}

	public String getNamePattern() {
		return namePattern.toString();
	}

	public void setNamePattern(String namePattern) {
		this.namePattern = Pattern.compile(namePattern);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namePattern == null) ? 0 : namePattern.pattern().hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueSetConceptNameFilter other = (ValueSetConceptNameFilter) obj;
		if (namePattern == null) {
			if (other.namePattern != null)
				return false;
		} else if (!namePattern.pattern().equals(other.namePattern.pattern()))
			return false;
		return true;
	}

	public static void main(String[] args) {
		ValueSetConceptNameFilter vs = new ValueSetConceptNameFilter("(A+)C");
		System.out.println(vs.filterConcept(
				"AAAAAAAAAAAAAAAAAAAAAAAAAC"));
	}
}
