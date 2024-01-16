/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 - 2024 Flowing Code
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
import com.vaadin.flow.component.html.testbench.AnchorElement;

public class ShareEasyFixedModeIT extends BaseShareEasyIT {

  private static final int DEFAULT_FIXED_DRIVER_COUNT = 5;

  public ShareEasyFixedModeIT() {
    super("share-easy/fixed-mode");
  }

  @Test
  public void withPositionTopLeft() {
    this.clickButtonElement("topleft");
    boolean fixedTopLeftExists =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed")
            .attributeContains("class", "sharee__position__top-left").exists();
    assertTrue("Fixed share easy with top left position does not exist", fixedTopLeftExists);
  }

  @Test
  public void withPositionBottomLeft() {
    this.clickButtonElement("bottomleft");
    boolean fixedBottomLeftExists =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed")
            .attributeContains("class", "sharee__position__bottom-left").exists();
    assertTrue("Fixed share easy with bottom left position does not exist", fixedBottomLeftExists);
  }

  @Test
  public void withPositionTopRight() {
    this.clickButtonElement("topright");
    boolean fixedTopRightExists =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed")
            .attributeContains("class", "sharee__position__top-right").exists();
    assertTrue("Fixed share easy with top right position does not exist", fixedTopRightExists);
  }

  @Test
  public void withPositionBottomRight() {
    this.clickButtonElement("bottomright");
    boolean fixedBottomRightExists =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed")
            .attributeContains("class", "sharee__position__bottom-right").exists();
    assertTrue("Fixed share easy with bottom right position does not exist",
        fixedBottomRightExists);
  }

  @Test
  public void withNoTitle() {
    this.clickButtonElement("notitle");
    ShareEasyElement fixedShareWithNoTitle =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = fixedShareWithNoTitle.getAllDriversAnchors().size();
    int withNoTitleCount = fixedShareWithNoTitle.$(AnchorElement.class)
        .attributeContains("class", "sharee__no-title").all().size();
    assertTrue("Fixed Share Easy has noTitle set but is showing title",
        driversCount == withNoTitleCount);
  }

  @Test
  public void withOnlyTwoDrivers() {
    this.clickButtonElement("twodrivers");
    ShareEasyElement fixedWithOnlyTwoDrivers =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = fixedWithOnlyTwoDrivers.getAllDriversAnchors().size();
    assertTrue("Normal Share Easy shows more than 2 drivers", driversCount == 2);
  }

  @Test
  public void withExtraSocial() {
    this.clickButtonElement("extrasocial");
    ShareEasyElement fixedWithExtraSocial =
        $(ShareEasyElement.class).attributeContains("class", "sharee__fixed").first();
    int driversCount = fixedWithExtraSocial.getAllDriversAnchors().size();
    assertTrue("Normal Share Easy shows no extra social",
        driversCount == DEFAULT_FIXED_DRIVER_COUNT + 1);
  }
}
