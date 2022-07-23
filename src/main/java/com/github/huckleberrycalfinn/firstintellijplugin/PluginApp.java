package com.github.huckleberrycalfinn.firstintellijplugin;

import com.github.huckleberrycalfinn.firstintellijplugin.listeners.PluginListener;
import com.github.huckleberrycalfinn.firstintellijplugin.services.PluginService;
import com.intellij.configurationStore.UnknownElementWriter;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PluginApp {
  private PluginEventEnum event;
  private Consumer<ActionEvent> clickListener =  new PluginListener();
  private Supplier<TS> eventHandler;


  private PluginApp(PluginListener clickListener,
  PluginService eventHandler){
    this.clickListener = clickListener;
    this.eventHandler = eventHandler;

  }

  public static Builder builder(){
    return new PluginApp
        .Builder()
        .onEvent()
        .event(new PluginListener())
        .action(new PluginService())
        .build();
  }


  private class Builder {

    private PluginListener clickListener;
    private PluginService pluginService;


    public Builder onEvent(ActionEvent event){
      this.event = event;
      return this;
    }

    public Builder listener(PluginListener eventListener){
      this.clickListener = eventListener;
      return this;
    }

    public Builder eventHandler(PluginService pluginService){
      this.pluginService = pluginService;
      return this;
    }

    public PluginApp build(){
      PluginApp = new PluginApp(
          this.clickListener,
          this.eventHandler()
      )
    }
  }

  public static void main(String[] args) {
]   PluginApp app = new PluginApp()
        .builder()
  }
}
