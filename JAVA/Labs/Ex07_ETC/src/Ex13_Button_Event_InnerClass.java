import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Btn_Handler implements ActionListener {
  private TextField txt_id, txt_pwd;

  public Btn_Handler(TextField txt_id, TextField txt_pwd) {
    this.txt_id = txt_id;
    this.txt_pwd = txt_pwd;
  }

  // id, pwd 입력하고 버튼을 클릭하면 id, pwd값을 가지고 와서 미리 지정한 값과
  // 일치하는지 확인
  // 클릭 이벤트가 발생하면 호출되는 함수 (핸들러 함수)
  @Override
  public void actionPerformed(ActionEvent e) {
    // 필요한 로직
    // System.out.println("ActionEvent 발생지의 객체 주소 : " + e.getSource());
    System.out.println(txt_id.getText() + " / " + txt_pwd.getText());
    if (txt_id.getText().equals("hong")) {
      System.out.println("방가방가" + " / " + txt_pwd.getText());
    } else {
      System.out.println("나는 누구인가 ^^");
    }
  }
}


class LoginForm extends Frame {
  Label lbl_id;
  Label lbl_pwd;
  TextField txt_id;
  TextField txt_pwd;
  Button btn_ok;

  public LoginForm(String title) {
    super(title);
    lbl_id = new Label("ID : ", Label.RIGHT);
    lbl_pwd = new Label("PWD : ", Label.RIGHT);
    txt_id = new TextField(10);
    txt_pwd = new TextField(10);
    txt_pwd.setEchoChar('*');
    btn_ok = new Button("Login");

    this.setLayout(new FlowLayout()); // add한 순서대로
    this.setSize(500, 100);
    this.setVisible(true);

    this.add(lbl_id);
    this.add(txt_id);
    this.add(lbl_pwd);
    this.add(txt_pwd);
    this.add(btn_ok);

    // 버튼에 클릭 이벤트 처리하기
    // 조건 : parameter로 처리되는 객체는 반드시 ActionListener 구현하는 객체
    Btn_Handler btn_handler = new Btn_Handler(txt_id, txt_pwd);
    btn_ok.addActionListener(btn_handler);
  }
}


public class Ex13_Button_Event_InnerClass {
  public static void main(String[] args) {
    LoginForm login = new LoginForm("로그인");

  }
}
