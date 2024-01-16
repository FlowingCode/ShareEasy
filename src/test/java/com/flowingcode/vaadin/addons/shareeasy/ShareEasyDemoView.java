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

import com.flowingcode.vaadin.addons.DemoLayout;
import com.flowingcode.vaadin.addons.GithubBranch;
import com.flowingcode.vaadin.addons.GithubLink;
import com.flowingcode.vaadin.addons.demo.TabbedDemo;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@ParentLayout(DemoLayout.class)
@Route("share-easy")
@GithubLink("https://github.com/FlowingCode/ShareEasy")
@CssImport("./styles/share-easy-demo-styles.css")
@GithubBranch("master")
public class ShareEasyDemoView extends TabbedDemo {

  public ShareEasyDemoView() {
    addDemo(DefaultValuesDemo.class);
    addDemo(NormalModeDemo.class);
    addDemo(DropdownModeDemo.class);
    addDemo(TextModeDemo.class);
    addDemo(HoverModeDemo.class);
    addDemo(FixedModeDemo.class);
    addDemo(SpecialCustomizationsDemo.class);
    setSizeFull();
  }
}
