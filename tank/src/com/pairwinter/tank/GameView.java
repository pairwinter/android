package com.pairwinter.tank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.KeyEvent;
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
    int x=0,y=0;
    public GameView(Context context) {
        super(context);
        setFocusable(true);
    }
    private Bitmap generateBitmap(int id){
        Resources resources = this.getContext().getResources();
        return BitmapFactory.decodeResource(resources,id);
    }
    private Bitmap tankBitmap(){
//        return this.generateBitmap(R.drawable.)
        return null;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(Boolean.TRUE.booleanValue());
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize((float)30);

        canvas.drawColor(Color.WHITE);
//        canvas.drawText("Tank",0,50,textPaint);
//        canvas.drawBitmap(this.generateBitmap(R.drawable.battlecity),0,0,new Paint());
        canvas.drawBitmap(this.generateBitmap(R.drawable.game_operator_pick_cycle),this.getLeft(),this.getBottom()-300,new Paint());
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
}
