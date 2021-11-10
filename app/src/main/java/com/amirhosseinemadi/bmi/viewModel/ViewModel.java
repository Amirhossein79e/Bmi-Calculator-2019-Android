package com.amirhosseinemadi.bmi.viewModel;

import android.view.ActionProvider;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import com.amirhosseinemadi.bmi.BR;
import com.amirhosseinemadi.bmi.R;
import com.amirhosseinemadi.bmi.common.Application;
import com.amirhosseinemadi.bmi.model.BMI;


public class ViewModel extends BaseObservable{


    public String weight = "";
    public String height = "";
    public String age = "";
    public Boolean m = false;
    public Boolean f = false;
    public String min;
    public String max;
    public String bm ;
    public String status;
    public boolean ms = true;
    public boolean fs = true;
    private LinearLayout lay;
    private LinearLayout lay2;
    private MutableLiveData<String> mutableLiveData;




    public ViewModel(LinearLayout lay,LinearLayout lay2) {

        this.lay = lay;
        this.lay2 = lay2;
        mutableLiveData = new MutableLiveData<>();


    }


    public void onClick()
    {

        if (!weight.isEmpty()&&!height.isEmpty()&&!age.isEmpty()) {
            float w = Integer.parseInt(weight);
            float h = Float.parseFloat(height);
            float a = Float.parseFloat(age);
            BMI bmi = null;
            if (w != 0 && h != 0 && a != 0&&w>=30&&w<=160&&h>=100&&h<=220) {
                bmi = new BMI();
                bmi.setWeight(weight);
                bmi.setHeight(height);
                bmi.setAge(age);
            } else {
                Toast.makeText(Application.context,R.string.inserttrue, Toast.LENGTH_SHORT).show();
                return;
            }
            if (m && f){
                Toast.makeText(Application.context, R.string.onecheck, Toast.LENGTH_SHORT).show();
            }else if (!m && !f)
            {
                Toast.makeText(Application.context, R.string.onecheck, Toast.LENGTH_SHORT).show();
            }else
                if (m || f)
                {
                    switch (bmi.getAge())
                    {
                        case "18":
                            if (m){


                            bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                            min = (String.valueOf(Application.component.calculator().getMin(bmi,0.984f)));
                            max = (String.valueOf(Application.component.calculator().getMax(bmi,1.024f)));
                            setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                            notifyPropertyChanged(BR._all);
                            }
                            if (f)
                            {
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,0.947f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1.029f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            break;
                        case "19":
                            if (m){

                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,1.011f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1.053f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            if (f)
                            {
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,0.963f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1.044f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            break;
                        case "20":
                            if (m){
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                bm = (String.valueOf(Application.component.calculator().getMin(bmi,1.033f)));
                                bm = (String.valueOf(Application.component.calculator().getMax(bmi,1.080f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            if (f)
                            {
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,0.963f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1.060f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            break;
                        default:
                            if (m){
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,1f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                            if (f)
                            {
                                bm = (String.valueOf(Application.component.calculator().calculate(bmi)));
                                min = (String.valueOf(Application.component.calculator().getMin(bmi,1f)));
                                max = (String.valueOf(Application.component.calculator().getMax(bmi,1f)));
                                setStatus(Application.component.calculator().calculate(bmi));
                                visi(lay,lay2);
                                mutableLiveData.setValue(bm);
                                notifyPropertyChanged(BR._all);
                            }
                    }
                }

        }else
        {
            Toast.makeText(Application.context, R.string.inserttrue, Toast.LENGTH_SHORT).show();
        }
    }


    private void setStatus(float bmi)
    {
        if (bmi<16)
        {
            status = Application.context.getString(R.string.underweight3);
        }else
            if (bmi>=16&&bmi<=17)
            {
                status = Application.context.getString(R.string.underweight2);
            }
            else
                if (bmi>17&&bmi<18.5)
                {
                    status = Application.context.getString(R.string.underweight);
                }
                else
                    if (bmi>=18.5&&bmi<=25)
                    {
                        status = Application.context.getString(R.string.normal);
                    }
                    else
                    if (bmi>25&&bmi<=30)
                    {
                        status = Application.context.getString(R.string.overweight);
                    }
                    else
                    if (bmi>30&&bmi<=35)
                    {
                        status = Application.context.getString(R.string.fat);
                    }
                    else
                    if (bmi>35&&bmi<=40)
                    {
                        status = Application.context.getString(R.string.fat2);
                    }
                    else
                    if (bmi>40)
                    {
                        status = Application.context.getString(R.string.fat3);
                    }
    }

    private void visi(LinearLayout lay,LinearLayout lay2)
    {
        lay.setVisibility(View.VISIBLE);
        lay2.setVisibility(View.GONE);
        Toast.makeText(Application.context, "وضعیت شما برای افراد بالای 20 سال صدق می کند", Toast.LENGTH_SHORT).show();
    }

    public MutableLiveData<String> getMutableLiveData()
    {
        return mutableLiveData;
    }

    public void fClick()
    {
        notifyPropertyChanged(BR._all);
        if (f) {
            ms = false;
            notifyPropertyChanged(BR._all);
        }
        else
        {
            ms = true;
        }
    }

    public void mClick()
    {
        notifyPropertyChanged(BR._all);
        if (m) {
            fs = false;
            notifyPropertyChanged(BR._all);
        }else
        {
            fs = true;
        }
    }

}


