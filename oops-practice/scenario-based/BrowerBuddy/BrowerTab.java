public class BrowerTab {
    private Page current;

    public void visitNewPage(String url){
        Page newPage = new Page(url);

        if(current != null){
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("New page!");
    }

    public void BackTab(){
        if(current != null && current.prev != null){
            current = current.prev;
            System.out.println("On the previous tab!");
        }
        else{
            System.out.println("No previous tab");
        }
    }

    public void forwardTab(){
        if(current != null && current.next != null){
            current = current.next;
            System.out.println("On the forward tab!");
        }
        else {
            System.out.println("No forward tab.");
        }
    }

    public String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}
