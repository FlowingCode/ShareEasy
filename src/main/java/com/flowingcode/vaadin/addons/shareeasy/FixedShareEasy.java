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

import java.util.stream.Stream;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.flowingcode.vaadin.addons.shareeasy.enums.Mode;
import com.flowingcode.vaadin.addons.shareeasy.enums.Position;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Represents a {@link BaseShareEasy ShareEasy} instance with Fixed mode.
 */
public class FixedShareEasy extends BaseShareEasy<FixedShareEasy> {

  public Position position = Position.TOP_LEFT;

  public boolean noTitle = false;

  public static FixedShareEasy create() {
    // remove copy driver cause is not working https://github.com/parsagholipour/sharee/issues/4
    Driver[] fixedDrivers =
        Stream.of(Driver.values()).filter(d -> Driver.COPY != d).toArray(Driver[]::new);
    return new FixedShareEasy().withDrivers(fixedDrivers);
  }

  public FixedShareEasy withPosition(Position position) {
    this.position = position;
    return this;
  }

  public FixedShareEasy withNoTitle(boolean noTitle) {
    this.noTitle = noTitle;
    return this;
  }
  
  @Override
  public FixedShareEasy withDrivers(ShareEasyDriver... drivers) {
    FixedShareEasy fixedShareEasy = super.withDrivers(drivers);
    this.withDefaultDriversListFirst = true;
    return fixedShareEasy;
  }

  @Override
  protected JsonObject getJsonObjectOptions() {
    JsonObject js = super.getJsonObjectOptions();
    js.put("mode", Mode.FIXED.getName());
    JsonObject modeOptions = Json.createObject();
    modeOptions.put("position", position.getName());
    modeOptions.put("noTitle", noTitle);
    js.put("modeOptions", modeOptions);
    return js;
  }
}
