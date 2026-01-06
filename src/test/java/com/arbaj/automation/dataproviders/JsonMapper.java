package com.arbaj.automation.dataproviders;

import java.util.List;

import com.arbaj.automation.models.LoginData;
import com.arbaj.automation.utils.JsonUtils;

public class JsonMapper {
	
	public static Object[][] mapToLoginData(String filePath) 
	{

        List<LoginData> dataList =
                JsonUtils.readJsonArray(filePath, LoginData.class);

        Object[][] data = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }

        return data;
    }

}
