import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FilePathValidator
{
    public static boolean outValidate(String testString)
    {
        Pattern p = Pattern.compile("^[a-zA-Z]:([\\\\].*)*\\.(txt|TXT|doc|DOC)$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
    public static boolean inValidate(String testString)
    {
        Pattern p = Pattern.compile("^[a-zA-Z]:([\\\\].*)*\\.(txt|TXT)$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}
