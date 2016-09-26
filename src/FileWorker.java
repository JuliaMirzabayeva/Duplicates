import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileWorker {

    private static File inputFile;
    private static File outputFile;
    public static boolean setFiles(String inputFilePath, String outputFilePath)  throws IOException
    {
        if(!checkInputFile(inputFilePath) || !checkOutputFile(outputFilePath)) return false;
        processData();
        return true;

    }
    private static boolean checkInputFile(String inputFileName)
    {
        if(((new File(inputFileName)).exists())) inputFile = new File(inputFileName);
        else {
            System.out.println("Указан неверный путь входного файла!"); //если входного файла не существует
            return false;
        }
        return true;
    }


    private static boolean checkOutputFile( String outputFileName)
    {
        if (!((new File(outputFileName)).exists())) { // если выходного файла не существует
            try{
                if(!FilePathValidator.validate(outputFileName)) //проверка на путь с помошью регулярного выражения
                {
                    System.out.println("Введенная строка не является путем или указано недопустимое расширение файла.");
                    return false;
                }
                outputFile = new File(outputFileName);
                boolean b = outputFile.createNewFile();
                if(!b) throw new Exception();
                System.out.println("Файл успешно создан!");
            }
            catch (Exception e)
            {
                System.out.println("Файл не найден! Создать файл по указанному пути невозможно.");
                return false;
            }
        }
        else outputFile = new File(outputFileName);
        return true;
    }

    private static void processData() throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));// считываем входной файл построчно
        String str;
        TreeMap<String,Integer> linesAndAmount = new TreeMap<>(); // строка и кол-во ее повторений
        while((str = fileReader.readLine())!= null)
        {
            if(linesAndAmount.isEmpty())
                linesAndAmount.put(str.substring(1),1);  //удаление символа-маркера
            else  {
                if (!linesAndAmount.containsKey(str))
                    linesAndAmount.put(str, 1);
                else {
                    for (Map.Entry<String, Integer> pair : linesAndAmount.entrySet()) {
                        if (pair.getKey().equals(str))
                            linesAndAmount.put(str, pair.getValue() + 1);
                    }
                }
            }
        }
        fileReader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));// true для записи в конец файла
        for(Map.Entry<String,Integer> pair: linesAndAmount.entrySet())
        {
            writer.write(pair.getKey() + "[" +pair.getValue() + "]" );
            writer.newLine();
        }
        writer.flush();
        writer.close();

    }
}
