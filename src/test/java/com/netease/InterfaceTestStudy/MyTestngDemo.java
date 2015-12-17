package com.netease.InterfaceTestStudy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestngDemo {

	@Test(groups={"debug","pass"})
	public void testGet() throws Exception {
		String resp = null;	
		resp = Demo.getDemo();
		System.out.println("get:" + resp);
		Assert.assertTrue(resp.contains("200"));
	}
	
	
//	@Test(groups={"pass"})
//	public void testPost() throws Exception {
//		String resp = null;	
//		resp = Demo.postDemo();
//		System.out.println("post:" + resp);
//		Assert.assertTrue(resp.contains("200"));
//	}
}
