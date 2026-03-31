import java.util.Stack;

public class TabManager {
    private Stack<BrowerTab> closedTabs = new Stack<>();

    public void closeTab(BrowerTab tab){
        closedTabs.add(tab);
        System.out.println("Tab closed!");
    }

    public BrowerTab reopenTab(){
        if(closedTabs.isEmpty()){
            System.out.println("No tabs to reopen.");
            return null;
        }

        System.out.println("Reopening closed tab.");
        return closedTabs.pop();
    }
    
}
