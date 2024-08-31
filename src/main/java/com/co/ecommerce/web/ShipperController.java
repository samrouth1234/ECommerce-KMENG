package com.co.ecommerce.web;

import com.co.ecommerce.entity.Shipper;
import com.co.ecommerce.service.ShipperService;
import com.co.ecommerce.web.dto.ShipperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippers")
@RequiredArgsConstructor
public class ShipperController {
    private final ShipperService shipperService;

    @PostMapping
    public ResponseEntity<Shipper> createShipper(@RequestBody ShipperDTO shipperDTO) {
        shipperService.createShipper(shipperDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShipperDTO>getAllShippers() {
       return shipperService.getAllShippers();
    }
}
