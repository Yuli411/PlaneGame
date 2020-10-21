package com.ppp.listener;

import com.ppp.view.BaseFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/13 00:08
 * @Description:
 */
public class FrameMouseListener implements MouseListener {
    private BaseFrame baseFrame;
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //reset X and Y
        baseFrame.myPanel.getPlayer().setX(mouseEvent.getX()-baseFrame.myPanel.getPlayer().getWidth()/2);
        baseFrame.myPanel.getPlayer().setY(mouseEvent.getY()-baseFrame.myPanel.getPlayer().getHeight()  /2);

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public FrameMouseListener(BaseFrame baseFrame) {
        this.baseFrame = baseFrame;
    }
}
