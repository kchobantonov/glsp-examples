/********************************************************************************
 * Copyright (c) 2022 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied:
 * -- GNU General Public License, version 2 with the GNU Classpath Exception
 * which is available at https://www.gnu.org/software/classpath/license.html
 * -- MIT License which is available at https://opensource.org/license/mit.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR MIT
 ********************************************************************************/
package org.eclipse.glsp.example.javaemf.server.palette;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.glsp.example.javaemf.server.TaskListModelTypes;
import org.eclipse.glsp.server.actions.TriggerNodeCreationAction;
import org.eclipse.glsp.server.features.toolpalette.PaletteItem;
import org.eclipse.glsp.server.features.toolpalette.ToolPaletteItemProvider;

public class TaskListToolPaletteItemProvider implements ToolPaletteItemProvider {

   @Override
   public List<PaletteItem> getItems(final Map<String, String> args) {
      return new ArrayList<>(List.of(nodes()));
   }

   private PaletteItem nodes() {
      PaletteItem createTask = node(TaskListModelTypes.TASK, "Task");
      List<PaletteItem> nodes = new ArrayList<>();
      nodes.add(createTask);
      return PaletteItem.createPaletteGroup("nodes", "Nodes", nodes, "symbol-property");
   }

   private PaletteItem node(final String elementTypeId, final String label) {
      return new PaletteItem(elementTypeId, label, new TriggerNodeCreationAction(elementTypeId));
   }

}
