import java.util.*;
import java.util.regex.*;

public class TemplateProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern p = Pattern.compile("\\$\\{([A-Z]+):([^}]+)\\}");

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            Matcher m = p.matcher(line);
            StringBuffer sb = new StringBuffer();

            while(m.find()){
                String type = m.group(1);
                String val = m.group(2);
                String rep = "INVALID";

                if(type.equals("UPPER")){
                    rep = val.toUpperCase();
                }
                else if(type.equals("LOWER")){
                    rep = val.toLowerCase();
                }
                else if(type.equals("DATE")){
                    if(val.matches("\\d{2}-\\d{2}-\\d{4}")){
                        String[] d = val.split("-");
                        int day = Integer.parseInt(d[0]);
                        int mon = Integer.parseInt(d[1]);
                        int yr = Integer.parseInt(d[2]);

                        if(day>=1 && day<=31 && mon>=1 && mon<=12){
                            rep = yr+"/"+String.format("%02d",mon)+"/"+String.format("%02d",day);
                        }
                    }
                }
                else if(type.equals("REPEAT")){
                    String[] a = val.split(",");
                    if(a.length==2){
                        String w = a[0];
                        int c = Integer.parseInt(a[1]);
                        StringBuilder t = new StringBuilder();
                        for(int j=0;j<c;j++) t.append(w);
                        rep = t.toString();
                    }
                }

                m.appendReplacement(sb, rep);
            }

            m.appendTail(sb);
            System.out.println(sb.toString());
        }
    }
}