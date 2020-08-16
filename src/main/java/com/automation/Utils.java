package com.automation;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils {

    public static String getCurrentTimeStamp() throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }

    public static String createTestReportFolder() throws Exception {
        String path = System.getProperty("user.dir") + "//Results//" + getCurrentTimeStamp();
        File mainFolder = new File(path);
        if (!mainFolder.exists()) {
            if (mainFolder.mkdir()) {
                new File(path + "//ScreenShots").mkdirs();
                new File(path + "//logs").mkdirs();
                return path;
            } else {
                return null;
            }
        }
        else
        {
            return path;
        }

    }
}
