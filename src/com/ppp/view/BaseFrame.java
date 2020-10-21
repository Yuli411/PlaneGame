package com.ppp.view;

import com.ppp.listener.FrameMouseListener;
import com.ppp.model.Enemy;
import com.ppp.model.Enemy01;
import com.ppp.model.Player;
import com.ppp.thread.DrawableThread;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/4/12 23:12
 * @Description:
 */
public class BaseFrame extends JFrame {
    //窗口大小
    public static int frameWidth = 512;
    public static int frameHeight = 768;
    public static MyPanel myPanel;
    public DrawableThread drawableThread;
    public FrameMouseListener frameMouseListener;

    public BaseFrame() {
        //窗口名字 调用父类初始化lable的构造器进行数据初始化赋值
        super("Plane Game");
        //获得屏幕分辨率
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //设置窗口弹出的初始位置和尺寸，相对于屏幕
        this.setBounds((int) ((screenSize.getWidth() - frameWidth) / 2), 0, frameWidth, frameHeight);
        //设置窗口大小不能变
        this.setResizable(false);
        //设置窗口布局0 对于新建的窗口对象
        this.setLayout(null);
        //创建mypanel
        myPanel = new MyPanel();
        //设置myPanel对象的位置，相对于窗口 est (0,0)
        myPanel.setBounds(0,0,frameWidth,frameHeight);
        //将组件添加到窗口中
        this.add(myPanel);
        drawableThread = new DrawableThread(myPanel);
        drawableThread.start();
        //add mouse listener into frame
        //显示窗口
        setVisible(true);
        //设置关闭 窗口关闭则应用程序结束运行
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }



    public void setTouchListener(){
        frameMouseListener = new FrameMouseListener(this);
        //register listener
        this.addMouseListener(frameMouseListener);
    }

    public void createPlayer(){
        myPanel.createPlayer();
    }

    public void setAttackMode(int mode){
        myPanel.getPlayer().setAttackMode(mode);
    }

    public void addEnemyType(Class typeOfEnemy){
        myPanel.getTypesOfEnemies().add(typeOfEnemy);
    }



}
