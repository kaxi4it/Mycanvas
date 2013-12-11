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
    Float bottom=610.0f;//所有色块
    int heightX=4;//色块数
    int widthX=6;//次数
    Float height;//单色块高
    Float width;//单次数宽
    Float mTextSize=25.0f;
    String[] values = new String[]{"300","200","100","  0"};
    int[] colors = new int[]{Color.parseColor("#ffa4a3"),Color.parseColor("#ffd36a"),Color.parseColor("#aee959"),Color.parseColor("#99deff")};
//    #ffa4a3
//    #ffd36a
//    #aee959
//    #99deff

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
        RectF rect=new RectF();

        for(int i=0;i<heightX;i++){
            paint.setColor(colors[i]);
            rect.set(left, top+height*i, right, top+height*(i+1));//l,t,r,b
            canvas.drawRect(rect,paint);
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(mTextSize);
        for (int i=0;i<heightX;i++){
            canvas.drawLine(left-10,top+height*(i+1),right+10,top+height*(i+1),paint);
            canvas.drawText(values[i],left-50,top+height*(i+1),paint);
        }

        canvas.drawLine(100.0F,0.0F,100.0F,620.0F,paint);//竖



    }

}
