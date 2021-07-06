package com.example.test2;


import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Command line tool
 */
public class CommandExec {

    private CommandExec() {
    }

    /**
     * Modify gpio next file permissions, so that he can use
     * @Param ledId gpio number
     * @Return true success
     */
    public static boolean execRedLed(int ledId) {
        return execCommand(String.format("cd /sys/class/gpio/gpio%d/ && busybox chmod 777 value", ledId));
    }

    /**
     * Restore file permissions gpio
     * @Param ledId gpio number
     * @Return true success
     */
    public static boolean releaseLed(int ledId) {
        return execCommand(String.format("cd /sys/class/gpio/gpio%d/ && chmod 644 value", ledId));
    }
    public static boolean setPIN(int ledId,int value) {
        return execCommand(String.format("cd /sys/class/gpio/gpio%d/ && echo %d > value", ledId,value));
    }
    public static String getPIN(int ledId) {
        Log.e("LED", "execCommand Leed:"+ ledId);

        return rexecCommand(String.format("cat /sys/class/gpio/gpio%d/value", ledId));
    }
    public static String readFully(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toString("UTF-8");
    }

    public static String rexecCommand(String command) {
        String status ="";
        if (TextUtils.isEmpty(command)) {
            return status;
        }
        try {
            Process exec =  Runtime.getRuntime().exec("");
            InputStream response = null;
            response = exec.getInputStream();
            OutputStream outputStream = exec.getOutputStream();
            outputStream.write(command.getBytes(Charset.forName("utf-8")));
            outputStream.write("\n".getBytes());
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            int waitFor = exec.waitFor();
            Log.e("execCommand", "execCommand command:"+command+";waitFor=" + waitFor);
            if (waitFor == 0) {
                //chmod succeed
                status =""+readFully(response);
                Log.e("Response", " " + readFully(response));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("execCommand", "execCommand exception-=" + e.getMessage());
            Log.e("execCommand", command+"ee");
            return "";
        }
        return status;
    }

    public static boolean execCommand(String command) {
        boolean status = false;
        if (TextUtils.isEmpty(command)) {
            return status;
        }
        try {
            Process exec = Runtime.getRuntime().exec("su");
            InputStream response = null;
            response = exec.getInputStream();
            OutputStream outputStream = exec.getOutputStream();
            outputStream.write(command.getBytes(Charset.forName("utf-8")));
            outputStream.write("\n".getBytes());
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            int waitFor = exec.waitFor();
            Log.e("execCommand", "execCommand command:"+command+";waitFor=" + waitFor);
            if (waitFor == 0) {
                Log.e("Response", " " + response.toString());
                //chmod succeed
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("execCommand", "execCommand exception=" + e.getMessage());
            return false;
        }
        return status;
    }
}
