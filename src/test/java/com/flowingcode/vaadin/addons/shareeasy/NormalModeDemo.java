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
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view of the Share Easy Normal mode and the available customizations.
 */
@SuppressWarnings("serial")
@DemoSource
@PageTitle("Normal Mode Demo")
@Route(value = "share-easy/normal-mode", layout = ShareEasyDemoView.class)
public class NormalModeDemo extends BaseShareEasyDemo {

  public NormalModeDemo() {
    Div normalDiv1 = new Div();
    NormalShareEasy.create().forComponent(normalDiv1);
    add(createContainerDiv("Default Values", normalDiv1)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv2 = new Div();
    NormalShareEasy.create().withNoTitle(true).forComponent(normalDiv2);
    add(createContainerDiv("Without title", normalDiv2)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv3 = new Div();
    NormalShareEasy.create().withDrivers(new Driver[] {Driver.LINKEDIN, Driver.TWITTER})
        .forComponent(normalDiv3);
    add(createContainerDiv("With only 2 drivers", normalDiv3)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv4 = new Div();
    LanguageKeys languageKeys1 = new LanguageKeys();
    languageKeys1.twitter = "TWT";
    languageKeys1.linkedin = "LI";
    NormalShareEasy.create().withDrivers(new Driver[] {Driver.LINKEDIN, Driver.TWITTER})
        .withCustomLanguageKeys(languageKeys1).forComponent(normalDiv4);
    add(createContainerDiv("With only 2 drivers & custom language keys", normalDiv4)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv5 = new Div();
    LanguageKeys languageKeys2 = new LanguageKeys();
    languageKeys2.copiedSuccessfully = "Copiado";
    languageKeys2.copyLink = "Copiar link";
    NormalShareEasy.create().withCustomLanguageKeys("es", languageKeys2).forComponent(normalDiv5);
    add(createContainerDiv("With custom locale: es (spanish)", normalDiv5)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv6 = new Div();
    NormalShareEasy.create().withShareText("Visit our demo at: ").forComponent(normalDiv6);
    add(createContainerDiv("With share text", normalDiv6)); // hide-source
    addSeparator(); // hide-source

    Div normalDiv7 = new Div();
    NormalShareEasy.create().withShareText("Visit our website! Go to ")
        .withShareLink("https://www.flowingcode.com/en/").forComponent(normalDiv7);
    add(createContainerDiv("With share text & share link", normalDiv7)); // hide-source
  }

}
