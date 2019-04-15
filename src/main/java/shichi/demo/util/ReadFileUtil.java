package shichi.demo.util;

import java.io.*;

public class ReadFileUtil {

    public static String readFileToString(String path){
        StringBuffer target = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
            String str ;
            while ((str = reader.readLine())!=null){
                target.append(str);
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  target.toString();
    }
}
