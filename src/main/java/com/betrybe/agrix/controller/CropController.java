package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.exceptions.NotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * comment.
 */

@RestController
@RequestMapping("/crops")
public class CropController {
  private CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * comment.
   */

  @GetMapping
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> allCrops = cropService.getCrops();
    List<CropDto> response = allCrops.stream().map(CropDto::fromEntity).toList();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * comment.
   */

  @GetMapping("/{cropId}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long cropId) {
    Optional<Crop> crop = cropService.getCropById(cropId);
    if (crop.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(CropDto.fromEntity(crop.get()));
    }
    throw new NotFoundException("Plantação não encontrada!");
  }
}