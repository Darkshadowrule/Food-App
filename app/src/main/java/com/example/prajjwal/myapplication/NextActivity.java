package com.example.prajjwal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class NextActivity extends AppCompatActivity  {

    HashMap<String,String> m;
    String s;
    TextView item1,item2,item3,item4,item5,quantity1,quantity2,quantity3,quantity4,quantity5,price1,price2,price3,price4,price5,totalprice;
    LinearLayout lpizza,lmomos,lmaggi, lburger,lcoffee;
    Button editOrder,orderNow;
    public int p1=0,p2=0,p3=0,p4=0,p5=0,totalp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        item1=findViewById(R.id.item1);
        item2=findViewById(R.id.item2);
        item3=findViewById(R.id.item3);
        item4=findViewById(R.id.item4);
        item5=findViewById(R.id.item5);
        quantity1=findViewById(R.id.quantity1);
        quantity2=findViewById(R.id.quantity2);
        quantity3=findViewById(R.id.quantity3);
        quantity4=findViewById(R.id.quantity4);
        quantity5=findViewById(R.id.quantity5);
        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);
        price3=findViewById(R.id.price3);
        price4=findViewById(R.id.price4);
        price5=findViewById(R.id.price5);
        lpizza=findViewById(R.id.layout1);
        lburger=findViewById(R.id.layout2);
        lmaggi=findViewById(R.id.layout3);
        lmomos=findViewById(R.id.layout4);
        lcoffee=findViewById(R.id.layout5);
        totalprice=findViewById(R.id.totalprice);
        orderNow=findViewById(R.id.orderNow);
        editOrder=findViewById(R.id.editOrder);
        editOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NextActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        orderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NextActivity.this, "Your Order Is on The Way", Toast.LENGTH_SHORT).show();
            }
        });

        m=new HashMap<String, String>();
        if(getIntent().hasExtra("Values")){
        m= (HashMap<String,String>)getIntent().getSerializableExtra("Values");
        }
        if(m.containsKey("Pizza"))
        {
            item1.setText("Pizza");
            quantity1.setText(m.get("Pizza"));
            p1=Integer.parseInt(m.get("Pizza"))*2;
            price1.setText(String.valueOf(p1)+"$");
        }
        else
        {
            lpizza.setVisibility(View.GONE);
        }
        if(m.containsKey("Coffee"))
        {
            item5.setText("Coffee");
            quantity5.setText(m.get("Coffee"));
            p5=Integer.parseInt(m.get("Coffee"))*1;
            price5.setText(String.valueOf(p5)+"$");
        }
        else
        {
           // Toast.makeText(this, " "+m.toString(), Toast.LENGTH_SHORT).show();
            lcoffee.setVisibility(View.GONE);
        }
        if(m.containsKey("Burger"))
        {
            item2.setText("Burger");
            quantity2.setText(m.get("Burger"));
            p2=Integer.parseInt(m.get("Burger"))*1;
            price2.setText(String.valueOf(p2)+"$");
        }
        else
        {
            lburger.setVisibility(View.GONE);
        }
        if(m.containsKey("Maggi"))
        {
            item3.setText("Maggi");
            quantity3.setText(m.get("Maggi"));
            p3=Integer.parseInt(m.get("Maggi"))*3;
            price3.setText(String.valueOf(p3)+"$");
        }
        else
        {
            lmaggi.setVisibility(View.GONE);
        }
        if(m.containsKey("Momos"))
        {
            item4.setText("Momos");
            quantity4.setText(m.get("Momos"));
            p4=Integer.parseInt(m.get("Momos"))*1;
            price4.setText(String.valueOf(p4)+"$");
        }
        else
        {
            lmomos.setVisibility(View.GONE);
        }
        totalp=p1+p2+p3+p4+p5;
        totalprice.setText(String.valueOf(totalp)+"$");

    }
}
