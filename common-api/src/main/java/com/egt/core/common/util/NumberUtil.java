package com.egt.core.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtil {
	public static BigDecimal nullToZero(BigDecimal val) {
		return (val!=null)?val:BigDecimal.ZERO;
	}
	
	public static Long nullToZero(Long val) {
		return (val!=null)?val:0L;
	}
	
	public static Long zeroToNull(Long val){
		Long result = null;
		if(isNullOrZero(val)){
			result = null;
		}else{
			result = val;
		}
		return result;
	}
	
	public static Long zeroToNull(String val){
		Long result = null;
		Long lVal = NumberUtil.parseStringToLong(val);
		if(isNullOrZero(lVal)){
			result = null;
		}else{
			result = lVal;
		}
		return result;
	}
	
	public static Double nullToZero(Double val) {
		return (val!=null)?val:0;
	}
	
	public static boolean isNullOrZero(Double val){
		boolean result = false;
		if(val == null || val == 0){
			result = true;
		}
		return result;
	}
	
	public static boolean isNullOrZero(Long val){
		boolean result = false;
		if(val == null || val == 0){
			result = true;
		}
		return result;
	}
	
	public static boolean isNull(Double val){
		boolean result = false;
		if(val == null){
			result = true;
		}
		return result;
	}
	
	public static boolean isZero(int val){
		boolean result = false;
		if(val == 0){
			result = true;
		}
		return result;
	}
	
	public static boolean isNull(Long val){
		boolean result = false;
		if(val == null){
			result = true;
		}
		return result;
	}
	
	public static boolean isNull(BigDecimal val){
		boolean result = false;
		if(val == null){
			result = true;
		}
		return result;
	}
	
	public static Long parseStringToLong(String val){
		if(!StringUtil.isEmpty(val)){
			return Long.valueOf(val.replaceAll(",", ""));
		}else{
			return null;
		}
	}
	
	public static int parseStringToInt(String val){
		if(!StringUtil.isEmpty(val)){
			return Integer.parseInt(val.replaceAll(",", ""));
		}else{
			return 0;
		}
	}
	
	public static Double parseStringToDouble(String val){
		if(!StringUtil.isEmpty(val)){
			return Double.valueOf(val.replaceAll(",", ""));
		}else{
			return null;
		}
	}
	
	public static boolean isDouble(String val){
		boolean isDouble = false;
		try{
			if(parseStringToDouble(val) != null){
				isDouble = true;
			}
		}catch(Exception ex){
			isDouble = false;
		}
		return isDouble;
	}
	
	public static Long parseLongEmpty(Long val){
		if(val==null){
			return -1L;
		}
		return val;
	}
	
	public static Long parseNullToZero(Long val){
		if(val == null) return 0l;
		return val;
	}
	
	public static Double parseNullToZero(Double val){
		if(val == null) return Double.valueOf(0);
		return val;
	}

	private static NumberFormat moneyFormat = NumberFormat.getNumberInstance();	
	private static DecimalFormat df = new DecimalFormat("#,###,###.00");
		
	public static String getCurrencyFormat(long number){
		DecimalFormat currencyFormat = new DecimalFormat();
		currencyFormat.setDecimalSeparatorAlwaysShown(true);
		currencyFormat.setMaximumFractionDigits(2);
		currencyFormat.setMinimumFractionDigits(2);

		return currencyFormat.format(number);
	}
	
	public static String toNumberStr(double value, int precision){
		String formatStr = "###0";
		if(precision > 0){
		formatStr += ".";
		for(int i = 0; i < precision; i++){
		formatStr += "0";
		}
		}
		DecimalFormat decFormat = new DecimalFormat(formatStr);

		return decFormat.format(value);
	}

	public static String parseDouble(double d) throws Exception{
		String result = "";
		try{
			NumberFormat formatter = new DecimalFormat("0.00");
			result = formatter.format(d);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public static String toCurrency(String money){
		//money = "22123.65";
		//String s = toNumberStr(new Double(money), 2);
		//DecimalFormat formatter = new DecimalFormat("#,###,###.00");		
		//String s = formatter.format(new BigDecimal(money));					
		if(money!=null && !money.equals("")){
			if(new Double(money) != 0){
				return df.format(new Double(money));
			}
			else{
				return "0.00";
			}
		}
		else{
			return "0.00";
		}		
	}
	
	public static String toCurrency(double money){
		//money = "22123.65";
		//String s = toNumberStr(new Double(money), 2);
		//DecimalFormat formatter = new DecimalFormat("#,###,###.00");		
		//String s = formatter.format(new BigDecimal(money));					
		
		if(money != 0.0){
			return df.format(money);
		}
		else{
			return "0.00";
		}
	}
	
	public static NumberFormat getMoneyFormat() {
		return moneyFormat;
	}
	public static void setMoneyFormat(NumberFormat moneyFormat) {
		NumberUtil.moneyFormat = moneyFormat;
	}	
	
	public static String formatAmountToCurrency(String amount){
		String result = "";
		amount = StringUtil.notNullAndTrim(amount);
		int digit = amount.length();	
		
		if(digit==0){
			//if amount equals to null, emptyString("") or "null"
			//result will be 0.00
			result = "0.00";
			
		}else if(digit==1){
			//if amount equals to 1 digit such as 5
			//result will be 0.05
			result = "0.0"+amount;
			
		}else if(digit==2){
			//if amount equals to 2 digit such as 50
			//result will be 0.50
			result = "0."+amount;
			
		}else if(digit > 2){
			//if amount more than 2 digit such as 150075
			//result will be 1500.75
			String number = amount.substring(0,digit-2);	
			String dicimal = amount.substring(digit-2);
			result = number + "." + dicimal;	
		}
		
		return result;
	}
	
	public static String formatIPayAmountToBankAmount(String amount){
		String formatAmount = "";
		if(amount==null || amount.equals("")){
			amount = "0.00";
		}
		
		int index = amount.indexOf(".");
		if(index>0){
			// Such as 12.34 -> 1234
			String num = amount.substring(0,index);
			String decimal = amount.substring(index+1);
			formatAmount = num+decimal;
		}else if(index==0){
			// Such as .34 -> 034
			formatAmount = "0"+amount.substring(index+1);
		}else{
			// Such as 12 -> 1200
			formatAmount = amount+"00";
		}
		
		return formatAmount;
	}
	
	public static boolean isSameAmount(double send, double receive)throws Exception{
		boolean sameAmount = false;
		
		if(send==receive){
			sameAmount = true;
		}
		return sameAmount;
	}
	
	public static Double toCurrencyDouble(double money){
		//money = "22123.65";
		//String s = toNumberStr(new Double(money), 2);
		//DecimalFormat formatter = new DecimalFormat("#,###,###.00");		
		//String s = formatter.format(new BigDecimal(money));					
		DecimalFormat df2 = new DecimalFormat("############0.00");
		
		if(money != 0.0){
			BigDecimal bg = new BigDecimal(df2.format(money));
			return bg.doubleValue();
		}else{
			return 0.00;
		}
	}
	
	public static boolean compareAmountInt(int sendAmt, int receiveAmt){
		boolean result = false;
		
		if(sendAmt==receiveAmt){
			result = true;
		}
		return result;
	}
}
