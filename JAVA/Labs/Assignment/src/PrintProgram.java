
class Printer {
    private static Printer printer = null;
    private Printer() {}
    public static Printer getInstance() {
        if(printer == null) {
            printer = new Printer();
        }
        return printer;
    }
    public void print(String content) {
        //자원 //프린트
        System.out.println(content);
    }
}

class User {
    private String name;
    
    public User(String name) {
        this.name = name;
    }
    
    public void print() {
        Printer printer = Printer.getInstance();
        printer.print(this.name + " print" + printer.toString());
    }
}    

public class PrintProgram {
    private static final int NUM=5;
    public static void main(String[] args) {
        User[] user = new User[NUM];
        for(int i = 0 ; i < NUM ; i++) {
            user[i] = new User((i+1) + "-user");
            user[i].print();
        }
    }
}
 
