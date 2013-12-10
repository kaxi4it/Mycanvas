package com.kaxi.mycanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by Bada on 13-12-10.
 */
public class MyDraw extends View{

    Paint paint;
    Float left=100.0f;//所有色块
    Float top=10.0f;//所有色块
    Float right=400.0f;//所有色块
    Float bottom=710.0f;//所有色块
    int heightX=4;//色块数
    int widthX=6;//次数
    Float height;//单色块高
    Float width;//单次数宽

    public MyDraw(Context context,AttributeSet attr){
        super(context,attr);
        paint=new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(1);
    }

    public MyDraw(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        height=(bottom-top)/heightX;
        width=(right-left)/widthX;

        //四色背景
        paint.setColor(Color.GRAY);
        RectF rect0 = new RectF(left, top, 430, 160);
        canvas.drawRect(rect0,paint);
        paint.setColor(Color.GREEN);
        RectF rect1 = new RectF(left, top+height*1, 430, 310);
        canvas.drawRect(rect1,paint);
        paint.setColor(Color.RED);
        RectF rect2 = new RectF(left,  top+height*2, 430, 460);
        canvas.drawRect(rect2,paint);
        paint.setColor(Color.BLUE);
        RectF rect3 = new RectF(left,  top+height*3, 430, 610);
        canvas.drawRect(rect3,paint);
        paint.setColor(Color.BLACK);
        canvas.drawLine(90.0F,610.0F,440.0F,610.0F,paint);//横
        canvas.drawLine(90.0F,460.0F,440.0F,460.0F,paint);
        canvas.drawLine(90.0F,310.0F,440.0F,310.0F,paint);
        canvas.drawLine(90.0F,160.0F,440.0F,160.0F,paint);
        canvas.drawLine(100.0F,0.0F,100.0F,620.0F,paint);//竖



    }

}
