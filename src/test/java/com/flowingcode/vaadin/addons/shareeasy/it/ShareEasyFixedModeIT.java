/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.flowingcode.vaadin.addons.shareeasy.it;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.AnchorElement;
import com.vaadin.flow.component.html.testbench.DivElement;

public class ShareEasyFixedModeIT extends BaseShareEasyIT {

  public ShareEasyFixedModeIT() {
    super("share-easy/fixed-mode");
  }

  @Test
  public void withPositionTopLeft() {
    ButtonElement topLeftButton = $(ButtonElement.class).id("topleft");
    topLeftButton.click();
    boolean fixedTopLeftExists =
        $(DivElement.class).attributeContains("class", "sharee__fixed")
        .attributeContains("class", "sharee__position__top-left").exists();
   assertTrue("Fixed share easy with top left position does not exist", fixedTopLeftExists);    
  }
  
  @Test
  public void withPositionBottomLeft() {
    ButtonElement bottomLeftButton = $(ButtonElement.class).id("bottomleft");
    bottomLeftButton.click();
    boolean fixedBottomLeftExists =
        $(DivElement.class).attributeContains("class", "sharee__fixed")
        .attributeContains("class", "sharee__position__bottom-left").exists();
   assertTrue("Fixed share easy with bottom left position does not exist", fixedBottomLeftExists);    
  }
  
  @Test
  public void withPositionTopRight() {
    ButtonElement topRightButton = $(ButtonElement.class).id("topright");
    topRightButton.click();
    boolean fixedTopRightExists =
        $(DivElement.class).attributeContains("class", "sharee__fixed")
        .attributeContains("class", "sharee__position__top-right").exists();
   assertTrue("Fixed share easy with top right position does not exist", fixedTopRightExists);    
  }

  @Test
  public void withPositionBottomRight() {
    ButtonElement bottomRightButton = $(ButtonElement.class).id("bottomright");
    bottomRightButton.click();
    boolean fixedBottomRightExists =
        $(DivElement.class).attributeContains("class", "sharee__fixed")
        .attributeContains("class", "sharee__position__bottom-right").exists();
   assertTrue("Fixed share easy with bottom right position does not exist", fixedBottomRightExists);    
  }
  
  @Test
  public void withNoTitle() {
    ButtonElement button = $(ButtonElement.class).id("notitle");
    button.click();
    DivElement fixedShareWithNoTitle =
        $(DivElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = this.getAllDriversAnchors(fixedShareWithNoTitle).size();
    int withNoTitleCount = fixedShareWithNoTitle.$(AnchorElement.class)
        .attributeContains("class", "sharee__no-title").all().size();
    assertTrue("Fixed Share Easy has noTitle set but is showing title",
        driversCount == withNoTitleCount);
  }

  @Test
  public void withOnlyTwoDrivers() {
    ButtonElement button = $(ButtonElement.class).id("twodrivers");
    button.click();
    DivElement fixedWithOnlyTwoDrivers =
        $(DivElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = this.getAllDriversAnchors(fixedWithOnlyTwoDrivers).size();
    assertTrue("Normal Share Easy shows more than 2 drivers", driversCount == 2);
  }

  @Test
  public void withExtraSocial() {
    ButtonElement button = $(ButtonElement.class).id("extrasocial");
    button.click();
    DivElement normalWithExtraSocial =
        $(DivElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = this.getAllDriversAnchors(normalWithExtraSocial).size();
    assertTrue("Normal Share Easy shows no extra social", driversCount == 6);
  }
}
