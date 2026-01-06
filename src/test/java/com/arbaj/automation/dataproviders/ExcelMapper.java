package com.arbaj.automation.dataproviders;

import com.arbaj.automation.models.LoginData;
import com.arbaj.automation.utils.ExcelUtils;

public class ExcelMapper {

	public static Object[][] mapToLoginData(String filePath, String sheetName) {

        Object[][] rawData = ExcelUtils.getTestData(filePath, sheetName);

        Object[][] mappedData = new Object[rawData.length][1];

        for (int i = 0; i < rawData.length; i++) {
            String username = rawData[i][0].toString();
            String password = rawData[i][1].toString();
            String expectedMessage = rawData[i][2].toString();

            mappedData[i][0] =
                new LoginData(username, password, expectedMessage);
        }

        return mappedData;
    }
	
}
