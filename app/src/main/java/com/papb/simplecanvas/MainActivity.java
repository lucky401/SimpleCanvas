package com.papb.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.FAKE_BOLD_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
        mPaintText.setTextSize(50);
    }

    public void drawSomething(View view) {
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth, vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.LTGRAY);
        mCanvas.drawText(getString(R.string.nama), 100,100,mPaintText);

//        mPaint.setColor(Color.BLUE);
//        mPaint.setStrokeWidth(6);
//        mCanvas.drawLine(100,150,400,150,mPaint);

        //Todo: This was made for android with 1080p resolution, other resolution may have different result

        //BASE WALL
        mPaint.setColor(Color.YELLOW);
        Rect mRect=new Rect();
        mRect.set(300,700,800,1000);
        mCanvas.drawRect(mRect,mPaint);

        //DOOR
        mPaint.setColor(Color.MAGENTA);
        Rect mRect2=new Rect();
        mRect2.set(600,800,700,1000);
        mCanvas.drawRect(mRect2,mPaint);

        //WINDOW
        mPaint.setColor(Color.GRAY);
        Rect mRect3=new Rect();
        mRect3.set(400,800,500,900);
        mCanvas.drawRect(mRect3,mPaint);

        //ROOF
        Path path=new Path();
        path.moveTo(250,700);
        path.lineTo(850,700);
        path.lineTo(550,500);
        path.lineTo(250,700);
        mPaint.setColor(Color.RED);
        mCanvas.drawPath(path,mPaint);

        mPaint.setColor(Color.GREEN);
        Rect mRect4=new Rect();
        mRect4.set(100,1000,1000,1150);
        mCanvas.drawRect(mRect4,mPaint);

        view.invalidate();
    }
}