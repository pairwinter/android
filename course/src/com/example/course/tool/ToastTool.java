package com.example.course.tool;

import android.content.Context;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: damon
 * Date: 5/29/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToastTool {
    private static Toast toast;
    public static void showToast(Context context,String text){
        if(toast!=null){
            toast.cancel();
            toast.setText(text);
            toast.show();
        }else{
            toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public static void cancelToast(){
        if(toast!=null){
            toast.cancel();
        }
    }
}
