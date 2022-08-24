package com.example.tipcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView total_per_person;
    private EditText amount;
    private Button less1;
    private Button plus1;
    private SeekBar seekBar;
    private  TextView seekbar_percentage;
    private TextView split_bt_no_of_person;
    private String number;
    private  TextView tip_amount;





    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total_per_person=findViewById(R.id.total_per_person);
        amount=findViewById(R.id.enter_amount);
        less1=findViewById(R.id.button_less_1);
        plus1=findViewById(R.id.button_plus1);
        seekBar=findViewById(R.id.seekBar);
        seekbar_percentage=findViewById(R.id.seekbar_percentage);
        split_bt_no_of_person=findViewById(R.id.split_between_no_of_person);
        tip_amount=findViewById(R.id.tip);





        less1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aa=split_bt_no_of_person.getText().toString();
                Integer person=Integer.parseInt(aa);
                //String aaa=amount.getText().toString().trim();

                if(person-- >1 )
                {number=person.toString();
                    split_bt_no_of_person.setText(number);
                    String a=amount.getText().toString().trim();
                    if(a.length()>0) {
                        Integer b = Integer.parseInt(a);
                        Integer c = b / person;
                        String value = c.toString();
                        total_per_person.setText(value);
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"At least one person is required",Toast.LENGTH_LONG).show();
                }
            }
        });





        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aa=split_bt_no_of_person.getText().toString();
                Integer person=Integer.parseInt(aa);
                person=person+1;
                number=person.toString();
                split_bt_no_of_person.setText(number);
                String  bb=amount.getText().toString().trim();

                if(bb.length() > 0) {
                    Integer cc = Integer.parseInt(bb);
                    Integer dd = cc / person;
                    String value = dd.toString();
                    total_per_person.setText(value);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter the amount",Toast.LENGTH_LONG).show();
                }
            }
        });





        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String aa=amount.getText().toString().trim();
                Integer money=Integer.parseInt(aa);
                String bb=split_bt_no_of_person.getText().toString();
                Integer cc=Integer.parseInt(bb);
                Integer each=money/cc;
                String value=each.toString();
                total_per_person.setText(value);
                String dd=seekbar_percentage.getText().toString().trim();
//                if(dd.length()>0 && aa.length()>0) {
//                    Double ee = Double.parseDouble(dd);
//                    Double ff = money / ee;
//                    String value1 = ff.toString();
//                    tip_amount.setText(value1);
//                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





seekBar.setMax(100);
seekBar.setMin(0);
seekBar.animate();
seekBar.setMinimumWidth(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                String aa=progress.to
//                seekbar_percentage.setText(progress);
                Integer aa=progress;
                String value=aa.toString();
                seekbar_percentage.setText(value+"%");

                String bb=amount.getText().toString().trim();
                if(bb.length()>0) {
                    Integer cc = Integer.parseInt(bb);
                    String dd = split_bt_no_of_person.getText().toString();
                    Integer ee = Integer.parseInt(dd);
                    Double zz = progress / 100.0;
                    Double tip = cc * zz;
                    String xx = tip.toString();
                    tip_amount.setText(xx);

                    Double total = tip + cc;
                    //
                    Double ff = total / ee;
                    String value1 = ff.toString();
                    total_per_person.setText(value1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}