package com.app.smoothie.adapter.primary.rest;

import com.app.smoothie.adapter.primary.rest.json.OrderJson;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController
{
    @PostMapping("/order")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> orderSmoothies(@RequestBody @Valid OrderJson order) {

        return ResponseEntity.accepted().build();
    }
}
