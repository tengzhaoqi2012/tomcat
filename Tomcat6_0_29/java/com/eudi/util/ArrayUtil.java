package com.eudi.util;

public class ArrayUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] ary = new byte[10];
		ary[0] = 0;
		ary[1] = 1;
		ary[2] = 2;
		ary[3] = 3;
		ary[4] = 4;
		ary[5] = 5;
		ary[6] = 6;
		ary[7] = 7;
		ary[8] = 8;
		ary[9] = 9;
		
		byte[] result = subArray(ary, 2, 5);
		
		for(byte b : result) {
			System.out.println(b);
		}
	}
	
	public static byte[] subArray(byte[] src, int srcpos, int len){
		byte[] result = new byte[len];
		System.arraycopy(src, srcpos, result, 0, len);
		return result;
	}

	public static String toStr(byte[] src, int srcpos, int len) {
		byte[] valid = subArray(src, srcpos, len);
		return new String(valid);
	}

}
