package com.tenpines.encolapp.modelo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Date: 27/01/18 - 15:25
 */
public class EstadoDeSala {

  private Set<Speaker> presentes;
  private Set<Speaker> cola;

  public static EstadoDeSala create(Set<Speaker> presentes, Set<Speaker> speakers) {
    EstadoDeSala estadoDeSala = new EstadoDeSala();
    estadoDeSala.presentes = new LinkedHashSet<>(presentes);
    estadoDeSala.cola = new LinkedHashSet<>(speakers);
    return estadoDeSala;
  }

  public Set<Speaker> getPresentes() {
    return presentes;
  }

  public void setPresentes(Set<Speaker> presentes) {
    this.presentes = presentes;
  }

  public Set<Speaker> getCola() {
    return cola;
  }

  public void setCola(Set<Speaker> cola) {
    this.cola = cola;
  }
}
