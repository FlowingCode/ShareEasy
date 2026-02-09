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

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.demo.SourceCodeViewer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Demo view showing the different modes of Share Easy where each mode has no extra configuration,
 * only default values.
 */
@SuppressWarnings("serial")
@DemoSource
@PageTitle("Default Values Demo")
@Route(value = "share-easy/default-values", layout = ShareEasyDemoView.class)
public class DefaultValuesDemo extends BaseShareEasyDemo {

  public DefaultValuesDemo() {    
    // begin-block example1
    Button showBtn = new Button("Show");
    // #if vaadin eq 0
    addClassName("share-easy-fixed");
    HorizontalLayout btnsLayout = new HorizontalLayout();    
    showBtn.addThemeVariants(ButtonVariant.LUMO_LARGE);
    showBtn.setDisableOnClick(true);    
    Button hideBtn = new Button("Hide");
    hideBtn.addThemeVariants(ButtonVariant.LUMO_LARGE);
    hideBtn.setDisableOnClick(true);
    hideBtn.setEnabled(false);
    btnsLayout.add(showBtn, hideBtn);
      
    Div example1 = createContainerDivWithInfo("Fixed Mode", btnsLayout,
        "Fixed Mode: Share Easy menu is attached to the document's body and displays as a vertical menu. By default is added at top left position.");
    SourceCodeViewer.highlightOnHover(example1, "example1");
    add(example1);
    addSeparator();
    // #endif
    showBtn.addClickListener(e -> {
      FixedShareEasy.create().forComponent(this);
      hideBtn.setEnabled(true); // hide-source
    });
    // #if vaadin eq 0
    hideBtn.addClickListener(e -> {
      this.removeExistingFixedMenus();
      showBtn.setEnabled(true);
    });
    // #endif
    // end-block

    // begin-block example2
    Div normalDiv = new Div();
    NormalShareEasy.create().forComponent(normalDiv);
    // #if vaadin eq 0
    Div example2 = createContainerDiv("Normal Mode", normalDiv); // hide-source
    SourceCodeViewer.highlightOnHover(example2, "example2");
    add(example2);
    addSeparator(); 
    // #endif
    // show-source add(normalDiv);   
    // end-block

    // begin-block example3
    Button dropdownButton = new Button("Share this");
    dropdownButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY); // hide-source
    DropdownShareEasy.create().forComponent(dropdownButton);
    // #if vaadin eq 0
    Div example3 = createContainerDivWithInfo("Dropdown Mode", dropdownButton,
        "Dropdown Mode: Share Easy menu will appear on hover. As default it will be shown as a column dropdown.");
    SourceCodeViewer.highlightOnHover(example3, "example3");
    add(example3);
    addSeparator();
    // #endif
    // show-source add(dropdownButton);
    // end-block

    // begin-block example4
    Paragraph paragraph = new Paragraph(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    TextShareEasy.create().forComponent(paragraph);
    // #if vaadin eq 0
    Div example4 = createContainerDivWithInfo("Text Mode", paragraph,
        "Text Mode: Select some text and Share Easy menu will popup to share the selected text.");
    SourceCodeViewer.highlightOnHover(example4, "example4");
    add(example4);
    addSeparator();
    // #endif
    // show-source add(paragraph);
    // end-block

    // begin-block example5
    Button hoverButton = new Button(new Icon(VaadinIcon.CONNECT));
    hoverButton.addThemeVariants(ButtonVariant.LUMO_ICON);
    HoverShareEasy.create().forComponent(hoverButton);
    // #if vaadin eq 0
    Div example5 = createContainerDivWithInfo("Hover Mode", hoverButton,
        "Hover Mode: Share Easy menu will appear on hover and will be displayed as an horizontal/row menu only.");
    SourceCodeViewer.highlightOnHover(example5, "example5");
    add(example5);
    // #endif
    // show-source add(hoverButton);
    // end-block
  }

}
