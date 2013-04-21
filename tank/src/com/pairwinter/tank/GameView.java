package com.pairwinter.tank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
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
    Bitmap bitmap;
    int x=0,y=0;
    public GameView(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.bitmap = BitmapFactory.decodeResource(resources,R.drawable.battlecity);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.
        Paint textPaint = new Paint();
        textPaint.setColor(0xff0000);
        canvas.drawColor(0xffffff);
        canvas.drawText("Tank",0,50,textPaint);
        canvas.drawBitmap(bitmap,50,100,new Paint());
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
