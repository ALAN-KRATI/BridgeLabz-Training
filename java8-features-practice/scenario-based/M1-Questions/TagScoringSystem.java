import java.util.*;
import java.util.regex.*;

public class TagScoringSystem{
    static String evaluate(String input){
        Pattern p=Pattern.compile("\\[(SUM|MUL|MAX|MIN):(-?(?:0|[1-9]\\d*)(?:,-?(?:0|[1-9]\\d*))+)]");
        Matcher m=p.matcher(input);
        StringBuffer sb=new StringBuffer();

        while(m.find()){
            String op=m.group(1);
            String[] nums=m.group(2).split(",");
            int res=0;

            if(op.equals("SUM")){
                for(String s:nums) res+=Integer.parseInt(s);
            }
            else if(op.equals("MUL")){
                res=1;
                for(String s:nums) res*=Integer.parseInt(s);
            }
            else if(op.equals("MAX")){
                res=Integer.MIN_VALUE;
                for(String s:nums) res=Math.max(res,Integer.parseInt(s));
            }
            else if(op.equals("MIN")){
                res=Integer.MAX_VALUE;
                for(String s:nums) res=Math.min(res,Integer.parseInt(s));
            }

            m.appendReplacement(sb,String.valueOf(res));
        }
        m.appendTail(sb);

        return sb.toString().replaceAll("\\[[^]]*","ERROR");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
            System.out.println(evaluate(sc.nextLine()));
    }
}