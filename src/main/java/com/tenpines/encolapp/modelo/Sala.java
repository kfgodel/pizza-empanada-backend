package com.tenpines.encolapp.modelo;

import com.tenpines.encolapp.websockets.Mensajes;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Date: 27/01/18 - 13:16
 */
public class Sala {

  private Set<Speaker> presentes;

  private Set<Speaker> speakers;
  private EventBus eventBus;

  public static Sala create(EventBus eventBus) {
    Sala sala = new Sala();
    sala.speakers = new CopyOnWriteArraySet<>();
    sala.presentes = new CopyOnWriteArraySet<>();
    sala.eventBus = eventBus;
    return sala;
  }

  public void ingresar(Speaker speaker) {
    presentes.add(speaker);
    actualizarNovedades();
  }

  public void salir(Speaker speaker) {
    presentes.remove(speaker);
    speakers.remove(speaker);
    actualizarNovedades();
  }

  public void encolar(Speaker speaker) {
    speakers.add(speaker);
    actualizarNovedades();
  }

  public void desencolar(Speaker speaker) {
    speakers.remove(speaker);
    actualizarNovedades();
  }

  private void actualizarNovedades() {
    EstadoDeSala nuevoEstado = estadoActual();
    eventBus.publish(Mensajes.CAMBIOS_EN_SALA, Json.encode(nuevoEstado));
  }

  private EstadoDeSala estadoActual() {
    return EstadoDeSala.create(presentes, speakers);
  }

}
