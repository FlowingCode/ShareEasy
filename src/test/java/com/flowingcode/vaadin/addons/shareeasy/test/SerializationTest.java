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
package com.flowingcode.vaadin.addons.shareeasy.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Assert;
import org.junit.Test;
import com.flowingcode.vaadin.addons.shareeasy.DropdownShareEasy;
import com.flowingcode.vaadin.addons.shareeasy.FixedShareEasy;
import com.flowingcode.vaadin.addons.shareeasy.HoverShareEasy;
import com.flowingcode.vaadin.addons.shareeasy.NormalShareEasy;
import com.flowingcode.vaadin.addons.shareeasy.TextShareEasy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;

public class SerializationTest {

  private void testSerializationOf(Object obj) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(obj);
    }
    try (ObjectInputStream in =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      obj.getClass().cast(in.readObject());
    }
  }

  @Test
  public void testSerialization() throws ClassNotFoundException, IOException {
    try {
      Div divFixed = new Div();
      FixedShareEasy.create().forComponent(divFixed);
      testSerializationOf(divFixed);      
      Div divNormal = new Div();
      NormalShareEasy.create().forComponent(divNormal);
      testSerializationOf(divNormal);      
      Paragraph p = new Paragraph();
      TextShareEasy.create().forComponent(p);
      testSerializationOf(p);      
      Button buttonDropdown = new Button();
      DropdownShareEasy.create().forComponent(buttonDropdown);
      testSerializationOf(buttonDropdown);      
      Button buttonHover = new Button();
      HoverShareEasy.create().forComponent(buttonHover);
      testSerializationOf(buttonHover);
    } catch (Exception e) {
      Assert.fail("Problem while testing serialization: " + e.getMessage());
    }
  }
}
