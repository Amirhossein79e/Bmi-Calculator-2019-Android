package com.amirhosseinemadi.bmi.common;

import android.content.Context;

import com.amirhosseinemadi.bmi.model.Calculator;
import com.amirhosseinemadi.bmi.view.MainActivity;

@dagger.Component(modules = Module.class)
public interface Component {

    Context context();
    Calculator calculator();
    MainActivity activity();

}
