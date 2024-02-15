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
package com.flowingcode.vaadin.addons.shareeasy;

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.demo.SourceCodeViewer;
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
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/NewTwitterDriverOptions.java")
@PageTitle("Special Customizations Demo")
@Route(value = "share-easy/special-customizations", layout = ShareEasyDemoView.class)
public class SpecialCustomizationsDemo extends BaseShareEasyDemo {

  public SpecialCustomizationsDemo() {
    // begin-block example1
    Div normalDiv1 = new Div();
    NormalShareEasy.create().withDrivers(Driver.WHATSAPP, Driver.TWITTER,
        Driver.TELEGRAM, Driver.LINKEDIN, Driver.FACEBOOK, Driver.COPY).forComponent(normalDiv1);
    // #if vaadin eq 0
    Div example1 = createContainerDivWithInfo("Default drivers with different order", normalDiv1, 
        "Use 'withDrivers' method to list the default drivers in the wanted order"); 
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    // show-source add(normalDiv1);
    // end-block

    // begin-block example2
    Div normalDiv2 = new Div();
    Map<String, CustomDriverOptions> customDrivers2 = new HashMap<>();
    NewTwitterDriverOptions newTwitterDriver = new NewTwitterDriverOptions();
    customDrivers2.put("X", newTwitterDriver);
    NormalShareEasy
        .create().withCustomDrivers(customDrivers2).withDrivers(Driver.COPY,
            Driver.TELEGRAM, Driver.FACEBOOK, Driver.WHATSAPP, newTwitterDriver, Driver.LINKEDIN)
        .forComponent(normalDiv2);
    // #if vaadin eq 0
    Div example2 = createContainerDivWithInfo("Custom driver definition to replace old Twitter option with new X option",
        normalDiv2,
        "Use 'witCustomDrivers' method to add the new custom driver for X and then call 'withDrivers' to list the drivers in the wanted order."); 
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator();
    // #endif
    // show-source add(normalDiv2);
    // end-block

    // begin-block example3
    Div normalDiv3 = new Div();
    Map<String, CustomDriverOptions> customDrivers3 = new HashMap<>();
    NewTwitterDriverOptions xDriver = new NewTwitterDriverOptions();
    customDrivers3.put("X", xDriver);
    TrelloDriverOptions trelloDriver = new TrelloDriverOptions();
    customDrivers3.put("trello", trelloDriver);
    NormalShareEasy.create().withCustomDrivers(customDrivers3)
        .withDrivers(trelloDriver, xDriver).forComponent(normalDiv3);
    // #if vaadin eq 0
    Div example3 = createContainerDivWithInfo("Custom drivers only", normalDiv3,
        "Use 'witCustomDrivers' method to add the new custom drivers and then call 'withDrivers' to list the wanted drivers in the wanted order.");
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    // #endif
    // show-source add(normalDiv3);
    // end-block
   }

}
