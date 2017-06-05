package controller.file;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.file.LoadData;
import view.TextViewer;

public class OpenFile extends JFrame {

   File f =null ;
   TextViewer b;
   
   
   public void LeftOpenFile(TextViewer c) {

      JFileChooser jc = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
      jc.setFileFilter(filter);
      b = c;

      if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
         try {
            f = jc.getSelectedFile();
         
               LoadData aaa = new LoadData();
               aaa.loadFile(b.getLefttext(), f);
         
            
         } catch (Exception e) {

         }
         b.setVisible(true);
      }
   }

   public void RightOpenFile(TextViewer c) {

      JFileChooser jc = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
      jc.setFileFilter(filter);
      b = c;

      if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
         try {
            f = jc.getSelectedFile();
            LoadData aaa = new LoadData();
            aaa.loadFile(b.getRighttext(), f);

         } catch (Exception e) {

         }
      }
   }
}