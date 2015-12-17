package com.netease.InterfaceTestStudy;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) throws Exception {
		String resp = "";
		resp = Demo.getDemo();
		System.out.println(resp);
		resp = Demo.postDemo();
		System.out.println(resp);
	}
	
	public static String getDemo() throws Exception {
		String url = "http://music.163.com/api/user/level";
//		请求的head信息
		String cookie = "MUSIC_U=d17f2cd23b3c5885064a01948cf6ae0caa267c690ce2ea3d206d8a5d07184d6d7935831029ad333c8c16d927350ff61bfe2897047e8106fb; usertrack=ezq0aVXbD804sTKSEep2Ag==; deviceId=MzU3MTk2MDUzMTEyNTMzCUNDOjNBOjYxOkMzOkM1OjZDCTFjNWEzMDAzMzI2N2U3YjUJNGQwMDllMDM5ODIwNDBlYg%3D%3D; appver=2.9.1; os=android; osver=4.4.2; mobilename=GT-I9500; resolution=1920x1080; channel=netease; __csrf=cd2ca54beb8e222bf276b868824082b7; JSESSIONID-WYYY=3ce9098a5a94d82b47ea6e08ac35a6c2df12d52876a1eb6c8875f27e3bdf04f01cf937a78f936d200350cd93f1b7f5e08cb7597828336b1a42a56691316e79b9b2965e2418ec1975985e187ba4700e46d77478a762c49f4ff65c60f40702c1a6639a67b8147d727914102f125b80563dd08043c7dbd3d36014e643bd07d5fbaf593eb405";
		Map<String, String> param = new HashMap<String, String>();
		param.put("Cookie", cookie);
//		调用自定义的方法，即get请求
		String resp = MyHttpClient.sendGet(url, param);
		return resp;
	}
	
	public static String postDemo() throws Exception {
		String url = "http://music.163.com/api/user/level";
//		请求的head信息
		String cookie = "MUSIC_U=d17f2cd23b3c5885064a01948cf6ae0caa267c690ce2ea3d206d8a5d07184d6d7935831029ad333c8c16d927350ff61bfe2897047e8106fb; usertrack=ezq0aVXbD804sTKSEep2Ag==; deviceId=MzU3MTk2MDUzMTEyNTMzCUNDOjNBOjYxOkMzOkM1OjZDCTFjNWEzMDAzMzI2N2U3YjUJNGQwMDllMDM5ODIwNDBlYg%3D%3D; appver=2.9.1; os=android; osver=4.4.2; mobilename=GT-I9500; resolution=1920x1080; channel=netease; __csrf=cd2ca54beb8e222bf276b868824082b7; JSESSIONID-WYYY=3ce9098a5a94d82b47ea6e08ac35a6c2df12d52876a1eb6c8875f27e3bdf04f01cf937a78f936d200350cd93f1b7f5e08cb7597828336b1a42a56691316e79b9b2965e2418ec1975985e187ba4700e46d77478a762c49f4ff65c60f40702c1a6639a67b8147d727914102f125b80563dd08043c7dbd3d36014e643bd07d5fbaf593eb405";
		Map<String, String> param = new HashMap<String, String>();
		param.put("Cookie", cookie);
//		调用自定义的方法，即post请求
		String resp = MyHttpClient.sendPost(url, param,"");
		return resp;
	}
}
