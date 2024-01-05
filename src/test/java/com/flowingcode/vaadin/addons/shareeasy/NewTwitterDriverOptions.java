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

import com.flowingcode.vaadin.addons.shareeasy.util.CustomDriverOptions;

/**
 * Custom driver option for X (ex Twitter) app.
 * 
 * X Logo PNG Vector (SVG) Free Download from https://about.twitter.com/en/who-we-are/brand-toolkit
 */
public class NewTwitterDriverOptions extends CustomDriverOptions {

  public NewTwitterDriverOptions() {
    this.setButtonText("X"); ;
    this.setBackgroundColor("#0f1419");
    this.setBackgroundHoverColor("#0f1419");
    this.setTextColor("#fff");
    this.setTextHoverColor("#fff");
    this.setLink("https://twitter.com/intent/tweet");
    this.setShareLinkParam("url");
    this.setShareTextParam("text");
    this.setName("x");
    this.setIconSvg(
        "<svg width='1200' height='1227' viewBox='0 0 1200 1227' fill='none' xmlns='http://www.w3.org/2000/svg'>\r\n"
        + "<path d='M714.163 519.284L1160.89 0H1055.03L667.137 450.887L357.328 0H0L468.492 681.821L0 1226.37H105.866L515.491 750.218L842.672 1226.37H1200L714.137 519.284H714.163ZM569.165 687.828L521.697 619.934L144.011 79.6944H306.615L611.412 515.685L658.88 583.579L1055.08 1150.3H892.476L569.165 687.854V687.828Z' fill='white'/>\r\n"
        + "</svg>");
  }

}
