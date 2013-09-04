package com.aps.utils;

/**
 * @author Anantha Sharma
 */
public final class TryParse {

	/**
	 * 
	 */
	private TryParse() {
		super();
	}

	/**
	 * tries to parse a given object to {@link Long}, returns null on failure.
	 * 
	 * @param value
	 * @return
	 */
	public static Long tryParseLong(Object value) {
		try {
			return Long.parseLong(value.toString());
		}
		catch (Exception e) {
			// ignore
		}
		return null;
	}

	/**
	 * tries to parse a given object to {@link Integer}, returns null on failure.
	 * 
	 * @param value
	 * @return
	 */
	public static Integer tryParseInteger(Object value) {
		try {
			return Integer.parseInt(value.toString());
		}
		catch (Exception e) {
			// ignore
		}
		return null;
	}

	/**
	 * tries to parse a given object to {@link Float}, returns null on failure.
	 * 
	 * @param value
	 * @return
	 */
	public static Float tryParseFloat(Object value) {
		try {
			return Float.parseFloat(value.toString());
		}
		catch (Exception e) {
			// ignore
		}
		return null;
	}

	/**
	 * tries to parse a given object to {@link Double}, returns null on failure.
	 * 
	 * @param value
	 * @return
	 */
	public static Double tryParseDouble(Object value) {
		try {
			return Double.parseDouble(value.toString());
		}
		catch (Exception e) {
			// ignore
		}
		return null;
	}

	/**
	 * tries to parse a given object to an enum, returns null on failure.
	 * 
	 * @param value
	 * @return
	 */
	public static Object tryParseEnum(Object value, Class<? extends Enum> emum) {
		try {
			Enum[] arr = emum.getEnumConstants();
			for (Enum enum1 : arr) {
				if (value instanceof Number) {
					// assuming we used Integer here.
					if (enum1.ordinal() == tryParseInteger(value)) {
						return enum1;
					}
				}
				else {
					// must be referenced by string.
					if (enum1.name().toLowerCase().equals(value.toString().toLowerCase())) {
						return enum1;
					}

				}
			}

			return null;
		}
		catch (Exception e) {
			// ignore
		}
		return null;
	}

	/**
	 * tries to parse a given object to {@link Boolean}, returns null on failure.
	 * 
	 * <pre>
	 * output:
	 * "1": returns TRUE
	 * "0": returns FALSE
	 * "true": returns TRUE <b> case insensitive </b>
	 * "false": returns FALSE <b> case insensitive </b>
	 * </pre>
	 * 
	 * @param object
	 * @return
	 */
	public static Boolean tryParseBoolean(Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof String) {
			return Boolean.parseBoolean(object.toString().trim().toUpperCase());
		}
		if (object instanceof Number) {
			return tryParseDouble(object) > 0;
		}
		return Boolean.FALSE;
	}
}
