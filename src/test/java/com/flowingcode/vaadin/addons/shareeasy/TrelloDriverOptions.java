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

import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;

/**
 * Custom driver option for Trello app.
 * 
 * Trello Logo PNG Vector (SVG) Free Download from https://seeklogo.com/vector-logo/274031/trello 
 */
public class TrelloDriverOptions extends CustomDriverOptions {

  public TrelloDriverOptions() {
    this.setButtonText("Trello"); ;
    this.setBackgroundColor("#008FE4");
    this.setBackgroundHoverColor("#008FE4");
    this.setTextColor("#fff");
    this.setTextHoverColor("#fff");
    this.setLink("https://trello.com/add-card");
    this.setShareLinkParam("url");
    this.setShareTextParam("name");
    this.setName("trello");
    this.setIconSvg(
        "<?xml version='1.0' encoding='UTF-8' standalone='no'?>\r\n"
        + "<svg width='256px' height='256px' viewBox='0 0 256 256' version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' preserveAspectRatio='xMidYMid'>\r\n"
        + "    <g>\r\n"
        + "        <g>\r\n"
        + "            <rect fill='#008fe4' x='0' y='0' width='256' height='256' rx='25'></rect>\r\n"
        + "            <rect fill='#FFFFFF' x='144.64' y='33.28' width='78.08' height='112' rx='12'></rect>\r\n"
        + "            <rect fill='#FFFFFF' x='33.28' y='33.28' width='78.08' height='176' rx='12'></rect>\r\n"
        + "        </g>\r\n"
        + "    </g>\r\n"
        + "</svg>");
  }

}
