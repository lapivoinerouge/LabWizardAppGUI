package com.lab.wizardgui.views.dashboard.patient.components;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class DoubleToLongConverter implements Converter<Double, Long> {

    @Override
    public Result<Long> convertToModel(Double value, ValueContext context) {
        return Result.ok(value.longValue());
    }

    @Override
    public Double convertToPresentation(Long value, ValueContext valueContext) {
        return value.doubleValue();
    }
}
