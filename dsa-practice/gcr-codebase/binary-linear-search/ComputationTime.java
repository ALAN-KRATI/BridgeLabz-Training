import java.util.*;

public class ComputationTime{
    public static void main(String[] args){
        int total = 1000000;

        StringBuffer sb = new StringBuffer();
        long stBuffer = System.nanoTime();

        for(int i = 0; i < total; i++){
            sb.append("hello");
        }

        long endBuffer = System.nanoTime();
        long buffer = endBuffer - stBuffer;

        StringBuilder stb = new StringBuilder();
        long stBuilder = System.nanoTime();

        for(int i = 0; i < total; i++){
            stb.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builder = endBuilder - stBuilder;

        System.out.println("Time taken by string builder: " + builder);
        System.out.println("Time taken by string buffer: " + buffer); 
    }
}