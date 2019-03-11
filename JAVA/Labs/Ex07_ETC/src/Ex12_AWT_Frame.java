import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
// AWT (CS 프로그램을 만들 수 있는 클래스 제공)
// Java라는 언어로 메모장, 계산기 등....(현재 Java는 Web 중심)
// cf) 이런 애들은 Visual C, C#
import java.awt.event.ActionListener;

// AWT >> Swing (순수 자바 코드로 버전 업)

// component(class 모음) : 버튼, 프레임, 틀

class MyFrame extends Frame {
  MyFrame(String title) {
    super(title);
  }
}


// 이벤트 구현 (이벤트는 이미 만들어져있다 ex) click, mouse over ...)
class BtnClick_Handler implements ActionListener {
  // click의 핸들러(함수)
  // 버튼을 click하면 actionPerformed 함수 자동 호출
  @Override
  public void actionPerformed(ActionEvent e) { // 버튼을 클릭하면 발생하는 이벤트
    // 안쪽 코드는 마음대로
    System.out.println("개발자가 원하는 행위 구현");
  }
}


public class Ex12_AWT_Frame {
  public static void main(String[] args) {
    MyFrame frame = new MyFrame("LOGIN");
    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setLayout(new FlowLayout());

    Button btn = new Button("나 버튼");
    Button btn2 = new Button("Two Button");
    Button btn3 = new Button("Three Button");

    frame.add(btn);
    frame.add(btn2);
    frame.add(btn3);

    /*
     * 익명 타입 (인터페이스를 직접 구현하지 않고 바로 객체를 만들어 쓰는 방법)
     * 코드량 감소
     * 1회성 (재사용성 X) 
     * 
     * btn.addActionListener(new ActionListener() {
     * 
     * @Override 
     * public void actionPerformed(ActionEvent e) { 
     *   // TODO Auto-generated method stub
     * 
     * } });
     */

    // ActionListener 구현하는 클래스의 객체 생성 >> 재사용 가능 (btn, btn2도 사용)
    BtnClick_Handler handler = new BtnClick_Handler();
    btn.addActionListener(handler);
    btn2.addActionListener(handler);
    
    btn3.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("인터페이스 직접 코딩...(익명 타입) 실제 클래스가 없다");
        
      }
    });
  }
}
