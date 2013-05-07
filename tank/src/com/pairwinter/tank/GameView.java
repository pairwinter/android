package com.pairwinter.tank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.BitmapFactory.*;

/**
 * Created with IntelliJ IDEA.
 * User: pairwinter
 * Date: 13-4-21
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public class GameView extends View {
    int x=0,y=this.getTop()+50;
    int logX=0,logY=0;
    Rect[] rects = null;
    public GameView(Context context) {
        super(context);
        setFocusable(true);
    }
    private Bitmap generateBitmap(int id){
        Resources resources = this.getContext().getResources();
        return BitmapFactory.decodeResource(resources,id);
    }
    private Bitmap tankBitmap(){
        return this.generateBitmap(R.drawable.tank);
    }

    private Bitmap[] controllerBitmap(){
        Bitmap[] bitmaps = new Bitmap[4];
        Bitmap controllerBitmap = this.generateBitmap(R.drawable.icon);
        bitmaps[0] = Bitmap.createBitmap(controllerBitmap,dip2px(159),dip2px(339), dip2px(14),dip2px(13));//up
        bitmaps[1] = Bitmap.createBitmap(controllerBitmap,dip2px(113),dip2px(339), dip2px(14),dip2px(13));//down
        bitmaps[2] = Bitmap.createBitmap(controllerBitmap,dip2px(70),dip2px(339), dip2px(14),dip2px(13));//left
        bitmaps[3] = Bitmap.createBitmap(controllerBitmap,dip2px(24),dip2px(339), dip2px(14),dip2px(13));//right
        return  bitmaps;
    }
    private Paint headerPaint(){
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(Boolean.TRUE.booleanValue());
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize((float) 30);
        textPaint.setTextAlign(Paint.Align.CENTER);
        return textPaint;
    }

    private Rect[] controllerAreaRect(){
        Rect[] rects = new Rect[4];
        Rect up = new Rect(getLeft(),this.getBottom()-(300),this.getRight(),this.getBottom()-(200));
        Rect down = new Rect(getLeft(),this.getBottom()-(100),this.getRight(),this.getBottom());
        Rect left = new Rect(getLeft(),this.getBottom()-(200),this.getRight()/2,this.getBottom()-(100));
        Rect right = new Rect(getRight()/2,getBottom()-(200),this.getRight(),this.getBottom()-(100));
//        Rect up = new Rect(this.getLeft(),this.getBottom()-200,this.getRight(),this.getBottom()-150);
//        Rect down = new Rect(this.getLeft(),this.getBottom()-150,this.getRight(),this.getBottom()-100);
//        Rect left = new Rect(this.getLeft(),this.getBottom()-100,this.getRight(),this.getBottom()-50);
//        Rect right = new Rect(this.getLeft(),this.getBottom()-50,this.getRight(),this.getBottom());
        rects[0] = up;
        rects[1] = down;
        rects[2] = left;
        rects[3] = right;
        return rects;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.
        rects = controllerAreaRect();
        canvas.drawColor(Color.WHITE);
        canvas.drawText("Tank War"+"("+logX+","+logY+")",this.getRight()/2,30,headerPaint());
        canvas.drawBitmap(this.tankBitmap(),x,y,new Paint());
        Bitmap[] controllerBitmap = controllerBitmap();
        canvas.drawBitmap(controllerBitmap[0],this.getRight()/2-dip2px(4),this.getBottom()-dip2px(150),new Paint());
        canvas.drawBitmap(controllerBitmap[1],this.getRight()/2-dip2px(4),this.getBottom()-dip2px(50),new Paint());
        canvas.drawBitmap(controllerBitmap[2],this.getLeft()+dip2px(50),this.getBottom()-dip2px(100),new Paint());
        canvas.drawBitmap(controllerBitmap[3],this.getRight()-dip2px(8)-dip2px(50),this.getBottom()-dip2px(100),new Paint());
//        canvas.drawBitmap(this.generateBitmap(R.drawable.icon),this.getLeft(),0,new Paint());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP:
                y -= 10;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                y += 10;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                x -= 10;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                x += 10;
                break;
        }
        postInvalidate();
        return super.onKeyDown(keyCode, event);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            int ax = (int)event.getX();
            int ay = (int)event.getY();
            if(rects[0].contains(ax,ay)){ //up
                y-=10;
            }else if(rects[1].contains(ax,ay)){ //down
                y+=10;
            }else if(rects[2].contains(ax,ay)){ //left
                x-=10;
            }else if(rects[3].contains(ax,ay)){ //right
                x+=10;
            }else {
                logX=ax;
                logY=ay;
            }
            postInvalidate();
        }

        return super.onTouchEvent(event);    //To change body of overridden methods use File | Settings | File Templates.
    }

    private int dip2px(int dip){
        return BastTools.dip2px(this.getContext(),dip);
    }
}
