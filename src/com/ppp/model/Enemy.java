package com.ppp.model;

import com.ppp.thread.MusicThread;
import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;
import java.util.List;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 12:57
 * @Description:
 */
public abstract class Enemy {
    public MyPanel myPanel;
    public int width ;
    public int height ;
    public Image image;
    public int x;
    public int y;
    public int hp;
    public int speed;
    public Image[] dieImages = new Image[]{

            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die01.png"),
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die02.png"),
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die03.png"),
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die04.png")
    };
    public int dieImageIndex = 0;
    public Item[] items;
    public Bullet[] bullets = new Bullet[1];

    public Enemy(){

    }
    public Enemy(MyPanel myPanel){
        this.myPanel = myPanel;

    }


    public void drawEnemy(Graphics graphics){
        if (hp > 0){
            graphics.drawImage(image,x,y,width,height,null);
            //move according to speed;
            if (myPanel.getTimer() % speed == 0){
                y++;
                if (y > BaseFrame.frameHeight){
                    myPanel.getEnemies().remove(this);
                }
            }

        }else{
            graphics.drawImage(dieImages[dieImageIndex],x,y,45,45,null);
            if (myPanel.getTimer() % 10 == 0){
                dieImageIndex++;
                if (dieImageIndex == dieImages.length){
                    killed();
                }
            }
        }

    }

    public void killed(){
        new MusicThread("video/boom.wav").start();
        myPanel.getEnemies().remove(this);
        //release items
        if (items != null && items.length > 0) {
            for (int i = 0 ;i < items.length; i++){
                items[i].x = this.x + 20 * i;
                items[i].y = this.y;
                myPanel.getItems().add(items[i]);
            }
        }


    }

    public void attacked(){
        if (hp > 0){
            hp --;
        }
    }


}
