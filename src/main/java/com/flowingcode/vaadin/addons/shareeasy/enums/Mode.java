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
package com.flowingcode.vaadin.addons.shareeasy.enums;

/**
 * Enumeration that represents the possible modes for Sharee. Modes can be: dropdown, text, normal,
 * fixed, hover.
 */
public enum Mode {

  DROPDOWN("dropdown"), TEXT("text"), NORMAL("normal"), FIXED("fixed"), HOVER("hover");

  private String name;

  private Mode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
