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

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import com.flowingcode.vaadin.addons.shareeasy.enums.Driver;
import com.vaadin.flow.component.Component;

/**
 * Event fired when one of the share drivers is clicked.
 *
 * @author Paola De Bartolo / Flowing Code
 */
@SuppressWarnings("serial")
public class ShareEasyClickEvent implements Serializable {

  private final Component source;

  private final String driverName;

  private final String link;

  /**
   * Creates a new share click event.
   *
   * @param source the component the Share Easy instance is attached to
   * @param driverName the name of the clicked driver, e.g. "telegram"
   * @param link the share link associated with the driver (the copied URL for the copy driver); may
   *        be {@code null} for custom drivers without a link
   */
  public ShareEasyClickEvent(Component source, String driverName, String link) {
    this.source = Objects.requireNonNull(source, "source must not be null");
    this.driverName = Objects.requireNonNull(driverName, "driverName must not be null");
    this.link = link;
  }

  /**
   * Gets the component the Share Easy instance is attached to.
   *
   * @return the source component
   */
  public Component getSource() {
    return source;
  }

  /**
   * Gets the name of the clicked driver.
   *
   * @return the driver name, e.g. "telegram"
   */
  public String getDriverName() {
    return driverName;
  }

  /**
   * Gets the clicked driver as a {@link Driver default driver}, if it corresponds to one.
   *
   * @return the matching default {@link Driver}, or an empty {@link Optional} if the clicked driver
   *         is a custom driver
   */
  public Optional<Driver> getDriver() {
    return Driver.fromName(driverName);
  }

  /**
   * Gets the share link associated with the clicked driver. For the copy driver this is the URL that
   * was copied to the clipboard.
   *
   * @return the share link, or {@code null} for custom drivers without a link
   */
  public String getLink() {
    return link;
  }
}
