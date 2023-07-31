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

import java.util.HashMap;
import java.util.Map;
import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Position;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Normal mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@PageTitle("Fixed Mode Demo")
@Route(value = "share-easy/fixed-mode", layout = ShareEasyDemoView.class)
public class FixedModeDemo extends BaseShareEasyDemo {

  public FixedModeDemo() {
    addClassName("share-easy-fixed");// hide-source    
    Button topleft = createButton("Top Left");
    Button bottomleft = createButton("Bottom Left");
    Button topright = createButton("Top Right");
    Button bottomright = createButton("Bottom Right");

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
    add(createContainerDivWithInfo("Position", horizontalLayout,
        "By default, Share Easy menu is attached to the document's body and displays as a vertical menu at top left position."));
    addSeparator();
    // #endif

    Button btn1 = createShowButton();
    Button btn2 = createShowButton();
    Button btn3 = createShowButton();
    Button btn4 = createShowButton();
    Button btn5 = createShowButton();

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
    add(createContainerDiv("Without title", btn1));
    addSeparator();
    // #endif

    btn2.addClickListener(e -> {
      this.removeExistingFixedMenus(); // hide-source
      LanguageKeys languageKeys1 = new LanguageKeys();
      languageKeys1.twitter = "Share on Twitter";
      languageKeys1.linkedin = "Share on Linkedin";
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
    add(createContainerDiv("With only 2 drivers & custom language keys", btn2));
    addSeparator();
    // #endif

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
    add(createContainerDiv("With custom share text", btn3));
    addSeparator();
    // #endif

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
    add(createContainerDiv("With custom share text & custom share link", btn4));
    addSeparator();
    // #endif

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
    add(createContainerDiv("With custom driver for extra social: Trello", btn5));
    addSeparator();
    // #endif
  }

  // #if vaadin eq 0
  private Button createButton(String caption) {
    Button button = new Button(caption);
    button.addThemeVariants(ButtonVariant.LUMO_LARGE);
    button.setDisableOnClick(true);
    return button;
  }

  private Button createShowButton() {
    return this.createButton("Show");
  }
  // #endif
}
