/*
 * Copyright 2019-2021 the original WEI.ZHOU.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package club.xiaoandx.experiment1.test1;

abstract class Size {
	/**
	 * 设计笔的大小
	 * @Date 14:08 2021/3/12
	 * @version:V1.0
	 * @Author: WEI.ZHOU
	 * @Param []
	 * @return void
	 **/
	abstract void sizePen();
}
class SmallPen extends Size {
	@Override
	public void sizePen() { System.out.print("小型"); }
}
class MiddlePen extends Size {
	@Override
	public void sizePen() { System.out.print("中型"); }
}
class LargePen extends Size {
	@Override
	public void sizePen() { System.out.print("大型"); }
}

abstract class Color {
	/**
	 * 设置笔的颜色
	 * @Date 14:09 2021/3/12
	 * @version:V1.0
	 * @Author: WEI.ZHOU
	 * @Param []
	 * @return void
	 **/
	abstract void colorPen();
}
class BlackPen extends Color {
	@Override
	public void colorPen() { System.out.print("黑色"); }
}
class RedPen extends Color {
	@Override
	public void colorPen() { System.out.print("红色"); }
}

class Pen {
	private Size size; private Color color;
	public Size getSize() { return size; }
	public void setSize(Size size) { this.size = size; }
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }
	public void print() { size.sizePen(); color.colorPen(); System.out.println("钢笔"); }
}

/**
 * @Title:
 * @Description 组合设计验证测试类
 * @Date 14:06 2021/3/12
 * @version:V1.0
 * @Author: WEI.ZHOU
 **/
public class Questions2 {
	public static void main(String[] args) {
		//颜色大小随意组合
		Pen pen=new Pen();
		//组合小型红色钢笔
		pen.setSize(new SmallPen());
		pen.setColor(new RedPen());
		pen.print();
	}
}
