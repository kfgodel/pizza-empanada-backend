package com.tenpines.encolapp;

import com.tenpines.encolapp.websockets.ServerConWebsockets;

/**
 * Esta clase implementa el server de encolapp pero sólo usando websockets
 * Date: 29/01/18 - 13:11
 */
public class PizzaEmpanadaMain {

  public static void main(String[] args) {
    ServerConWebsockets.create().iniciar();
  }

}
