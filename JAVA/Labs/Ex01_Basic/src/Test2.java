
public class Test2 {
    static int howMany(int i) {
        int five = 0;
        int three = 0;
        while (i > 5) {
        	if (i%3 != 0) {
        		five++;
        		i -= 5;
        	} else if (i%3 == 0 && i%5 != 0) {
        		three = i/3;
        		i = 0;
        	}
        	
        }
        if (i != 0) {
        	return -1;
        } else if (i == 6) {
        	return 2;
        } else {
        	return (five + three);
        }
    }
    
    public static void main(String[] args) {
        int n = 6;
        System.out.println(Test2.howMany(n));
    }
}