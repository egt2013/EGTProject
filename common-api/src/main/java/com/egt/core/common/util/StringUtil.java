package com.egt.core.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class StringUtil {

	private static Locale thaiLocale = new Locale("th", "TH");
	private static Locale engLocale = new Locale("en", "EN");

	public static String[] getStrArray(String str, String delimiter) {
		StringTokenizer strTokenizer = new StringTokenizer(str, delimiter, true);
		String[] tmpArry = null;
		String[] retArry = null;
		int i = 0;
		int arryCount = 0;
		String token = "";
		if (strTokenizer.countTokens() > 0) {
			tmpArry = new String[strTokenizer.countTokens()];
			while (strTokenizer.hasMoreTokens()) {
				token = strTokenizer.nextToken();
				if (token.equals(delimiter)) {
					arryCount++;
				}
				tmpArry[i++] = token;
			}
		}
		if ((arryCount > 0) || (tmpArry != null)) {
			retArry = new String[arryCount + 1];
		}
		if (retArry != null) {
			token = "";
			i = 0;
			int k = 0;
			for (int j = 0; j < tmpArry.length; j++) {
				token = tmpArry[j];
				k++;
				if (token.equals(delimiter)) {
					if (k % 2 == 1) {
						retArry[i++] = "";
						k++;
					}
				} else {
					retArry[i++] = token;
				}
			}
			if (retArry[arryCount] == null) {
				retArry[arryCount] = "";
			}
		}
		return retArry;
	}

	public static List<String> getStrList(String str, String delimiter) {
		StringTokenizer strTokenizer = new StringTokenizer(str, delimiter, true);
		List<String> retList = new ArrayList<String>();
		String token = "";
		if (strTokenizer.countTokens() > 0) {
			while (strTokenizer.hasMoreTokens()) {
				token = strTokenizer.nextToken();
				if (!token.equals(delimiter)) {
					retList.add(token);
				}

			}
		} else {
			retList.add(null);
		}

		return retList;
	}

	public static boolean isNull(String input) {
		if (input == null || input.equals("") || "null".equalsIgnoreCase(input)) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String input) {
		if (input == null || input.trim().equals("")
				|| "null".equalsIgnoreCase(input)) {
			return true;
		}
		return false;
	}

	public static String concatStringToSql(String valueArr[],
			boolean convNumFlag, boolean singleQuoteFlag) {
		StringBuffer valueBuff = new StringBuffer();
		String values = "''";
		if (valueArr != null) {
			for (int i = 0; i < valueArr.length; i++) {
				String valueStr = "";
				valueStr = (convNumFlag) ? convertToNumber(valueArr[i])
						: valueArr[i];
				valueStr = (singleQuoteFlag) ? addSingleQuote(valueStr)
						: valueStr;
				valueBuff.append(valueStr + ",");
			}
			// split comma(,) in the last character
			if (!StringUtil.isEmpty(valueBuff.toString()))
				values = valueBuff.toString().substring(0,
						valueBuff.toString().length() - 1);

		}
		return values;
	}

	public static String concatStringToSql(List valueLst, boolean singleQuoteFlag) throws Exception {
		StringBuffer valueBuff = new StringBuffer();
		String values = "''";
		if (valueLst != null) {
			for (int i = 0; i < valueLst.size(); i++) {
				String valueStr = "";
				valueStr = (singleQuoteFlag) ? addSingleQuote((String) valueLst
						.get(i)) : (String) valueLst.get(i);
				valueBuff.append(valueStr + ",");
			}
			// split comma(,) in the last character
			if (!StringUtil.isEmpty(valueBuff.toString())) {
				values = valueBuff.toString().substring(0,
						valueBuff.toString().length() - 1);
			}

		}
		return values;
	}

	public static String convertToNumber(String valStr) {
		String numStr = "0";
		try {
			if (!StringUtil.isEmpty(valStr))
				valStr = replace(valStr, ",", "");
			numStr = String.valueOf(Integer.parseInt(notNullAndTrim(valStr)));
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numStr;
	}

	public static String addSingleQuote(String valStr) {
		valStr = "'" + notNullAndTrim(valStr) + "'";
		return valStr;
	}

	public static String nullOrBlankStrToStr(String str, String initStr) {
		return ((str == null) || (str.equals("")) ? initStr : str.trim());
	}

	public static String notNullAndTrim(String str) {
		if (str == null || "null".equalsIgnoreCase(str))
			return "";
		return str.trim();
	}

	public static String notNull(String str) {
		if (str == null)
			return "";
		return str;
	}

	public static String replace(String s, String oldChar, String newChar) {
		String value = "";
		try {
			if (!StringUtil.isEmpty(s)) {
				value = StringUtil.notNull(s).replace(oldChar, newChar);
				// value = StringUtils.replace(s,oldValue,newValue);
			} else {
				value = "";
			}
		} catch (Exception e) {
			value = "";
		}
		return value;
	}

	public static String concatString(String str, int length, String concatStr) {
		if (!StringUtil.isEmpty(str) && 0 != length) {
			str = StringUtil.notNullAndTrim(str);
			if (str.length() < length) {
				for (int i = str.length(); i < length; i++) {
					str = concatStr + str;
				}
			}
		}
		return str;
	}

	public static String findErrStatus(int status) {
		String message = "";
		if (status == 400) {
			message = status + ":" + "Bad Request";
		} else if (status == 403) {
			message = status + ":" + "Forbidden";
		} else if (status == 404) {
			message = status + ":" + "Not Found";
		} else if (status == 500) {
			message = status + ":" + "Internal Server Error";
		} else {
			message = status + ":" + "Server Errors";
		}
		return message;
	}

}
