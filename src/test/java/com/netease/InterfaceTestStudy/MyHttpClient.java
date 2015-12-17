package com.netease.InterfaceTestStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class MyHttpClient {

	/**
	 * get请求函数
	 * 
	 * @param url
	 *            url地址
	 * @param heads
	 *            header头文件参数
	 * @return 返回类型 string
	 * @throws IOException 
	 * @throws Exception
	 */
	public static String sendGet(String url, Map<String, String> heads) throws IOException{

		BufferedReader in = null;
		String result = "";

		try {
			// 实例化一个url
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 强制类型转换为HttpURLConnection
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			// 填写请求头的相关参数
			for (String key : heads.keySet()) {
				httpURLConnection.setRequestProperty(key, heads.get(key));
			}
			// 获取respose code
			int status = httpURLConnection.getResponseCode();
			System.out.println("get status: " + status);
			// 若code＝200，读取response的信息
			if (status == 200) {
				in = new BufferedReader(new InputStreamReader(
						httpURLConnection.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			// 关闭输入流
			if (in != null) {
				in.close();
			}

		}
		return result;
	}

	public static String sendPost(String url, Map<String, String> heads,
			String postbody) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 强制类型转换为HttpURLConnection
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

			// 设置通用的请求属性
			for (String key : heads.keySet()) {
				httpURLConnection.setRequestProperty(key, heads.get(key));
			}

			//**************************与get请求不同*********************
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(httpURLConnection.getOutputStream());
			// 发送请求参数
			out.print(postbody);
			// flush输出流的缓冲
			out.flush();
			// *********************************************************

			int status = httpURLConnection.getResponseCode();
			System.out.println("post status:" + status);
			if (status == 200) {
				// 定义BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(
						httpURLConnection.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
			}

		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
