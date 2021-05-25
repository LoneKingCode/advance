import java.io.*;
import java.text.MessageFormat;

/**
 * 题目：
 * 描述:
 * <p>
 * 思路：
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("D:\\MyProject\\LoneKingCode\\java\\advance\\test.txt"));
        String str;
        File file = new File("D:\\MyProject\\LoneKingCode\\java\\advance\\test1.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWritter = new FileWriter(file.getName(), true);

        while ((str = bufferedReader.readLine()) != null) {
            String[] strs = str.split("----");
            String s = MessageFormat.format("{0}----{1}----{2}----{3}\n",
                    strs[2], strs[3], strs[0], strs[1]);
            fileWritter.write(s);
        }
        fileWritter.close();
    }
}

