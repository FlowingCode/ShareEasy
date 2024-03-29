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

import java.util.HashMap;
import java.util.Map;
import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.demo.SourceCodeViewer;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Hover mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@PageTitle("Hover Mode Demo")
@Route(value = "share-easy/hover-mode", layout = ShareEasyDemoView.class)
public class HoverModeDemo extends BaseShareEasyDemo {

  public HoverModeDemo() {
    // begin-block example1
    Button hoverpBtn1 = createButton();
    HoverShareEasy.create().forComponent(hoverpBtn1);
    // #if vaadin eq 0
    Div example1 = createContainerDiv("Default Values", hoverpBtn1);
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    // show-source add(hoverpBtn1);
    // end-block

    // begin-block example2
    Button hoverBtn2 = createButton();
    HoverShareEasy.create().withDrivers(Driver.LINKEDIN, Driver.FACEBOOK)
        .forComponent(hoverBtn2);
    // #if vaadin eq 0
    Div example2 = createContainerDiv("With only 2 drivers", hoverBtn2);
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator();
    // #endif
    // show-source add(hoverpBtn2);
    // end-block

    // begin-block example3
    Button hoverBtn3 = createButton();
    HoverShareEasy.create().withShareText("Visit our website! Go to ")
        .withShareLink("https://www.flowingcode.com/en/").forComponent(hoverBtn3);
    // #if vaadin eq 0
    Div example3 = createContainerDiv("With custom share text & custom share link", hoverBtn3);
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator();
    // #endif
    // show-source add(hoverpBtn3);
    // end-block

    // begin-block example4
    Button hoverBtn4 = createButton();
    Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
    customDrivers.put("Trello", new TrelloDriverOptions());
    HoverShareEasy.create().withCustomDrivers(customDrivers).forComponent(hoverBtn4);
    // #if vaadin eq 0
    Div example4 = createContainerDiv("With custom driver for extra social: Trello", hoverBtn4);
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    // #endif
    // show-source add(hoverpBtn4);
    // end-block
  }

  /* button implementation */
  private Button createButton() {
    Button button = new Button(new Icon(VaadinIcon.CONNECT));
    button.addThemeVariants(ButtonVariant.LUMO_ICON);
    return button;
  }
}
