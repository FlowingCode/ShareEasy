/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 - 2026 Flowing Code
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
import com.flowingcode.vaadin.addons.shareeasy.ShareEasyDriver;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Representation of the options to be defined to create a custom driver.
 */
public class CustomDriverOptions implements ShareEasyDriver {

  private String buttonText;

  private String iconSvg;

  private String backgroundColor;

  private String backgroundHoverColor;

  private String textColor;

  private String textHoverColor;

  private String rippleColor;

  private String link;

  private String shareLinkParam;

  private String shareTextParam;

  private String name;

  public String getButtonText() {
    return buttonText;
  }

  public void setButtonText(String buttonText) {
    this.buttonText = buttonText;
  }

  public String getIconSvg() {
    return iconSvg;
  }

  public void setIconSvg(String iconSvg) {
    this.iconSvg = iconSvg;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public String getBackgroundHoverColor() {
    return backgroundHoverColor;
  }

  public void setBackgroundHoverColor(String backgroundHoverColor) {
    this.backgroundHoverColor = backgroundHoverColor;
  }

  public String getTextColor() {
    return textColor;
  }

  public void setTextColor(String textColor) {
    this.textColor = textColor;
  }

  public String getTextHoverColor() {
    return textHoverColor;
  }

  public void setTextHoverColor(String textHoverColor) {
    this.textHoverColor = textHoverColor;
  }

  public String getRippleColor() {
    return rippleColor;
  }

  public void setRippleColor(String rippleColor) {
    this.rippleColor = rippleColor;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getShareLinkParam() {
    return shareLinkParam;
  }

  public void setShareLinkParam(String shareLinkParam) {
    this.shareLinkParam = shareLinkParam;
  }

  public String getShareTextParam() {
    return shareTextParam;
  }

  public void setShareTextParam(String shareTextParam) {
    this.shareTextParam = shareTextParam;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JsonObject getJsonObject() {
    JsonObject js = Json.createObject();
    Optional.ofNullable(buttonText).ifPresent(value -> js.put("buttonText", value));
    Optional.ofNullable(iconSvg).ifPresent(value -> js.put("icon", value));
    Optional.ofNullable(backgroundColor).ifPresent(value -> js.put("backgroundColor", value));
    Optional.ofNullable(backgroundHoverColor)
        .ifPresent(value -> js.put("backgroundHoverColor", value));
    Optional.ofNullable(textColor).ifPresent(value -> js.put("textColor", value));
    Optional.ofNullable(textHoverColor).ifPresent(value -> js.put("textHoverColor", value));
    Optional.ofNullable(rippleColor).ifPresent(value -> js.put("rippleColor", value));
    Optional.ofNullable(link).ifPresent(value -> js.put("link", value));
    Optional.ofNullable(shareLinkParam).ifPresent(value -> js.put("shareLinkParam", value));
    Optional.ofNullable(shareTextParam).ifPresent(value -> js.put("shareTextParam", value));
    Optional.ofNullable(name).ifPresent(value -> js.put("name", value));

    js.put("linkWithParams",
        OptionsUtils.isNotBlank(shareLinkParam) || OptionsUtils.isNotBlank(shareTextParam));

    return js;
  }

}
