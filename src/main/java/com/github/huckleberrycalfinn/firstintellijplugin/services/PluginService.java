package com.github.huckleberrycalfinn.firstintellijplugin.services;

import java.util.function.Supplier;

public class PluginService<ActionEvent> implements Supplier<ActionEvent> {
  private ActionEvent event;

  @Override
  public ActionEvent get() {
    return this.event;
  }
}
