package com.secretservice.taxservice.controller;

import com.secretservice.taxservice.request.TaxCalculationRequest;
import com.secretservice.taxservice.service.CongestionCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TaxServiceController {
    @Autowired
    private CongestionCalculationService congestionCalculationService;

    @PostMapping("/calculateTotalTax")
    ResponseEntity<Map<String,Integer>> getTotalTax(
            @RequestBody TaxCalculationRequest taxCalculationRequest
    ) {
        List<Date> timestamps = taxCalculationRequest.getTimestamps();
        int code = taxCalculationRequest.getVehicleTypeCode();
        Map<String,Integer> dateToAmount = new HashMap<>();
        if(timestamps == null || timestamps.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Date[] dates = timestamps.stream().filter(t->t!=null).sorted()
                    .filter(d->d!=null).sorted((Comparator.naturalOrder()))
                    .collect(Collectors.toList()).toArray(new Date[]{});
        return ResponseEntity.ok(congestionCalculationService.getTotalTax(code, dates));
    }
}
