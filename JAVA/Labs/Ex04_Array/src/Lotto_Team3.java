public class Lotto_Team3 {
 
    public static void main(String[] args) {
        /*
         1. 1~45까지의 난수를발생시켜 6개의 배열을 담으세요
         2. 배열에 담긴 6개의 배열값은 중복값이나오면 안되요
         3. 배열에 있는 6개의 값은 낮은 순으로정렬 시키세요.
         4. 위 결과를 담고 있는 배열을 출력하세요.
         */
        
        
        int[] lotto = new int[6];
        while(true) {
            for(int i=0; i<lotto.length; i++) {
                int random = (int) (Math.random()*45+1);
                lotto[i]=random;
 
            }
 
            int temp = 0;
            while (!(lotto[0] >= lotto[1] && lotto[1] >= lotto[2] && lotto[2] >= lotto[3] && lotto[3] >= lotto[4] && lotto[4] >=lotto[5])) {
                for (int i = 0; i < lotto.length - 1; i++) {
                    if (lotto[i] >= lotto[i + 1]) {
                        continue;
                    } else {
                        temp = lotto[i];
                        lotto[i] = lotto[i + 1];
                        lotto[i + 1] = temp;
                    }
                }
            } // while 문
 
            if (lotto[0] == lotto[1] | lotto[1] == lotto[2] | lotto[2] == lotto[3] | lotto[3] == lotto[4] | lotto[4] == lotto[5]) {
                System.out.println("다시");;
            } else {
                break;
            }
        }
        
        
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i]);
            if (i<lotto.length-1) {
                System.out.print(", ");
            }
        }
    
    }    
    }