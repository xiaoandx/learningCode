package club.xiaoandx.section7;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Test4 {

	public static void main(String[] args) {
		JFileChooser jfc  = new JFileChooser();
		//jfc.showSaveDialog(null);
		if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File file =jfc.getSelectedFile();
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			
			
		}else{
			JOptionPane.showMessageDialog(null, "û��ѡ���ļ�!");
			JOptionPane.showConfirmDialog(null, "���������г���");
			JOptionPane.showInputDialog("�����룺");
		}

	}

}
