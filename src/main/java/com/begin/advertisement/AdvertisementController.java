package com.begin.advertisement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/adv")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Advertisement>>> findAll() {
        List<Advertisement> advertisements = advertisementService.getAll();
        if (advertisements.isEmpty()) {
            ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Error",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                advertisements
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Advertisement>> create(@RequestBody Advertisement advertisement) {
        Advertisement add = advertisementService.save(advertisement);
        ApiResponse<Advertisement> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Advertisement Created",
                add
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Optional<Advertisement>>> findById(
            @PathVariable int id,
            @RequestParam(name = "viewerId", required = false) Integer viewerId) {

        Optional<Advertisement> advertisementOpt = advertisementRepository.findById(id);

        if (!advertisementOpt.isPresent()) {
            ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Error: data not found",
                    Optional.empty()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        Advertisement advertisement = advertisementOpt.get();

        if (viewerId != null && viewerId != advertisement.getAdvUserID()) {
            advertisement.setCount(advertisement.getCount() + 1);
            advertisementRepository.save(advertisement);
        }

        ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                Optional.of(advertisement)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("subCategory/{id}")
    public ResponseEntity<ApiResponse<List<Advertisement>>> findAllBySubCategoryId(@PathVariable int id) {
        List<Advertisement> advertisement = advertisementService.getBySubCategoryId(id);
        if (advertisement.isEmpty()) {
            ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "error",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                advertisement
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Optional<Advertisement>>> update(@PathVariable int id, @RequestBody Advertisement advertisement) {
        Optional<Advertisement> adv = advertisementService.getById(id);
        if (!adv.isPresent()) {
            ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "error",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Optional<Advertisement> ad = advertisementService.update(id, advertisement);
        ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                ad
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Empty file"));
        }

        try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadDir = Paths.get("uploads");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            Path filePath = uploadDir.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUrl = "http://10.0.167.11:2012/uploads/" + fileName;

            return ResponseEntity.ok(Map.of("url", fileUrl));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Upload failed"));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Optional<Advertisement>>> delete(@PathVariable int id) {
        Optional<Advertisement> adv = advertisementService.getById(id);
        if (!adv.isPresent()) {
            ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "error",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Optional<Advertisement> ad = advertisementService.delete(id);
        ApiResponse<Optional<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                ad
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("userID/{id}")
    public ResponseEntity<ApiResponse<List<Advertisement>>> findAllByUserId(@PathVariable int id) {
        List<Advertisement> adv = advertisementService.getByUserId(id);
        if (adv.isEmpty()) {
            ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "error",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<List<Advertisement>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                adv
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
