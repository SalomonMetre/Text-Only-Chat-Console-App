package socket_programming_package;

public class Printer {
    private Printer() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void showMessage(String message){
        System.out.print("\n"+message+"\n[Me] : ");
    }
}
