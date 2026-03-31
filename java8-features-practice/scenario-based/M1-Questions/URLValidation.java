import java.util.*;
import java.util.regex.*;

public class URLValidation{
    static Set<String> seen=new HashSet<>();

    static String validateURL(String url){
        if(!url.matches("^(http://|https://).+"))
            return "INVALID URL: protocol is invalid";

        if(!url.matches("^(http://|https://)[a-zA-Z]+\\.[a-z]+$"))
            return "INVALID URL: format is invalid";

        Matcher m=Pattern.compile("^(http://|https://)([a-z]+)(\\.[a-z]+)$").matcher(url);
        if(!m.find()) return "INVALID URL: format is invalid";

        String site=m.group(2);
        String dom=m.group(3);

        if(!site.matches("[a-z]{1,10}"))
            return "INVALID URL: website name is invalid";

        if(!dom.matches("\\.(com|co|in|org|gov)"))
            return "INVALID URL: domain is invalid";

        if(seen.contains(url))
            return "DUPLICATE URL FOUND";

        seen.add(url);
        return "VALID URL";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
            System.out.println(validateURL(sc.nextLine()));
    }
}