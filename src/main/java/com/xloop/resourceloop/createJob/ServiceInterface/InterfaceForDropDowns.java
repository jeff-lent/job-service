package com.xloop.resourceloop.createJob.ServiceInterface;

import java.util.List;

public interface InterfaceForDropDowns<T> {
    public T        add(T t);
    public T        update(T t);
    public void     deactivate(Long id);
    public void     reactive(Long id);
    public List<T>  viewAll();
}
