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
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Normal mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@PageTitle("Normal Mode Demo")
@Route(value = "share-easy/normal-mode", layout = ShareEasyDemoView.class)
public class NormalModeDemo extends BaseShareEasyDemo {

  public NormalModeDemo() {
    // begin-block example1
    Div normalDiv1 = new Div();
    NormalShareEasy.create().forComponent(normalDiv1);
    // #if vaadin eq 0
    Div example1 = createContainerDiv("Default Values", normalDiv1); // hide-source
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    // show-source add(normalDiv1);
    // end-block

    // begin-block example2
    Div normalDiv2 = new Div();
    NormalShareEasy.create().withNoTitle(true).forComponent(normalDiv2);
    // #if vaadin eq 0
    Div example2 = createContainerDiv("Without title", normalDiv2); // hide-source
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator();
    // #endif
    // show-source add(normalDiv2);
    // end-block

    // begin-block example3
    Div normalDiv3 = new Div();
    LanguageKeys languageKeys1 = new LanguageKeys();
    languageKeys1.setTwitter("Share on Twitter");
    languageKeys1.setLinkedin("Share on Linkedin");
    NormalShareEasy.create().withDrivers(new Driver[] {Driver.LINKEDIN, Driver.TWITTER})
        .withCustomLanguageKeys(languageKeys1).forComponent(normalDiv3);
    // #if vaadin eq 0
    Div example3 = createContainerDiv("With only 2 drivers & custom language keys", normalDiv3); 
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator();
    // #endif
    // show-source add(normalDiv3);
    // end-block

    // begin-block example4
    Div normalDiv4 = new Div();
    LanguageKeys languageKeys2 = new LanguageKeys();
    languageKeys2.setCopiedSuccessfully("Copiado");
    languageKeys2.setCopyLink("Copiar link");
    NormalShareEasy.create().withCustomLanguageKeys("es", languageKeys2).forComponent(normalDiv4);
    // #if vaadin eq 0
    Div example4 = createContainerDiv("With custom locale: es (spanish)", normalDiv4);
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    addSeparator();
    // #endif
    // show-source add(normalDiv4);
    // end-block

    // begin-block example5
    Div normalDiv5 = new Div();
    NormalShareEasy.create().withShareText("Visit our demo at: ").forComponent(normalDiv5);
    // #if vaadin eq 0
    Div example5 = createContainerDiv("With custom share text", normalDiv5);
    SourceCodeViewer.highlightOnHover(example5, "example5");
    add(example5);
    addSeparator();
    // #endif
    // show-source add(normalDiv5);
    // end-block

    // begin-block example6
    Div normalDiv6 = new Div();
    NormalShareEasy.create().withShareText("Visit our website! Go to ")
        .withShareLink("https://www.flowingcode.com/en/").forComponent(normalDiv6);
    // #if vaadin eq 0
    Div example6 = createContainerDiv("With custom share text & custom share link", normalDiv6);
    SourceCodeViewer.highlightOnHover(example6, "example6");
    add(example6);
    addSeparator();
    // #endif
    // show-source add(normalDiv6);
    // end-block

    // begin-block example7
    Div normalDiv7 = new Div();
    Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
    customDrivers.put("Trello", new TrelloDriverOptions());
    NormalShareEasy.create().withCustomDrivers(customDrivers).forComponent(normalDiv7);
    // #if vaadin eq 0
    Div example7 = createContainerDiv("With custom driver for extra social: Trello", normalDiv7); 
    SourceCodeViewer.highlightOnHover(example7, "example7");
    add(example7);
    // #endif
    // show-source add(normalDiv7);
    // end-block
  }

}
