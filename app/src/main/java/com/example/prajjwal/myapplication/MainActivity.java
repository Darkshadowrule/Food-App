package com.example.prajjwal.myapplication;
//package com.foodbil.com.foodbillapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CheckBox cb1,cb2,cb3,cb4,cb5;
    TextView isum;
    Button bp1,bp2,bp3,bp4,bp5,bm1,bm2,bm3,bm4,bm5,reset,sum,next;
    EditText i1,i2,i3,i4,i5;
    public int count1=0,count2=0,count3=0,count4=0,count5=0,total=0;
    HashMap<String,String> m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1=findViewById(R.id.pizza_cb);
        cb2=findViewById(R.id.burger_cb);
        cb3=findViewById(R.id.maggi_cb);
        cb4=findViewById(R.id.momos_cb);
        cb5=findViewById(R.id.coffee_cb);
        bp1=findViewById(R.id.pizza_plus);
        bp2=findViewById(R.id.burger_plus);
        bp3=findViewById(R.id.maggi_plus);
        bp4=findViewById(R.id.momos_plus);
        bp5=findViewById(R.id.coffee_plus);
        bm1=findViewById(R.id.pizza_minus);
        bm2=findViewById(R.id.burger_minus);
        bm3=findViewById(R.id.maggi_minus);
        bm4=findViewById(R.id.momos_minus);
        bm5=findViewById(R.id.coffee_minus);
        reset=findViewById(R.id.reset_button);
        sum=findViewById(R.id.sum_button);
        next=findViewById(R.id.next_button);
        i1=findViewById(R.id.pizza_text);
        i2=findViewById(R.id.burger_text);
        i3=findViewById(R.id.maggi_text);
        i4=findViewById(R.id.momos_text);
        i5=findViewById(R.id.coffee_text);
        isum=findViewById(R.id.sum_text);
        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);
        cb4.setOnClickListener(this);
        cb5.setOnClickListener(this);
        bp1.setOnClickListener(this);
        bp2.setOnClickListener(this);
        bp3.setOnClickListener(this);
        bp4.setOnClickListener(this);
        bp5.setOnClickListener(this);
        bm1.setOnClickListener(this);
        bm2.setOnClickListener(this);
        bm3.setOnClickListener(this);
        bm4.setOnClickListener(this);
        bm5.setOnClickListener(this);
        reset.setOnClickListener(this);
        next.setOnClickListener(this);
        sum.setOnClickListener(this);
        next.setEnabled(false);
        bp1.setEnabled(false);
        bp2.setEnabled(false);
        bp3.setEnabled(false);
        bp4.setEnabled(false);
        bp5.setEnabled(false);
        bm1.setEnabled(false);
        bm2.setEnabled(false);
        bm3.setEnabled(false);
        bm4.setEnabled(false);
        bm5.setEnabled(false);
        sum.setEnabled(false);
        isum.setEnabled(false);
        i1.setEnabled(false);
        i2.setEnabled(false);
        i3.setEnabled(false);
        i4.setEnabled(false);
        i5.setEnabled(false);
        m=new HashMap<>();

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.pizza_cb)
        {
            if(!cb1.isChecked())
            {count1=0;
                bp1.setEnabled(false);
                bm1.setEnabled(false);
                i1.setEnabled(false);
                i1.setText("0");
            }
            else
            {bp1.setEnabled(true);
                sum.setEnabled(true);
                bm1.setEnabled(true);
                i1.setEnabled(true);

            }
        }
        if(view.getId()==R.id.burger_cb)
        {
            if(!cb2.isChecked())
            {count2=0;
                i2.setText("0");
                bp2.setEnabled(false);
                bm2.setEnabled(false);
                i2.setEnabled(false);
            }
            else
            {
                bp2.setEnabled(true);
                bm2.setEnabled(true);
                sum.setEnabled(true);
                i2.setEnabled(true);
            }
        }
        if(view.getId()==R.id.maggi_cb)
        {
            if(!cb3.isChecked())
            {count3=0;
                bp3.setEnabled(false);
                bm3.setEnabled(false);
                i3.setEnabled(false);
                i3.setText("0");
            }
            else{
                bp3.setEnabled(true);
                bm3.setEnabled(true);
                i3.setEnabled(true);
                sum.setEnabled(true);

            }

        }
        if(view.getId()==R.id.momos_cb)
        {
            if(!cb4.isChecked())
            {count4=0;
                bp4.setEnabled(false);
                bm4.setEnabled(false);
                i4.setEnabled(false);
                i4.setText("0");
            }
            else
            {
                bp4.setEnabled(true);
                bm4.setEnabled(true);
                sum.setEnabled(true);
                i4.setEnabled(true);
            }
        }
        if(view.getId()==R.id.coffee_cb)
        {
            if(!cb5.isChecked())
            {count5=0;
                bp5.setEnabled(false);
                bm5.setEnabled(false);
                i5.setEnabled(false);
                i5.setText("0");
            }
            else
            {
                bp5.setEnabled(true);
                bm5.setEnabled(true);
                i5.setEnabled(true);
                sum.setEnabled(true);

            }
        }
        if(view.getId()==R.id.pizza_plus)
        {
            if(cb1.isChecked())
            {count1=Integer.parseInt(i1.getText().toString());
                count1++;
                i1.setText(String.valueOf(count1));
            }
        }
        if(view.getId()==R.id.burger_plus)
        {
            if(cb2.isChecked())
            { count2=Integer.parseInt(i2.getText().toString());
                count2++;
                i2.setText(String.valueOf(count2));
            }
        }
        if(view.getId()==R.id.maggi_plus)
        {
            if(cb3.isChecked())
            { count3=Integer.parseInt(i3.getText().toString());
                count3++;
                i3.setText(String.valueOf(count3));
            }
        }
        if(view.getId()==R.id.momos_plus)
        {
            if(cb4.isChecked())
            { count4=Integer.parseInt(i4.getText().toString());
                count4++;
                i4.setText(String.valueOf(count4));
            }
        }
        if(view.getId()==R.id.coffee_plus)
        {
            if(cb5.isChecked())
            { count5=Integer.parseInt(i5.getText().toString());
                count5++;
                i5.setText(String.valueOf(count5));
            }
        }

        if(view.getId()==R.id.pizza_minus)
        {
            if(cb1.isChecked())
            {  count1=Integer.parseInt(i1.getText().toString());
                if(count1>0)
            {
                count1--;}
                i1.setText(String.valueOf(count1));
            }
        }
        if(view.getId()==R.id.burger_minus)
        {
            if(cb2.isChecked())
            {count2=Integer.parseInt(i2.getText().toString());
                if(count2>0)
            {
                count2--;}
                i2.setText(String.valueOf(count2));
            }
        }
        if(view.getId()==R.id.maggi_minus)
        {
            if(cb3.isChecked())
            { count3=Integer.parseInt(i3.getText().toString());
                if(count3>0)
            {
                count3--;}
                i3.setText(String.valueOf(count3));
            }
        }
        if(view.getId()==R.id.momos_minus)
        {
            if(cb4.isChecked())
            { count4=Integer.parseInt(i4.getText().toString());
                if(count4>0)
            {
                count4--;}
                i4.setText(String.valueOf(count4));
            }
        }
        if(view.getId()==R.id.coffee_minus)
        {
            if(cb5.isChecked())
            { count5=Integer.parseInt(i5.getText().toString());
                if(count5>0)
            {
                count5--;}
                i5.setText(String.valueOf(count5));
            }
        }
        if(view.getId()==R.id.reset_button)
        {
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
            cb5.setChecked(false);
            i1.setText("0");
            i2.setText("0");
            i3.setText("0");
            i4.setText("0");
            i5.setText("0");
            i1.setEnabled(false);
            i2.setEnabled(false);
            i3.setEnabled(false);
            i4.setEnabled(false);
            i5.setEnabled(false);
            isum.setText("0");
            count1=0;
            count2=0;
            count3=0;
            count4=0;
            count5=0;
            next.setEnabled(false);
            bp1.setEnabled(false);
            bp2.setEnabled(false);
            bp3.setEnabled(false);
            bp4.setEnabled(false);
            bp5.setEnabled(false);
            bm1.setEnabled(false);
            bm2.setEnabled(false);
            bm3.setEnabled(false);
            bm4.setEnabled(false);
            bm5.setEnabled(false);

        }
        if(view.getId()==R.id.sum_button)
        { int price1,price2,price3,price4,price5;
            isum.setEnabled(true);
            next.setEnabled(true);
            price1=Integer.parseInt(i1.getText().toString())*2;
            price2=Integer.parseInt(i2.getText().toString())*1;
            price3=Integer.parseInt(i3.getText().toString())*3;
            price4=Integer.parseInt(i4.getText().toString())*1;
            price5=Integer.parseInt(i5.getText().toString())*1;
            total=price1+price2+price3+price4+price5;
            isum.setText(String.valueOf(total));
        }
        if(view.getId()==R.id.next_button)
        {
            sum.callOnClick();
            m.clear();
            putVal();
            if(Integer.parseInt(isum.getText().toString())!=0){
            Intent intent = new Intent(this,NextActivity.class);
            intent.putExtra("Values",m);
            startActivity(intent);}
            else
            {
                Toast.makeText(this, "Please make an order", Toast.LENGTH_SHORT).show();
            }
        }

    }
    void putVal()
    {
        if(Integer.parseInt(i1.getText().toString())>0)
        {
            m.put("Pizza",i1.getText().toString());
        }
        if(Integer.parseInt(i2.getText().toString())>0)
        {
            m.put("Burger",i2.getText().toString());
        }
        if(Integer.parseInt(i3.getText().toString())>0)
        {
            m.put("Maggi",i3.getText().toString());
        }
        if(Integer.parseInt(i4.getText().toString())>0)
        {
            m.put("Momos",i4.getText().toString());
        }
        if(Integer.parseInt(i5.getText().toString())>0)
        {
            m.put("Coffee",i5.getText().toString());
        }
        m.put("sum",isum.getText().toString());
    }
}
