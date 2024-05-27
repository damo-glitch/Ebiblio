package org.myproject.ebiblio.Controllers;

import jakarta.websocket.server.PathParam;
import org.myproject.ebiblio.Entities.Dto.BorrowDto;
import org.myproject.ebiblio.Mapper.BorrowMapper;
import org.myproject.ebiblio.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping()
    public ResponseEntity<List<BorrowDto>> getAllBorrows() {
        return new ResponseEntity<>(BorrowMapper.mapToDtoList(borrowService.getAllBorrows()), HttpStatus.OK);
    }

    @GetMapping("/book/{title}")
    public ResponseEntity<List<BorrowDto>> getBorrowsByBookTitle(@PathParam("title") String title) {
        return new ResponseEntity<>(BorrowMapper.mapToDtoList(borrowService.getBorrowsByBookTitle(title)), HttpStatus.OK);
    }

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<BorrowDto>> getBorrowsByDate(@PathVariable String startDate, @PathVariable String endDate) {
        return new ResponseEntity<>(BorrowMapper.mapToDtoList(borrowService.getBorrowsByDate(startDate, endDate)), HttpStatus.OK);
    }
}
