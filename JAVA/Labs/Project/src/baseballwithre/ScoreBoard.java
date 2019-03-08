package baseballwithre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ScoreBoard extends Thread implements ActionListener {
  private int runA;
  private int runB;
  private int inningNow;
  private Team A, B;
  private JFrame frame;
  private JLabel tf1, tf2;
  private JButton b;

  public ScoreBoard(Team A, Team B) {
    this.A = A;
    this.B = B;
  }

  @Override
  public void run() {
    frame = new JFrame("점수판");
    tf1 = new JLabel("0");
    tf2 = new JLabel("0");
    b = new JButton("Refresh");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(tf1);
    tf1.setBounds(50, 50, 100, 30);
    frame.add(tf2);
    tf2.setBounds(50, 100, 100, 30);
    frame.add(b);
    b.setBounds(150, 100, 100, 50);
    b.addActionListener(this); // 버튼의 액션을 this(ScoreBoard)가 듣는다
    frame.setLayout(null); 
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    runA = A.getRunsTotal();
    runB = B.getRunsTotal();
    tf1.setText(String.valueOf(runA));
    tf2.setText(String.valueOf(runB));    
  }
}
