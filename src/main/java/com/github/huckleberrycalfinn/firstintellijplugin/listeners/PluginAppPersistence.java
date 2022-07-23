package com.github.huckleberrycalfinn.firstintellijplugin.listeners;

import com.github.huckleberrycalfinn.firstintellijplugin.PluginApp;
import java.util.function.Function;

public class PluginAppPersistence<E>  {
  private E state;

  public void setState(E data){
    this.state = data;
  }

  public E getState(){
    return this.state;
  }


  public PluginAppPersistence(E stateData){
    this(stateData, null);
  }

  public PluginAppPersistence(
      E stateData,
      Function<T, R> toTransportModel){
    this(dataType, toTransportModel, null);
  }

  public PluginAppPersistence(E)



}
