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
package com.flowingcode.vaadin.addons.shareeasy;

import java.util.HashMap;
import java.util.Map;
import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.demo.SourceCodeViewer;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Position;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Normal mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@PageTitle("Fixed Mode Demo")
@Route(value = "share-easy/fixed-mode", layout = ShareEasyDemoView.class)
public class FixedModeDemo extends BaseShareEasyDemo {

  public FixedModeDemo() {
    
    addClassName("share-easy-fixed");// hide-source    
    Button topleft = createButton("Top Left");
    topleft.setId("topleft"); // hide-source 
    Button bottomleft = createButton("Bottom Left");
    bottomleft.setId("bottomleft"); // hide-source 
    Button topright = createButton("Top Right");
    topright.setId("topright"); // hide-source 
    Button bottomright = createButton("Bottom Right");
    bottomright.setId("bottomright"); // hide-source 

    // begin-block example1
    topleft.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().forComponent(this);
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
    });

    bottomleft.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withPosition(Position.BOTTOM_LEFT).forComponent(this);
      topleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
    });

    topright.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withPosition(Position.TOP_RIGHT).forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
    });

    bottomright.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withPosition(Position.BOTTOM_RIGHT).forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    HorizontalLayout horizontalLayout =
        new HorizontalLayout(topleft, bottomleft, topright, bottomright);
    horizontalLayout.setClassName("share-easy-fixed-horizontal");
    Div example1 = createContainerDivWithInfo("Position", horizontalLayout,
        "By default, Share Easy menu is attached to the document's body and displays as a vertical menu at top left position.");
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    // end-block

    Button btn1 = createShowButton();
    btn1.setId("notitle"); // hide-source 
    Button btn2 = createShowButton();
    btn2.setId("twodrivers"); // hide-source 
    Button btn3 = createShowButton();
    btn3.setId("customtext"); // hide-source 
    Button btn4 = createShowButton();
    btn4.setId("customlink"); // hide-source 
    Button btn5 = createShowButton();
    btn5.setId("extrasocial"); // hide-source 

    // begin-block example2
    btn1.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withNoTitle(true).forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
      btn2.setEnabled(true); // hide-source
      btn3.setEnabled(true); // hide-source
      btn4.setEnabled(true); // hide-source
      btn5.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    Div example2 = createContainerDiv("Without title", btn1);
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator();
    // #endif
    // end-block

    // begin-block example3
    btn2.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      LanguageKeys languageKeys1 = new LanguageKeys();
      languageKeys1.setTwitter("Share on Twitter");
      languageKeys1.setLinkedin("Share on Linkedin");
      FixedShareEasy.create().withDrivers(new Driver[] {Driver.LINKEDIN, Driver.TWITTER})
          .withCustomLanguageKeys(languageKeys1).forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
      btn1.setEnabled(true); // hide-source
      btn3.setEnabled(true); // hide-source
      btn4.setEnabled(true); // hide-source
      btn5.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    Div example3 = createContainerDiv("With only 2 drivers & custom language keys", btn2);
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator();
    // #endif
    // end-block

    // begin-block example4
    btn3.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withShareText("Visit our demo at: ").forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
      btn1.setEnabled(true); // hide-source
      btn2.setEnabled(true); // hide-source
      btn4.setEnabled(true); // hide-source
      btn5.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    Div example4 = createContainerDiv("With custom share text", btn3);
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    addSeparator();
    // #endif
    // end-block

    // begin-block example5
    btn4.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      FixedShareEasy.create().withShareText("Visit our website! Go to ")
          .withShareLink("https://www.flowingcode.com/en/").forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
      btn1.setEnabled(true); // hide-source
      btn2.setEnabled(true); // hide-source
      btn3.setEnabled(true); // hide-source
      btn5.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    Div example5 = createContainerDiv("With custom share text & custom share link", btn4);
    SourceCodeViewer.highlightOnHover(example5, "example5");
    add(example5);
    addSeparator();
    // #endif
    // end-block

    // begin-block example6
    btn5.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
      customDrivers.put("Trello", new TrelloDriverOptions());
      FixedShareEasy.create().withCustomDrivers(customDrivers).forComponent(this);
      topleft.setEnabled(true); // hide-source
      bottomleft.setEnabled(true); // hide-source
      topright.setEnabled(true); // hide-source
      bottomright.setEnabled(true); // hide-source
      btn1.setEnabled(true); // hide-source
      btn2.setEnabled(true); // hide-source
      btn3.setEnabled(true); // hide-source
      btn4.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    Div example6 = createContainerDiv("With custom driver for extra social: Trello", btn5);
    SourceCodeViewer.highlightOnHover(example6, "example6");
    add(example6);
    addSeparator();
    // #endif
    // end-block
  }

  /* button implementation */
  private Button createButton(String caption) {
    Button button = new Button(caption);
    button.addThemeVariants(ButtonVariant.LUMO_LARGE);
    button.setDisableOnClick(true);
    return button;
  }

  private Button createShowButton() {
    return this.createButton("Show");
  }
}
