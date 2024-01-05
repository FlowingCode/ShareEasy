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
package com.flowingcode.vaadin.addons.shareeasy;

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo view for special customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@PageTitle("Special Customizations Demo")
@Route(value = "share-easy/special-customizations", layout = ShareEasyDemoView.class)
public class SpecialCustomizationsDemo extends BaseShareEasyDemo {

  public SpecialCustomizationsDemo() {
    Div normalDiv1 = new Div();
    NormalShareEasy.create().withDrivers(new Driver[] {Driver.WHATSAPP, Driver.TWITTER,
        Driver.TELEGRAM, Driver.LINKEDIN, Driver.FACEBOOK, Driver.COPY}).forComponent(normalDiv1);
    // #if vaadin eq 0
    add(createContainerDivWithInfo("Default drivers with different order", normalDiv1, 
        "Use 'withDrivers' method to list the default drivers in the wanted order")); 
    // #endif
    // show-source add(normalDiv1);
    addSeparator(); // hide-source

    Div normalDiv2 = new Div();
    Map<String, CustomDriverOptions> customDrivers2 = new HashMap<>();
    NewTwitterDriverOptions newTwitterDriver = new NewTwitterDriverOptions();
    customDrivers2.put("X", newTwitterDriver);
    NormalShareEasy
        .create().withCustomDrivers(customDrivers2).withDrivers(new ShareEasyDriver[] {Driver.COPY,
            Driver.TELEGRAM, Driver.FACEBOOK, Driver.WHATSAPP, newTwitterDriver, Driver.LINKEDIN})
        .forComponent(normalDiv2);
    // #if vaadin eq 0
    add(createContainerDivWithInfo("Custom driver definition to replace old Twitter option with new X option",
        normalDiv2,
        "Use 'witCustomDrivers' method to add the new custom driver for X and then call 'withDrivers' to list the drivers in the wanted order.")); 
    // #endif
    // show-source add(normalDiv2);
    addSeparator(); // hide-source

    Div normalDiv3 = new Div();
    Map<String, CustomDriverOptions> customDrivers3 = new HashMap<>();
    NewTwitterDriverOptions xDriver = new NewTwitterDriverOptions();
    customDrivers3.put("X", xDriver);
    TrelloDriverOptions trelloDriver = new TrelloDriverOptions();
    customDrivers3.put("trello", trelloDriver);
    NormalShareEasy.create().withCustomDrivers(customDrivers3)
        .withDrivers(new ShareEasyDriver[] {trelloDriver, xDriver}).forComponent(normalDiv3);
    // #if vaadin eq 0
    add(createContainerDivWithInfo("Custom drivers only", normalDiv3,
        "Use 'witCustomDrivers' method to add the new custom drivers and then call 'withDrivers' to list the wanted drivers in the wanted order."));
    // #endif
    // show-source add(normalDiv3);
    addSeparator(); // hide-source
   }

}
