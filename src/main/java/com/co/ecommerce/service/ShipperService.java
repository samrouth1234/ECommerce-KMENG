package com.co.ecommerce.service;

import com.co.ecommerce.entity.Shipper;
import com.co.ecommerce.repository.ShipperRepository;
import com.co.ecommerce.web.dto.ShipperDTO;
import com.co.ecommerce.web.mapper.ShipperMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipperService {
    private final ShipperRepository shipperRepository;
    private final ShipperMapper shipperMapper;

    // Create shipper
    public void createShipper(ShipperDTO shipperDTO) {
        Shipper shipper = shipperMapper.mapShipperDTOToShipper(shipperDTO);
        shipperRepository.save(shipper);
    }

    // Find all shipper
    public List<ShipperDTO> getAllShippers() {
        List<Shipper> shippers = shipperRepository.findAll();
        return shippers.stream().map(shipperMapper::mapShipperToShipperDTO)
                .collect(Collectors.toList());
    }

}
