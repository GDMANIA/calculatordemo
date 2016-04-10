package com.example.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	Button bt_0;
	Button bt_1;
	Button bt_2;
	Button bt_3;
	Button bt_4;
	Button bt_5;
	Button bt_6;
	Button bt_7;
	Button bt_8;
	Button bt_9;
	Button bt_point;
	Button bt_plus;
	Button bt_minus;
	Button bt_multiply;
	Button bt_divide;
	Button bt_clear;
	Button bt_del;
	Button bt_equal;
	EditText et_input;
	boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_0=(Button)findViewById(R.id.bt_0);
        bt_1=(Button)findViewById(R.id.bt_1);
        bt_2=(Button)findViewById(R.id.bt_2);
        bt_3=(Button)findViewById(R.id.bt_3);
        bt_4=(Button)findViewById(R.id.bt_4);
        bt_5=(Button)findViewById(R.id.bt_5);
        bt_6=(Button)findViewById(R.id.bt_6);
        bt_7=(Button)findViewById(R.id.bt_7);
        bt_8=(Button)findViewById(R.id.bt_8);
        bt_9=(Button)findViewById(R.id.bt_9);
        bt_clear=(Button)findViewById(R.id.bt_clear);
        bt_point=(Button)findViewById(R.id.bt_point);
        bt_plus=(Button)findViewById(R.id.bt_plus);
        bt_minus=(Button)findViewById(R.id.bt_minus);
        bt_multiply=(Button)findViewById(R.id.bt_multiply);
        bt_divide=(Button)findViewById(R.id.bt_devide);
        bt_del=(Button)findViewById(R.id.bt_del);
        bt_equal=(Button)findViewById(R.id.bt_equal);
        et_input=(EditText)findViewById(R.id.et_input);
        
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this); 
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_plus.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str=et_input.getText().toString();
		switch (v.getId()) {
		case R.id.bt_0:
		case R.id.bt_1:	
		case R.id.bt_2:	
		case R.id.bt_3:	
		case R.id.bt_4:
		case R.id.bt_5:
		case R.id.bt_6:
		case R.id.bt_7:
		case R.id.bt_8:
		case R.id.bt_9:
		case R.id.bt_point:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+((Button)v).getText());
			break;
		case R.id.bt_plus:
		case R.id.bt_minus:
		case R.id.bt_multiply:
		case R.id.bt_devide:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.bt_del:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			} else if(str!=null&&!str.equals("")){
				et_input.setText(str.substring(0,str.length()-1));
			}
		
			break;
		case R.id.bt_clear:
			clear_flag=false;
			str="";
			et_input.setText("");
			break;
		case R.id.bt_equal:
			getResult();
			break;
		}
	}
 
	

	private void getResult(){
		String exp=et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(clear_flag){
			clear_flag=false;
			return;
		}
		clear_flag=true;
		double result=0;
		String s1=exp.substring(0, exp.indexOf(" "));//运算符前面的字符串
		String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//截取到的运算符
		String s2=exp.substring(exp.indexOf(" ")+3);//运算符后面的字符串
		if(!s1.equals("")&&!s2.equals("")){
			double d1=Double.parseDouble(s1);
			double d2=Double.parseDouble(s2);
			if(op.equals("+")){
				result=d1+d2;
			}else if(op.equals("-")){
				result=d1-d2;
			}else if(op.equals("×")){
				result=d1*d2;
			}else if(op.equals("÷")){
			if(d2==0){
				result=0;
			}else{
				result=d1/d2;
			}
			}
		
		
	 if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
			int r=(int)result;
			et_input.setText(r+"");
			}else{
			et_input.setText(result+"");
			}
	}else if(!s1.contains("")&&s2.contains("")){
			et_input.setText(exp);
	}else if(s1.contains("")&&!s2.contains("")){
			double d2=Double.parseDouble(s2);
			if(op.equals("+")){
				result=0+d2;
			}else if(op.equals("-")){
				result=0-d2;
			}else if(op.equals("×")){
				result=0;
			}else if(op.equals("÷")){
				result=0;
			}
	
		if(s2.contains(".")){
			int r=(int)result;
			et_input.setText(r+"");
			}else{
			et_input.setText(result+"");
			}
	}else{
		et_input.setText("");
	}

	}
}
	
	
