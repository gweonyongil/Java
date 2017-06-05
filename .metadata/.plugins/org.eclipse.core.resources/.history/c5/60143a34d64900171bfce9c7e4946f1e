package view;

import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;

import controller.file.NewFile;
import controller.file.StoreFile;
import view.SMConstants.ToolBarButtons;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.SynchronousQueue;

public class ToolBar extends JToolBar {
   private ButtonGroup buttonGroup;
   private ToolBarHandler toolBarHandler;
   private TextViewer textviewer;

   public ToolBar(String title) {
      super(title);
      toolBarHandler = new ToolBarHandler();
      buttonGroup = new ButtonGroup();
      JButton jbtn;
      for (ToolBarButtons btn : ToolBarButtons.values()) {
         jbtn = new JButton();
         jbtn.setIcon(new ImageIcon(SMConstants.IMG_URL + btn.toString() + SMConstants.TOOLBAR_BTN));
         jbtn.addActionListener(toolBarHandler);
         jbtn.setActionCommand(btn.toString());
         buttonGroup.add(jbtn);
         this.add(jbtn);
      }
   }

   public void initial(TextViewer textviewer) {
      this.textviewer = textviewer;
   }

   private class ToolBarHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JButton button = (JButton) e.getSource();
         if (button.getActionCommand().equals(ToolBarButtons.NewFile.name())) {
            String strleft1 = textviewer.getLefttext().getText();
            String strright1 = textviewer.getRighttext().getText();

            if (strleft1.length() != 0 || strright1.length() != 0) // 왼쪽
                                                      // 문서또는
                                                      // 오른쪽
                                                      // 문서가
                                                      // 하나라도
                                                      // 있을경우
                                                      // 저장을
                                                      // 하는
                                                      // 창으로
                                                      // 간다.
               new NewFile(textviewer);

         } else if (button.getActionCommand().equals(ToolBarButtons.LoadFile.name())) {
            OpenFile o = new OpenFile();
            o.LeftOpenFile(textviewer);

         } else if (button.getActionCommand().equals(ToolBarButtons.SaveFile.name())) {
            StoreFile s = new StoreFile();
            s.LeftStoreFile(textviewer);

         } else if (button.getActionCommand().equals(ToolBarButtons.ShiftRight.name())) {
        	 try {
				textviewer.shiftRight();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         } else if (button.getActionCommand().equals(ToolBarButtons.ShiftLeft.name())) {
        	 try {
				textviewer.shiftLeft();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         } else if (button.getActionCommand().equals(ToolBarButtons.Undo.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.Redo.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.FindDiffInLine.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.NextDiff.name())) {
            try {
               textviewer.nextDiff();
            } catch (BadLocationException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         } else if (button.getActionCommand().equals(ToolBarButtons.PrevDiff.name())) {
            try {
               textviewer.prevDiff();
            } catch (BadLocationException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         } else if (button.getActionCommand().equals(ToolBarButtons.FirstDiff.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.NowDiff.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.LastDiff.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.ShiftLeftPro.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.ShiftRightPro.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.Settings.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.AllShiftRight.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.AllShiftLeft.name())) {

         } else if (button.getActionCommand().equals(ToolBarButtons.F5.name())) {
            textviewer.highliteText();
            //button.setEnabled(false);
         }
      }
   }
}