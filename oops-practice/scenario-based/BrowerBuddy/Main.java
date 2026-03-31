public class Main {
    public static void main(String[] args) {

        BrowerTab tab = new BrowerTab();
        TabManager manager = new TabManager();

        tab.visitNewPage("google.com");
        tab.visitNewPage("github.com");
        tab.visitNewPage("stackoverflow.com");

        tab.BackTab();
        tab.BackTab();
        tab.forwardTab();

        System.out.println("Current Page: " + tab.getCurrentPage());

        manager.closeTab(tab);

        BrowerTab restoredTab = manager.reopenTab();
        if (restoredTab != null) {
            System.out.println("Restored Page: " + restoredTab.getCurrentPage());
        }
    }
}
