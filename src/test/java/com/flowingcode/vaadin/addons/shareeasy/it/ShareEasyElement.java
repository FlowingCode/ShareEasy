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

import java.util.List;
import com.vaadin.flow.component.html.testbench.AnchorElement;
import com.vaadin.flow.component.html.testbench.DivElement;

public class ShareEasyElement extends DivElement {

  public List<AnchorElement> getAllDriversAnchors() {
    return this.$(AnchorElement.class).all();
  }

  public boolean copyExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__F").exists();
  }

  public boolean telegramExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__I").exists();
  }

  public boolean facebookExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__G").exists();
  }

  public boolean whatsappExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__P").exists();
  }

  public boolean twitterExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__W").exists();
  }

  public boolean linkedinExists() {
    return this.$(AnchorElement.class).attributeContains("class", "sharee__driver__A").exists();
  }

  public boolean normalModeContainAllDefaultValues() {
    return copyExists() && telegramExists() && facebookExists() && whatsappExists()
        && twitterExists() && linkedinExists();
  }

  public boolean fixedModeContainAllDefaultValues() {
    return telegramExists() && facebookExists() && whatsappExists() && twitterExists()
        && linkedinExists();
  }

  public boolean textModeContainAllDefaultValues() {
    return telegramExists() && facebookExists() && whatsappExists() && twitterExists()
        && linkedinExists();
  }

  public boolean hoverModeContainAllDefaultValues(ShareEasyElement shareEasyElement) {
    return copyExists() && telegramExists() && facebookExists() && whatsappExists()
        && twitterExists() && linkedinExists();
  }

  public boolean dropdownModeContainAllDefaultValues() {
    return copyExists() && telegramExists() && facebookExists() && whatsappExists()
        && twitterExists() && linkedinExists();
  }

}
