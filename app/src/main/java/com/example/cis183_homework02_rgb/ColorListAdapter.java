package com.example.cis183_homework02_rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{

    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.color_cell, null);
        }
        TextView redValue = view.findViewById(R.id.tv_v_cell_redValue);
        TextView greenValue = view.findViewById(R.id.tv_v_cell_greenValue);
        TextView blueValue = view.findViewById(R.id.tv_v_cell_blueValue);
        TextView hexValue = view.findViewById(R.id.tv_v_cell_hexValue);

        ColorInfo color = listOfColors.get(i);
        View backgroundView = view.findViewById(R.id.cl_v_cell_background);

        redValue.setText("Red: " + color.getRedValue());
        greenValue.setText("Green: " + color.getGreenValue());
        blueValue.setText("Blue: " + color.getBlueValue());
        hexValue.setText("Hex: " + color.getHexValue());

        backgroundView.setBackgroundColor(Color.parseColor("#" + color.getHexValue()));

        if(color.getRedValue() >= 170 || color.getGreenValue() >= 170 || color.getBlueValue() >= 225)
        {
            redValue.setTextColor(Color.BLACK);
            greenValue.setTextColor(Color.BLACK);
            blueValue.setTextColor(Color.BLACK);
            hexValue.setTextColor(Color.BLACK);
        }

        else
        {
            redValue.setTextColor(Color.WHITE);
            greenValue.setTextColor(Color.WHITE);
            blueValue.setTextColor(Color.WHITE);
            hexValue.setTextColor(Color.WHITE);
        }


        return view;
    }
}
