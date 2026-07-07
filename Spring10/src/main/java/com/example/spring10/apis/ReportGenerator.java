package com.example.spring10.apis;

public interface ReportGenerator {
	String fetchData();
	
	void export(String content);

	default void createAndExport() {
		System.out.println("start...");
		String data = fetchData();
		String formatedData = formatData(data);
		export(formatedData);
		System.out.println("end");
	}
	
	private String formatData(String rawData) {
		return "format" + rawData.toUpperCase();
	}
	
}
