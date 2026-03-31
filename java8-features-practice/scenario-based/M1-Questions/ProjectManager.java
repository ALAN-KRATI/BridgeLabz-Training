import java.util.*;

class ProjectTeam{
    String id,section,domain,name;
    int score;
    ProjectTeam(String a,String b,String c,String d,int e){
        id=a;section=b;domain=c;name=d;score=e;
    }
}

public class ProjectManager{
    static List<ProjectTeam> list=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("REGISTER")){
                boolean exists=false;
                for(ProjectTeam t:list)
                    if(t.id.equals(p[1])) exists=true;

                if(!exists)
                    list.add(new ProjectTeam(p[1],p[2],p[3],p[4],Integer.parseInt(p[5])));
            }

            else if(p[0].equals("REVISE")){
                boolean found=false;
                for(ProjectTeam t:list){
                    if(t.id.equals(p[1])){
                        t.score=Integer.parseInt(p[2]);
                        System.out.println("REVISED "+p[1]+" "+p[2]);
                        found=true;
                    }
                }
                if(!found) System.out.println("team is not available");
            }

            else if(p[0].equals("FILTERDOMAIN")){
                boolean found=false;
                for(ProjectTeam t:list){
                    if(t.domain.equals(p[1])){
                        System.out.println(t.id+" "+t.section+" "+t.domain+" "+t.name+" "+t.score);
                        found=true;
                    }
                }
                if(!found)
                    System.out.println("Team is not available for the domain: "+p[1]);
            }

            else if(p[0].equals("QUALIFY")){
                int cut=Integer.parseInt(p[1]);
                boolean found=false;
                for(ProjectTeam t:list){
                    if(t.score>=cut){
                        System.out.println(t.id+" "+t.section+" "+t.domain+" "+t.name+" "+t.score);
                        found=true;
                    }
                }
                if(!found)
                    System.out.println("No team qualified");
            }
        }
    }
}