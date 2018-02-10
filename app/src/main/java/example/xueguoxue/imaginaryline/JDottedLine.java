package example.xueguoxue.imaginaryline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xueguoxue on 2018/2/9.
 */

public class JDottedLine extends View {

    private Paint mDotPaint;

    public JDottedLine(Context context) {
        super(context);
        initView();
    }

    public JDottedLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JDottedLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mDotPaint = new Paint();
        mDotPaint.setColor(Color.parseColor("#FF6677")); //画笔颜色
        mDotPaint.setStrokeWidth(2); //画笔宽度
        // 1、STROKE 描边
        // 2、FILL_AND_STROKE 填充内部和描边
        // 3、FILL：填充内部
        mDotPaint.setStyle(Paint.Style.STROKE);
        //1、Cap.BUTT 这条路径结束，而不是超越它。
        //2、Cap.ROUND 结束是个半圆
        //3、Cap.SQUARE 结束是个方形
        mDotPaint.setStrokeCap(Paint.Cap.ROUND);//
        //设置抗锯齿
        mDotPaint.setAntiAlias(true);
        //设置是否抖动
        mDotPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startY = getHeight();
        float startX = getWidth() / 2;
        DashPathEffect dashPathEffect =
                new DashPathEffect(new float[]{8, 10, 8, 10}, 0);
        mDotPaint.setPathEffect(dashPathEffect);
        Path path = new Path();
        path.moveTo(startX,0);
        path.lineTo(startX,startY);
        canvas.drawPath(path,mDotPaint);
    }
}
