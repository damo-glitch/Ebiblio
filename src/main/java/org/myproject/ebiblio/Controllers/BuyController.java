package org.myproject.ebiblio.Controllers;

import jakarta.websocket.server.PathParam;
import org.myproject.ebiblio.Entities.Dto.BorrowDto;
import org.myproject.ebiblio.Entities.Dto.BuyDto;
import org.myproject.ebiblio.Mappers.BorrowMapper;
import org.myproject.ebiblio.Mappers.BuyMapper;
import org.myproject.ebiblio.Services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buys")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @GetMapping()
    public ResponseEntity<List<BuyDto>> getAllBuys() {
        return new ResponseEntity<>(BuyMapper.mapToDtoList(buyService.getAllBuys()), HttpStatus.OK);
    }

    @GetMapping("/book/{title}")
    public ResponseEntity<List<BuyDto>> getBuysByBookTitle(@PathParam("title") String title) {
        return new ResponseEntity<>(BuyMapper.mapToDtoList(buyService.getBuysByBookTitle(title)), HttpStatus.OK);
    }

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<BuyDto>> getBuysByDate(@PathVariable String startDate, @PathVariable String endDate) {
        return new ResponseEntity<>(BuyMapper.mapToDtoList(buyService.getBuysByDate(startDate, endDate)), HttpStatus.OK);
    }
}
