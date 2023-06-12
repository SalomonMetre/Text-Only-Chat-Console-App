/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_programming_package;

/**
 *
 * @author salomon-metre
 */
public class Printer {
    private Printer() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void showMessage(String message){
        System.out.print("\n"+message+"\n[Me] : ");
    }
}
