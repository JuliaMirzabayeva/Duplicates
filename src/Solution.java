import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Пожалуйста, введите полный пусть к входному файлу(допутимый формат txt):");
        String inputFileName = reader.readLine();
        System.out.println("Пожалуйста, введите полный пусть к выходному файлу(допутимый формат txt/doc):");
        String outputFileName = reader.readLine();
        reader.close();
        if(!FileWorker.setFiles(inputFileName,outputFileName))
            System.out.println("Программа не выполнена.");
        else System.out.println("Программа успешно завершена.");
    }
}
