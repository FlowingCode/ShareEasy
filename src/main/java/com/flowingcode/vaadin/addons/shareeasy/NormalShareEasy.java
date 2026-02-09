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
package com.flowingcode.vaadin.addons.shareeasy;

import com.flowingcode.vaadin.addons.shareeasy.enums.Mode;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Represents a {@link BaseShareEasy ShareEasy} instance with Normal mode.
 */
public class NormalShareEasy extends BaseShareEasy<NormalShareEasy> {

  public boolean noTitle = false;

  public static NormalShareEasy create() {
    return new NormalShareEasy();
  }

  public NormalShareEasy withNoTitle(boolean noTitle) {
    this.noTitle = noTitle;
    return this;
  }

  @Override
  public JsonObject getJsonObjectOptions() {
    JsonObject js = super.getJsonObjectOptions();
    js.put("mode", Mode.NORMAL.getName());
    JsonObject modeOptions = Json.createObject();
    modeOptions.put("noTitle", noTitle);
    js.put("modeOptions", modeOptions);
    return js;
  }
}
