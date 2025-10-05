//===================================================================================
//Name : Joshua Strimpel
//Date : 09-29-25
//Desc : An RGB app that allows you to change the background color and save the color
//===================================================================================

package com.example.cis183_homework02_rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    TextView tv_j_red;
    TextView tv_j_redValue;
    SeekBar  sb_j_redSeekbar;
    TextView tv_j_green;
    TextView tv_j_greenValue;
    SeekBar  sb_j_greenSeekbar;
    TextView tv_j_blue;
    TextView tv_j_blueValue;
    SeekBar  sb_j_blueSeekbar;
    TextView tv_j_hex;
    TextView tv_j_hexValue;
    Button btn_j_saveColor;
    ArrayList<ColorInfo> listOfColors;
    ListView lv_j_listOfColors;
    private ColorListAdapter clAdapter;
    ColorInfo colorInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //red
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_redValue = findViewById(R.id.tv_v_redValue);
        sb_j_redSeekbar = findViewById(R.id.sb_v_redSeekbar);

        //green
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_greenValue = findViewById(R.id.tv_v_greenValue);
        sb_j_greenSeekbar = findViewById(R.id.sb_v_greenSeekbar);

        //blue
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_blueValue = findViewById(R.id.tv_v_blueValue);
        sb_j_blueSeekbar = findViewById(R.id.sb_v_blueSeekbar);

        //hex
        tv_j_hex = findViewById(R.id.tv_v_hex);
        tv_j_hexValue = findViewById(R.id.tv_v_hexValue);

        //list view
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);
        listOfColors = new ArrayList<>();

        //set max value for all seekbars
        sb_j_redSeekbar.setMax(255);
        sb_j_greenSeekbar.setMax(255);
        sb_j_blueSeekbar.setMax(255);

        //set starting value for all seekbars
        sb_j_redSeekbar.setProgress(0);
        sb_j_greenSeekbar.setProgress(0);
        sb_j_blueSeekbar.setProgress(0);

        seekBarChangeListener();
        saveColorButtonOnClickListener();
        listViewOnClickListener();
    }

    private void seekBarChangeListener()
    {
        sb_j_redSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {

                tv_j_redValue.setText(String.valueOf(progress));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        sb_j_greenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                tv_j_greenValue.setText(String.valueOf(progress));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_blueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                tv_j_blueValue.setText(String.valueOf(progress));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateHexValue()
    {
        int redValue = sb_j_redSeekbar.getProgress();
        int greenValue = sb_j_greenSeekbar.getProgress();
        int blueValue = sb_j_blueSeekbar.getProgress();

        //use String.format to get the values to display in correct hexadecimal format.
        String hexValue = String.format("%02X%02X%02X", redValue, greenValue, blueValue);

        colorInfo = new ColorInfo(redValue, greenValue, blueValue, hexValue);

        tv_j_hexValue.setText(hexValue);

        //call another function to update the background color
        updateBackgroundColor(hexValue);

        if(redValue >= 170 || greenValue >= 170 || blueValue >= 225)
        {
            //Text color too bright
            changeTextColorBlack();
        }

        else
        {
            //Text color too dark
            changeTextColorWhite();
        }
    }

    private void updateBackgroundColor(String hexValue)
    {
        //get the constraint layout to be able to set the background color.
        ConstraintLayout mainLayout = findViewById(R.id.main);

        //add a '#' before the hexValue so the value is properly read.
        mainLayout.setBackgroundColor(Color.parseColor("#" + hexValue));
    }

    private void changeTextColorBlack()
    {
        tv_j_red.setTextColor(Color.BLACK);
        tv_j_redValue.setTextColor(Color.BLACK);

        tv_j_green.setTextColor(Color.BLACK);
        tv_j_greenValue.setTextColor(Color.BLACK);

        tv_j_blue.setTextColor(Color.BLACK);
        tv_j_blueValue.setTextColor(Color.BLACK);

        tv_j_hex.setTextColor(Color.BLACK);
        tv_j_hexValue.setTextColor(Color.BLACK);
    }

    private void changeTextColorWhite()
    {
        tv_j_red.setTextColor(Color.WHITE);
        tv_j_redValue.setTextColor(Color.WHITE);

        tv_j_green.setTextColor(Color.WHITE);
        tv_j_greenValue.setTextColor(Color.WHITE);

        tv_j_blue.setTextColor(Color.WHITE);
        tv_j_blueValue.setTextColor(Color.WHITE);

        tv_j_hex.setTextColor(Color.WHITE);
        tv_j_hexValue.setTextColor(Color.WHITE);
    }

    private void saveColorButtonOnClickListener()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fillListView();

                //reset seekbars
                sb_j_redSeekbar.setProgress(0);
                sb_j_blueSeekbar.setProgress(0);
                sb_j_greenSeekbar.setProgress(0);
            }
        });
    }

    private void fillListView()
    {
        listOfColors.add(colorInfo);
        //Log.d("Color Info: ", listOfColors.get(0).getHexValue());

        clAdapter = new ColorListAdapter(this, listOfColors);
        lv_j_listOfColors.setAdapter(clAdapter);
    }

    private void listViewOnClickListener()
    {
        //create an on click listener for the list view to be able to display a selected color.
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                ColorInfo colorSelected = listOfColors.get(i);
                displaySelectedColor(colorSelected);
            }
        });
    }

    private void displaySelectedColor(ColorInfo colorSelected)
    {
        sb_j_redSeekbar.setProgress(colorSelected.getRedValue());
        sb_j_greenSeekbar.setProgress(colorSelected.getGreenValue());
        sb_j_blueSeekbar.setProgress(colorSelected.getBlueValue());
    }

}