package com.kaxi.mycanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.math.BigDecimal;
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
    String[] values = new String[]{"300","200","100","  0"};//结果标尺
    String[] counts = new String[]{"1","2","3","4","5","6"};//次数
    Float[] points = new Float[]{55f,250f,144f,22f,205f,111f};//结果数值
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
        width=(right-left)/(widthX-1);
        RectF rect=new RectF();

        for(int i=0;i<heightX;i++){
            paint.setColor(colors[i]);
            rect.set(left, top+height*i, right, top+height*(i+1));//l,t,r,b
            canvas.drawRect(rect,paint);
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(mTextSize);
        for (int i=0;i<heightX;i++){//横
            canvas.drawLine(left-10,top+height*(i+1),right+10,top+height*(i+1),paint);
            canvas.drawText(values[i],left-50,top+height*(i+1),paint);
        }

//        canvas.drawLine(left,top-10,left,bottom+10,paint);//竖
        for(int i=0;i<widthX;i++){//竖
            canvas.drawLine(left+width*i,top-10,left+width*i,bottom+10,paint);
            canvas.drawText(counts[i],left+width*i,bottom+10+mTextSize,paint);
        }

        BigDecimal a=new BigDecimal(bottom-top);
        BigDecimal b=new BigDecimal(400);
        BigDecimal c=a.divide(b,2,BigDecimal.ROUND_HALF_UP);

        //结果确认坐标
        for(int i=0;i<widthX-1;i++){
            //55

            Float X1=left+width*i;
            Float Y1=(bottom-top)-points[i]*(c.floatValue());
            Float X2=left+width*(i+1);
            Float Y2=(bottom-top)-points[i+1]*(c.floatValue());
            canvas.drawCircle(X1,Y1,8,paint);
            canvas.drawCircle(X2,Y2,8,paint);
            paint.setStrokeWidth(3);
            canvas.drawLine(X1,Y1,X2,Y2,paint);

        }


    }

}
