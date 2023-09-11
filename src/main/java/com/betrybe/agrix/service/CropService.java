package com.betrybe.agrix.service;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * comment.
 */

@Service
public class CropService {
  private CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public Crop newCrop(Crop crop) {
    return cropRepository.save(crop);
  }

  public List<Crop> getCropsByFarmId(Long farmId) {
    List<Crop> allCrops = getCrops();
    return allCrops.stream().filter(a -> a.getFarmId().equals(farmId)).toList();
  }

  public List<Crop> getCrops() {
    return cropRepository.findAll();
  }

  public Optional<Crop> getCropById(Long id) {
    return cropRepository.findById(id);
  }
}