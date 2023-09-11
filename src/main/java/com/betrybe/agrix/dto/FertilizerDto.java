package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Fertilizer;

/**
 * comment.
 */

public record FertilizerDto(Long id, String name, String brand, String composition) {
  public Fertilizer toFertilizer() {
    return new Fertilizer(id, name, brand, composition);
  }
}