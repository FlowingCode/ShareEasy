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
package com.flowingcode.vaadin.addons.shareeasy.util;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import com.flowingcode.vaadin.addons.shareeasy.ShareEasyDriver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Locale;
import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;

/**
 * Representation of the default options that can be configure for a Share Easy component.
 */
public class Options {

  /* By default current page's title */
  private String shareText;

  /* By default current page's url */
  private String shareLink;

  private boolean ripple = true;

  private String showTransitionDuration = "200ms";

  private String locale = Locale.ENGLISH.getName();

  private LanguageKeys languageKeys;

  private ShareEasyDriver[] drivers = Driver.values();

  public String getShareText() {
    return shareText;
  }

  public void setShareText(String shareText) {
    this.shareText = shareText;
  }

  public String getShareLink() {
    return shareLink;
  }

  public void setShareLink(String shareLink) {
    this.shareLink = shareLink;
  }

  public boolean isRipple() {
    return ripple;
  }

  public void setRipple(boolean ripple) {
    this.ripple = ripple;
  }

  public String getShowTransitionDuration() {
    return showTransitionDuration;
  }

  public void setShowTransitionDuration(String showTransitionDuration) {
    this.showTransitionDuration = showTransitionDuration;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public LanguageKeys getLanguageKeys() {
    return languageKeys;
  }

  public void setLanguageKeys(LanguageKeys languageKeys) {
    this.languageKeys = languageKeys;
  }

  public ShareEasyDriver[] getDrivers() {
    return drivers;
  }

  public void setDrivers(ShareEasyDriver[] drivers) {
    this.drivers = drivers;
  }

  public JsonObject getJsonObject() {
    JsonObject js = Json.createObject();

    Optional.ofNullable(shareText).ifPresent(value -> js.put("shareText", value));
    Optional.ofNullable(shareLink).ifPresent(value -> js.put("shareLink", value));

    js.put("ripple", ripple);
    js.put("showTransitionDuration", showTransitionDuration);
    js.put("lang", locale);

    if (languageKeys != null && StringUtils.isNotBlank(locale)) {
      JsonObject langs = Json.createObject();
      langs.put(locale, languageKeys.getJsonObject());
      js.put("langs", langs);
    }

    JsonArray jsonDriversArray = Json.createArray();
    for (int i = 0; i < drivers.length; i++) {
      jsonDriversArray.set(i, drivers[i].getName());
    }
    js.put("drivers", jsonDriversArray);

    return js;
  }

}
