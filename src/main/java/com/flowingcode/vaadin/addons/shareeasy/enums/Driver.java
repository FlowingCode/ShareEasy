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
package com.flowingcode.vaadin.addons.shareeasy.enums;

import com.flowingcode.vaadin.addons.shareeasy.ShareEasyDriver;

/**
 * Enumeration that represents the drivers provided by default by Sharee library. Values: copy,
 * telegram, facebook, whatsapp, twitter, linkedin.
 */
public enum Driver implements ShareEasyDriver {

  COPY("copy"), TELEGRAM("telegram"), FACEBOOK("facebook"), WHATSAPP("whatsapp"), TWITTER(
      "twitter"), LINKEDIN("linkedin");

  private String name;

  private Driver(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
