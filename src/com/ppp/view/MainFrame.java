package com.ppp.view;

import com.ppp.listener.FrameMouseListener;
import com.ppp.model.Enemy01;
import com.ppp.model.Enemy02;
import com.ppp.model.Enemy03;
import com.ppp.model.Enemy07;
import com.ppp.thread.MusicThread;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 13:11
 * @Description:
 */
public class MainFrame extends BaseFrame {

    public MainFrame(){
        super();
        setTouchListener();
        createPlayer();
        setAttackMode(1);
        addEnemyType(Enemy01.class);
        addEnemyType(Enemy02.class);
        addEnemyType(Enemy03.class);
        addEnemyType(Enemy07.class);
        new MusicThread("video/bjmusic.wav").start();


    }
}
