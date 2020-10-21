package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/12 23:19
 * @Description:
 */
public class Player {
    private MyPanel myPanel;
    private int timer;
    private Image[] images;
    // image size
    private int width = 100;
    private int height = 100;
    //
    private int x = (int)(BaseFrame.frameWidth - width)/2;
    private int y = (int)BaseFrame.frameHeight - 2 * height;
    private int i = 0;
    private int attackMode = 1;
    private int hp = 5;
    private int count = 0;
    private Image[] diedImages = new Image[]{
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die01.png"),
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die02.png"),
            Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\die03.png"),
    };
    private int dieIndex;

    public Player(){

    }

    public Player(MyPanel myPanel){
        this.myPanel = myPanel;
        timer = myPanel.getTimer();
        images = new Image[]{
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player01.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player02.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player03.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player04.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player05.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player06.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player07.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player08.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\player09.png"),


        };
    }

    public MyPanel getMyPanel() {
        return myPanel;
    }

    public void setMyPanel(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getI() {
        return i;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }


    public int getAttackMode() {
        return attackMode;
    }

    public void setAttackMode(int attackMode) {
        this.attackMode = attackMode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void drawItself(Graphics graphics){


        if (hp > 0) {
            graphics.drawImage(images[i], x, y, width, height, null);

            if (timer % 100 == 0) {
                i++;
                if (i == images.length) {
                    i = 0;
                }
            }

            for (Item item : myPanel.getItems()) {
                if (x <= item.x + item.width && x >= item.x - width && y >= item.y - height && y <= item.y + item.height) {
                    item.eaten();
                }
            }
        }else{
            if (dieIndex == diedImages.length){
                graphics.drawString("Game Over",BaseFrame.frameWidth/2,BaseFrame.frameHeight/2);
            }else {
                graphics.drawImage(diedImages[dieIndex], x, y, width, height, null);
                if (timer % 10 == 0) {
                    dieIndex++;
                }
            }
        }

    }




}
