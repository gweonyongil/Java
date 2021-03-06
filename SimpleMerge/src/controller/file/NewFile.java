package controller.file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import view.TextViewer;

public class NewFile extends JFrame implements ActionListener {

   TextViewer t;
   JButton b1;
   JButton b2;
   JButton b3;
   JRadioButton radioButton1;
   JRadioButton radioButton2;
   JRadioButton radioButton3;
   JRadioButton radioButton4;
   public NewFile(TextViewer textviewer){
      
      
      t = textviewer;
      setSize(400,300);
      setVisible(true);
      JPanel radioPanel1 = new JPanel();
      JPanel radioPanel2 = new JPanel();

      radioButton1 = new JRadioButton("저장(S)",true);
      radioButton2 = new JRadioButton("저장 안 함(D)");
      
      ButtonGroup aGroup = new ButtonGroup();
      aGroup.add(radioButton1);
      aGroup.add(radioButton2);
      
      
      JTextField text = new JTextField("이름없는 문서");
       text.setEditable(false);
       text.setSize(10,10);
      
      radioPanel1.setLayout(new FlowLayout());
      radioPanel1.add(radioButton1);
      radioPanel1.add(radioButton2);
      
      radioPanel2.setLayout(new BorderLayout());
      radioPanel2.add(radioPanel1,BorderLayout.SOUTH);
      radioPanel2.add(text,BorderLayout.NORTH);
      radioPanel2.setBorder(new TitledBorder("왼쪽 파일"));
      
      //오른쪽 문서
      
      JPanel radioPanel3 = new JPanel();
      JPanel radioPanel4 = new JPanel();

      radioButton3 = new JRadioButton("저장(A)",true);
      radioButton4 = new JRadioButton("저장 안 함(C)");
      
      ButtonGroup bGroup = new ButtonGroup();
      bGroup.add(radioButton3);
      bGroup.add(radioButton4);
      
      JTextField text2 = new JTextField("이름없는 문서");
       text2.setEditable(false);
      

      b1 = new JButton("모두 저장 안 함");
       b2 = new JButton("확인");
       b3 = new JButton("취소");
      
      radioPanel3.setLayout(new FlowLayout());
      radioPanel3.add(radioButton3);
      radioPanel3.add(radioButton4);
      
      radioPanel4.setLayout(new BorderLayout());
      radioPanel4.add(radioPanel3,BorderLayout.SOUTH);
      radioPanel4.add(text2,BorderLayout.NORTH);
      radioPanel4.setBorder(new TitledBorder("오른쪽 파일"));
      
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2,1));
      p.add(radioPanel2);
      p.add(radioPanel4);
      
   
      JPanel p2 = new JPanel();
      
      p2.setLayout(new FlowLayout());
   
      p2.add(b1);
      p2.add(b2);
      p2.add(b3);
      
      
      setLayout(new BorderLayout());
      add(p,BorderLayout.CENTER);
      add(p2,BorderLayout.SOUTH);
      
      radioButton1.addActionListener(this);
      radioButton2.addActionListener(this);
      radioButton3.addActionListener(this);
      radioButton4.addActionListener(this);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      //왼쪽문서 오른쪽 문서 모두 저장했을 때에
      if(radioButton1.isSelected() && radioButton3.isSelected() && e.getSource()==b2){
      StoreFile save = new StoreFile();
      save.LeftStoreFile(t);
      save.RightStoreFile(t);
      t.getLefttext().setText("");
      t.getRighttext().setText("");
      dispose();
      }
      //모두 저장 안했을 때
      else if(e.getSource()==b1){
      t.getLefttext().setText("");
      t.getRighttext().setText("");
      dispose();
   }
      //왼쪽 문서만 저장할 때
      else if(radioButton1.isSelected() && radioButton4.isSelected() &&e.getSource()==b2){
         StoreFile save = new StoreFile();
         save.LeftStoreFile(t);
         t.getLefttext().setText("");
         t.getRighttext().setText("");
         dispose();
      }
      
      else if(radioButton2.isSelected() && radioButton3.isSelected() &&e.getSource()==b2){
         StoreFile save = new StoreFile();
         save.RightStoreFile(t);
         t.getLefttext().setText("");
         t.getRighttext().setText("");
         dispose();
      }
      
      else if (e.getSource()==b3){
         dispose();
      }
      
   }
   
}