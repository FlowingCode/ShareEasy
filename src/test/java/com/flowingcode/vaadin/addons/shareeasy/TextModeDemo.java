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
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Text mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@DemoSource(value = "/src/test/java/com/flowingcode/vaadin/addons/shareeasy/TrelloDriverOptions.java")
@PageTitle("Text Mode Demo")
@Route(value = "share-easy/text-mode", layout = ShareEasyDemoView.class)
public class TextModeDemo extends BaseShareEasyDemo {

  public TextModeDemo() {
    // begin-block example1
    Paragraph paragraph1 = createParagraph();
    TextShareEasy.create().forComponent(paragraph1);
    // #if vaadin eq 0
    Div example1 = createContainerDiv("Default Values", paragraph1);
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    // show-source add(paragraph1);    
    // end-block

    // begin-block example2
    Paragraph paragraph2 = createParagraph();
    TextShareEasy.create().withDrivers(Driver.LINKEDIN, Driver.TWITTER)
        .forComponent(paragraph2);
    // #if vaadin eq 0
    Div example2 = createContainerDiv("With only 2 drivers", paragraph2);
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator(); 
    // #endif
    // show-source add(paragraph2);
    // end-block

    // begin-block example3
    Paragraph paragraph3 = createParagraph();
    TextShareEasy.create().withShareLink("https://www.flowingcode.com/en/")
        .forComponent(paragraph3);
    // #if vaadin eq 0
    Div example3 = createContainerDiv("With custom share link", paragraph3); 
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator(); 
    // #endif
    // show-source add(paragraph3);
    // end-block

    // begin-block example4
    Paragraph paragraph4 = createParagraph();
    Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
    customDrivers.put("Trello", new TrelloDriverOptions());
    TextShareEasy.create().withCustomDrivers(customDrivers).forComponent(paragraph4);
    // #if vaadin eq 0
    Div example4 = createContainerDiv("With custom driver for extra social: Trello", paragraph4);
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    // #endif
    // show-source add(paragraph4);   
    // end-block
  }

  /* paragraph implementation */
  private Paragraph createParagraph() {
    return new Paragraph(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
  }
}
