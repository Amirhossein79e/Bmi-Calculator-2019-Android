package com.amirhosseinemadi.bmi.model;

import android.widget.Toast;
import com.amirhosseinemadi.bmi.R;
import com.amirhosseinemadi.bmi.common.Application;

public class Calculator {

    public float calculate(BMI bmi)
    {
      float w = Float.parseFloat(bmi.getWeight());
      float h = Float.parseFloat(bmi.getHeight());
      float tmp = 0;
      float factor = 0;
      if (w>=30&&w<=160&&h>=100&&h<=220) {

          float result = (w*10000) / (h * h);
          factor = (float) Math.pow(10,1);
          result = result * factor;
          tmp = Math.round(result);
      }
        return tmp/factor;
    }

    public float getMin(BMI bmi,Float zarib)
    {
        float f = 0;
        float factor = 0;
        float tmp = 0;
        int age = Integer.parseInt(bmi.getAge());
        float height = Float.parseFloat(bmi.getHeight());
        if (age>=18&&age<=100)
        {
            f = (float) (height*height*18.5f*zarib)/10000f;
            factor = (float) Math.pow(10,1);
            f = f*factor;
            tmp = Math.round(f);
        }
        else
        {
            Toast.makeText(Application.context, R.string.trueAge, Toast.LENGTH_SHORT).show();
        }

        return tmp/factor;
    }

    public float getMax(BMI bmi,Float zarib)
    {
        float f = 0;
        float factor = 0;
        float tmp = 0;
        int age = Integer.parseInt(bmi.getAge());
        float height = Float.parseFloat(bmi.getHeight());
        if (age>=18&&age<=100)
        {
            f = (float) (height*height*25f*zarib)/10000f;
            factor = (float) Math.pow(10,1);
            f = f*factor;
            tmp = Math.round(f);
        }
        else
        {
            Toast.makeText(Application.context, R.string.trueAge, Toast.LENGTH_SHORT).show();
        }

        return tmp/factor;
    }

}
