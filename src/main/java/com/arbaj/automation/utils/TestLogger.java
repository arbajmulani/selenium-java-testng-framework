package com.arbaj.automation.utils;

public class TestLogger {

	public static void logStep(
            String component,
            String action,
            String locator,
            String status,
            String data,
            String message
    ) {
        System.out.println(
            component + " | " + action + " | " + status + " | " + data + " | " + message
        );
    }
	
}
