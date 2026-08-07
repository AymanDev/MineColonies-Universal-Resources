/**
 * @author KingoSawada
 */
package com.aymandev.universalresources;

import com.ldtteam.structurize.placement.handlers.placement.PlacementHandlers;
import java.util.ArrayList;

public class PlacementHandlerOverrider {
  public static void init() {
    var handlers = new ArrayList<>(PlacementHandlers.handlers);

    for (var handler : handlers) {
      PlacementHandlers.add(new WrappedPlacementHandler(handler), handler.getClass());
    }
  }
}
