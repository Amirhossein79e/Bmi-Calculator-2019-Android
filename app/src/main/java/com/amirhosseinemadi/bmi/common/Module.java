package com.amirhosseinemadi.bmi.common;

import android.content.Context;

import com.amirhosseinemadi.bmi.model.BMI;
import com.amirhosseinemadi.bmi.model.Calculator;
import com.amirhosseinemadi.bmi.view.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;

@dagger.Module
public class Module {

    private final Context context;

    @Inject
    public Module(Context context)
    {
        this.context = context;
    }

    @Provides
    public Context getContext()
    {
        return context;
    }


    @Provides
    public Calculator getCalculator()
    {
        return new Calculator();
    }

    @Provides
    public MainActivity getActivity()
    {
        return new MainActivity();
    }

}
