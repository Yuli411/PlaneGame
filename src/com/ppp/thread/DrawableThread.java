package com.ppp.thread;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/12 22:51
 * @Description:
 */
public class DrawableThread extends Thread {
    private MyPanel myPanel;

    public DrawableThread(MyPanel myPanel){
        this.myPanel = myPanel;
    }

    @Override
    public void run() {
        while (myPanel.getPlayer() == null || myPanel.getPlayer().getHp() > 0){
            //redraw panel each 1ms
                myPanel.repaint();// rappeler paintComponent();

            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
