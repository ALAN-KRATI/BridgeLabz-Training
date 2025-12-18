import java.util.Scanner;
class Solution {
    public static int romanToInt(String s) {
        int pre = 0;
        int sum =0;
        for(int i = 0 ; i < s.length() ; i++){
            int current = 0;
            char ch = s.charAt(i);
            switch(ch){
                case 'I':
                current = 1;
                break;
                
                case 'V':
                current = 5;
                break;
                
                case 'X':
                current = 10;
                break;
                
                case 'L':
                current = 50;
                break;

                case 'C':
                current = 100;
                break;

                case 'D':
                current = 500;
                break;
                
                case 'M':
                current = 1000;
                break;
                default:
                System.out.println("Invalud character" + ch);
                return -1;
            }
        if(pre < current){
            sum += current - (2 * pre);
        }
        else{
            sum = sum + current;
        }
        pre = current;
        }    
        
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Roman num :");
        String s = scanner.nextLine();
        int result = romanToInt(s);
        if(result == -1){
            System.out.println("Invalud character" + s);
        }
        else{
            System.out.println(s + " --> Integer value : " +result);
        }

    }

}