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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

/**
 * Base class for demo views.
 */
@SuppressWarnings("serial")
public class BaseShareEasyDemo extends Div {

  public BaseShareEasyDemo() {
    setClassName("share-easy-main");
  }

  protected Div createContainerDiv(String title, Component component) {
    Div containerDiv = createContainerDiv();
    containerDiv.add(new Span(new Text(title)), component);
    return containerDiv;
  }

  protected Div createContainerDivWithInfo(String title, Component component, String info) {
    Div containerDiv = createContainerDiv();
    Button infoButton = new Button(new Icon(VaadinIcon.INFO_CIRCLE_O));
    infoButton.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_TERTIARY_INLINE);
    infoButton.setTooltipText(info);
    Tooltip tooltip = infoButton.getTooltip().withManual(true);
    infoButton.addClickListener(event -> {
      tooltip.setOpened(!tooltip.isOpened());
    });
    Span titleSpan = new Span(new Text(title), infoButton);
    containerDiv.add(titleSpan, component);
    return containerDiv;
  }

  private Div createContainerDiv() {
    Div containerDiv = new Div();
    containerDiv.setClassName("share-easy-container");
    return containerDiv;
  }

  protected void addSeparator() {
    Element hr = ElementFactory.createHr();
    this.getElement().appendChild(hr);
  }

  @Override
  protected void onDetach(DetachEvent detachEvent) {
    super.onDetach(detachEvent);
    removeExistingFixedMenus();
  }
    
  protected void removeExistingFixedMenus() {
    this.getElement().executeJs(
        "let fixedSharees = document.getElementsByClassName('sharee__fixed'); while(fixedSharees.length > 0) { fixedSharees[0].remove();}");
  }

}
