package com.roytuts.spring.mvc.and.spring.jdbc.util;

import java.util.regex.Pattern;

public final class Util {

	private Util() {
	}

	public static boolean isStringNumeric(String str) {
		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";
		final String Exp = "[eE][+-]?" + Digits;
		final String fpRegex = ("[\\0-\\x20]*[+-]?(NaN|Infinity|(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp
				+ ")?)|(\\.(" + Digits + ")(" + Exp + ")?)|(((0[xX]" + HexDigits + "(\\.)?)|(0[xX]" + HexDigits
				+ "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))[fFdD]?))[\\0-\\x20]*");
		if (Pattern.matches(fpRegex, str)) {
			return false;
		}
		return true;
	}

}
