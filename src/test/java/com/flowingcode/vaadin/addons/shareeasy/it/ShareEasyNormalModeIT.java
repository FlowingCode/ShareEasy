/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 - 2025 Flowing Code
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.vaadin.flow.component.html.testbench.AnchorElement;

public class ShareEasyNormalModeIT extends BaseShareEasyIT {

  private static final int DEFAULT_NORMAL_DRIVER_COUNT = 6;

  public ShareEasyNormalModeIT() {
    super("share-easy/normal-mode");
  }

  @Test
  public void withDefaultDrivers() {
    ShareEasyElement normalShareWithNoTitle =
        $(ShareEasyElement.class).attributeContains("class", "sharee__normal").get(0);
    int driversCount = normalShareWithNoTitle.getAllDriversAnchors().size();
    assertFalse("Normal Share Easy is showing more than default drivers",
        driversCount > DEFAULT_NORMAL_DRIVER_COUNT);
    assertFalse("Normal Share Easy is showing less than default drivers",
        driversCount < DEFAULT_NORMAL_DRIVER_COUNT);
    assertTrue("Normal Share Easy doesn't contain all default drivers as expected",
        normalShareWithNoTitle.normalModeContainAllDefaultValues());
  }

  @Test
  public void withNoTitle() {
    ShareEasyElement normalShareWithNoTitle =
        $(ShareEasyElement.class).attributeContains("class", "sharee__normal").get(1);
    int driversCount = normalShareWithNoTitle.getAllDriversAnchors().size();
    int withNoTitleCount = normalShareWithNoTitle.$(AnchorElement.class)
        .attributeContains("class", "sharee__no-title").all().size();
    assertTrue("Normal Share Easy has noTitle set but is showing title",
        driversCount == withNoTitleCount);
  }

  @Test
  public void withOnlyTwoDrivers() {
    ShareEasyElement normalWithOnlyTwoDrivers =
        $(ShareEasyElement.class).attributeContains("class", "sharee__normal").get(2);
    int driversCount = normalWithOnlyTwoDrivers.getAllDriversAnchors().size();
    assertTrue("Normal Share Easy shows more than 2 drivers", driversCount == 2);
  }

  @Test
  public void withExtraSocial() {
    ShareEasyElement normalWithExtraSocial =
        $(ShareEasyElement.class).attributeContains("class", "sharee__normal").get(6);
    int driversCount = normalWithExtraSocial.getAllDriversAnchors().size();
    assertTrue("Normal Share Easy shows no extra social",
        driversCount == DEFAULT_NORMAL_DRIVER_COUNT + 1);
  }
}
