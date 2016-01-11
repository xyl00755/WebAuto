package com.danlu.testcases;


import org.testng.annotations.Test;

import com.danlu.common.BaseTestCase;

public class FormTest001 extends BaseTestCase {

	@Test
	public static void form001() {
		NewShippingAddress.initial();
		NewShippingAddress.inputBlank();
		NewShippingAddress.verifyBlank();
	}
	
	@Test
	public static void form002() {
		NewShippingAddress.inputInvalid();
		NewShippingAddress.verifyInvalid();
	}
	
	@Test
	public static void form003() {
		NewShippingAddress.inputValid();
		NewShippingAddress.verifyValid();
	}
	
}
