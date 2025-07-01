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
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Representation of the default language keys in Sharee library.
 */
public class LanguageKeys {

  enum Direction {

    LTR, RTL;
  }

  private String copiedSuccessfully = "Copied successfully";
  private Direction direction = Direction.LTR;
  private String telegram = "Telegram";
  private String copyLink = "Copy Link";
  private String whatsapp = "Whatsapp";
  private String twitter = "Twitter";
  private String linkedin = "Linkedin";
  private String facebook = "Facebook";  

  public String getCopiedSuccessfully() {
    return copiedSuccessfully;
  }
  
  public void setCopiedSuccessfully(String copiedSuccessfully) {
    this.copiedSuccessfully = copiedSuccessfully;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public String getTelegram() {
    return telegram;
  }

  public void setTelegram(String telegram) {
    this.telegram = telegram;
  }

  public String getCopyLink() {
    return copyLink;
  }
  
  public void setCopyLink(String copyLink) {
    this.copyLink = copyLink;
  }

  public String getWhatsapp() {
    return whatsapp;
  }

  public void setWhatsapp(String whatsapp) {
    this.whatsapp = whatsapp;
  }

  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  public String getLinkedin() {
    return linkedin;
  }

  public void setLinkedin(String linkedin) {
    this.linkedin = linkedin;
  }

  public String getFacebook() {
    return facebook;
  }

  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }

  public JsonObject getJsonObject() {
    JsonObject js = Json.createObject();
    Optional.ofNullable(copiedSuccessfully).ifPresent(value -> js.put("CopiedSuccessfully", value));
    Optional.ofNullable(direction)
        .ifPresent(value -> js.put("Direction", value.name().toLowerCase()));
    Optional.ofNullable(telegram).ifPresent(value -> js.put("Telegram", value));
    Optional.ofNullable(copyLink).ifPresent(value -> js.put("Copy_Link", value));
    Optional.ofNullable(whatsapp).ifPresent(value -> js.put("Whatsapp", value));
    Optional.ofNullable(twitter).ifPresent(value -> js.put("Twitter", value));
    Optional.ofNullable(linkedin).ifPresent(value -> js.put("Linkedin", value));
    Optional.ofNullable(facebook).ifPresent(value -> js.put("Facebook", value));
    return js;
  }

}
