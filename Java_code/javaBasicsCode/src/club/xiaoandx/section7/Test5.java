package club.xiaoandx.section7;
import java.awt.Color;

import javax.swing.JColorChooser;

public class Test5 {
	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {
		JColorChooser jcc = new JColorChooser();
		Color c = jcc.showDialog(null, "��ѡ����ɫ��", Color.black);
	}
}
