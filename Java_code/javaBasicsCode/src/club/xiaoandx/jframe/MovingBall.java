/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.jframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

/**  
 * <p> 实验 - 移动的小球 </p> 
 *
 * @ClassName:MovingBall   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 10:19
 * @since: JDK1.8
 * @version V1.0.0
 */
public class MovingBall extends JFrame implements ActionListener {
	
	/**
	 * 主窗口的宽 高设置
	 */
	private int windowWidth = 800;
	private int windowHight = 400;
	
	/**
	 * 小球的大写
	 */
	private static final int BALL_WIDTH = 30;
	private static final int BALL_HIGHT = 30;
	
	/**
	 * 小球的初始桌标
	 */
	private int ballX = 20;
	private int ballY = 20;
	
	/**
	 * 小球的移动变化值
	 */
	private int ballMoveX = 3;
	private int ballMoveY = 3;	

	/**   
	 * @Fields serialVersionUID :    
	 */ 
	private static final long serialVersionUID = 6471761600317841489L;
	
	/**
	 * Swing 定时器用于刷新小球的位置
	 */
	Timer time = new Timer(20, this);
	
	/**   
	 * <p>用于窗口初始化 </p></br>
	 * @Title:  MovingBall   
	 * @date: 2021-04-14 10:29 
	 * @since: 1.0.0
	 */
	public MovingBall() {
		this.getContentPane().setBackground(Color.white);
		this.setTitle("移动的小球");
		this.setSize(windowWidth, windowHight);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		windowWidth = this.getContentPane().getWidth();
		windowHight = this.getContentPane().getHeight();
		
		time.start();
	}
	
	/**   
	 * <p> 绘制窗口中的小球 </p></br>
	 * <pre>
	 * 绘制小球并设置初始值进行显示，小球移动的关键点在，移动下一次绘制小球的坐标的变化
	 * </pre>
	 * <p>Title: paint</p> 
	 * @date: 2021-04-14 10:39    
	 * @param g   
	 * @see java.awt.Window#paint(java.awt.Graphics)   
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);		
		g.setColor(Color.red);
		g.fillOval(ballX, ballY, BALL_WIDTH, BALL_HIGHT);
		
	}

	/**   
	 * <p> 移动事件 - 改变小球的坐标达到移动的效果 </p></br>
	 * <pre>
	 * 先判断小球此时的坐标位置是否超过面板窗口区域；如果超过区域将会把移动变量改为相反数。
	 * 在通过修改后的小球移动变量 加上 此时小球的坐标位置 得到最新小球的坐标位置。得到最新的小球的坐标后进行
	 * 刷新再次绘制小球；从而达到移动效果。
	 * </pre>
	 * <p>Title: actionPerformed</p> 
	 * @date: 2021-04-14 10:51    
	 * @param e   
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)   
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ballX < 0 || ballX > windowWidth) {
			ballMoveX = -ballMoveX;
		}
		if(ballY < 20 || ballY > windowHight) {
			ballMoveY = -ballMoveY;
		}
		
		ballX = ballX + ballMoveX;
		ballY = ballY + ballMoveY;
		this.repaint();
	}
}
