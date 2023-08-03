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

public class ShareEasyDefaultValuesIT extends AbstractViewTest {

  public ShareEasyDefaultValuesIT() {
    super("share-easy/default-values");
  }

  @Test
  public void componentExistsForAllModes() {
    boolean fixedShareEasyExists =
        $(ShareEasyElement.class).onPage().attributeContains("class", "sharee__fixed")
            .attributeContains("class", "sharee__position__top-left").exists();
    assertTrue("Fixed Share Easy at top left not present", fixedShareEasyExists);

    boolean normalShareEasyExists =
        $(ShareEasyElement.class).attributeContains("class", "sharee__normal").exists();
    assertTrue("Normal Share Easy not present", normalShareEasyExists);

    boolean dropdownShareEasyExists =
        $(ShareEasyElement.class).onPage().attributeContains("class", "sharee__dropdown").exists();
    assertTrue("Dropdown Share Easy not present", dropdownShareEasyExists);

    boolean textShareEasyExists =
        $(ShareEasyElement.class).onPage().attributeContains("class", "sharee__text").exists();
    assertTrue("Text Share Easy not present", textShareEasyExists);

    boolean hoverShareEasyExists =
        $(ShareEasyElement.class).onPage().attributeContains("class", "sharee__hover").exists();
    assertTrue("Hover Share Easy not present", hoverShareEasyExists);
  }

}
