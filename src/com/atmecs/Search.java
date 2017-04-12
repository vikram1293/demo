package com.atmecs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {
	public static final String str = "D:\\search.txt";

	public static void main(String[] args) {
		try {
			BufferedReader br = null;
			Map<String, List<String>> map = new HashMap<String, List<String>>();

			String searchStream = "";

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (!searchStream.equalsIgnoreCase("exit")) {
				System.out.println("Enter Search Stream:");
				searchStream = reader.readLine();
				if (map != null && map.containsKey(searchStream)) {

					ArrayList<String> cache = new ArrayList<>();
					cache = (ArrayList<String>) map.get(searchStream);
					System.out.println("search results from Cache");
					/*cache.forEach(System.out::println);
					String AtmecsSystem = () -> System.out.print("Hello");*/
					

				} else {
					String sline;
					br = new BufferedReader(new FileReader(str));
					List<String> values = new ArrayList<String>();

					while ((sline = br.readLine()) != null) {
						if (sline.contains(searchStream)) {
							System.out.println(sline);
							values.add(sline);
						}
					}
					map.put(searchStream, values);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
