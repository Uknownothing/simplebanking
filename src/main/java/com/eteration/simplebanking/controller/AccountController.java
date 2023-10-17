package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
@RequiredArgsConstructor
@RequestMapping("/account/v1/credit")

public class AccountController {

    @PostMapping("/{accountNumber}")
    public ResponseEntity<CreditResponse> processCreditRequest(
            @RequestBody CreditRequest request) {

        String status = "OK";
        String approvalCode = "67f1aada-637d-4469-a650-3fb6352527ba";

        CreditResponse response = new CreditResponse(status, approvalCode);

        return ResponseEntity.ok(response);

    }
}
