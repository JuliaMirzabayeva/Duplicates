import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FilePathValidator
{
    public static boolean validate(String testString)
    {
        Pattern p = Pattern.compile("^[a-zA-Z]:(\\\\.*)*\\.(txt|TXT|doc|DOC)$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}
