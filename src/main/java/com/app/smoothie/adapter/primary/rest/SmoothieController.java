package com.app.smoothie.adapter.primary.rest;

import com.app.smoothie.adapter.primary.rest.converter.UpdateSmoothieRequestMapper;
import com.app.smoothie.adapter.primary.rest.json.CreateSmoothieRequestJson;
import com.app.smoothie.adapter.primary.rest.json.SmoothieJson;
import com.app.smoothie.adapter.primary.rest.json.SmoothieWithDetailsJson;
import com.app.smoothie.adapter.primary.rest.json.UpdateSmoothieRequestJson;
import com.app.smoothie.core.port.primary.usecase.CreateSmoothieUseCase;
import com.app.smoothie.core.port.primary.usecase.DeleteSmoothieUseCase;
import com.app.smoothie.core.port.primary.usecase.GetAllSmoothiesUseCase;
import com.app.smoothie.core.port.primary.usecase.GetSmoothieDetailsUseCase;
import com.app.smoothie.core.port.primary.usecase.UpdateSmoothieUseCase;
import com.app.smoothie.core.port.primary.usecase.dto.EntityRequest;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smoothie")
@RequiredArgsConstructor
public class SmoothieController {

    private final CreateSmoothieUseCase createSmoothieUseCase;
    private final GetAllSmoothiesUseCase getAllSmoothiesUseCase;
    private final DeleteSmoothieUseCase deleteSmoothieUseCase;
    private final GetSmoothieDetailsUseCase getSmoothieDetailsUseCase;
    private final UpdateSmoothieUseCase updateSmoothieUseCase;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SmoothieJson>> getAllSmoothies() {
        final List<SmoothieDto> response = getAllSmoothiesUseCase.execute();
        return ResponseEntity.ok(response.stream()
            .map(SmoothieJson::new)
            .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SmoothieWithDetailsJson> getSmoothieById(@PathVariable("id") UUID id) {
        final SmoothieWithDetailsDto response = getSmoothieDetailsUseCase.execute(new EntityRequest(id));
        return ResponseEntity.ok(new SmoothieWithDetailsJson(response));
    }

    @PostMapping
    @PreAuthorize("hasRole('BUSINESS_OWNER')")
    public ResponseEntity<SmoothieJson> createSmoothie(@RequestBody CreateSmoothieRequestJson smoothie) {
        final CreateSmoothieUseCase.CreateSmoothieRequest request = new CreateSmoothieUseCase.CreateSmoothieRequest(smoothie.getName());
        final SmoothieDto response = createSmoothieUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SmoothieJson(response));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('BUSINESS_OWNER')")
    public ResponseEntity<SmoothieWithDetailsJson> updateSmoothie(@PathVariable("id") UUID id, @RequestBody @Valid UpdateSmoothieRequestJson smoothie) {
        final SmoothieWithDetailsDto response = updateSmoothieUseCase.execute(UpdateSmoothieRequestMapper.map(smoothie, id));
        return ResponseEntity.ok(new SmoothieWithDetailsJson(response));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('BUSINESS_OWNER')")
    public ResponseEntity<UUID> deleteById(@PathVariable("id") UUID id) {
        deleteSmoothieUseCase.execute(new EntityRequest(id));
        return ResponseEntity.ok(id);
    }
}
