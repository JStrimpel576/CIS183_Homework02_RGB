package com.example.cis183_homework02_rgb;

public class ColorInfo
{
    private int redValue;
    private int greenValue;
    private int blueValue;
    private String hexValue;

    public ColorInfo()
    {

    }

    public ColorInfo(int r, int g, int b, String h)
    {
        redValue = r;
        greenValue = g;
        blueValue = b;
        hexValue = h;
    }

    public int getRedValue()
    {
        return redValue;
    }

    public void setRedValue(int redValue)
    {
        this.redValue = redValue;
    }

    public int getGreenValue()
    {
        return greenValue;
    }

    public void setGreenValue(int greenValue)
    {
        this.greenValue = greenValue;
    }

    public int getBlueValue()
    {
        return blueValue;
    }

    public void setBlueValue(int blueValue)
    {
        this.blueValue = blueValue;
    }

    public String getHexValue()
    {
        return hexValue;
    }

    public void setHexValue(String hexValue)
    {
        this.hexValue = hexValue;
    }
}
