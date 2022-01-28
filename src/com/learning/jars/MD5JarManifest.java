/**
 * 
 */
package com.learning.jars;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Tool for getting md5sums from classes in a jar. Useful for diffing jars.
 */
public class MD5JarManifest {
	private final static String salt="36e5Jq00jrgaf501FFxwe1wIJMdR(j7pnJAa$XtKygo8WMZ0VP";
	private static class ClassFileHash {
		private String classname;
		private String md5sum;

		public ClassFileHash(String classname, BigInteger hashsum) {
			this.classname = classname;
			this.md5sum = hashsum.toString(16);
			if (md5sum.length() < 32) {
				StringBuffer sb = new StringBuffer();
				int pad = 32 - md5sum.length();
				for (int i = 0; i < pad; i++)
					sb.append("0");
				md5sum = sb.toString() + md5sum;
			}
		}

		public String toString() {
			return md5sum + "  " + classname;
		}
	}

	private static List<ClassFileHash> getClassManifest(JarFile jarFile) throws IOException {
		List<ClassFileHash> checksums = new ArrayList<ClassFileHash>();
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()) {
				String name = entry.getName();
				InputStream input = jarFile.getInputStream(entry);
				BigInteger md5 = getMD5Hash(input);
				checksums.add(new ClassFileHash(name, md5));
			}
		}
		return checksums;
	}

	public static BigInteger getMD5Hash(InputStream input) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			throw new RuntimeException(e1);
		}
		BigInteger bigInt;
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while ((read = input.read(buffer)) > 0) {
				digest.update(buffer, 0, read);
			}
			byte[] md5sum = digest.digest();
			bigInt = new BigInteger(1, md5sum);
		} catch (IOException e) {
			throw new RuntimeException("Unable to process file for MD5", e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
			}
		}
		return bigInt;
	}

	public static void writeCheckSum(Writer writer, JarFile jar) throws IOException {
		List<ClassFileHash> checksums = getClassManifest(jar);
		for (ClassFileHash sum : checksums) {
			writer.write(sum.toString() + "\n");
		}
		writer.close();
	}

	/**
	 * Run from the commandline, args are the jar files, print to standard out
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args == null || args.length == 0) {
			System.out.println("Please supply name of jar file as command-line argument");
		}
		for (String filename : args) {
			JarFile jar = new JarFile(filename);
			writeCheckSum(new OutputStreamWriter(System.out), jar);
		}
	}

}
