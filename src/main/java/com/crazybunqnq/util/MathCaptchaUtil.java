/*
package com.crazybunqnq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;

import java.util.Random;

public class MathCaptchaUtil {
    private static final char[] CHARS = { // 定义随机字符集
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static final String[] OPERATORS = { // 定义随机字符集
            "加上", "减去", "乘以", "除以", "+", "-", "×", "÷"};
    // 验证码固定参数，也就是将会用到的几个常量
    private static final int DEFAULT_FONT_SIZE = 20;// 字体大小
    private static final int DEFAULT_LINE_NUMBER = 3;// 默认的用于干扰视线直线的条数
    private static final int BASE_PADDING_LEFT = 10, RANGE_PADDING_LEFT = 15, BASE_PADDING_TOP = 20,
            RANGE_PADDING_TOP = 10;

    // width="60" height="30"
    // base_padding_left="5"
    // range_padding_left="10"
    // base_padding_top="15"
    // range_padding_top="10"
    // codeLength="4"
    // line_number="3"
    // font_size="20"
    */
/**
     * 上边4个整型数的解释： BASE_PADDING_LEFT,BASE_PADDING_TOP 表示每一个将要画出字符坐标计算的基准
     * RANGE_PADDING_LEFT,RANGE_PADDING_TOP 表示字符坐标x,y的变化范围
     *//*

    private static final int DEFAULT_WIDTH = 100, DEFAULT_HEIGHT = 30;
    private static MathCaptchaUtil vCode;
    int result;
    // 将一些常量应用到本类的成员变量上
    // settings decided by the layout xml
    // canvas width and height
    private int width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;
    // 设置位图宽高，具体的宽高取ImageView和BitMap之间较小的一个，
    // 即就是宽= min{ImageView.Width,Bitmap.Width},高同理
    // 注意：当我们需要一个不同尺寸的验证码图片，不仅仅需要修改DEFAULT_WIDTH 和DEFAULT_HEIGHT,为了显示效果
    // 的最佳化，最好将上述的4个坐标值也调整一下，使得我们的验证码能最恰当地占据整个底板
    // random word space and pading_top
    private int base_padding_left = BASE_PADDING_LEFT, range_padding_left = RANGE_PADDING_LEFT,
            base_padding_top = BASE_PADDING_TOP, range_padding_top = RANGE_PADDING_TOP;
    // number of chars, lines; font size
    private int line_number = DEFAULT_LINE_NUMBER, font_size = DEFAULT_FONT_SIZE;
    // variables
    private String code;// 存储随机生成的随机码序列
    private int padding_left, padding_top;// 左边框间距和上边框间距
    private Random random = new Random();// 随机数生成器

    public static MathCaptchaUtil getInstance() {// 单例模式获取验证码对象
        if (vCode == null)
            vCode = new MathCaptchaUtil();
        return vCode;
    }

    public Bitmap createBitmap() {// 得到位图对象

        padding_left = 0;// 设置位图左内边距离

        Bitmap bi = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);// 创建位图
        */
/**
         * 位图最后一个设置参数的简介 A：透明度 R：红色 G：绿 B：蓝 Bitmap.Config
         * ARGB_4444：每个像素占四位，即A=4，R=4，G=4，B=4，那么一个像素点占4+4+4+4=16位 Bitmap.Config
         * ARGB_8888：每个像素占四位，即A=8，R=8，G=8，B=8，那么一个像素点占8+8+8+8=32位 Bitmap.Config
         * RGB_565：每个像素占四位，即R=5，G=6，B=5，没有透明度，那么一个像素点占5+6+5=16位 Bitmap.Config
         * ALPHA_8：每个像素占四位，只有透明度，没有颜色。
         * 一般情况下我们都是使用的ARGB_8888，由此可知它是最占内存的，因为一个像素占32位，8位=1字节，所以一个像素占4字节的内存。假设有一张480x800的图片，如果格式为ARGB_8888，那么将会占用1500KB的内存
         *//*


        Canvas c = new Canvas(bi);// 以创建好的空位图创建画布

        code = createCode();// 生成目标字符串

        c.drawColor(Color.WHITE);
        Paint paint = new Paint();// 创建画笔
        paint.setTextSize(font_size);// 设置画笔的字体大小

        for (int i = 0; i < code.length(); i++) {// 画每一个字符
            randomTextStyle(paint);// 随机的画笔风格
            randomPadding();// 按照约定好的规则生成字符的坐标
            c.drawText(code.charAt(i) + "", padding_left, padding_top, paint);// 开始以随机的画笔和坐标画每一个字符
        }

        for (int i = 0; i < line_number; i++) {// 画事先设置好数量的几条横线
            drawLine(c, paint);
        }

        c.save(Canvas.ALL_SAVE_FLAG);// 保存在画布上的所有操作
        c.restore();
        return bi;// 返回画好的位图
    }

    private String createCode() {// 随机生成随机码
        StringBuilder buffer = new StringBuilder();
        buffer.append(CHARS[random.nextInt(CHARS.length)]);// 获取第一个运算数
        buffer.append(OPERATORS[random.nextInt(OPERATORS.length)]);// 获取运算符
        buffer.append(CHARS[random.nextInt(CHARS.length)]);// 获取第二个运算数
        buffer.append("=");
        return buffer.toString();
    }

    private void drawLine(Canvas canvas, Paint paint) {// 自定义的任意方向画横线的方法
        int color = randomColor();
        int startX = random.nextInt(width);
        int startY = random.nextInt(height);
        int stopX = random.nextInt(width);
        int stopY = random.nextInt(height);
        paint.setStrokeWidth(1);// 设置画笔粗细
        paint.setColor(color);// 颜色
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    private int randomColor() {
        return randomColor(1);
    }// 随机生成颜色

    private int randomColor(int rate) {
        int red = random.nextInt(256) / rate;
        int green = random.nextInt(256) / rate;
        int blue = random.nextInt(256) / rate;
        return Color.rgb(red, green, blue);
    }

    private void randomTextStyle(Paint paint) {// 随机的字体风格
        int color = randomColor();// 颜色
        paint.setColor(color);
        paint.setFakeBoldText(random.nextBoolean()); // 粗细；true为粗体，false为非粗体
        float skewX = random.nextInt(11) / 10F;
        skewX = random.nextBoolean() ? skewX : -skewX;
        paint.setTextSkewX(skewX); // float类型参数，负数表示右斜，整数左斜
        // paint.setUnderlineText(true); //true为下划线，false为非下划线
        // paint.setStrikeThruText(true); //true为删除线，false为非删除线
    }

    */
/**
     * 随机定义每一个字符所绘画的坐标，注意：在这里padding_left是具有叠加效果的，
     * 也就是说所画的字符越往后，坐标也就越大，而top永远就是base+range
     *//*

    private void randomPadding() {
        padding_left += base_padding_left + random.nextInt(range_padding_left);
        padding_top = base_padding_top + random.nextInt(range_padding_top);
    }

    public boolean checkCode(String input) {// 验证码校验
        result = 0;
        input = input.trim();// 除掉空格
        if (TextUtils.equals("", input))// 空输入判为错
            return false;

        int arg1 = char2Int(code.charAt(0));
        String opt = code.substring(1, code.length() - 2);// java区间遵循左闭右开原则，所以length-2取到的是倒数第二个字符
        int arg2 = char2Int(code.charAt(code.length() - 2));

        Log.i("result", arg1 + "  " + arg2);
        Log.i("opt", opt);

        switch (opt) {// 计算正确结果
            case "加上":
            case "+": {
                result = arg1 + arg2;
            }
            break;

            case "减去":
            case "-": {
                result = arg1 - arg2;
            }
            break;

            case "乘以":
            case "×": {
                result = arg1 * arg2;
            }
            break;

            case "除以":
            case "÷": {
                if (arg2 == 0)
                    result = 0;
                else
                    result = arg1 / arg2;
            }
            break;
            
            default:
                break;
        }

        if (Integer.parseInt(input) == result)// 如果在这里检测到异常抛出的话，容易使前边白做，因此提前
            return true;
        return false;
    }

    private int char2Int(char arg)// 利用下标来转换字符
    {
        for (int i = 0; i < CHARS.length; i++) {
            if (CHARS[i] == arg)
                if (i >= 10)
                    return i - 10;
                else
                    return i;
        }
        return 0;// 默认返回0
    }
}
*/
