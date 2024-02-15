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
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Locale;
import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;
import com.flowingcode.vaadin.addons.shareeasy.util.LanguageKeys;
import com.flowingcode.vaadin.addons.shareeasy.util.Options;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import elemental.json.JsonObject;

/**
 * BaseSharee represents the base class for creating Sharee instances.
 * 
 * @param <T> The actual implementation class type, extending BaseSharee
 * 
 * @author Paola De Bartolo / Flowing Code
 */
@NpmPackage(value = "sharee", version = "1.1.13")
@JsModule("./src/fc-sharee-connector.js")
@CssImport("./styles/fc-share-easy/style.css")
class BaseShareEasy<T extends BaseShareEasy<T>> {

  private Component component;

  private Options options = new Options();

  Map<String, CustomDriverOptions> customDrivers = new HashMap<>();
  
  protected boolean withDefaultDriversListFirst = true;

  /**
   * Sets the share link for the shared content.
   *
   * @param shareLink The URL to be shared
   * @return The current instance of the BaseSharee class
   */
  public T withShareLink(String shareLink) {
    this.options.setShareLink(shareLink);
    return (T) this;
  }

  /**
   * Sets the share text for the shared content.
   *
   * @param shareText The text to be shared
   * @return The current instance of the BaseSharee class
   */
  public T withShareText(String shareText) {
    this.options.setShareText(shareText);
    return (T) this;
  }

  /**
   * Enables or disables the ripple effect.
   *
   * @param ripple True to enable the ripple effect, false to disable
   * @return The current instance of the BaseSharee class
   */
  public T withRipple(boolean ripple) {
    this.options.setRipple(ripple);
    return (T) this;
  }

  /**
   * Sets the duration of the show transition for sharing.
   *
   * @param showTransitionDuration The duration of the show transition
   * @return The current instance of the BaseSharee class
   */
  public T withShowTransitionDuration(String showTransitionDuration) {
    this.options.setShowTransitionDuration(showTransitionDuration);
    return (T) this;
  }

  /**
   * Sets the language to be displayed. Default value is "en" for English. Default values are listed
   * in {@link Locale Locale}. Custom locales can be defined.
   *
   * @param locale The language code, e.g., "en" for English
   * @return The current instance of the BaseSharee class
   */
  public T withLocale(Locale locale) {
    this.options.setLocale(locale.getName());
    return (T) this;
  }

  /**
   * Sets the social media drivers to be displayed (default and/or custom drivers). Default values
   * are listed in {@link Driver Driver}.
   *
   * @param drivers An array of social media drivers
   * @return The current instance of the BaseSharee class
   */
  public T withDrivers(ShareEasyDriver... drivers) {
    this.options.setDrivers(drivers);
    this.withDefaultDriversListFirst = false;
    return (T) this;
  }

  /**
   * Initializes the Sharee component with the specified Vaadin component.
   *
   * @param component The Vaadin component to associate with the Sharee instance
   */
  public void forComponent(Component component) {
    this.component = component;
    createSharee();
  }

  /**
   * Gets the JSON representation of the Sharee options.
   *
   * @return The JsonObject representing the Sharee options
   */
  protected JsonObject getJsonObjectOptions() {
    return options.getJsonObject();
  }

  private void createSharee() {
    String shareeOptions = getJsonObjectOptions().toJson();
    if(customDrivers.isEmpty()) {
      this.create(shareeOptions);
    } else {
      for (CustomDriverOptions options : customDrivers.values()) {
        component.getElement().executeJs("fcShareeConnector.addCustomDriver(this, $0)",
            options.getJsonObject().toJson());
      }
      if (this.withDefaultDriversListFirst) {
        component.getElement().executeJs("fcShareeConnector.createWithCustomDrivers(this, $0)",
            shareeOptions);
      } else {
        this.create(shareeOptions);
      }
    }   
  }
  
  private void create(String shareeOptions) {
    component.getElement().executeJs("fcShareeConnector.create(this, $0)", shareeOptions);
  }

  /**
   * Sets custom language keys for the default locale.
   * 
   * @param languageKeys The custom language keys
   * @return The current instance of the BaseSharee class
   */
  public T withCustomLanguageKeys(LanguageKeys languageKeys) {
    this.options.setLanguageKeys(languageKeys);
    return (T) this;
  }

  /**
   * Sets custom language keys for the specified locale.
   * 
   * @param locale The language code
   * @param languageKeys The custom language keys
   * @return The current instance of the BaseSharee class
   */
  public T withCustomLanguageKeys(String locale, LanguageKeys languageKeys) {
    this.options.setLocale(locale);
    this.options.setLanguageKeys(languageKeys);
    return (T) this;
  }

  /**
   * Sets custom drivers (new social options).
   * 
   * @param customDrivers The custom drivers
   * @return The current instance of the BaseSharee class
   */
  public T withCustomDrivers(Map<String, CustomDriverOptions> customDrivers) {
    this.customDrivers = new HashMap<>(customDrivers);
    return (T) this;
  }

}
