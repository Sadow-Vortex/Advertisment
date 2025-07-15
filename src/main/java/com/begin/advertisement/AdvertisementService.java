package com.begin.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }
    public Optional<Advertisement> getById(int id) {
        return advertisementRepository.findById(id);
    }

    public List<Advertisement> getBySubCategoryId(int subCategoryId) {
        return advertisementRepository.findByAdvSubCategoryID(subCategoryId);
    }

    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);

    }
    public Optional<Advertisement> update(int id, Advertisement advertisement) {
        Optional<Advertisement> advertisementOptional = advertisementRepository.findById(id);
        if (advertisementOptional.isPresent()) {
            advertisementOptional.get().setAdvUserID(advertisement.getAdvUserID());
            advertisementOptional.get().setAdv_CategoryID(advertisement.getAdv_CategoryID());
            advertisementOptional.get().setAdvSubCategoryID(advertisement.getAdvSubCategoryID());
            advertisementOptional.get().setAdv_Title(advertisement.getAdv_Title());
            advertisementOptional.get().setAdv_Description(advertisement.getAdv_Description());
            advertisementOptional.get().setAdv_Unit(advertisement.getAdv_Unit());
            advertisementOptional.get().setAdv_Price(advertisement.getAdv_Price());
            advertisementOptional.get().setAdv_Address(advertisement.getAdv_Address());
            advertisementOptional.get().setAdv_Image(advertisement.getAdv_Image());
            advertisementOptional.get().setAdv_Status(advertisement.isAdv_Status());
            advertisementOptional.get().setAdv_Location(advertisement.getAdv_Location());
            advertisementRepository.save(advertisementOptional.get());
        }
        return advertisementOptional;
    }
    public Optional<Advertisement> delete(int id) {
        advertisementRepository.deleteById(id);
        return null;
    }

    public List<Advertisement> getByUserId(int advUserID) {
        return advertisementRepository.findByAdvUserID(advUserID);
    }
}
