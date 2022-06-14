package com.example.vinkelapp_v_2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class MyCanvas extends View {
    Paint paint;
    public MyCanvas(Context context){
        super(context);
        paint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas){
        drawTriangle(canvas);
        super.onDraw(canvas);
    }

    private void drawTriangle(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);



        float verticalInput = 2;
        float horizontalInput = 10;
        float diagonalInput = 0;
        float[] coordinates;
        float scalar = 0;
        if(verticalInput > horizontalInput){
            //Vertical bigger than horizontal
            scalar = verticalInput / horizontalInput;
            coordinates = setup(Byte.parseByte("1"),scalar);
        }
        else if(horizontalInput > verticalInput){
            //Horizontal bigger than vertical
            scalar = horizontalInput / verticalInput;
            coordinates = setup(Byte.parseByte("2"),scalar);
        }
        else{
            //equal default case
            coordinates = setup(Byte.parseByte("3"),scalar);
        }
        //coordinates = setup(Byte.parseByte("1"),scalar);


        //Verical
        float vertialStopPosX = coordinates[0];
        float vertialStopPosY = coordinates[1];
        float vertialStartPosX = coordinates[2];
        float vertialStartPosY = coordinates[3];
        canvas.drawLine(vertialStartPosX,vertialStartPosY,vertialStopPosX,vertialStopPosY,paint);
        //Horizontal
        float horisontalStartPosX = coordinates[2];
        float horisontalStartPosY = coordinates[3];
        float horisontalStopPosX = coordinates[4];
        float horisontalStopPosY = coordinates[5];
        canvas.drawLine(horisontalStartPosX,horisontalStartPosY,horisontalStopPosX,horisontalStopPosY,paint);
        //Hypotenusan
        float hypotenusaStartPosX = coordinates[0];
        float hypotenusaStartPosY = coordinates[1];
        float hypotenusaStopPosX = coordinates[4];
        float hypotenusaStopPosY = coordinates[5];
        canvas.drawLine(hypotenusaStartPosX,hypotenusaStartPosY,hypotenusaStopPosX,hypotenusaStopPosY,paint);
    }

    private float[] setup(byte choice,float scalar){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        float topX;
        float topY;
        float leftX;
        float leftY;
        float rightX;
        float rightY;
        float[]coordinates=new float[6];
        leftX = width/6;
        leftY =  50 +  width/2;
        topX = width/6;
        rightY = 50 + width/2;
        switch(choice) {
            //Vertical bigger than horizontal
            case 1:
                topY = 50;
                rightX =width/6 +  (width/2)/ scalar;
                break;
            //Horizontal bigger than vertical
            case 2:
                topY = 50 + width/2 - (width/2) / scalar;
                rightX =width/6 +  width/2;
                break;
            default:
                topY = 50;
                rightX =  width/6 +  width/2 ;

        }
        coordinates[0] = topX;
        coordinates[1] = topY;
        coordinates[2] = leftX;
        coordinates[3] = leftY;
        coordinates[4] = rightX;
        coordinates[5] = rightY;
        return coordinates;
    }
}
