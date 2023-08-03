package com.flowingcode.vaadin.addons.shareeasy.it;

import com.vaadin.flow.component.button.testbench.ButtonElement;

public abstract class BaseShareEasyIT extends AbstractViewTest {

  public BaseShareEasyIT() {
    super();
  }

  protected BaseShareEasyIT(String route) {
    super(route);
  }

  public void clickButtonElement(String buttonId) {
    ButtonElement button = $(ButtonElement.class).id(buttonId);
    button.click();
  }

}
