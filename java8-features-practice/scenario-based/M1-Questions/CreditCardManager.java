import java.util.*;

class Transaction{
    String type;
    int amount;
    int remainingLimit;
    Transaction(String t,int a,int r){
        type=t;
        amount=a;
        remainingLimit=r;
    }
}

class CreditCard{
    String cardNumber;
    String holder;
    int creditLimit;
    int availableLimit;
    List<Transaction> list=new ArrayList<>();

    CreditCard(String c,String h,int l){
        cardNumber=c;
        holder=h;
        creditLimit=l;
        availableLimit=l;
    }
}

public class CreditCardManager{
    static Map<String,CreditCard> map=new HashMap<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("ISSUE")){
                String num=p[1];
                String name=p[2];
                int limit=Integer.parseInt(p[3]);
                if(!map.containsKey(num))
                    map.put(num,new CreditCard(num,name,limit));
            }

            else if(p[0].equals("SPEND")){
                String num=p[1];
                int amt=Integer.parseInt(p[2]);
                if(!map.containsKey(num) || map.get(num).availableLimit<amt){
                    System.out.println("Transaction declined");
                }else{
                    CreditCard c=map.get(num);
                    c.availableLimit-=amt;
                    c.list.add(new Transaction("SPEND",amt,c.availableLimit));
                    System.out.println("SPENT "+num+" "+c.availableLimit);
                }
            }

            else if(p[0].equals("PAYMENT")){
                String num=p[1];
                int amt=Integer.parseInt(p[2]);
                if(!map.containsKey(num)){
                    System.out.println("Card not found");
                }else{
                    CreditCard c=map.get(num);
                    c.availableLimit=Math.min(c.creditLimit,c.availableLimit+amt);
                    c.list.add(new Transaction("PAYMENT",amt,c.availableLimit));
                    System.out.println("PAYMENT DONE "+num+" "+c.availableLimit);
                }
            }

            else if(p[0].equals("HOLDER")){
                String name=p[1];
                List<CreditCard> l=new ArrayList<>();
                for(CreditCard c:map.values())
                    if(c.holder.equals(name))
                        l.add(c);

                if(l.isEmpty()){
                    System.out.println("No cards found");
                }else{
                    l.sort(Comparator.comparing(a->a.cardNumber));
                    for(CreditCard c:l)
                        System.out.println(c.cardNumber+" "+c.availableLimit);
                }
            }
        }
    }
}