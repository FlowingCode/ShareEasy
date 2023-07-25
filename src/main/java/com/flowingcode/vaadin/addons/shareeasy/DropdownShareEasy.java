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

import com.flowingcode.vaadin.addons.shareeasy.enums.Animation;
import com.flowingcode.vaadin.addons.shareeasy.enums.Mode;
import com.flowingcode.vaadin.addons.shareeasy.enums.Type;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Represents a {@link BaseShareEasy ShareEasy} instance with Dropdown mode.
 */
public class DropdownShareEasy extends BaseShareEasy<DropdownShareEasy> {

  public Type type = Type.COLUMN;

  public Animation animation = Animation.FADE_DOWM;

  public static DropdownShareEasy create() {
    return new DropdownShareEasy();
  }

  public DropdownShareEasy withType(Type type) {
    this.type = type;
    return this;
  }

  public DropdownShareEasy withAnimation(Animation animation) {
    this.animation = animation;
    return this;
  }

  @Override
  public JsonObject getJsonObjectOptions() {
    JsonObject js = super.getJsonObjectOptions();
    js.put("mode", Mode.DROPDOWN.getName());
    JsonObject modeOptions = Json.createObject();
    modeOptions.put("type", type.getName());
    modeOptions.put("animation", animation.getName());
    js.put("modeOptions", modeOptions);
    return js;
  }
}
