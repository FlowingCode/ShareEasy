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
import com.flowingcode.vaadin.addons.shareeasy.enums.Animation;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Type;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Dropdown mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@PageTitle("Dropdown Mode Demo")
@Route(value = "share-easy/dropdown-mode", layout = ShareEasyDemoView.class)
public class DropdownModeDemo extends BaseShareEasyDemo {

  public DropdownModeDemo() {
    // begin-block example1
    Button column = createButton("Column");
    Button row = createButton("Row");
    Button grid = createButton("Grid");
    DropdownShareEasy.create().forComponent(column);
    DropdownShareEasy.create().withType(Type.ROW).forComponent(row);
    DropdownShareEasy.create().withType(Type.GRID).forComponent(grid);
    // #if vaadin eq 0
    Div example1 = createContainerDivWithInfo("Type", new HorizontalLayout(column, row, grid),
        "By default, Share Easy menu in Dropdown mode is displayed as column, but it can also be shown as row or grid.");
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    //show-source add(new HorizontalLayout(column, row, grid));
    // end-block
    
    // begin-block example2
    Button dropBtn1 = createShareDemoButton();
    DropdownShareEasy.create().withAnimation(Animation.FADE).forComponent(dropBtn1);
    // #if vaadin eq 0
    Div example2 = createContainerDiv("With animation fade", dropBtn1);
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator(); 
    // #endif
    // show-source add(dropBtn1);
    // end-block

    // begin-block example3
    Button dropBtn2 = createShareDemoButton();
    LanguageKeys languageKeys1 = new LanguageKeys();
    languageKeys1.setFacebook("Share on Facebook");
    languageKeys1.setLinkedin("Share on Linkedin");
    DropdownShareEasy.create().withDrivers(new Driver[] {Driver.LINKEDIN, Driver.FACEBOOK})
        .withCustomLanguageKeys(languageKeys1).forComponent(dropBtn2);
    // #if vaadin eq 0
    Div example3 = createContainerDiv("With only 2 drivers & custom language keys", dropBtn2); 
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator(); 
    // #endif
    // show-source add(dropBtn2);
    // end-block

    // begin-block example4
    Button dropBtn3 = createShareDemoButton();
    DropdownShareEasy.create().withShareText("Visit our website! Go to ")
        .withShareLink("https://www.flowingcode.com/en/").forComponent(dropBtn3);
    // #if vaadin eq 0
    Div example4 = createContainerDiv("With custom share text & custom share link", dropBtn3); 
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    addSeparator(); 
    // #endif
    // show-source add(dropBtn3);
    // end-block

    // begin-block example5
    Button dropBtn4 = createShareDemoButton();
    Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
    customDrivers.put("Trello", new TrelloDriverOptions());
    DropdownShareEasy.create().withCustomDrivers(customDrivers).forComponent(dropBtn4);
    // #if vaadin eq 0
    Div example5 = createContainerDiv("With custom driver for extra social: Trello", dropBtn4);
    SourceCodeViewer.highlightOnHover(example5, "example5");
    add(example5);
    // #endif
    // show-source add(dropBtn4);
    // end-block
  }
  
  /* share demo button implementation */
  private Button createShareDemoButton() {
    return this.createButton("Share Demo");
  }

  private Button createButton(String caption) {
    Button button = new Button(caption);
    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
    return button;
  }
}
