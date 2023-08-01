package com.flowingcode.vaadin.addons.shareeasy.it;

import java.util.List;
import com.vaadin.flow.component.html.testbench.AnchorElement;
import com.vaadin.flow.component.html.testbench.DivElement;

public class BaseShareEasyIT extends AbstractViewTest {

  public BaseShareEasyIT() {
    super();
  }

  protected BaseShareEasyIT(String route) {
    super(route);
  }
  
  public List<AnchorElement> getAllDriversAnchors(DivElement divElement) {
    return divElement.$(AnchorElement.class).all();
  }

  public boolean copyExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__F")
        .exists();
  }

  public boolean telegramExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__I")
        .exists();
  }

  public boolean facebookExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__G")
        .exists();
  }

  public boolean whatsappExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__P")
        .exists();
  }

  public boolean twitterExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__W")
        .exists();
  }

  public boolean linkedinExists(DivElement divElement) {
    return divElement.$(AnchorElement.class).attributeContains("class", "sharee__driver__A")
        .exists();
  }

  public boolean normalModeContainAllDefaultValues(DivElement divElement) {
    return copyExists(divElement) && telegramExists(divElement) && facebookExists(divElement)
        && whatsappExists(divElement) && twitterExists(divElement) && linkedinExists(divElement);
  }

  public boolean fixedModeContainAllDefaultValues(DivElement divElement) {
    return telegramExists(divElement) && facebookExists(divElement) && whatsappExists(divElement)
        && twitterExists(divElement) && linkedinExists(divElement);
  }
  
  public boolean textModeContainAllDefaultValues(DivElement divElement) {
    return telegramExists(divElement) && facebookExists(divElement) && whatsappExists(divElement)
        && twitterExists(divElement) && linkedinExists(divElement);
  }

  public boolean hoverModeContainAllDefaultValues(DivElement divElement) {
    return copyExists(divElement) && telegramExists(divElement)
        && facebookExists(divElement) && whatsappExists(divElement)
        && twitterExists(divElement) && linkedinExists(divElement);
  }
  
  public boolean dropdownModeContainAllDefaultValues(DivElement divElement) {
    return copyExists(divElement) && telegramExists(divElement)
        && facebookExists(divElement) && whatsappExists(divElement)
        && twitterExists(divElement) && linkedinExists(divElement);
  }
  
}
