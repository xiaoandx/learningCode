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
package club.xiaoandx.experiment7.assignment2.observer.impl;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import club.xiaoandx.experiment7.assignment2.observer.PanelObserver;
import club.xiaoandx.experiment7.assignment2.pojo.Attribute;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**  
 * <p> 可视化面板 </p> 
 * @ClassName:DynamicPanel2  
 * @author: WEI.ZHOU
 * @date: 2021-06-10 11:17
 * @since: JDK1.8
 * @version V1.0.0
 */
public class DynamicPanel extends JFrame implements PanelObserver{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 8906225104449345718L;
	private JPanel contentPane;
	private JTextField txtTest;
	private String name;
	private Attribute attribute;

	

	/**   
	 * @Title:  DynamicPanel2   
	 * @date: 2021-06-10 11:48
	 * @param name
	 * @throws HeadlessException 
	 * @since: 1.0.0
	 */
	public DynamicPanel(String name) throws HeadlessException {
		this.name = name;
	}
	
	/**
	 * Create the frame.
	 */
	public void init() {
		setTitle(this.name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("角色姓名");
		label.setBounds(299, 13, 68, 18);
		contentPane.add(label);
		
		JLabel lblAname = new JLabel(attribute.getAname());
		lblAname.setBounds(379, 13, 72, 18);
		contentPane.add(lblAname);
		
		JLabel labelheadURl = new JLabel("头像地址");
		labelheadURl.setBounds(10, 13, 68, 18);
		contentPane.add(labelheadURl);
		
		txtTest = new JTextField();
		txtTest.setText(attribute.getAheadUrl());
		txtTest.setBounds(92, 10, 153, 24);
		contentPane.add(txtTest);
		txtTest.setColumns(10);
		
		JLabel labelgrade = new JLabel("等级");
		labelgrade.setBounds(10, 64, 68, 18);
		contentPane.add(labelgrade);
		
		JLabel lblAgrade = new JLabel(String.valueOf(attribute.getAgrade()));
		lblAgrade.setBounds(92, 64, 72, 18);
		contentPane.add(lblAgrade);
		
		JLabel labelAcombatEffectiveeness = new JLabel("战斗力");
		labelAcombatEffectiveeness.setBounds(299, 64, 68, 18);
		contentPane.add(labelAcombatEffectiveeness);
		
		JLabel lblAcom = new JLabel(String.valueOf(attribute.getAcombatEffectiveeness()));
		lblAcom.setBounds(381, 64, 72, 18);
		contentPane.add(lblAcom);
		
		JLabel labellabelAexperience = new JLabel("经验值");
		labellabelAexperience.setBounds(299, 107, 68, 18);
		contentPane.add(labellabelAexperience);
		
		JLabel lblAex = new JLabel(String.valueOf(attribute.getAexperience()));
		lblAex.setBounds(381, 107, 72, 18);
		contentPane.add(lblAex);
		
		JLabel labelAdiamonds = new JLabel("钻石");
		labelAdiamonds.setBounds(10, 152, 68, 18);
		contentPane.add(labelAdiamonds);
		
		JLabel lblAsim = new JLabel(String.valueOf(attribute.getAdiamonds()));
		lblAsim.setBounds(92, 152, 72, 18);
		contentPane.add(lblAsim);
		
		JLabel lblAgol = new JLabel(String.valueOf(attribute.getAgoldCoin()));
		lblAgol.setBounds(381, 152, 72, 18);
		contentPane.add(lblAgol);
		
		JLabel labelAgoldCoin = new JLabel("金币");
		labelAgoldCoin.setBounds(299, 152, 68, 18);
		contentPane.add(labelAgoldCoin);
		this.setVisible(true);
	}

	/**   
	 * <p> </p></br>
	 * <p>Title: update</p> 
	 * @date: 2021-06-10 11:44    
	 * @param attr   
	 * @see club.xiaoandx.experiment7.assignment2.observer.PanelObserver#update(club.xiaoandx.experiment7.assignment2.pojo.Attribute)   
	 */
	@Override
	public void update(Attribute attr) {
		this.attribute = attr;
		showContext();
	}
	
	/**
	 * <p> </p></br>
	 * <p>Title: showContext</p> 
	 * @date: 2021-06-10 11:47       
	 * @see club.xiaoandx.experiment7.assignment2.observer.PanelObserver#showContext()
	 */
	@Override
	public void showContext() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
