package com.example.connect4h;

public class dot
{
    //0 == gray
    //1 == red
    //2 == yellow
    int color = 0 ;


    public dot(int mColor)
    {
        color = mColor;
    }

    public void setColor(int mColor)
    {
        color = mColor;
    }

    public int getColor()
    {
        return color;
    }
}
